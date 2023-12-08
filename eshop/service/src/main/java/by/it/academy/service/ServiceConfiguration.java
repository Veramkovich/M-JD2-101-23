package by.it.academy.service;

import by.it.academy.data.DataConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.it.academy.service")
@Import(DataConfiguration.class)
public class ServiceConfiguration {

}
