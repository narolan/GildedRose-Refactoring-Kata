package com.gildedrose;

import java.util.Objects;

import static com.gildedrose.ItemCategory.*;

class GildedRose {
    Item[] items;
    NormalItemQualityUpdate normalItemQualityUpdate;

    public GildedRose(Item[] items) {
        this.items = items;
        this.normalItemQualityUpdate = new NormalItemQualityUpdate();
    }

    public void updateQuality() {
        for (Item item : items) {
            if (NORMAL.equals(fromName(item.name))) {
                normalItemQualityUpdate.updateQuality(item);
                return;
            }

            if (!item.name.equals(AGED_BRIE.getName())
                    && !item.name.equals(BACKSTAGE_PASSES.getName())) {
                if (item.quality > 0) {
                    if (item.name.equals(SULFURAS.getName())) {
                        //do nothing
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES.getName())) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS.getName())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE.getName())) {
                    if (!item.name.equals(BACKSTAGE_PASSES.getName())) {
                        if (item.quality > 0) {
                            if (item.name.equals(SULFURAS.getName())) {
                                //do nothing
                            }
                        }
                    } else {
                      item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
