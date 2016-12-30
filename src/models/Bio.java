package models;

import enums.Categories;

/**
 * Class to model a bio object.
 *
 * @author John D. Miller
 * @version 1.0.3
 * @since 01/06/2016
 */

public class Bio extends Waste {

    public static Categories[] cats = new Categories[]{Categories.COMPOSTABLE, Categories.NON_COMPOSTABLE};

    public Bio() {
        super();
    }

    // Casting Constructor
    public Bio(Waste w) {
        super();
        this.setAmount(w.getAmount());
        this.setDate(w.getDate());
        this.setWasteCategory(w.getWasteCategory());
        this.setWasteMaterial(w.getWasteMaterial());
    }
}