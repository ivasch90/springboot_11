package ru.gb.springboot_1.dao.product;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springboot_1.entity.Product;



public interface ProductDao extends JpaRepository<Product, Long> {
    //List<Product> findAllByCostOrderByCost(Sort. Direction direction);
    //List<Product> findAllByCostOrderByCostDesc(Sort direction);



}
