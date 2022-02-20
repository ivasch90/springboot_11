package ru.gb.springboot_1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.gb.springboot_1.dao.product.ProductDao;
import ru.gb.springboot_1.entity.Product;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;


@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductDao productDao;
    private Sort sort;


    public Product save(Product product) {
        return productDao.save(product);
    }

    public Product findById(Long id) {
        return productDao.findById(id).get();
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);

    }

    public List<Product> findAllSortedByCost(String sortName) {
        List<Product> allSortedByCost;

        if (sortName.equals("asc")) {
            allSortedByCost = productDao.findAll(Sort.by(Sort.Direction.ASC, "cost"));
        } else {
            allSortedByCost = productDao.findAll(Sort.by(DESC, "cost"));
        }

        return allSortedByCost;
    }
}
