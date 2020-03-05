package com.gildedrose;

class GildedRose {	
    Item[] items;
    
    /**
     * This Constructor is to initialize the items attribute and instantiate the item object.
     * @param items
     */
    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    /** 
     * This function is to decrement SellIn (Days) of an item.
     * @param item
     * @return void
     */
    public void decrementSellIn(Item item) {
    	if (!typeOfItem(item).equals("Sulfuras")) { 
    		item.sellIn = item.sellIn -1; // decrement all items except "Sulfuras".
    	}
    }
    
    /**
     * This function is to increment quality of an item.
     * @param item
     * @return void
     */
    public void incrementQuality(Item item ) {
    	if (item.quality < 50)
    		item.quality = item.quality + 1; // increment all items with quality lower than 50.
    }
    
    /**
     * This function is to decrement quality of an item.
     * @param item
     * @return void
     */
    public void decrementQuality(Item item) {
    	if (item.quality > 0 && !typeOfItem(item).equals("Sulfuras"))
    		item.quality = item.quality -1; // decrement all items with quality upper than 0 and not "Sulfuras" item.
    }
    
    /**
     * This function is to increment quality of "Aged Brie" or "Backstage" item.
     * @param item
     * @return void
     */
    public void incrementQualityByItemType(Item item) {
    	if (typeOfItem(item).equals("Aged Brie") || typeOfItem(item).equals("Backstage")) {
    		incrementQuality(item); // increment quality, ( quality = quality +1)
    		if (typeOfItem(item).equals("Backstage")) {
    			if (item.sellIn < 11)
    				incrementQuality(item); // increment quality, ( quality = quality +2).
    			if (item.sellIn < 6)
    				incrementQuality(item); // increment quality, ( quality = quality +3).
    		}
    	}
    	if (item.sellIn <= 0) { 
    		if (typeOfItem(item).equals("Aged Brie")) { // "Aged Brie" is sold.
    			incrementQuality(item);
    		}
    	}
    }
    
    
    
    /**
     * This function is to decrement quality of items except "Aged Brie" and "Backstage".
     * @param item
     * @return void
     */
    public void decrementQualityByItemType(Item item) {
    	if (!typeOfItem(item).equals("Aged Brie") && !typeOfItem(item).equals("Backstage")) {
    		decrementQuality(item); // decrement all items except "Aged Brie" and "Backstage". Also decrement "Conjured" item quality. 
    		if(typeOfItem(item).equals("Conjured"))  
    			decrementQuality(item); // decrement the "Conjured" item second time.
    	}
    	if (item.sellIn <= 0) {
    		if (!typeOfItem(item).equals("Aged Brie")) { // all items those are sold except "Aged Brie".
    			if (typeOfItem(item).equals("Backstage")) { // the "Backstage" after the concert.
    				item.quality = 0; // Quality drops to 0.
    			} else { // all items those are sold except "Aged Brie" and "Backstage" and "Sulfuras".
    				decrementQuality(item);	
    			}
    		}
    	}
    }
    
    /**
     * This function returns the type of an item.
     * @param item
     * @return String
     */
    public String typeOfItem(Item item) {
    	if (item.name.startsWith("Aged Brie"))
    		return "Aged Brie";
    	else if (item.name.startsWith("Sulfuras"))
    		return "Sulfuras";
    	else if (item.name.startsWith("Backstage"))
    		return "Backstage";
    	else if(item.name.startsWith("Conjured"))
    		return "Conjured";
    	else
    		return "Normal Item";
    }
    
    
	/**
	 * This function execute all functions that are above.
	 * @return void
	 */
    public void updateQuality() {
    	for (Item item : items) {
    		incrementQualityByItemType(item);
    		decrementQualityByItemType(item);
    		decrementSellIn(item);
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

/*for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
 * 
 * 
 * 
 */
 