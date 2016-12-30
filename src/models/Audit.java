package models;

    import java.util.ArrayList;
    import java.util.Calendar;

/**
 * Class to model a trash audit.
 *
 * @author John D. Miller
 * @version 1.0.2
 * @since 01/07/2016
 */
public class Audit {

    // Instance Variables
    private Calendar cal;
    private ArrayList<Waste> wasteList;

    // Constructor accepting no arguments
    public Audit() {
        cal = Calendar.getInstance();
        wasteList = new ArrayList<>();
    }

    // Arguments constructor
    public Audit(Calendar cal, ArrayList<Waste> wasteList) {
        this.cal = cal;
        this.wasteList = wasteList;
    }

    /**
     * @return the audit calendar object.
     */
    public Calendar getCal() {
        return cal;
    }

    /**
     * @param cal the calendar object to set.
     */
    public void setCal(Calendar cal) {
        this.cal = cal;
    }

    /**
     * @return the wasteList.
     */
    public ArrayList<Waste> getWasteList() {
        return wasteList;
    }

    /**
     * @param wasteList the wasteList to set.
     */
    public void setWasteList(ArrayList<Waste> wasteList) {
        this.wasteList = wasteList;
    }
}