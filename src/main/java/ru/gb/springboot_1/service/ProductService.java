package ru.gb.springboot_1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springboot_1.dao.product.JpaProductDao;
import ru.gb.springboot_1.entity.Product;
import ru.gb.springboot_1.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    //private final ProductRepository productRepository;
    private final JpaProductDao jpaProductDao;


    public Product save(Product product) {
        return jpaProductDao.save(product);
    }

    public Product findById(Long id) {
        return jpaProductDao.findById(id);
    }

    public List<Product> findAll() {
        return (List<Product>) jpaProductDao.findAll();
    }


    public void deleteById(Long id) {
        jpaProductDao.deleteById(id);

    }
}
