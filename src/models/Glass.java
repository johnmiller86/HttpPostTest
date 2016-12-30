package models;

import enums.Categories;

/**
 * Class to model a glass object.
 *
 * @author John D. Miller
 * @version 1.0.3
 * @since 01/06/2016
 */
public class Glass extends Waste {

    public static Categories[] cats = new Categories[]{Categories.RECYCLABLE, Categories.NON_RECYCLABLE};

    public Glass() {
        super();
    }

    // Casting Constructor
    public Glass(Waste w) {
        super();
        this.setAmount(w.getAmount());
        this.setDate(w.getDate());
        this.setWasteCategory(w.getWasteCategory());
        this.setWasteMaterial(w.getWasteMaterial());
    }
}