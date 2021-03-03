package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService{
    private static Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Samsung Note 20", "20000000", "May ngon"));
        products.put(2, new Product(2, "Iphone 12 pro max", "32000000", "256Gb"));
        products.put(3, new Product(3, "Sony XZ3", "12000000", "Nope"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
