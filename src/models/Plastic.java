package models;

/**
 * Class to model a plastic object.
 *
 * @author John D. Miller
 * @version 1.0.3
 * @since 01/06/2016
 */
import enums.Categories;

public class Plastic extends Waste {

    public static Categories[] cats = new Categories[]{Categories.RECYCLABLE, Categories.NON_RECYCLABLE, Categories.FILM};

    // Constructor
    public Plastic() {
        super();
    }

    // Casting Constructor
    public Plastic(Waste w) {
        super();
        this.setAmount(w.getAmount());
        this.setDate(w.getDate());
        this.setWasteCategory(w.getWasteCategory());
        this.setWasteMaterial(w.getWasteMaterial());
    }
}