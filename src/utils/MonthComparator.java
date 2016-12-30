package utils;

/**
 * Comparator for comparing waste objects with month/year date objects.
 *
 * @author John D. Miller
 * @version 1.0.2
 * @since 01/06/2016
 */

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Comparator;
        import java.util.logging.Level;
        import java.util.logging.Logger;

/**
 *
 * @author chefj
 */
public enum MonthComparator implements Comparator<String> {

    DATE_SORT {
        @Override
        public int compare(String a, String b) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM,yyyy");
            try {
                return sdf.parse(a).compareTo(sdf.parse(b));
            } catch (ParseException ex) {
                Logger.getLogger(WasteComparator.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
    };

    public static Comparator<String> ascending(final Comparator<String> comparator) {
        return (String a, String b) -> 1 * comparator.compare(a, b);
    }

    public static Comparator<String> getComparator(final MonthComparator... multipleOptions) {
        return (String a, String b) -> {
            for (MonthComparator option : multipleOptions) {
                int result = option.compare(a, b);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        };
    }
}