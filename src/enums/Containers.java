package enums;

/**
 * Enumeration for container options.
 *
 * @author John D. Miller
 * @version 1.0.2
 * @since 01/06/2016
 */
public enum Containers {
    PLACE_HOLDER,
    FIVE_GALLON_BUCKET,
    LARGE_TRASH_BAG,
    SMALL_TRASH_BAG,
    LARGE_BOX,
    SMALL_BOX;

    @Override
    public String toString() {
        switch (this) {
            case PLACE_HOLDER:
                return "";
            case FIVE_GALLON_BUCKET:
                return "5 Gallon Bucket";
            case LARGE_TRASH_BAG:
                return "Large Trash Bag";
            case SMALL_TRASH_BAG:
                return "Small Trash Bag";
            case LARGE_BOX:
                return "Large Box";
            case SMALL_BOX:
                return "Small Box";
            default:
                return null;
        }
    }
}