package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();
    private Product[] items = new Product[0];

    public ProductManager() {
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public void add(Product item) {
        Product[] tmp = new Product[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        this.items = tmp;
    }


}