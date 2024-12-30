package com.gildedrose.modelpossiblesolution;

import com.gildedrose.Item;

public class ExtendedItem extends Item {
    public ExtendedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (super.quality > 0) {
            if (super.sellIn <= 0)
                super.quality = super.quality - 2;
            else
                super.quality--;
        }
        decreaseSellIn();
        if (super.quality < 0) {
            super.quality = 0;
        }
    }

    public void decreaseSellIn() {
        if (super.sellIn > 0)
            super.sellIn--;
    }
}
