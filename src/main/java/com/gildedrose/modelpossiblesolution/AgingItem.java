package com.gildedrose.modelpossiblesolution;

public class AgingItem extends ExtendedItem {

    public AgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (super.quality < 50) {
            super.quality++;
        }
        decreaseSellIn();
    }
}
