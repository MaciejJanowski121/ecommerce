package org.example.ecommerce;

import org.example.ecommerce.model.Product;
import org.example.ecommerce.repository.ProductRepository;
import org.example.ecommerce.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductTest {

    private ProductRepository repository;
    private ProductService service;

    @BeforeEach
    void setUp() {
        repository = mock(ProductRepository.class);
        service = new ProductService(repository);
    }

    @Test
    void getAllProducts_shouldReturnListOfProducts() {
        // Given
        Product product1 = new Product(1L, "Test Product 1", 10.0);
        Product product2 = new Product(2L, "Test Product 2", 20.0);

        when(repository.findAll()).thenReturn(Arrays.asList(product1, product2));

        // When
        List<Product> result = service.getAllProducts();

        // Then
        assertEquals(2, result.size());
        assertEquals("Test Product 1", result.get(0).getName());
        verify(repository, times(1)).findAll();
    }
}

//Proof
//Proof
//Proof