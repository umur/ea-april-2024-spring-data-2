package miu.ea.group3g.lab4.aop;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Getter
@Setter
@RequiredArgsConstructor
public class AppConfig implements WebMvcConfigurer {

    private final ControllerAdviceInterceptor controllerAdviceInterceptor;

//    @Autowired
//    AppConfig(ControllerAdviceInterceptor controllerAdviceInterceptor) {
//        this.controllerAdviceInterceptor = controllerAdviceInterceptor;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(controllerAdviceInterceptor);
    }
}
