package com.revature.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
public class LoggingAspect {
    private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    public LoggingAspect()
    {
        log.info("Logging Initiated.");
    }

    //Very simple logging. With time, will make this a lot better.
    @Before("within(com.revature.controllers.*.*)")
    public void logControllerMethods(JoinPoint jp)
    {
        log.info("-=CONTROLLER=-");
        log.info(jp.getTarget()+ "invoked "+jp.getSignature());
    }

    @Before("within(com.revature.services.*.*)")
    public void logServiceMethods(JoinPoint jp)
    {
        log.info("-=SERVICE=-");
        log.info(jp.getTarget()+ "invoked "+jp.getSignature());
    }
}
