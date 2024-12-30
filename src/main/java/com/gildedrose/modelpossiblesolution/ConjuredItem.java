package com.gildedrose.modelpossiblesolution;

public class ConjuredItem extends ExtendedItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (super.quality > 0) {
            if (super.sellIn <= 0)
                super.quality = super.quality - 4;
            else
                super.quality = super.quality - 2;
            decreaseSellIn();
        }

        if (super.quality < 0) {
            super.quality = 0;
        }
    }
}
