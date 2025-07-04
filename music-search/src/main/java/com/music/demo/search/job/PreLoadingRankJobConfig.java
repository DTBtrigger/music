package com.music.demo.search.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreLoadingRankJobConfig {

    /**
     * 描述任务详情对象
     * @return
     */
    @Bean
    public JobDetail jobDetailRank() {
        return JobBuilder.newJob(PreRankJob.class)
                .storeDurably(true)
                .build();
    }

    @Bean
    public Trigger triggerRank() {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailRank())
                .withSchedule(CronScheduleBuilder.cronSchedule("0 01 17 * * ? *"))
                .startNow()
                .build();
    }
}
