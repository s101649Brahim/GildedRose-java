package com.gildedrose.modelpossiblesolution;

public class LegendaryItem extends ExtendedItem {
    public static final int LEGENDARY_QUALITY = 80;

    public LegendaryItem(String name, int sellIn) {
        super(name, sellIn, LEGENDARY_QUALITY);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
    }
}
