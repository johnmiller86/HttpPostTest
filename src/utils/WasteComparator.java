package utils;

/**
 * Comparator for comparing waste objects with simple date format date objects.
 *
 * @author John D. Miller
 * @version 1.0.2
 * @since 01/06/2016
 */
        import models.Waste;

        import java.text.DateFormat;
        import java.text.ParseException;
        import java.util.Comparator;
        import java.util.logging.Level;
        import java.util.logging.Logger;

/**
 *
 * @author chefj
 */
public enum WasteComparator implements Comparator<Waste> {
    //private final DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);

    DATE_SORT {
        @Override
        public int compare(Waste a, Waste b) {
            DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
            try {
                return dateFormatter.parse(a.getDate()).compareTo(dateFormatter.parse(b.getDate()));
            } catch (ParseException ex) {
                Logger.getLogger(WasteComparator.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
    },
    // Material Sort
    MATERIAL_SORT {
        @Override
        public int compare(Waste a, Waste b) {
            return a.getWasteMaterial().compareTo(b.getWasteMaterial());
        }
    },
    // Category Sort
    CATEGORY_SORT {
        @Override
        public int compare(Waste a, Waste b) {
            return a.getWasteCategory().compareTo(b.getWasteCategory());
        }
    };

    public static Comparator<Waste> ascending(final Comparator<Waste> comparator) {
        return (Waste a, Waste b) -> 1 * comparator.compare(a, b);
    }

    public static Comparator<Waste> getComparator(final WasteComparator... multipleOptions) {
        return (Waste a, Waste b) -> {
            for (WasteComparator option : multipleOptions) {
                int result = option.compare(a, b);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        };
    }
}