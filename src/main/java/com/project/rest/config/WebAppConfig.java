package com.project.rest.config;

import com.project.service.UserDetailsServiceImpl;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.project.Constant;

import javax.annotation.Resource;

// Говорим, что это конфигурация
@Configuration
// Включаем MVC
@EnableWebMvc
// Указываем где искать контроллеры и остальные компоненты
@ComponentScan(Constant.COMPONENT_PACKAGE)
@PropertySource("classpath:jdbc.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter{

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        // указываем где будут лежать наши веб-страницы
        resolver.setPrefix(Constant.VIEW_FOLDER);
        // формат View который мы будем использовать
        resolver.setSuffix(Constant.VIEW_FORMAT);
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Constant.VIEW_FOLDER + "**").addResourceLocations(Constant.VIEW_FOLDER);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //главной страницы нету, перенаправляем в кабинет пользователя
        registry.addRedirectViewController("/","/home");
        //ресурс кабинета пользователя
        registry.addViewController("/home").setViewName("user");
        //временно
        registry.addViewController("/home/cabinet").setViewName("cabinet");
        //ресурс формы авторизации
        registry.addViewController("/login").setViewName("login");
        //страница 403
        registry.addViewController("/403").setViewName("403");
    }

    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }


}