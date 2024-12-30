package com.gildedrose;

import com.gildedrose.modelpossiblesolution.*;

import java.util.ArrayList;
import java.util.List;

/*
    This is my first solution, by relying on inheritance I can split up the logic and make the code future-proof(by simply adding new classes if needed).
    But since Items property was not allowed to be altered I wasn't sure if this also applied to the Items object in the test of TexttestFixture, or the tests in general.
    In order for that test to work the value of the Items object would have to overridden by the result of updateQuality() on line 33
    This is my preferred solution if that's allowed
*/


class PossibleSolution {
    Item[] items;

    public PossibleSolution(Item[] items) {
        this.items = items;
    }

    public Item[] updateQuality() {
        List<ExtendedItem> convertedItems = splitItembasedOnType();
        for (ExtendedItem item : convertedItems) {
            item.updateQuality();
        }
        return convertedItems.toArray(new Item[0]);
    }

    private List<ExtendedItem> splitItembasedOnType() {
        List<ExtendedItem> convertedItems = new ArrayList<ExtendedItem>();
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.contains("Sulfuras")) {
                convertedItems.add(new LegendaryItem(items[i].name, items[i].sellIn));
            } else if (items[i].name.contains("Aged Brie")) {
                convertedItems.add(new AgingItem(items[i].name, items[i].sellIn, items[i].quality));
            } else if (items[i].name.contains("Backstage passes")) {
                convertedItems.add(new LifeSpanItem(items[i].name, items[i].sellIn, items[i].quality));
            } else if (items[i].name.contains("Conjured")) {
                convertedItems.add(new ConjuredItem(items[i].name, items[i].sellIn, items[i].quality));
            } else {
               convertedItems.add(new ExtendedItem(items[i].name, items[i].sellIn, items[i].quality));
            }
        }

        return convertedItems;
    }
}
