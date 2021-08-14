package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// To enable Spring MVC support through a Java configuration class, all we have to do is add the @EnableWebMvc annotation
// This will set up the basic support we need for an MVC project,
// such as registering controllers and mappings, type converters, validation support, message converters and exception handling.
// to define and scan additional controller classes
// If we want to customize this configuration, we need to implement the WebMvcConfigurer interface
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.example" })
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    //In this example, we've registered a ViewResolver bean that will return .jsp views from the /WEB-INF/view directory.
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        //bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        bean.setExposeContextBeansAsAttributes(true);

        return bean;
    }
}
