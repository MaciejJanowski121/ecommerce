package org.example.ecommerce;

import org.example.ecommerce.model.Product;
import org.example.ecommerce.repository.ProductRepository;
import org.example.ecommerce.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// ProductServiceTest.java
class ProductServiceTest {


    @Test
    void testConstructorAndGetters() {
        Product product = new Product(1L, "Testprodukt", 9.99);

        assertEquals(1L, product.getId());
        assertEquals("Testprodukt", product.getName());
        assertEquals(9.99, product.getPrice());
    }

    @Test
    void testSetters() {
        Product product = new Product();
        product.setId(2L);
        product.setName("Neues Produkt");
        product.setPrice(19.99);

        assertEquals(2L, product.getId());
        assertEquals("Neues Produkt", product.getName());
        assertEquals(19.99, product.getPrice());
    }
}

//Proof