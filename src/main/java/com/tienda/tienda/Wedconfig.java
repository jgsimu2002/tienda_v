
package com.tienda.tienda;

import java.util.Locale;
import org.springframework.boot.autoconfigure.web.WebProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class Wedconfig implements WedMvcConfigurer{
    
    @Bean
    
    public LocaleResolver localeResolver() {
    var slr = new SessionLocaleResolver();
    slr.setDefaultLocale(new Locale("es"));
    return slr;
    }
    
    @Bean
    
    public LocaleChangeInterceptor localeChanceInterceptor () {
    var lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro) {
    registro.addInterceptor (localeChanceInterceptor());
    }
}
