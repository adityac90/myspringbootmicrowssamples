package com.example.demo.springbatch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class JobConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step-1").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step-1 executed");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step-2").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step-2 executed");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step-3").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step-3 executed");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }


    @Bean
    public Step stexx() {
        return stepBuilderFactory.get("step-xx").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step xx has been executed by " + Thread.currentThread().getName());
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step steyy() {
        return stepBuilderFactory.get("step-yy").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step yy has been executed by " + Thread.currentThread().getName());
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Job myJob() {
        return jobBuilderFactory.get("first-job").start(step1()).next(step2()).build();
    }

    @Bean
    public Job myJob2() {
        return jobBuilderFactory.get("second-job").start(step1()).on("COMPLETED").to(step2()).from(step2()).on("COMPLETED").to(step3()).end().build();
    }

    @Bean
    public Job myJob3() {
        return jobBuilderFactory.get("third-job").start(step1()).on("COMPLETED").to(step2()).from(step2()).on("COMPLETED").fail().from(step3()).end().build();
    }

    @Bean
    public Job myJob4() {
        return jobBuilderFactory.get("third-job").start(step1()).on("COMPLETED").to(step2()).from(step2()).on("COMPLETED").stopAndRestart(step3()).from(step3()).end().build();
    }

    @Bean
    public Flow myStepFlows() {
        FlowBuilder<Flow> myFlow = new FlowBuilder<>("myCustomFlow");
        myFlow.start(stexx()).next(steyy()).end();
        return myFlow.build();
    }

    @Bean
    public Flow myStepFlowsAgain() {
        FlowBuilder<Flow> myFlow = new FlowBuilder<>("myCustomFlow222222");
        myFlow.start(stexx()).next(steyy()).end();
        return myFlow.build();
    }


    @Bean
    public Step step1234() {
        return stepBuilderFactory.get("step1234").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Step step1234 has been executed by " + Thread.currentThread().getName());
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step5678() {
        return stepBuilderFactory.get("step5678").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("step5678 has been executed by " + Thread.currentThread().getName());
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step9101112() {
        return stepBuilderFactory.get("step9101112").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("step9101112 has been executed by " + Thread.currentThread().getName());
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step step13141516() {
        return stepBuilderFactory.get("step13141516").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("step13141516 has been executed by " + Thread.currentThread().getName());
                return RepeatStatus.FINISHED;
            }
        }).build();
    }


    @Bean
    public Flow flowABC() {
        FlowBuilder<Flow> myFlow = new FlowBuilder<>("flowABC");
        myFlow.start(step1234()).next(step5678()).end();
        return myFlow.build();
    }


    @Bean
    public Flow flowDEF() {
        FlowBuilder<Flow> myFlow = new FlowBuilder<>("flowDEF");
        myFlow.start(step9101112()).next(step13141516()).end();
        return myFlow.build();
    }

    @Bean
    public Job jobmadeWithaFlow() {
        return jobBuilderFactory.get("ninja-job").start(myStepFlows()).next(step1()).end().build();
    }

    @Bean
    public Job jobmadeWithaFlowAsysnc() {
        return jobBuilderFactory.get("xyzzzzz-job").start(flowABC()).split(new SimpleAsyncTaskExecutor()).add(flowDEF()).end().build();
    }
}
