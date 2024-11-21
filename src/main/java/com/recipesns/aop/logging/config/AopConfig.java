package com.recipesns.aop.logging.config;

import com.recipesns.aop.logging.aspect.LogTraceAspect;
import com.recipesns.aop.logging.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
