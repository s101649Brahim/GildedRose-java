package com.gildedrose.modelpossiblesolution;

public class LifeSpanItem extends ExtendedItem {
    public LifeSpanItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (super.quality < 50) {
            if (super.sellIn == 0)
                super.quality = 0;
            else if (super.sellIn <= 5)
                super.quality = super.quality + 3;
            else if (super.sellIn <= 10)
                super.quality = super.quality + 2;
            else
                super.quality++;
        }

//      To ensure that the quality never gets over 50
        if (super.quality > 50)
            super.quality = 50;

        decreaseSellIn();
    }
}
