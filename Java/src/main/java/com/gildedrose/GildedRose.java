package com.gildedrose;

import com.gildedrose.process.*;

import static com.gildedrose.ItemCategory.fromName;

class GildedRose {

    Item[] items;
    private final NormalItemQualityUpdate normalItemQualityUpdate;
    private final SulfarasItemQualityUpdate sulfarasItemQualityUpdate;
    private final BackstagePassesItemQualityUpdate backstagePassesItemQualityUpdate;
    private final AgedBrieItemQualityUpdate agedBrieItemQualityUpdate;
    private final ConjuredItemQualityUpdate conjuredItemQualityUpdate;

    public GildedRose(Item[] items) {
        this.items = items;
        this.normalItemQualityUpdate = new NormalItemQualityUpdate();
        this.sulfarasItemQualityUpdate = new SulfarasItemQualityUpdate();
        this.backstagePassesItemQualityUpdate = new BackstagePassesItemQualityUpdate();
        this.agedBrieItemQualityUpdate = new AgedBrieItemQualityUpdate();
        this.conjuredItemQualityUpdate = new ConjuredItemQualityUpdate();
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemCategory itemCategory = fromName(item.name);
            ItemQualityUpdate itemQualityUpdater = ItemQualityUpdateFactory.getItemQualityUpdater(itemCategory);
            itemQualityUpdater.updateQuality(item);
        }
    }
}
