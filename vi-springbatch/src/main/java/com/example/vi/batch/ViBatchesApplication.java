package com.example.vi.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling

public class ViBatchesApplication {

   /* @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    @Qualifier("loadVinJob")
    private Job job;

    @Qualifier("writeTutorialsDataJob")
    @Autowired
    private Job anotherJob;*/

    public static void main(String[] args) {
        SpringApplication.run(ViBatchesApplication.class, args);
    }

    /*
    @Scheduled(cron = "* * * * * *")
    second, minute, hour, day of month, month, day(s) of week
    https://riptutorial.com/spring/example/21209/cron-expression
     */
    //@Scheduled(cron = "*/30 * * * * MON-FRI") // This means MONday to Friday after each 30 seconds
    /*public void scheduleTheJob() {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("startTime", new JobParameter(new Date()));
        JobParameters parameters = new JobParameters(maps);
        try {
            final JobExecution run = jobLauncher.run(job, parameters);

        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

    }*/

    //@Scheduled(cron = "0 0/1 * * * MON-FRI") // This means after each 1 minute
    /*public void scheduleAnotherJob() {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("startTime", new JobParameter(new Date()));
        JobParameters parameters = new JobParameters(maps);
        try {
            final JobExecution run = jobLauncher.run(anotherJob, parameters);

        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

    }*/

}
