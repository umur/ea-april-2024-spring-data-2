package edu.miu.cs544.labs.lab3.aspect;

import edu.miu.cs544.labs.lab3.exception.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AopIsAwesomeAspect {
    @Before("execution(* edu.miu.cs544.labs.lab3.controller.*Controller.*(..)) && @annotation(postMapping)")
    public void run(PostMapping postMapping) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String value = request.getHeader("AOP-IS-AWESOME");

        if (value == null) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing in the request");
        }
    }



}
