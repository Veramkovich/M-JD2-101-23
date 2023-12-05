package by.it.academy.service;

import by.it.academy.data.dao.ProductSpecificationDao;
import by.it.academy.data.model.ProductSpecificationDto;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import java.util.List;

import static org.mockito.Mockito.when;

@Configuration
@Import(ServiceConfiguration.class)
public class ServiceConfigurationTest {

    @Bean(name = "DAO1")
    @Primary
    public ProductSpecificationDao dao1() throws Exception {
        ProductSpecificationDao mock = Mockito.mock(ProductSpecificationDao.class);
        when(mock.read()).thenReturn(List.of(
                        new ProductSpecificationDto(1L, "Product1", 1001.01),
                        new ProductSpecificationDto(2L, "Product2", 2002.02),
                        new ProductSpecificationDto(3L, "Product3", 3003.03)
                )
        );
        return mock;
    }

    @Bean(name = "DAO2")
    public ProductSpecificationDao dao2() {
        ProductSpecificationDao mock = Mockito.mock(ProductSpecificationDao.class);
        return mock;
    }
}
