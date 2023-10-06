package com.gildedrose;

import com.gildedrose.process.*;

import static com.gildedrose.ItemCategory.fromName;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemCategory itemCategory = fromName(item.name);
            ItemQualityUpdate itemQualityUpdater = ItemQualityUpdateFactory.getItemQualityUpdater(itemCategory);
            itemQualityUpdater.updateQuality(item);
        }
    }
}
