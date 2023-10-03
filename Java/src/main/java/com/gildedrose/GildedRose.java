package com.gildedrose;

import com.gildedrose.process.AgedBrieItemQualityUpdate;
import com.gildedrose.process.BackstagePassesItemQualityUpdate;
import com.gildedrose.process.NormalItemQualityUpdate;
import com.gildedrose.process.SulfarasItemQualityUpdate;

import static com.gildedrose.ItemCategory.fromName;

class GildedRose {

    Item[] items;
    private final NormalItemQualityUpdate normalItemQualityUpdate;
    private final SulfarasItemQualityUpdate sulfarasItemQualityUpdate;
    private final BackstagePassesItemQualityUpdate backstagePassesItemQualityUpdate;
    private final AgedBrieItemQualityUpdate agedBrieItemQualityUpdate;

    public GildedRose(Item[] items) {
        this.items = items;
        this.normalItemQualityUpdate = new NormalItemQualityUpdate();
        this.sulfarasItemQualityUpdate = new SulfarasItemQualityUpdate();
        this.backstagePassesItemQualityUpdate = new BackstagePassesItemQualityUpdate();
        this.agedBrieItemQualityUpdate = new AgedBrieItemQualityUpdate();
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
                default:
                    normalItemQualityUpdate.updateQuality(item);
                    return;
            }
        }
    }
}
