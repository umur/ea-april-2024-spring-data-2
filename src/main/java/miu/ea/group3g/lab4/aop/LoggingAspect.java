package miu.ea.group3g.lab4.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        long totalUsedBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info("*** Before Memory Used " + totalUsedBefore/1024/1024 + " Mb");

        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long totalUsedAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        log.info(joinPoint.getSignature() + " executed in " + (endTime - startTime) + "ms");
        log.info(" After Memory used: " + totalUsedAfter/1024/1024 + " Mb");
        log.info(" Memory consumed: " + (totalUsedAfter - totalUsedBefore)/1024/1024 + " Mb");
        return proceed;
    }
}
