package views;
/**
 * Home Trash Audit Frame Class
 *
 * @author John D. Miller
 * @version 1.0.4
 * @since 01/07/2016
 */

// Imports
        import models.*;
        import utils.WasteComparator;

        import java.awt.Toolkit;
        import java.text.NumberFormat;
        import java.text.DecimalFormat;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.PrintWriter;
        import java.lang.reflect.InvocationTargetException;
        import java.text.DateFormat;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;
        import java.util.Collections;
        import java.util.Date;
        import java.util.Scanner;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import javax.swing.JFrame;
        import javax.swing.JOptionPane;
        import javax.swing.table.DefaultTableModel;

public class HomeTrashAuditFrame extends JFrame {

    // Global Variables
    ArrayList<Waste> wasteList = new ArrayList<>();
    ArrayList<Plastic> plasRec = new ArrayList<>();
    ArrayList<Plastic> plasNonRec = new ArrayList<>();
    ArrayList<Plastic> plasFilm = new ArrayList<>();
    ArrayList<Paper> papRec = new ArrayList<>();
    ArrayList<Paper> papNonRec = new ArrayList<>();
    ArrayList<Paper> papComp = new ArrayList<>();
    ArrayList<Metal> metRec = new ArrayList<>();
    ArrayList<Metal> metNonRec = new ArrayList<>();
    ArrayList<Glass> glassRec = new ArrayList<>();
    ArrayList<Glass> glassNonRec = new ArrayList<>();
    ArrayList<Bio> bioComp = new ArrayList<>();
    ArrayList<Bio> bioNonComp = new ArrayList<>();
    ArrayList<Waste> monthlyTotals = new ArrayList<>();
    ArrayList<Waste> yearlyTotals = new ArrayList<>();
    ArrayList<Waste> historicalTotals = new ArrayList<>();
    ArrayList<Date> months = new ArrayList<>();

    String username, goal, unit;
    boolean prompted;

    // Files
    File fileDirectory = new File(System.getProperty("user.home") + File.separator + "Home Trash Audit");
    File journalFile = new File(System.getProperty("user.home") + File.separator + "Home Trash Audit" + File.separator + "Journal.txt");
    File settingsFile = new File(System.getProperty("user.home") + File.separator + "Home Trash Audit" + File.separator + "Settings.txt");
    File goalFile = new File(System.getProperty("user.home") + File.separator + "Home Trash Audit" + File.separator + "Goals.txt");

    // Formatters
    private final NumberFormat percentFormatter = new DecimalFormat("#.##%");
    private final DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
    private final DateFormat monthDateFormatter = new SimpleDateFormat("MMMM, yyyy");
    private final DateFormat yearDateFormatter = new SimpleDateFormat("yyyy");

    /**
     * Initializes the application WasteApplicationFrame
     */
    public HomeTrashAuditFrame(String username, String unit) {

        this.username = username;
        this.unit = unit;
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the frame */
//        try {
//            java.awt.EventQueue.invokeAndWait(() -> initComponents());
//        } catch (InterruptedException | InvocationTargetException ex) {
//            java.util.logging.Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        initComponents();
//            materialComboBox.setSelectedIndex(0);
        // Getting Java Version
        //String version = System.getProperty("java.version");
        //System.out.println(version);
        setTitle("Home Trash Audit 1.1.2");
        setSize(754, 650);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Setting Icon //TODO
//        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("recycle.png")));

//        // First time run only
//        if (!settingsFile.exists()) {
//            // Creating directory
//            fileDirectory.mkdir();
//
//            // Starting greeting screen
//            JFrame greeting = new FirstTimeGreeting();
//            greeting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            greeting.setLocationRelativeTo(null);
//            greeting.setAlwaysOnTop(true);
//            greeting.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("recycle.png")));
//
//            // Waiting for file creation
//            while (!settingsFile.exists()) {
//                greeting.setVisible(true);
//            }
//        }

        // Setting up goals file
//        if (!goalFile.exists()) {
//            PrintWriter writer;
//            try {
//                writer = new PrintWriter(goalFile);
//                Date date = new Date();
//                writer.println(monthDateFormatter.format(date));
//                writer.println("Complete some audits");
//                writer.close();
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        // Initiating Goal Frame
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        try{
//            Scanner reader = new Scanner(goalFile);
//            while (reader.hasNextLine()){
//                Date date = monthDateFormatter.parse(reader.nextLine());
//                months.add(date);
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        for (Date d : months){
//            Calendar c = Calendar.getInstance();
//            c.setTime(d);
//            if (Calendar.get(Calendar.MONTH) > c.get(Calendar.MONTH)){
//                JFrame goals = new FirstTimeGreeting();
//                goals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                goals.setLocationRelativeTo(null);
//                goals.setAlwaysOnTop(true);
//                goals.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("recycle.png")));
//            }
//        }
        // Applying settings
//        try {
//            // Name greeting
//            try (Scanner reader = new Scanner(settingsFile)) {
//                // Name greeting
//                nameLabel.setText("Hi, " + reader.nextLine() + "!");
//                String unit = reader.nextLine();
//
//                // Units label
//                if (!unit.contains("Box")) {
//                    displayTable.getColumnModel().getColumn(2).setHeaderValue("Amount    (" + line + "s)");
//                } else {
//                    displayTable.getColumnModel().getColumn(2).setHeaderValue("Amount    (" + line + "es)");
//                }
//
//                // Goal label
//                if (reader.hasNextLine()) {
//                    goal = reader.nextLine();
//                    goalLabel.setText(goal);
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }

        // Configuring greeting
        nameLabel.setText("Hi, " + username + "!");

        // Configuring units
        if (!unit.contains("Box")) {
            displayTable.getColumnModel().getColumn(2).setHeaderValue("Amount    (" + unit + "s)");
        } else {
            displayTable.getColumnModel().getColumn(2).setHeaderValue("Amount    (" + unit + "es)");
        }

        // Configuring goal // TODO
//        if (reader.hasNextLine()) {
//            goal = reader.nextLine();
//            goalLabel.setText(goal);
//        }

        // Configuring datePicker
        datePicker.setFormats(dateFormatter);
        datePicker.getEditor().setEditable(false);
        datePicker.setDate(new Date());

        // Config ComboBox
        materialComboBox.setSelectedIndex(0);
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        tablePane = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        addToJournalButton = new javax.swing.JButton();
        viewJournalButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        viewTotalsButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        materialLabel = new javax.swing.JLabel();
        materialComboBox = new javax.swing.JComboBox();
        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        categoryLabel = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        jPanel5 = new javax.swing.JPanel();
        goalLabel = new javax.swing.JLabel();

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Material", "Category", "Amount", "Total"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        displayTable.getTableHeader().setReorderingAllowed(false);
        tablePane.setViewportView(displayTable);
        if (displayTable.getColumnModel().getColumnCount() > 0) {
            displayTable.getColumnModel().getColumn(0).setResizable(false);
            displayTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            displayTable.getColumnModel().getColumn(1).setResizable(false);
            displayTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            displayTable.getColumnModel().getColumn(2).setResizable(false);
            displayTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            displayTable.getColumnModel().getColumn(3).setResizable(false);
            displayTable.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        addToJournalButton.setText("Add to Journal");
        addToJournalButton.setToolTipText("");
        addToJournalButton.setActionCommand("Save to Journal");
        addToJournalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToJournalButtonActionPerformed(evt);
            }
        });

        viewJournalButton.setText("View Journal");
        viewJournalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJournalButtonActionPerformed(evt);
            }
        });

        logoLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        logoLabel.setText("Rehabilitating Our Planet, One Pledge at a Time.");

        viewTotalsButton.setText("View Totals");
        viewTotalsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTotalsButtonActionPerformed(evt);
            }
        });

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel.setText("nameLabel");
        nameLabel.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Waste Properties"));

        materialLabel.setText("Material:");

        materialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Plastic", "Paper", "Metal", "Glass", "Bio" }));
        materialComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialComboBoxActionPerformed(evt);
            }
        });

        amountLabel.setText("Amount:");

        categoryLabel.setText("Category:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        categoryComboBox.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(amountLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(materialLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(materialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(categoryLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(materialLabel)
                                        .addComponent(materialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(categoryLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(amountLabel))
                                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Audit Buttons"));

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Audit Date"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Current Goal"));

        goalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goalLabel.setText("Complete some audits.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(goalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(goalLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(logoLabel)
                                                                .addGap(34, 34, 34)
                                                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(addToJournalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(viewJournalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(viewTotalsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(tablePane, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logoLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(viewJournalButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                        .addComponent(viewTotalsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addToJournalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }// </editor-fold>

    /**
     * Filling categories based on material selection.
     *
     * @param evt the material selected.
     */
    private void materialComboBoxActionPerformed(java.awt.event.ActionEvent evt) {

        // Determining selection and filling
        switch (materialComboBox.getSelectedItem().toString()) {
            case "Plastic":
                categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(Plastic.cats));
                break;
            case "Paper":
                categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(Paper.cats));
                break;
            case "Metal":
                categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(Metal.cats));
                break;
            case "Glass":
                categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(Glass.cats));
                break;
            case "Bio":
                categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(Bio.cats));
                break;

            // No material selection, do not fill
            default:
                categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>());
                break;
        }
    }

    /**
     * Views existing journal file.
     *
     * @param evt the mouse clicked.
     */
    private void viewJournalButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        // Displaying Journal
        if (journalFile.exists()) {
            readInWasteList();
            Collections.sort(wasteList, WasteComparator.ascending(WasteComparator.getComparator(WasteComparator.DATE_SORT, WasteComparator.MATERIAL_SORT, WasteComparator.CATEGORY_SORT)));

            JFrame journalFrame = new JournalFrame(wasteList);
            journalFrame.setVisible(true);
        } // No Journal Found
        else {
            JOptionPane.showMessageDialog(this, "You have not yet created a journal!!!", "Empty Journal!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Adds contents of table to journal file.
     *
     * @param evt the mouse clicked.
     */
    private void addToJournalButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();

        // Checking for Empty Table
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "You must first complete an audit before adding to Journal!", "Empty Audit!", JOptionPane.ERROR_MESSAGE);
        } // Checking if audit exsists for selected date
        else if (dateExists()) {
            JOptionPane.showMessageDialog(this, "An audit for this date has already been completed!!!", "Check Date!", JOptionPane.ERROR_MESSAGE);
        } // Appending Journal
        else {
            try {
                try (PrintWriter output = new PrintWriter(new FileOutputStream(journalFile, true))) {
                    String format = "%s\t%-30s\t%-20s\t%-20s";
                    // Header
                    output.println(dateFormatter.format(datePicker.getDate()) + "\n");
                    output.printf(format, "Material", "Category", "Amount", "Total");
                    output.println();
                    output.println("----------------------------------------------------------------------------------------------------");
                    // Body
                    for (int i = 0; i < model.getRowCount(); i++) {
                        output.printf(format, model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3));
                        output.println();
                    }
                    output.println("----------------------------------------------------------------------------------------------------");
                    output.println();
                    // Closing PrintWriter
                }

                // Confirmation
                JOptionPane.showMessageDialog(null, "The journal was successfully updated!", "Journal Updated!", JOptionPane.PLAIN_MESSAGE);

                // Resetting for new audits
                model.setRowCount(0);
                materialComboBox.setSelectedItem("");
                amountField.setText("");

                // Organizing Journal
                rewriteJournal();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Determines if a material/category combination exists in the table model.
     *
     * @param anObject the material.
     * @param otherObject the category.
     * @param model the table model.
     * @return true or false.
     */
    private Boolean rowExsists(Object anObject, Object otherObject, DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0) == anObject && model.getValueAt(i, 1) == otherObject) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the row where the combination is contained in the model.
     *
     * @param anObject the material.
     * @param otherObject the category.
     * @param model the table model.
     * @return the rows index.
     */
    private int combinationFoundAt(Object anObject, Object otherObject, DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0) == anObject && model.getValueAt(i, 1) == otherObject) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Calculates and sets percentages for total column.
     *
     * @param model the JTable model.
     */
    private void setPercentages(DefaultTableModel model) {
        // Updating Percentage Column
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            // Calculating Total
            total += Double.parseDouble((String) model.getValueAt(i, 2).toString());

            // Setting Percentages
            for (int j = 0; j < model.getRowCount(); j++) {
                model.setValueAt(((percentFormatter.format(Double.parseDouble((String) model.getValueAt(j, 2).toString()) / total))), j, 3);
            }
        }
    }

    private void readInWasteList() {
        ArrayList<String> lines = new ArrayList<>();
        String date = "";
        wasteList = new ArrayList<>();

        // Reading in file
        try {
            Scanner reader = new Scanner(journalFile);

            // Reading File
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException ex) {

        }

        // Processing information to fill list
        for (String line : lines) {
            if (isDate(line)) {
                date = line;
            } // Empty line
            else if (line.equals("")) {
            } // Header
            else if (line.contains("Material")) {
            } // Audit Separater
            else if (line.contains("--")) {
            } // Process data
            else {
                Waste waste = new Waste();
                try (Scanner lineReader = new Scanner(line)) {
                    waste.setDate(date);
                    waste.setWasteMaterial(lineReader.next());
                    waste.setWasteCategory(lineReader.next());
                    waste.setAmount(lineReader.nextDouble());
                    waste.setPercent(lineReader.next());
                    wasteList.add(waste);
                }
            }
        }
    }

    /**
     * Determines if a line is a date.
     *
     * @param line the line to be evaluated.
     * @return true or false.
     */
    private Boolean isDate(String line) {
        try {
            dateFormatter.parse(line);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Calculates totals and displays a graph.
     *
     * @param evt the button clicked.
     */
    private void viewTotalsButtonActionPerformed(java.awt.event.ActionEvent evt) {

        if (journalFile.exists()) {
            // Processing data
            try {
                processHistoricalTotals();
                processMonthlyTotals();
                processYearlyTotals();
            } catch (ParseException ex) {
                Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Displaying journalFrame
            JFrame totalsFrame = new TotalsFrame(monthlyTotals, yearlyTotals, historicalTotals);
            totalsFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "You have not yet created a journal!!!", "Empty Journal!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Removes selected rows from the table.
     *
     * @param evt mouse clicked.
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Finding Selected Rows
        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
        int[] rows = displayTable.getSelectedRows();

        // Removing Rows
        for (int i = 0; i < rows.length; i++) {
            model.removeRow(rows[i] - i);
        }

        // Recalculating Percentages
        setPercentages(model);
    }

    /**
     * Adds data to the JTable.
     *
     * @param evt mouse clicked.
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();

        // Checking for blank fields.
        if (amountField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Amount cannot be left blank!!!", "Empty Amount!", JOptionPane.ERROR_MESSAGE);
        } // Checking for proper input
        else if (!isDouble(amountField.getText())) {
            JOptionPane.showMessageDialog(null, "Amount must be numeric!!!", "Check amount!", JOptionPane.ERROR_MESSAGE);
        } else if (amountField.getText().contains("-")) {
            JOptionPane.showMessageDialog(null, "Amount may not be negative!!!", "Negative amount!", JOptionPane.ERROR_MESSAGE);
        } // Checking for blank combo boxes
        else if (materialComboBox.getSelectedItem() == null || materialComboBox.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "A material was not selected!!!", "Choose a material!", JOptionPane.ERROR_MESSAGE);
        } else if (categoryComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "A category was not selected!!!", "Choose a category!", JOptionPane.ERROR_MESSAGE);
        } // Updating existing rows
        else if (rowExsists(materialComboBox.getSelectedItem(), categoryComboBox.getSelectedItem(), model)) {
            // Getting location of row
            int location = combinationFoundAt(materialComboBox.getSelectedItem(), categoryComboBox.getSelectedItem(), model);

            // Updating amount
            model.setValueAt(Double.parseDouble(amountField.getText()) + new Double(model.getValueAt(location, 2).toString()), location, 2);

            // Calculating Percentages
            setPercentages(model);
        } // Adding new rows
        else {
            // Adding Rows
            Object[] row = {materialComboBox.getSelectedItem(), categoryComboBox.getSelectedItem(), amountField.getText()};
            model.addRow(row);
            displayTable.setModel(model);

            // Calculating Percentages
            setPercentages(model);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton addButton;
    private javax.swing.JButton addToJournalButton;
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel goalLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JComboBox materialComboBox;
    private javax.swing.JLabel materialLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JButton viewJournalButton;
    private javax.swing.JButton viewTotalsButton;
    // End of variables declaration

    /**
     * Determines an audit has been created for the current audit.
     *
     * @return true or false.
     */
    private boolean dateExists() {
        readInWasteList();
        Collections.sort(wasteList, WasteComparator.ascending(WasteComparator.getComparator(WasteComparator.DATE_SORT, WasteComparator.MATERIAL_SORT, WasteComparator.CATEGORY_SORT)));
        return wasteList.stream().anyMatch((waste) -> (waste.getDate().equals(dateFormatter.format(datePicker.getDate()))));
    }

    /**
     * Splits the wasteList to separate arrayLists.
     */
    private void splitList() {
        // ArrayLists for processing totals.
        plasRec = new ArrayList<>();
        plasNonRec = new ArrayList<>();
        plasFilm = new ArrayList<>();
        papRec = new ArrayList<>();
        papNonRec = new ArrayList<>();
        papComp = new ArrayList<>();
        metRec = new ArrayList<>();
        metNonRec = new ArrayList<>();
        glassRec = new ArrayList<>();
        glassNonRec = new ArrayList<>();
        bioComp = new ArrayList<>();
        bioNonComp = new ArrayList<>();

        // Separating Combinations for totaling.
        for (Waste w : wasteList) {
            switch (w.getWasteMaterial()) {
                case "Plastic":
                    switch (w.getWasteCategory()) {

                        case "Recyclable":
                            plasRec.add(new Plastic(w));
                            break;
                        case "Non-Recyclable":
                            plasNonRec.add(new Plastic(w));
                            break;
                        case "Film":
                            plasFilm.add(new Plastic(w));
                            break;
                    }
                    break;
                case "Paper":
                    switch (w.getWasteCategory()) {
                        case "Recyclable":
                            papRec.add(new Paper(w));
                            break;
                        case "Non-Recyclable":
                            papNonRec.add(new Paper(w));
                            break;
                        case "Compostable":
                            papComp.add(new Paper(w));
                            break;
                    }
                    break;
                case "Metal":
                    switch (w.getWasteCategory()) {
                        case "Recyclable":
                            metRec.add(new Metal(w));
                            break;
                        case "Non-Recyclable":
                            metNonRec.add(new Metal(w));
                            break;
                    }
                    break;
                case "Glass":
                    switch (w.getWasteCategory()) {
                        case "Recyclable":
                            glassRec.add(new Glass(w));
                            break;
                        case "Non-Recyclable":
                            glassNonRec.add(new Glass(w));
                            break;
                    }
                    break;
                default:
                    switch (w.getWasteCategory()) {
                        case "Compostable":
                            bioComp.add(new Bio(w));
                            break;
                        case "Non-Compostable":
                            bioNonComp.add(new Bio(w));
                            break;
                    }
                    break;
            }
        }
    }

    /**
     * Process arrayLists to get totals.
     */
    private void processHistoricalTotals() {
        // Preparing
        readInWasteList();

        // Sorting
        //wasteList.sort(sorter);
        Collections.sort(wasteList, WasteComparator.ascending(WasteComparator.getComparator(WasteComparator.DATE_SORT, WasteComparator.MATERIAL_SORT, WasteComparator.CATEGORY_SORT)));

        // Splitting
        splitList();

        // Variables
        double total;
        String material, category, date = "";

        if (!plasRec.isEmpty()) {
            material = plasRec.get(0).getWasteMaterial();
            category = plasRec.get(0).getWasteCategory();
            total = 0;

            total = plasRec.stream().map((p) -> p.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!plasNonRec.isEmpty()) {
            material = plasNonRec.get(0).getWasteMaterial();
            category = plasNonRec.get(0).getWasteCategory();
            total = 0;

            total = plasNonRec.stream().map((p) -> p.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!plasFilm.isEmpty()) {
            material = plasFilm.get(0).getWasteMaterial();
            category = plasFilm.get(0).getWasteCategory();
            total = 0;

            total = plasFilm.stream().map((p) -> p.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!papRec.isEmpty()) {
            material = papRec.get(0).getWasteMaterial();
            category = papRec.get(0).getWasteCategory();
            total = 0;

            total = papRec.stream().map((p) -> p.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!papNonRec.isEmpty()) {
            material = papNonRec.get(0).getWasteMaterial();
            category = papNonRec.get(0).getWasteCategory();
            total = 0;

            total = papNonRec.stream().map((p) -> p.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!papComp.isEmpty()) {
            material = papComp.get(0).getWasteMaterial();
            category = papComp.get(0).getWasteCategory();
            total = 0;

            total = papComp.stream().map((p) -> p.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!metRec.isEmpty()) {
            material = metRec.get(0).getWasteMaterial();
            category = metRec.get(0).getWasteCategory();
            total = 0;

            total = metRec.stream().map((m) -> m.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!metNonRec.isEmpty()) {
            material = metNonRec.get(0).getWasteMaterial();
            category = metNonRec.get(0).getWasteCategory();
            total = 0;

            total = metNonRec.stream().map((m) -> m.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!glassRec.isEmpty()) {
            material = glassRec.get(0).getWasteMaterial();
            category = glassRec.get(0).getWasteCategory();
            total = 0;

            total = glassRec.stream().map((g) -> g.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!glassNonRec.isEmpty()) {
            material = glassNonRec.get(0).getWasteMaterial();
            category = glassNonRec.get(0).getWasteCategory();
            total = 0;

            total = glassNonRec.stream().map((g) -> g.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!bioComp.isEmpty()) {
            material = bioComp.get(0).getWasteMaterial();
            category = bioComp.get(0).getWasteCategory();
            total = 0;

            total = bioComp.stream().map((b) -> b.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }

        if (!bioNonComp.isEmpty()) {
            material = bioNonComp.get(0).getWasteMaterial();
            category = bioNonComp.get(0).getWasteCategory();
            total = 0;

            total = bioNonComp.stream().map((b) -> b.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
            historicalTotals.add(new Waste(date, material, category, total));
        }
    }

    /**
     * Process arrayLists to get totals.
     */
    private void processMonthlyTotals() throws ParseException {
        // Preparing
        readInWasteList();

        // Sorting
        Collections.sort(wasteList, WasteComparator.ascending(WasteComparator.getComparator(WasteComparator.DATE_SORT, WasteComparator.MATERIAL_SORT, WasteComparator.CATEGORY_SORT)));

        // Splitting
        splitList();

        // Variables
        double total;
        String material, category, date = "";
        Calendar calendar;

        // Processing
        if (!plasRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(plasRec.get(0).getDate()));
            material = plasRec.get(0).getWasteMaterial();
            category = plasRec.get(0).getWasteCategory();
            total = 0;

            for (Plastic p : plasRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.MONTH)
                        && calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.YEAR)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Addding if last element
                if (plasRec.indexOf(p) == plasRec.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!plasNonRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(plasNonRec.get(0).getDate()));
            material = plasNonRec.get(0).getWasteMaterial();
            category = plasNonRec.get(0).getWasteCategory();
            total = 0;

            for (Plastic p : plasNonRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.MONTH)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Addding if last element
                if (plasNonRec.indexOf(p) == plasNonRec.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!plasFilm.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(plasFilm.get(0).getDate()));
            material = plasFilm.get(0).getWasteMaterial();
            category = plasFilm.get(0).getWasteCategory();
            total = 0;

            for (Plastic p : plasFilm) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.MONTH)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Addding if last element
                if (plasFilm.indexOf(p) == plasFilm.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!papRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(papRec.get(0).getDate()));
            material = papRec.get(0).getWasteMaterial();
            category = papRec.get(0).getWasteCategory();
            total = 0;

            for (Paper p : papRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.MONTH)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Addding if last element
                if (papRec.indexOf(p) == papRec.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!papNonRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(papNonRec.get(0).getDate()));
            material = papNonRec.get(0).getWasteMaterial();
            category = papNonRec.get(0).getWasteCategory();
            total = 0;

            for (Paper p : papNonRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.MONTH)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Addding if last element
                if (papNonRec.indexOf(p) == papNonRec.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!papComp.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(papComp.get(0).getDate()));
            material = papComp.get(0).getWasteMaterial();
            category = papComp.get(0).getWasteCategory();
            total = 0;

            for (Paper p : papComp) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.MONTH)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Addding if last element
                if (papComp.indexOf(p) == papComp.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!metRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(metRec.get(0).getDate()));
            material = metRec.get(0).getWasteMaterial();
            category = metRec.get(0).getWasteCategory();
            total = 0;

            for (Metal m : metRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(m.getDate())).get(Calendar.MONTH)) {
                    date = m.getDate();
                    total += m.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(m.getDate()));
                    date = m.getDate();
                    total = m.getAmount();
                }

                // Addding if last element
                if (metRec.indexOf(m) == metRec.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!metNonRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(metNonRec.get(0).getDate()));
            material = metNonRec.get(0).getWasteMaterial();
            category = metNonRec.get(0).getWasteCategory();
            total = 0;

            for (Metal m : metNonRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(m.getDate())).get(Calendar.MONTH)) {
                    date = m.getDate();
                    total += m.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(m.getDate()));
                    date = m.getDate();
                    total = m.getAmount();
                }

                // Addding if last element
                if (metNonRec.indexOf(m) == metNonRec.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!glassRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(glassRec.get(0).getDate()));
            material = glassRec.get(0).getWasteMaterial();
            category = glassRec.get(0).getWasteCategory();
            total = 0;

            for (Glass g : glassRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(g.getDate())).get(Calendar.MONTH)) {
                    date = g.getDate();
                    total += g.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(g.getDate()));
                    date = g.getDate();
                    total = g.getAmount();
                }

                // Addding if last element
                if (glassRec.indexOf(g) == glassRec.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!glassNonRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(glassNonRec.get(0).getDate()));
            material = glassNonRec.get(0).getWasteMaterial();
            category = glassNonRec.get(0).getWasteCategory();
            total = 0;

            for (Glass g : glassNonRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(g.getDate())).get(Calendar.MONTH)) {
                    date = g.getDate();
                    total += g.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(g.getDate()));
                    date = g.getDate();
                    total = g.getAmount();
                }

                // Addding if last element
                if (glassNonRec.indexOf(g) == glassNonRec.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!bioComp.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(bioComp.get(0).getDate()));
            material = bioComp.get(0).getWasteMaterial();
            category = bioComp.get(0).getWasteCategory();
            total = 0;

            for (Bio b : bioComp) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(b.getDate())).get(Calendar.MONTH)) {
                    date = b.getDate();
                    total += b.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(b.getDate()));
                    date = b.getDate();
                    total = b.getAmount();
                }

                // Addding if last element
                if (bioComp.indexOf(b) == bioComp.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!bioNonComp.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(bioNonComp.get(0).getDate()));
            material = bioNonComp.get(0).getWasteMaterial();
            category = bioNonComp.get(0).getWasteCategory();
            total = 0;

            for (Bio b : bioNonComp) {
                // Incrementing monthly total
                if (calendar.get(Calendar.MONTH) == getCalendar(dateFormatter.parse(b.getDate())).get(Calendar.MONTH)) {
                    date = b.getDate();
                    total += b.getAmount();
                } // Adding and proceeding to next month
                else {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(b.getDate()));
                    date = b.getDate();
                    total = b.getAmount();
                }

                // Addding if last element
                if (bioNonComp.indexOf(b) == bioNonComp.size() - 1) {
                    monthlyTotals.add(new Waste(monthDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }
    }

    /**
     * Process arrayLists to get totals.
     */
    private void processYearlyTotals() throws ParseException {
        // Preparing
        readInWasteList();

        // Sorting
        //wasteList.sort(sorter);
        Collections.sort(wasteList, WasteComparator.ascending(WasteComparator.getComparator(WasteComparator.DATE_SORT, WasteComparator.MATERIAL_SORT, WasteComparator.CATEGORY_SORT)));

        // Splitting
        splitList();

        // Variables
        double total;
        String material, category, date = "";
        Calendar calendar;

        // Processing
        if (!plasRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(plasRec.get(0).getDate()));
            material = plasRec.get(0).getWasteMaterial();
            category = plasRec.get(0).getWasteCategory();
            total = 0;

            for (Plastic p : plasRec) {
                // Incrementing yearly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.YEAR)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next year
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Addding if last element
                if (plasRec.indexOf(p) == plasRec.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!plasNonRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(plasNonRec.get(0).getDate()));
            material = plasNonRec.get(0).getWasteMaterial();
            category = plasNonRec.get(0).getWasteCategory();
            total = 0;

            for (Plastic p : plasNonRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.YEAR)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Adding if last element
                if (plasNonRec.indexOf(p) == plasNonRec.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!plasFilm.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(plasFilm.get(0).getDate()));
            material = plasFilm.get(0).getWasteMaterial();
            category = plasFilm.get(0).getWasteCategory();
            total = 0;

            for (Plastic p : plasFilm) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.YEAR)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Adding if last element
                if (plasFilm.indexOf(p) == plasFilm.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!papRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(papRec.get(0).getDate()));
            material = papRec.get(0).getWasteMaterial();
            category = papRec.get(0).getWasteCategory();
            total = 0;

            for (Paper p : papRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.YEAR)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Adding if last element
                if (papRec.indexOf(p) == papRec.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!papNonRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(papNonRec.get(0).getDate()));
            material = papNonRec.get(0).getWasteMaterial();
            category = papNonRec.get(0).getWasteCategory();
            total = 0;

            for (Paper p : papNonRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.YEAR)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Adding if last element
                if (papNonRec.indexOf(p) == papNonRec.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!papComp.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(papComp.get(0).getDate()));
            material = papComp.get(0).getWasteMaterial();
            category = papComp.get(0).getWasteCategory();
            total = 0;

            for (Paper p : papComp) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(p.getDate())).get(Calendar.YEAR)) {
                    date = p.getDate();
                    total += p.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(p.getDate()));
                    date = p.getDate();
                    total = p.getAmount();
                }

                // Adding if last element
                if (papComp.indexOf(p) == papComp.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!metRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(metRec.get(0).getDate()));
            material = metRec.get(0).getWasteMaterial();
            category = metRec.get(0).getWasteCategory();
            total = 0;

            for (Metal m : metRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(m.getDate())).get(Calendar.YEAR)) {
                    date = m.getDate();
                    total += m.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(m.getDate()));
                    date = m.getDate();
                    total = m.getAmount();
                }

                // Adding if last element
                if (metRec.indexOf(m) == metRec.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!metNonRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(metNonRec.get(0).getDate()));
            material = metNonRec.get(0).getWasteMaterial();
            category = metNonRec.get(0).getWasteCategory();
            total = 0;

            for (Metal m : metNonRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(m.getDate())).get(Calendar.YEAR)) {
                    date = m.getDate();
                    total += m.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(m.getDate()));
                    date = m.getDate();
                    total = m.getAmount();
                }

                // Adding if last element
                if (metNonRec.indexOf(m) == metNonRec.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!glassRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(glassRec.get(0).getDate()));
            material = glassRec.get(0).getWasteMaterial();
            category = glassRec.get(0).getWasteCategory();
            total = 0;

            for (Glass g : glassRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(g.getDate())).get(Calendar.YEAR)) {
                    date = g.getDate();
                    total += g.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(g.getDate()));
                    date = g.getDate();
                    total = g.getAmount();
                }

                // Adding if last element
                if (glassRec.indexOf(g) == glassRec.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!glassNonRec.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(glassNonRec.get(0).getDate()));
            material = glassNonRec.get(0).getWasteMaterial();
            category = glassNonRec.get(0).getWasteCategory();
            total = 0;

            for (Glass g : glassNonRec) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(g.getDate())).get(Calendar.YEAR)) {
                    date = g.getDate();
                    total += g.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(g.getDate()));
                    date = g.getDate();
                    total = g.getAmount();
                }

                // Adding if last element
                if (glassNonRec.indexOf(g) == glassNonRec.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!bioComp.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(bioComp.get(0).getDate()));
            material = bioComp.get(0).getWasteMaterial();
            category = bioComp.get(0).getWasteCategory();
            total = 0;

            for (Bio b : bioComp) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(b.getDate())).get(Calendar.YEAR)) {
                    date = b.getDate();
                    total += b.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(b.getDate()));
                    date = b.getDate();
                    total = b.getAmount();
                }

                // Adding if last element
                if (bioComp.indexOf(b) == bioComp.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }

        if (!bioNonComp.isEmpty()) {
            calendar = getCalendar(dateFormatter.parse(bioNonComp.get(0).getDate()));
            material = bioNonComp.get(0).getWasteMaterial();
            category = bioNonComp.get(0).getWasteCategory();
            total = 0;

            for (Bio b : bioNonComp) {
                // Incrementing monthly total
                if (calendar.get(Calendar.YEAR) == getCalendar(dateFormatter.parse(b.getDate())).get(Calendar.YEAR)) {
                    date = b.getDate();
                    total += b.getAmount();
                } // Adding and proceeding to next month
                else {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                    calendar = getCalendar(dateFormatter.parse(b.getDate()));
                    date = b.getDate();
                    total = b.getAmount();
                }

                // Addding if last element
                if (bioNonComp.indexOf(b) == bioNonComp.size() - 1) {
                    yearlyTotals.add(new Waste(yearDateFormatter.format(dateFormatter.parse(date)), material, category, total));
                }
            }
        }
    }

    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * Checks if text is numeric.
     *
     * @param text the text to be evaluated.
     * @return true or false.
     */
    private boolean isDouble(String text) {
        try {
            Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

//    private void goal() throws ParseException
//    {
//        readInWasteList();
//        Date date = new Date();
//        int month = date.getMonth();
//        int lastMonth;
//
//        // Setting last months value
//        if (month == 1)
//        {
//            lastMonth = 12;
//        }
//        else
//        {
//            lastMonth = month - 1;
//        }
//
//        int year = date.getYear();
//        for (Waste w : wasteList)
//        {
//            Date d = dateFormatter.parse(w.getDate());
//
//            // Show if goal completed and prompt to set new goal...
//            if (!goal.equals(""))
//            {
//                if(goalMet(lastMonth))
//                {
//                    JOptionPane.showMessageDialog(this, "You have met your goal for the month!!!", "Goal Satisfied!", JOptionPane.INFORMATION_MESSAGE);
//                }
//                else
//                {
//                    JOptionPane.showMessageDialog(this, "You have not met your goal for the month, better luck next time!", "Goal Failed!", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//
//            if (d.getMonth() > month && d.getYear() >= year)
//            {
//                // TODO Time for a new goal show journalFrame....
//            }
//        }
//    }
//    private boolean goalMet(int month)
//    {
//        int lastMonth;
//        if (month == 1)
//        {
//            lastMonth = 12;
//        }
//        else
//        {
//           lastMonth = month - 1;
//        }
//
//        switch(goal)
//        {
//            case "Reduce Compostable Bio":
//                if (monthlyTotal.get(month > monthlyTotal.get(lastMonth))
//                return ;
//            case REDUCE_BIO_NON_COMPOSTABLE:
//                return "Reduce Non-Compostable Bio";
//            case REDUCE_GLASS_RECYCLABLE:
//                return "Reduce Recyclable Glass";
//            case REDUCE_GLASS_NON_RECYCLABLE:
//                return "Reduce Non-Recyclable Glass";
//            case REDUCE_METAL_RECYCLABLE:
//                return "Reduce Recyclable Metal";
//            case REDUCE_METAL_NON_RECYCLABLE:
//                return "Reduce Non-Recyclable Metal";
//            case REDUCE_PAPER_RECYCLABLE:
//                return "Reduce Recyclable Paper";
//            case REDUCE_PAPER_NON_RECYCLABLE:
//                return "Reduce Non-Recyclable Paper";
//            case REDUCE_PAPER_COMPOSTABLE:
//                return "Reduce Compostable Paper";
//            case REDUCE_PLASTIC_RECYCLABLE:
//                return "Reduce Recyclable Plastic";
//            case REDUCE_PLASTIC_NON_RECYCLABLE:
//                return "Reduce Non-Recyclable Plastic";
//            case REDUCE_PLASTIC_FILM:
//                return "Reduce Plastic Films";
//            default:
//                return null;
//            }
//        }

    private void readSettings(){
        // Reading settings
        try (Scanner reader = new Scanner(settingsFile)) {
            // Name greeting
            username = reader.nextLine();
            unit = reader.nextLine();
            goal = reader.nextLine();
            prompted = Boolean.parseBoolean(reader.nextLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readGoals(){

    }
    /**
     * Rewrites the journal with a sorted list.
     */
    private void rewriteJournal() {
        // Reading File
        readInWasteList();

        // Sorting List
        Collections.sort(wasteList, WasteComparator.ascending(WasteComparator.getComparator(WasteComparator.DATE_SORT, WasteComparator.MATERIAL_SORT, WasteComparator.CATEGORY_SORT)));

        // Constructing PrintWriter
        PrintWriter output;
        String format = "%s\t%-30s\t%-20s\t%-20s";

        try {
            output = new PrintWriter(journalFile);
            // Header
            String date = wasteList.get(0).getDate();
            output.println(date + "\n");
            output.printf(format, "Material", "Category", "Amount", "Total");
            //output.println();
            output.println("----------------------------------------------------------------------------------------------------");

            // Body
            for (Waste w : wasteList) {
                if (w.getDate().equals(date)) {
                    output.printf(format, w.getWasteMaterial(), w.getWasteCategory(), w.getAmount(), w.getPercent());
                    output.println();
                } else {
                    output.println("----------------------------------------------------------------------------------------------------");
                    output.println();
                    date = w.getDate();
                    output.println(date + "\n");
                    output.printf(format, "Material", "Category", "Amount", "Total");
                    //output.println();
                    output.println("----------------------------------------------------------------------------------------------------");
                    output.printf(format, w.getWasteMaterial(), w.getWasteCategory(), w.getAmount(), w.getPercent());
                    output.println();
                }

                // Finalizing if end of list
                if (wasteList.indexOf(w) == wasteList.size() - 1) {
                    output.println("----------------------------------------------------------------------------------------------------");
                    output.println();
                }
            }

            // Closing PrintWriter
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeTrashAuditFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//     /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HomeTrashAuditFrame(username, unit).setVisible(true);
//            }
//        });
//    }
}