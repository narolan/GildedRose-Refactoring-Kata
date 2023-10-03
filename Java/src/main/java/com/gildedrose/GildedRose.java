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
            switch(fromName(item.name)) {
                case SULFURAS:
                    sulfarasItemQualityUpdate.updateQuality(item);
                    return;
                case BACKSTAGE_PASSES:
                    backstagePassesItemQualityUpdate.updateQuality(item);
                    return;
                case AGED_BRIE:
                    agedBrieItemQualityUpdate.updateQuality(item);
                    return;
                case CONJURED:
                    conjuredItemQualityUpdate.updateQuality(item);
                    return;
                default:
                    normalItemQualityUpdate.updateQuality(item);
                    return;
            }
        }
    }
}
