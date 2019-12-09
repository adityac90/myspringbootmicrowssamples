package com.example.vi.batch.controllers;


import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BatchController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    @Qualifier(value = "writeToCSVJob")
    private Job job;

    @GetMapping("/runBatch")
    public void runBatch() {
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

    }

}
