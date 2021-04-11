package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.PosterItem;

@NoArgsConstructor
public class PosterManager {

    private PosterItem[] items = new PosterItem[0];
    private int maxResultCount = 10;

    public PosterManager(int maxResultCount) {
        this.maxResultCount = maxResultCount;
    }

    public void add(PosterItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        PosterItem[] tmp = new PosterItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PosterItem[] getItems() {
        int count = maxResultCount;
        if (maxResultCount > items.length) {
            count = items.length;
        }
        PosterItem[] result = new PosterItem[count];
        for (int i = 0; i < count; i++) {
            result[i] = items[items.length - i - 1];
        }
        return result;
    }

}
