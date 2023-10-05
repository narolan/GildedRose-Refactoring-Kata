package com.gildedrose.process;

import com.gildedrose.Item;

public class BackstagePassesItemQualityUpdate implements ItemQualityUpdate {

    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            if(item.sellIn<6) {
                item.quality += 3;
            } else if(item.sellIn<11) {
                item.quality += 2;
            } else {
                item.quality++;
            }
            if (item.quality > 50) {
                item.quality = 50;
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
