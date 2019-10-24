package com.example.vi.batch.BatchConfig;

import com.example.vi.batch.model.PurchasedVehicle;
import com.example.vi.batch.model.Tutorial;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.persistence.EntityManagerFactory;


@Configuration
@EnableBatchProcessing
public class ViBatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private ItemWriter<PurchasedVehicle> itemWriter;
    @Autowired
    private ItemProcessor<PurchasedVehicle, PurchasedVehicle> itemProcessor;
    @Autowired
    @Qualifier("dbReader")
    private ItemReader<Tutorial> dbReader;

    //Path to the input file - the VIN csv
    @Value("${filePath}")
    private Resource resource;

    @Value("${outputfilePath}")
    private String outputResource;

    @Bean
    public Step loadVinCsvStep() {

        return stepBuilderFactory.get("load-vin-csv-and-save-to-db")
                .<PurchasedVehicle, PurchasedVehicle>chunk(2).
                        reader(itemReader(resource)).
                        processor(itemProcessor).
                        writer(itemWriter)
                .build();
    }

    @Bean
    public Step writeTutorialDataToCsvStep() {
        return stepBuilderFactory.get("write-tutorial-data-to-csv")
                .<Tutorial, Tutorial>chunk(2)
                .reader(dbReader)//dbReader or dbReader()
                .writer(csvWriter(outputResource))
                .build();
    }


    @Bean
    public Job loadVinJob() {
        return jobBuilderFactory.get("load-vin-job")
                .incrementer(new RunIdIncrementer())
                .start(loadVinCsvStep())
                .build();
    }

    @Bean
    public Job writeTutorialsDataJob() {
        return jobBuilderFactory.get("write-tutorial-data-job")
                .incrementer(new RunIdIncrementer())
                .start(writeTutorialDataToCsvStep())
                .build();
    }

    @Bean
    public FlatFileItemReader<PurchasedVehicle> itemReader(Resource resource) {
        FlatFileItemReader<PurchasedVehicle> reader = new FlatFileItemReader<>();
        reader.setResource(resource);
        reader.setName("vin-file-reader");
        reader.setLinesToSkip(1); // skip 1 line for CSV headers
        reader.setLineMapper(lineMapper());
        return reader;
    }


    private LineMapper<PurchasedVehicle> lineMapper() {
        DefaultLineMapper<PurchasedVehicle> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setNames(new String[]{"vin", "typeofbuy", "year", "make", "model", "series"});
        BeanWrapperFieldSetMapper<PurchasedVehicle> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(PurchasedVehicle.class);
        lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        lineMapper.setLineTokenizer(tokenizer);
        return lineMapper;
    }


    @Bean
    public JpaPagingItemReader<Tutorial> dbReader() {
        String jpqlQuery = "SELECT t from Tutorial t";
        JpaPagingItemReader<Tutorial> reader = new JpaPagingItemReader<>();
        try {
            reader.setQueryString(jpqlQuery);
            reader.setEntityManagerFactory(entityManagerFactory);
            reader.afterPropertiesSet();
            //reader.setPageSize(1000);
            reader.setSaveState(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reader;
    }

    @Bean
    public FlatFileItemWriter<Tutorial> csvWriter(String outputResource) {
        //Create writer instance
        FlatFileItemWriter<Tutorial> writer = new FlatFileItemWriter<>();

        //Set output file location

        writer.setResource(new FileSystemResource(outputResource));

        //All job repetitions should "append" to same output file
        writer.setAppendAllowed(true);

        //Name field values sequence based on object properties
        writer.setLineAggregator(new DelimitedLineAggregator<Tutorial>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<Tutorial>() {
                    {
                        setNames(new String[]{"id", "title", "author", "submission_date"});
                    }
                });
            }
        });
        return writer;
    }


}
