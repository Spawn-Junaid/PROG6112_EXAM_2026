package Question2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

    public class MattressSalesApp extends JFrame {
        private JTextField txtCustomerName, txtPrice;
        private JComboBox<String> cmbProducts;
        private JMenuBar menuBar;
        private JMenu menuFile;
        private JMenuItem mnuClear;
        private JMenuItem mnuExit;

        public MattressSalesApp() {
            setTitle("Product App");
            setSize(400, 350);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);


            JLabel lblCustomer = new JLabel("Customer Name:");
            lblCustomer.setBounds(30, 30, 120, 25);
            add(lblCustomer);

            JLabel lblProduct = new JLabel("Select Product:");
            lblProduct.setBounds(30, 70, 120, 25);
            add(lblProduct);

            JLabel lblPrice = new JLabel("Enter Price:");
            lblPrice.setBounds(30, 110, 120, 25);
            add(lblPrice);

            // Text Fields & Combo Box
            txtCustomerName = new JTextField();
            txtCustomerName.setBounds(160, 30, 180, 25);
            add(txtCustomerName);

            String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
            cmbProducts = new JComboBox<>(products);
            cmbProducts.setBounds(160, 70, 180, 25);
            add(cmbProducts);

            txtPrice = new JTextField();
            txtPrice.setBounds(160, 110, 180, 25);
            add(txtPrice);

            // Process Button
            JButton btnProcess = new JButton("PROCESS");
            btnProcess.setBounds(160, 160, 180, 30);
            add(btnProcess);


            menuBar = new JMenuBar();
            menuFile = new JMenu("File");
            JMenuItem mnuProcess = new JMenuItem("Process");
            mnuClear = new JMenuItem("Clear");
            mnuExit = new JMenuItem("Exit");

            menuFile.add(mnuProcess);
            menuFile.add(mnuClear);
            menuFile.add(mnuExit);
            menuBar.add(menuFile);
            setJMenuBar(menuBar);


            ActionListener processAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    processSalesData();
                }
            };

            btnProcess.addActionListener(processAction);
            mnuProcess.addActionListener(processAction);

            mnuClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtCustomerName.setText("");
                    txtPrice.setText("");
                    cmbProducts.setSelectedIndex(0);
                }
            });

            mnuExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }

        private void processSalesData() {
            try {
                String customerName = txtCustomerName.getText();
                String selectedProduct = (String) cmbProducts.getSelectedItem();
                double price = Double.parseDouble(txtPrice.getText());

                ProductCalculations calc = new ProductCalculations(price);
                double vat = calc.GetVat();
                double commission = calc.GetCommission();
                double total = calc.GetTotal();

                // Display Message Dialog
                String message = "Customer Name: " + customerName + "\n" +
                        "Product: " + selectedProduct + "\n" +
                        "VAT: R " + String.format("%.1f", vat) + "\n" +
                        "COMMISSION: R " + String.format("%.1f", commission) + "\n" +
                        "TOTAL: R " + String.format("%.1f", total);

                JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);


                try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
                    out.println("**************************************************");
                    out.println("Customer Name: " + customerName);
                    out.println("Product: " + selectedProduct);
                    out.println("VAT: R " + String.format("%.1f", vat));
                    out.println("COMMISSION: R " + String.format("%.1f", commission));
                    out.println("TOTAL: R " + String.format("%.1f", total));
                    out.println("**************************************************");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new MattressSalesApp().setVisible(true));
        }
    }


