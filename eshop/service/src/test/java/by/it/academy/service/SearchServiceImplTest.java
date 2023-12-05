package by.it.academy.service;

import by.it.academy.service.model.ProductSpecification;
import by.it.academy.service.model.SearchCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfigurationTest.class)
public class SearchServiceImplTest {

    @Autowired
    SearchService searchService;

    @Test
    public void searchProducts() throws Exception {
        // Given
        assertNotNull(searchService);
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setProductNameCriteria("Product2");

        // When
        List<ProductSpecification> productSpecifications = searchService.searchProducts(searchCriteria);

        // Then
        assertEquals(1, productSpecifications.size());
        assertEquals(2002.02, productSpecifications.get(0).getProductPrice(), 0);
    }
}