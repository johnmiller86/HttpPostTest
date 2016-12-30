package models;

/**
 * Pie chart class for graphing.
 *
 * @author John D. Miller
 * @version 1.0.3
 * @since 01/06/2016
 */
        import java.awt.Font;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.Scanner;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import org.jfree.chart.ChartFactory;
        import org.jfree.chart.ChartPanel;
        import org.jfree.chart.JFreeChart;
        import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
        import org.jfree.chart.plot.PiePlot3D;
        import org.jfree.data.general.DefaultPieDataset;
        import org.jfree.data.general.PieDataset;
        import org.jfree.ui.ApplicationFrame;

public class PieChart extends ApplicationFrame {

    // Instance variables
    File settingsFile = new File(System.getProperty("user.home") + File.separator + "Home Trash Audit" + File.separator + "Settings.txt");
    ArrayList<Waste> wasteList = new ArrayList<>();
    String unit;

    // Constructor
    public PieChart(final String title, ArrayList<Waste> wasteList) {
        super(title);
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
            Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
        }
        setContentPane(createPanel());
    }

    /**
     * Creates a dataset for the pie chart.
     *
     * @return the dataset.
     */
    private PieDataset createDataset() {
        final DefaultPieDataset dataset = new DefaultPieDataset();
        wasteList.stream().forEach((w) -> {
            dataset.setValue(w.getWasteCategory() + " " + w.getWasteMaterial() + " ", new Double(w.getAmount()));
        });
        return dataset;
    }

    /**
     * Creates a pie chart from a supplied dataset.
     *
     * @param dataset the dataset.
     * @return the pie chart.
     */
    private JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart3D(super.getTitle(), dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1} (" + unit + ")"));
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setStartAngle(270);
        //plot.setForegroundAlpha(0.60f);
        plot.setCircular(false);
        plot.setBackgroundPaint(this.getBackground());
        chart.setBackgroundPaint(this.getBackground());
        chart.getLegend().setBackgroundPaint(this.getBackground());
        return chart;
    }

    /**
     * Creates a panel to contain the pie chart.
     *
     * @return
     */
    private ChartPanel createPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart, false, true, true, false, false);
    }
}