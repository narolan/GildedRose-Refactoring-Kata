package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemCategory.*;
import static com.gildedrose.ItemCategory.BACKSTAGE_PASSES;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Nested
    class NormalItems {

        @Test
        void normalItemUpdateDoesNotDecreaseQualityBelowZero() {
            Item[] items = new Item[] { new Item("foo", 0, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void normalItemUpdateDecreasesQualityByOne() {
            Item[] items = new Item[] { new Item("foo", 1, 1) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void normalItemUpdateDoesNotDecreaseBelowZero() {
            Item[] items = new Item[] { new Item("foo", 1, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void normalItemUpdate_whenAfterSellInDate_decreasesQualityTwice() {
            Item[] items = new Item[] { new Item("foo", -1, 5) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
            assertEquals(-2, app.items[0].sellIn);
            assertEquals(3, app.items[0].quality);
        }
    }

    @Nested
    class SulfurasItems {

        @Test
        void sulfurasItemUpdateDoesNotChangeQualityOrSellIn() {
            Item[] items = new Item[] { new Item(SULFURAS.getName(), 1, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(SULFURAS.getName(), app.items[0].name);
            assertEquals(1, app.items[0].sellIn);
            assertEquals(20, app.items[0].quality);
        }

        @Test
        void sulfurasItemUpdate_whenAfterSellInDate_doNothingToQuality() {
            Item[] items = new Item[] { new Item(SULFURAS.getName(), -1, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(SULFURAS.getName(), app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(20, app.items[0].quality);
        }

        @Test
        void sulfurasItemUpdate_whenAfterSellInDateAndNegativeQuality_doNothingToQuality() {
            Item[] items = new Item[] { new Item(SULFURAS.getName(), -1, -20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(SULFURAS.getName(), app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(-20, app.items[0].quality);
        }
    }

    @Nested
    class AgedBrieItems {

        @Test
        void agedBrieItemUpdateIncreasesQuality() {
            Item[] items = new Item[] { new Item(AGED_BRIE.getName(), 1, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(AGED_BRIE.getName(), app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(21, app.items[0].quality);
        }

        @Test
        void agedBrieItemUpdateDoesNotGoAbove50Quality() {
            Item[] items = new Item[] { new Item(AGED_BRIE.getName(), 1, 50) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(AGED_BRIE.getName(), app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void agedBrieItemUpdate_whenAfterSellInDate_increasesQualityByTwo() {
            Item[] items = new Item[] { new Item(AGED_BRIE.getName(), -1, 5) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(AGED_BRIE.getName(), app.items[0].name);
            assertEquals(-2, app.items[0].sellIn);
            assertEquals(7, app.items[0].quality);
        }

        @Test
        void agedBrieItemUpdate_whenAfterSellInDateAndQuality50_doNotIncreaseQuality() {
            Item[] items = new Item[] { new Item(AGED_BRIE.getName(), -1, 50) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(AGED_BRIE.getName(), app.items[0].name);
            assertEquals(-2, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }
    }

    @Nested
    class BackstagePassesItems {

        @Test
        void backstagePassItemUpdateIncreasesQuality() {
            Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getName(), 11, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
            assertEquals(10, app.items[0].sellIn);
            assertEquals(21, app.items[0].quality);
        }

        @Test
        void backstagePassItemUpdate_whenLessThan11DaysLef_increasesQualityTwice() {
            Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getName(), 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
            assertEquals(9, app.items[0].sellIn);
            assertEquals(22, app.items[0].quality);
        }

        @Test
        void backstagePassItemUpdate_whenLessThan11DaysLef_increasesQualityTwiceAndDoesNotGoOver50() {
            Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getName(), 10, 49) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
            assertEquals(9, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void backstagePassItemUpdate_whenLessThan6DaysLef_increasesQualityTwice() {
            Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getName(), 5, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
            assertEquals(4, app.items[0].sellIn);
            assertEquals(23, app.items[0].quality);
        }

        @Test
        void backstagePassItemUpdate_whenLessThan6DaysLef_increasesQualityTwiceAndDoesNotGoOver50() {
            Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getName(), 5, 49) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
            assertEquals(4, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void backstagePassItemUpdateNotGoAbove50Quality() {
            Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getName(), 1, 50) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void backstagePassItemUpdate_whenAfterSellInDate_decreasesQualityToZero() {
            Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getName(), -1, 5) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
            assertEquals(-2, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }
    }

    @Nested
    class ConjuredItems {
        @Test
        void conjuredItemUpdateDoesNotDecreaseQualityBelowZero() {
            Item[] items = new Item[] { new Item(CONJURED.getName(), 0, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(CONJURED.getName(), app.items[0].name);
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void conjuredItemUpdateDecreasesQualityByTwo() {
            Item[] items = new Item[] { new Item(CONJURED.getName(), 1, 3) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(CONJURED.getName(), app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(1, app.items[0].quality);
        }

        @Test
        void conjuredItemUpdateDoesNotDecreaseBelowZero() {
            Item[] items = new Item[] { new Item(CONJURED.getName(), 1, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(CONJURED.getName(), app.items[0].name);
            assertEquals(0, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void conjuredItemUpdate_whenAfterSellInDate_decreasesQualityByFour() {
            Item[] items = new Item[] { new Item(CONJURED.getName(), -1, 5) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(CONJURED.getName(), app.items[0].name);
            assertEquals(-2, app.items[0].sellIn);
            assertEquals(1, app.items[0].quality);
        }

        @Test
        void conjuredItemUpdate_whenQualityWouldGoBelowZero_qualityRemainsZero() {
            Item[] items = new Item[] { new Item(CONJURED.getName(), -1, 1) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(CONJURED.getName(), app.items[0].name);
            assertEquals(-2, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }
    }
}
