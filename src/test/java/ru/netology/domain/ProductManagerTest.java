package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(1, "WarAndPeace", 345, "Tolstoy");
    Product book2 = new Book(2, "Ono", 569, "King");
    Product book3 = new Book(3, "Ispoved", 449, "Tolstoy");
    Product smartphone1 = new Smartphone(4, "IPhone", 99000, "Apple");
    Product smartphone2 = new Smartphone(5, "GalaxyP", 68000, "Samsung");
    Product smartphone3 = new Smartphone(6, "GalaxyS", 78000, "Samsung");

    @Test
    void testSearchBookByName1() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("WarAndPeace");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchBookByName2() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Ono");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchBookByName3() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Kniga");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchSmartphoneByName1() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("IPhone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchSmartphoneByName2() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] expected = new Product[]{smartphone2, smartphone3};
        Product[] actual = manager.searchBy("Galaxy");
        assertArrayEquals(expected, actual);
    }

}

