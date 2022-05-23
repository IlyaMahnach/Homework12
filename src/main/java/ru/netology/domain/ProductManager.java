package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    public ProductRepository repository;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
