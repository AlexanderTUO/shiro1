package com.itdragon.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: itdragon
 * @Date: 2019/5/14 10:54
 * @Description:
 */
@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        WebSiteMeshFilter siteMeshFilter = new WebSiteMeshFilter();
        filterRegistrationBean.setFilter(siteMeshFilter);
        return filterRegistrationBean;
    }
}
