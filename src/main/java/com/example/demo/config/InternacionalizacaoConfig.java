package com.example.demo.config;

import java.util.Locale;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizacaoConfig {

//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("classpath:messages");
//		messageSource.setDefaultEncoding("ISO-8859-1");
//		messageSource.setDefaultLocale(Locale.getDefault());
//		return messageSource();
//	}
//	
//	@Bean
//	public LocalValidatorFactoryBean localValidatorFactoryBean() {
//		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//		bean.setValidationMessageSource(messageSource());
//		return bean;
//	}
	
	@Bean
	public PropertiesFactoryBean propertiesFactoryBean() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setFileEncoding("UTF-8");
		bean.setLocation(new ClassPathResource("messages.properties"));   
		return bean;
	}
}
