package enums;

/**
 * Enumeration for goal options.
 *
 * @author John D. Miller
 * @version 1.0.2
 * @since 01/07/2016
 */
public enum Goals {
    PLACE_HOLDER,
    INCREASE_BIO_COMPOSTABLE,
    REDUCE_BIO_NON_COMPOSTABLE,
    INCREASE_GLASS_RECYCLABLE,
    REDUCE_GLASS_NON_RECYCLABLE,
    INCREASE_METAL_RECYCLABLE,
    REDUCE_METAL_NON_RECYCLABLE,
    INCREASE_PAPER_RECYCLABLE,
    REDUCE_PAPER_NON_RECYCLABLE,
    INCREASE_PAPER_COMPOSTABLE,
    INCREASE_PLASTIC_RECYCLABLE,
    REDUCE_PLASTIC_NON_RECYCLABLE,
    REDUCE_PLASTIC_FILM;

    @Override
    public String toString() {
        switch (this) {
            case PLACE_HOLDER:
                return "";
            case INCREASE_BIO_COMPOSTABLE:
                return "Increase Compostable Bio";
            case REDUCE_BIO_NON_COMPOSTABLE:
                return "Reduce Non-Compostable Bio";
            case INCREASE_GLASS_RECYCLABLE:
                return "Increase Recyclable Glass";
            case REDUCE_GLASS_NON_RECYCLABLE:
                return "Reduce Non-Recyclable Glass";
            case INCREASE_METAL_RECYCLABLE:
                return "Increase Recyclable Metal";
            case REDUCE_METAL_NON_RECYCLABLE:
                return "Reduce Non-Recyclable Metal";
            case INCREASE_PAPER_RECYCLABLE:
                return "Increase Recyclable Paper";
            case REDUCE_PAPER_NON_RECYCLABLE:
                return "Reduce Non-Recyclable Paper";
            case INCREASE_PAPER_COMPOSTABLE:
                return "Increase Compostable Paper";
            case INCREASE_PLASTIC_RECYCLABLE:
                return "Increase Recyclable Plastic";
            case REDUCE_PLASTIC_NON_RECYCLABLE:
                return "Reduce Non-Recyclable Plastic";
            case REDUCE_PLASTIC_FILM:
                return "Reduce Plastic Films";
            default:
                return null;
        }
    }
}