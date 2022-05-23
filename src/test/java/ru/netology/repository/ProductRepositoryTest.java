package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.ProductManager;
import ru.netology.domain.Smartphone;


import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book;
    private Smartphone smartphone;
    ProductManager manager = new ProductManager(repository);


    Product book1 = new Book(1, "WarAndPeace", 345, "Tolstoy");
    Product book2 = new Book(2, "Ono", 569, "King");
    Product book3 = new Book(3, "Ispoved", 449, "Tolstoy");
    Product smartphone1 = new Smartphone(4, "IPhone", 99000, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy", 68000, "Samsung");


    @Test
    public void testShouldSave1() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testShouldSave2() {
        repository.save(smartphone1);
        repository.save(smartphone2);
        Product[] expected = new Product[]{smartphone1, smartphone2};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void testRemoveById() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);

        repository.removeById(3);

        Product[] actual = repository.getAll();
        Product[] expected = new Product[]{book1, book2, smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testRemoveById2() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);

        repository.removeById(5);

        Product[] actual = repository.getAll();
        Product[] expected = new Product[]{book1, book2, book3, smartphone1};
        assertArrayEquals(expected, actual);
    }
}
