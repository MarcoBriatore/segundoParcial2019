package com.utn.parcial.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

    private static final int CORE_POL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 5;
    private static final int QUEUE_CAPACITY = 50;

    @Bean("threadPoolTaskExecutor")
    public Executor asyncExecutor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);

        executor.initialize();

        return executor;
    }

}
