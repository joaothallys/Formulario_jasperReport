package edu.br.pucgoias.relatorio.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/classes/edu/br/pucgoias/relatorio/");
        resolver.setSuffix(".jasper");
        resolver.setViewNames("relatorio");
        resolver.setOrder(1);
        return resolver;
    }
}
