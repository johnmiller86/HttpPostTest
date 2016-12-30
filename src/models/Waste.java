package models;

import enums.Containers;

/**
 * Class to model a waste object.
 *
 * @author John D. Miller
 * @version 1.0.3
 * @since 01/06/2016
 */
public class Waste {
    // Instance Variables

    public static Containers[] cntrs = {Containers.PLACE_HOLDER, Containers.FIVE_GALLON_BUCKET, Containers.LARGE_TRASH_BAG, Containers.SMALL_TRASH_BAG, Containers.LARGE_BOX, Containers.SMALL_BOX};
    private double amount;
    private String wasteType, wasteCategory, date, percent;

    // Constructor accepting no arguments
    public Waste() {
        date = "";
        wasteType = "";
        wasteCategory = "";
        amount = 0;
    }

    // Arguments constructor
    public Waste(String date, String wasteType, String wasteCategory, double amount) {
        this.date = date;
        this.wasteType = wasteType;
        this.wasteCategory = wasteCategory;
        this.amount = amount;
    }

    /**
     * Gets the amount of the waste.
     *
     * @return the weight.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the waste.
     *
     * @param amount the amount.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the type of the waste.
     *
     * @return the type.
     */
    public String getWasteMaterial() {
        return wasteType;
    }

    /**
     * Gets the percent of the waste.
     *
     * @return the percent.
     */
    public String getPercent() {
        return percent;
    }

    /**
     * Sets the percent of the waste.
     *
     * @param percent the percent to set.
     */
    public void setPercent(String percent) {
        this.percent = percent;
    }

    /**
     * Sets the waste type.
     *
     * @param wasteType the type to be set.
     */
    public void setWasteMaterial(String wasteType) {
        this.wasteType = wasteType;
    }

    /**
     * Gets the waste category.
     *
     * @return the category.
     */
    public String getWasteCategory() {
        return wasteCategory;
    }

    /**
     * Sets the waste category.
     *
     * @param wasteCategory the category to be set.
     */
    public void setWasteCategory(String wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    /**
     * Gets the waste Date.
     *
     * @return the Date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the waste Date.
     *
     * @param date the date to set.
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date: " + this.getDate() + "     Material: " + this.getWasteMaterial() + "     Category: " + this.getWasteCategory() + "     Amount: " + this.getAmount();
    }
}