package com.zyt.utils.job;

import com.zyt.App;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class QuartzTest {

    @SneakyThrows
    @Test
    public void jobExecution4SimpleTriggerTest() {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class).withIdentity("job1", "group1").build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("---- scheduler start ! ------");
        scheduler.start();

        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("---- scheduler shutdown ! ------");

    }

    @SneakyThrows
    @Test
    public void jobExecution4CronTriggerTest() {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .usingJobData("jobDetail1", "这个Job用来测试的")
                .withIdentity("job1", "group1").build();

        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 5 * 1000);

        Date endDate = new Date();
        endDate.setTime(startDate.getTime() + 60 * 1000);

        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .usingJobData("trigger1", "这是jobDetail1的trigger")
                .startNow()
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();


        scheduler.scheduleJob(jobDetail, cronTrigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();

        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");
    }


}
