package com.example.config;

import com.example.config.WebConfig;
import com.example.controllers.EventController;
import com.example.entity.Event;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// To bootstrap an application that loads this configuration, we also need an initializer class
public class MainWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.scan("com.example");
        context.register(WebConfig.class);

        servletContext.addListener(new ContextLoaderListener(context));
        context.setServletContext(servletContext);

        // Create and register the DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");


//        EventController eventController = (EventController) context.getBean("eventController");
//        Event event = eventController.createNewEvent();
//        System.out.println("Event Name: " + event.getName());
//        System.out.println("Event Date: " + event.getEventDate());
//        System.out.println("Event Participants: " + event.getParticipants());

    }


}
