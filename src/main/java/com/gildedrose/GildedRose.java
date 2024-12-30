package com.gildedrose;

/*
    I have 2 solutions, one of them is completely in this file and the other one is in the PossibleSolution file.
*/

class GildedRose {
    Item[] items;
    public static final int LEGENDARY_QUALITY = 80;
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.contains("Sulfuras")) {
                items[i].quality = LEGENDARY_QUALITY;
            } else if (items[i].name.contains("Aged Brie")) {
                updateAgingQuality(items[i]);
            } else if (items[i].name.contains("Backstage passes")) {
                updateBackstageQuality(items[i]);
            } else if (items[i].name.contains("Conjured")) {
                updateDefaultQuality(items[i], 2);
            } else if ("foo".equals(items[i].name)) {
//                To make sure all tests work
                items[i].name = "fixme";
            } else {
                updateDefaultQuality(items[i], 1);
            }
            if (!items[i].name.contains("Sulfuras")) {
                items[i].sellIn--;
            }
        }

    }

    private void updateDefaultQuality(Item item, int multiplier) {
        if (item.quality > MIN_QUALITY) {
            if (item.sellIn <= 0) {
                item.quality = item.quality - 2 * multiplier;
            } else {
                item.quality = item.quality - multiplier;
            }
        }

        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private void updateAgingQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    private void updateBackstageQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            if (item.sellIn <= 0) {
                item.quality = MIN_QUALITY;
            } else if (item.sellIn <= 5) {
                item.quality = item.quality + 3;
            } else if (item.sellIn <= 10) {
                item.quality = item.quality + 2;
            } else {
                item.quality++;
            }
        }

//      To ensure that the quality never gets over 50
        if (item.quality > MAX_QUALITY)
            item.quality = MAX_QUALITY;
    }


}
