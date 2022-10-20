/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vpdq.formatters.DepartmentFormatter;
import com.vpdq.formatters.MedicalRecordFormatter;
import com.vpdq.formatters.MedicineFormatter;
import com.vpdq.formatters.ServiceFormatter;
import com.vpdq.formatters.StatusFormatter;
import com.vpdq.formatters.SupplierFormatter;
import com.vpdq.formatters.UnitFormatter;
import com.vpdq.formatters.UserFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author vinhp
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.vpdq.controllers",
    "com.vpdq.repository",
    "com.vpdq.service"
})
public class WebAppContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
        conf.enable();
    }

//    //Tao View (chỉ sử dụng khi viết header, footer, content vào 1 file .jsp)
//    @Bean
//    public InternalResourceViewResolver viewResolver ()
//    {
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        
//        r.setPrefix("/WEB-INF/jsp/"); // set cho chua view
//        r.setSuffix(".jsp"); // set hau to file
//        r.setViewClass(JstlView.class);
//        
//        return r;
//    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasenames("messages");
        return m;
    }

    @Override
    public void addFormatters(FormatterRegistry r) {
        r.addFormatter(new UnitFormatter());
        r.addFormatter(new SupplierFormatter());
        r.addFormatter(new StatusFormatter());
//        r.addFormatter(new MedicalRecordFormatter());
        r.addFormatter(new UserFormatter());
        r.addFormatter(new DepartmentFormatter());
        r.addFormatter(new ServiceFormatter());
        r.addFormatter(new MedicalRecordFormatter());
        r.addFormatter(new MedicineFormatter());
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        return v;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "vinhphuvtv2",
                        "api_key", "335115886111226",
                        "api_secret", "Y4A5vCe_8f-liruLKg5FRmjl9tw",
                        "secure", true));
        return cloudinary;
    }
}
