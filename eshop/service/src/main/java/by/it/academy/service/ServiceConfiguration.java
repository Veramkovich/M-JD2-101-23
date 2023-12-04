package by.it.academy.service;

import by.it.academy.data.EShopSessionFactory;
import by.it.academy.data.dao.ProductSpecificationDao;
import by.it.academy.data.dao.ProductSpecificationDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "by.it.academy.service")
public class ServiceConfiguration {

    @Bean(name = "DAO1")
    @Primary
    public ProductSpecificationDao dao1() {
        return new ProductSpecificationDaoImpl(EShopSessionFactory.getSessionFactory());
    }

    @Bean(name = "DAO2")
    public ProductSpecificationDao dao2() {
        return new ProductSpecificationDaoImpl(EShopSessionFactory.getSessionFactory());
    }

}
