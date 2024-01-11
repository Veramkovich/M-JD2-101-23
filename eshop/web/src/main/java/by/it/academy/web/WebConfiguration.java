package by.it.academy.web;

import by.it.academy.service.ServiceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "by.it.academy.web")
@Import(ServiceConfiguration.class)
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    @SuppressWarnings("unused")
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*.html")
                .addResourceLocations("/");

        registry.addResourceHandler("/static/img/*.jpg")
                .addResourceLocations("/static/img/");

        // https://github.com/swagger-api/swagger-ui/blob/master/docs/usage/installation.md
        registry.addResourceHandler("/static/swagger/*")
                .addResourceLocations("/static/swagger/");

    }

    @Bean
    @SuppressWarnings("unused")
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
