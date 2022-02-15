package ru.gb.springboot_1.dao.product;

import ru.gb.springboot_1.entity.Product;

public interface ProductDao {
    Iterable<Product> findAll();
    Product findById(Long id);
    String findNameById(Long id);
    void insert(Product product);
    Product save(Product product);
    void deleteById(Long id);
}
