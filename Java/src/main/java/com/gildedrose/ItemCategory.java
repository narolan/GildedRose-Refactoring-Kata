package com.gildedrose;

public enum ItemCategory {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    ;

    private final String name;

    ItemCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
