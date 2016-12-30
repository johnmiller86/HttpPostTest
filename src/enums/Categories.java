package enums;

/**
 * Enumeration for category options.
 *
 * @author John D. Miller
 * @version 1.0.2
 * @since 01/06/2016
 */
public enum Categories {
    RECYCLABLE,
    NON_RECYCLABLE,
    FILM,
    COMPOSTABLE,
    NON_COMPOSTABLE;

    @Override
    public String toString() {
        switch (this) {
            case RECYCLABLE:
                return "Recyclable";
            case NON_RECYCLABLE:
                return "Non-Recyclable";
            case FILM:
                return "Film";
            case COMPOSTABLE:
                return "Compostable";
            case NON_COMPOSTABLE:
                return "Non-Compostable";
            default:
                return null;
        }
    }
}