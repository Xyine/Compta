package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

public class MasterWindow {

    private JFrame frame;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> categoryComboBox;
    private JComboBox<String> subcategoryComboBox;
    private JTextField amountField;
    private JButton newTransactionButton;
    private DefaultTableModel tableModel;

    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final String[] CATEGORIES = {"Food", "Housing", "Transportation", "Health", "Entertainment", "Utilities", "Education", "Debts and Loans", "Savings and Investments", "Miscellaneous"};

    private static final Map<String, String[]> SUBCATEGORIES_MAP = new HashMap<>();
    static {
        SUBCATEGORIES_MAP.put("Food", new String[]{"Groceries", "Dining out", "Fast food", "Snacks", "Beverages"});
        SUBCATEGORIES_MAP.put("Housing", new String[]{"Rent or Mortgage", "Utilities", "Property Taxes", "Home Insurance", "Maintenance and Repairs"});
        SUBCATEGORIES_MAP.put("Transportation", new String[]{"Gasoline or Fuel", "Public Transport", "Vehicle Maintenance", "Parking Fees", "Car Insurance"});
        SUBCATEGORIES_MAP.put("Health", new String[]{"Health Insurance Premiums", "Doctor Visits", "Medications", "Health Supplements", "Gym Memberships"});
        SUBCATEGORIES_MAP.put("Entertainment", new String[]{"Movies", "Concerts", "Streaming Services", "Hobbies", "Vacations"});
        SUBCATEGORIES_MAP.put("Utilities", new String[]{"Internet", "Cable TV", "Phone", "Streaming Services", "Subscriptions"});
        SUBCATEGORIES_MAP.put("Education", new String[]{"Tuition Fees", "Books and Supplies", "School Trips", "Educational Workshops", "Online Courses"});
        SUBCATEGORIES_MAP.put("Debts and Loans", new String[]{"Credit Card Payments", "Student Loans", "Personal Loans", "Car Loans", "Mortgage Payments"});
        SUBCATEGORIES_MAP.put("Savings and Investments", new String[]{"Retirement Funds", "Savings Accounts", "Stock Investments", "Mutual Funds", "Real Estate Investments"});
        SUBCATEGORIES_MAP.put("Miscellaneous", new String[]{"Clothing", "Gifts", "Charitable Donations", "Pet Expenses", "Home Decor"});
    }

    private class NonEditableTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    public MasterWindow() {
        frame = new JFrame("Wallet Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        // Month Field
        JLabel monthLabel = new JLabel("Month:");
        monthComboBox = new JComboBox<>(MONTHS);
        panel.add(monthLabel);
        panel.add(monthComboBox);

        // Category Field
        JLabel categoryLabel = new JLabel("Category:");
        categoryComboBox = new JComboBox<>(CATEGORIES);
        panel.add(categoryLabel);
        panel.add(categoryComboBox);

        // Subcategory Field
        JLabel subcategoryLabel = new JLabel("Subcategory:");
        subcategoryComboBox = new JComboBox<>();
        panel.add(subcategoryLabel);
        panel.add(subcategoryComboBox);

        // Amount Field
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        panel.add(amountLabel);
        panel.add(amountField);

        // New Transaction Button
        newTransactionButton = new JButton("New Transaction");
        panel.add(newTransactionButton);

// Table for displaying transactions
        String[] columnNames = {"Month", "Category", "Subcategory", "Amount"};
        tableModel = new NonEditableTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        JTable table = new JTable(tableModel);
        table.setDefaultRenderer(Object.class, new NonEditableTableCellRenderer());
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Add an item listener to categoryComboBox to update subcategories
        categoryComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedCategory = (String) categoryComboBox.getSelectedItem();
                String[] subcategories = SUBCATEGORIES_MAP.get(selectedCategory);
                if (subcategories != null) {
                    subcategoryComboBox.setModel(new DefaultComboBoxModel<>(subcategories));
                } else {
                    subcategoryComboBox.setModel(new DefaultComboBoxModel<>());
                }
            }
        });

        // Add ActionListener for the newTransactionButton
        newTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String month = (String) monthComboBox.getSelectedItem();
                String category = (String) categoryComboBox.getSelectedItem();
                String subcategory = (String) subcategoryComboBox.getSelectedItem();
                String amount = amountField.getText();

                // Check if all fields are filled before adding to the table
                if (!month.isEmpty() && !category.isEmpty() && !subcategory.isEmpty() && !amount.isEmpty()) {
                    // Add a new row to the table
                    String[] rowData = {month, category, subcategory, amount};
                    tableModel.addRow(rowData);

                    // Clear input fields
                    amountField.setText("");
                    // You can reset combo boxes to default selection if needed
                } else {
                    // Show a message if any field is empty
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields before adding a new transaction.");
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    private class NonEditableTableCellRenderer implements TableCellRenderer {
        private final DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return defaultRenderer.getTableCellRendererComponent(table, value, false, false, row, column);
        }
    }
}
