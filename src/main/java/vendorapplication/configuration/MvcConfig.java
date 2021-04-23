package vendorapplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.context.MessageSource;
import vendorapplication.utilities.Constants;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        //  SessionLocaleResolver slr = new SessionLocaleResolver();
        // slr.setDefaultLocale(Locale.US);
        // return slr;
        return new CookieLocaleResolver();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName(Constants.lang);
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean(Constants.messageSource)
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames(Constants.lang_messages);
        messageSource.setDefaultEncoding(Constants.utf8);
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
}