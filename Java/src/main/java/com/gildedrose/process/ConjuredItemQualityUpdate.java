package com.gildedrose.process;

import com.gildedrose.Item;

public class ConjuredItemQualityUpdate implements ItemQualityUpdate {

    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
        }

        item.sellIn--;

        if(item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality -= 2;
            }
        }

        if(item.quality < 0) {
            item.quality = 0;
        }
    }
}
