
package homeinventorygui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeInventoryGUI extends JFrame {
    private JTextField itemNameField, descriptionField, quantityField, valueField;
    private JTextArea inventoryArea;

    public HomeInventoryGUI() {
        setTitle("Home Inventory");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels
        JLabel itemNameLabel = new JLabel("Item Name:");
        JLabel descriptionLabel = new JLabel("Description:");
        JLabel quantityLabel = new JLabel("Quantity:");
        JLabel valueLabel = new JLabel("Value:");

        // Create text fields
        itemNameField = new JTextField(20);
        descriptionField = new JTextField(20);
        quantityField = new JTextField(5);
        valueField = new JTextField(10);

        // Create buttons
        JButton addButton = new JButton("Add Item");
        JButton clearButton = new JButton("Clear Inventory");

        // Create text area for displaying inventory
        inventoryArea = new JTextArea(10, 30);
        inventoryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(inventoryArea);

        // Create panel for text fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(itemNameLabel);
        inputPanel.add(itemNameField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(valueLabel);
        inputPanel.add(valueField);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        // Add components to frame
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new AddItemListener());
        clearButton.addActionListener(new ClearInventoryListener());
    }

    private class AddItemListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String itemName = itemNameField.getText();
            String description = descriptionField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double value = Double.parseDouble(valueField.getText());

            // Add item details to inventory area
            inventoryArea.append("Item: " + itemName + "\n");
            inventoryArea.append("Description: " + description + "\n");
            inventoryArea.append("Quantity: " + quantity + "\n");
            inventoryArea.append("Value: $" + value + "\n");
            inventoryArea.append("----------------------\n");

            // Clear input fields
            itemNameField.setText("");
            descriptionField.setText("");
            quantityField.setText("");
            valueField.setText("");
        }
    }

    private class ClearInventoryListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Clear inventory area
            inventoryArea.setText("");
        }
    }

    public static void main(String[] args) {
        HomeInventoryGUI inventoryGUI = new HomeInventoryGUI();
        inventoryGUI.setVisible(true);
    }
}
