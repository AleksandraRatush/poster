package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerIfEmptyTest {

    private PosterManager posterManager;

    @BeforeEach
    void setUp() {
        posterManager = new PosterManager();
    }

    @Test
    void add() {
        PosterItem item = new PosterItem(1, "Бладшот", "Боевик", "http://test", false);
        PosterItem[] array = new PosterItem[1];
        array[0] = item;
        posterManager.add(new PosterItem(1, "Бладшот", "Боевик", "http://test", false));
        assertArrayEquals(array, posterManager.getItems());
    }

    @Test
    void getItems() {
        PosterItem[] items = posterManager.getItems();
        PosterItem[] array = new PosterItem[0];
        assertEquals(0, items.length);
        assertArrayEquals(array,items);
    }
}