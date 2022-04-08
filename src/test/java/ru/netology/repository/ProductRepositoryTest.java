package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.ProductManager;
import ru.netology.domain.Smartphone;


import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book core1 = new Book();
    private Smartphone core2 = new Smartphone();
    ProductManager manager = new ProductManager();

    Product first = new Book(1, "WarAndPeace", 345, "Tolstoy");
    Product second = new Book(2, "Ono", 569, "King");
    Product third = new Smartphone(3, "IPhone", 99000, "Apple");
    Product fourth = new Smartphone(4, "Galaxy", 68000, "Samsung");


    @Test
    public void shouldsave() {
        repository.save(core1);

        Product[] expected = new Product[]{core1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {

        repository.save(core1);
        Product[] expected = new Product[]{core1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(3);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, fourth};
        assertArrayEquals(expected, actual);
    }

}
