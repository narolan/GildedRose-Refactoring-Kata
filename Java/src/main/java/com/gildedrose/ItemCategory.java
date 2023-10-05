package com.gildedrose;

import java.util.Arrays;

public enum ItemCategory {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake"),
    NORMAL("");
    ;

    private final String name;

    ItemCategory(String name) {
        this.name = name;
    }

    public static ItemCategory fromName(String name) {
        return Arrays.stream(ItemCategory.values())
            .filter(itemCategory -> itemCategory.getName().equals(name))
            .findFirst()
            .orElse(NORMAL);
    }

    public String getName() {
        return name;
    }
}
