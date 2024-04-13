package miu.ea.group3g.lab4.aop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Slf4j
public class ControllerAdviceInterceptor implements HandlerInterceptor {
    private long startTime = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("--- Request Started ---");
        startTime = System.currentTimeMillis();
        log.info("*** Before Memory " + (Runtime.getRuntime().totalMemory() / 1024 / 1024 + " / " + Runtime.getRuntime().freeMemory() / 1024 / 1024) + " Mb");
        //call GC to clean up memory
        Runtime.getRuntime().gc();
        return true;
    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response,
//                           Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("---method executed---");
//    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("--- Request Completed ---");
        long endTime = System.currentTimeMillis();
        log.info("Time taken: " + (endTime - startTime) + "ms");
        log.info("*** After Memory " + (Runtime.getRuntime().totalMemory() / 1024 / 1024 + " / " + Runtime.getRuntime().freeMemory() / 1024 / 1024) + " Mb");
        //call GC to clean up memory
        Runtime.getRuntime().gc();
    }
}