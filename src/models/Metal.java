package models;

import enums.Categories;

/**
 * Class to model a metal object.
 *
 * @author John D. Miller
 * @version 1.0.3
 * @since 01/06/2016
 */
public class Metal extends Waste {

    public static Categories[] cats = new Categories[]{Categories.RECYCLABLE, Categories.NON_RECYCLABLE};

    public Metal() {
        super();
    }

    // Casting Constructor
    public Metal(Waste w) {
        super();
        this.setAmount(w.getAmount());
        this.setDate(w.getDate());
        this.setWasteCategory(w.getWasteCategory());
        this.setWasteMaterial(w.getWasteMaterial());
    }
}