package com.example.SpringFirstProjectWithJSPPagesWithNormalPages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig {
	
	Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Bean
    public ViewResolver jspViewResolver() {
    	logger.info("Calling the jspViewResolver method okay");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);  // Ensures JSTL support
        return resolver;
    }
}
