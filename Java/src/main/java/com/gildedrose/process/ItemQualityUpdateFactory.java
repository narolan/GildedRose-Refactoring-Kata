package com.gildedrose.process;

import com.gildedrose.ItemCategory;

public class ItemQualityUpdateFactory {

    public static ItemQualityUpdate getItemQualityUpdater(ItemCategory itemCategory) {
        switch (itemCategory) {
            case AGED_BRIE:
                return new AgedBrieItemQualityUpdate();
            case BACKSTAGE_PASSES:
                return new BackstagePassesItemQualityUpdate();
            case SULFURAS:
                return new SulfarasItemQualityUpdate();
            case CONJURED:
                return new ConjuredItemQualityUpdate();
            default:
                return new NormalItemQualityUpdate();
        }
    }
}
