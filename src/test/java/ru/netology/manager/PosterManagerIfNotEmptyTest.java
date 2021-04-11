package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PosterManagerIfNotEmptyTest {

    private PosterManager posterManager;

    @BeforeEach
    void setUp() {
        posterManager = new PosterManager(4);
        PosterItem item1 = new PosterItem(1, "Бладшот", "боевик", "http://test1", false);
        PosterItem item2 = new PosterItem(2, "Вперед", "мультфильм", "http://test2", false);
        PosterItem item3 = new PosterItem(3, "Отель \"Белград\"", "комедия", "http://test3", false);
        posterManager.add(item1);
        posterManager.add(item2);
        posterManager.add(item3);
    }

    @Test
    void add() {
        PosterItem item = new PosterItem(4, "Джентельмены", "боевик", "http://test4", false);
        posterManager.add(item);
        assertEquals(posterManager.getItems()[0],
                new PosterItem(4, "Джентельмены", "боевик", "http://test4", false));
    }

    @Test
    void getItemsIfCountLessMaxResultCount() {
        PosterItem[] items = posterManager.getItems();
        assertEquals(3, items.length);
        PosterItem item1 = new PosterItem(1, "Бладшот", "боевик", "http://test1", false);
        PosterItem item2 = new PosterItem(2, "Вперед", "мультфильм", "http://test2", false);
        PosterItem item3 = new PosterItem(3, "Отель \"Белград\"", "комедия", "http://test3", false);
        PosterItem[] expectedItems = new PosterItem[3];
        expectedItems[0] = item3;
        expectedItems[1] = item2;
        expectedItems[2] = item1;
        assertArrayEquals(expectedItems, items);
    }

    @Test
    void getItemsIfCountEqualMaxResultCount() {
        PosterItem item1 = new PosterItem(1, "Бладшот", "боевик", "http://test1", false);
        PosterItem item2 = new PosterItem(2, "Вперед", "мультфильм", "http://test2", false);
        PosterItem item3 = new PosterItem(3, "Отель \"Белград\"", "комедия", "http://test3", false);
        PosterItem item4 = new PosterItem(4, "Джентельмены", "боевик", "http://test4", false);
        PosterItem[] expectedItems = new PosterItem[4];
        expectedItems[0] = item4;
        expectedItems[1] = item3;
        expectedItems[2] = item2;
        expectedItems[3] = item1;
        posterManager.add(new PosterItem(4, "Джентельмены", "боевик", "http://test4", false));
        PosterItem[] items = posterManager.getItems();
        assertArrayEquals(expectedItems, items);
    }


    @Test
    void getItemsIfCountAboveMaxResultCount() {
        PosterItem item2 = new PosterItem(2, "Вперед", "мультфильм", "http://test2", false);
        PosterItem item3 = new PosterItem(3, "Отель \"Белград\"", "комедия", "http://test3", false);
        PosterItem item4 = new PosterItem(4, "Джентельмены", "боевик", "http://test4", false);
        PosterItem item5 = new PosterItem(5, "Человек невидимка", "ужасы", "http://test5", false);
        PosterItem[] expectedItems = new PosterItem[4];
        expectedItems[0] = item5;
        expectedItems[1] = item4;
        expectedItems[2] = item3;
        expectedItems[3] = item2;
        posterManager.add(new PosterItem(4, "Джентельмены", "боевик", "http://test4", false));
        posterManager.add(new PosterItem(5, "Человек невидимка", "ужасы", "http://test5", false));
        PosterItem[] items = posterManager.getItems();
        assertArrayEquals(expectedItems, items);
    }
}