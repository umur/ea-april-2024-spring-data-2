package edu.miu.cs544.labs.lab3.aspect;

import edu.miu.cs544.labs.lab3.entity.ActivityLog;
import edu.miu.cs544.labs.lab3.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService activityLogService;

    @Around("@annotation(edu.miu.cs544.labs.lab3.annotation.ExecutionTime)")
    public Object run(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object process = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;

        ActivityLog activityLog = new ActivityLog(
                LocalDate.now(),
                proceedingJoinPoint.getSignature().getName(),
                duration);
        activityLogService.add(activityLog);

        return process;
    }

}
