package models;

/**
 * Bar graph class for graphing.
 *
 * @author John D. Miller
 * @version 1.0.4
 * @since 01/06/2016
 */
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.Scanner;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import org.jfree.chart.ChartFactory;
        import org.jfree.chart.ChartPanel;
        import org.jfree.chart.JFreeChart;
        import org.jfree.chart.plot.PlotOrientation;
        import org.jfree.data.category.CategoryDataset;
        import org.jfree.data.category.DefaultCategoryDataset;
        import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author chefj
 */
public class BarGraph extends ApplicationFrame {

    // Instance variables
    public ArrayList<Waste> wasteList;
    String unit;
    File settingsFile = new File(System.getProperty("user.home") + File.separator + "Home Trash Audit" + File.separator + "Settings.txt");

    // Constructor
    public BarGraph(String frameTitle, String graphTitle, ArrayList<Waste> wasteList) {
        super(frameTitle);
        this.wasteList = wasteList;
        Scanner reader;
        try {
            reader = new Scanner(settingsFile);
            reader.nextLine();
            String line = reader.nextLine();
            if (!line.contains("Box")) {
                unit = line + "s";
            } else {
                unit = line + "es";
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BarGraph.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFreeChart chart = ChartFactory.createBarChart(graphTitle, null, "Amount (" + unit + ")", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(this.getBackground());
        chart.getLegend().setBackgroundPaint(this.getBackground());
        ChartPanel cp = new ChartPanel(chart, false, true, true, false, false);
        setContentPane(cp);
    }

    /**
     * Creates a dataset from arrayLists.
     *
     * @return
     */
    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        wasteList.stream().forEach((w) -> {
            dataset.addValue(w.getAmount(), w.getWasteCategory() + " " + w.getWasteMaterial(), "");
        });
        return dataset;
    }
}