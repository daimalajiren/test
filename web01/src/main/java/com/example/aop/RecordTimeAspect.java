package com.example.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
@Component
public class RecordTimeAspect {

    @Pointcut("execution(* com.example.service.impl.*.*(..))")
    public void pt(){}

    @Around("pt()")
        public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
            System.out.println("记录时间");
            long begin  = System.currentTimeMillis();


                Object result = pjp.proceed();


            long end = System.currentTimeMillis();
            log.info("{}耗时：{}",pjp.getSignature().getName(),end-begin);
            return result;
        }
        @Before("pt()")
    public void before(){
            log.info("开始执行");
        }
        @After("pt()")
    public void after(){
            log.info("结束执行");
        }
}
