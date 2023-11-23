import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewSale {
    private JFrame previousWindow;
    JFrame frame=new JFrame();
    private JCheckBox[] itemCheckboxes;
    private JTextField[] quantityFields;
    private JLabel[] priceLabels;
    private JButton calculateButton;
    private JLabel totalCostLabel;
    private JLabel discountLabel;

    public NewSale(JFrame previousWindow) {
        frame.setTitle("Maringo Sports Store Shopping Cart");
        frame.setLayout(null); // Use absolute positioning

        JButton backButton= new JButton("BACK");
        backButton.setFont(new Font("poppins", Font.BOLD, 25));
        backButton.setBounds(600, 510, 150, 40);
        backButton.setFocusable(false);
        backButton.setBackground(new Color(50, 64, 64));
        backButton.setForeground(Color.white);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
      //frame.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousWindow.setVisible(true);
                frame.dispose();

            }
        });


        // List of items and their prices
        String[] items = {
                "Bloomer (250)",
                "Gameshorts (750)",
                "Hockeystick (2000)",
                "Socks (350)",
                "Sport Shoes  (1000)",
                "Tracksuit (1000)",
                "Tshirt (800)",
                "Wrapper (450)"

        };

        itemCheckboxes = new JCheckBox[items.length];
        quantityFields = new JTextField[items.length];
        priceLabels = new JLabel[items.length];

        for (int i = 0; i < items.length; i++) {
            String item = items[i];
            itemCheckboxes[i] = new JCheckBox(item.split("\\(")[0]);
            quantityFields[i] = new JTextField("1");
            priceLabels[i] = new JLabel("Price: Ksh. " + item.split("\\(")[1].replaceAll("[^0-9]", ""));

            int yOffset = 55 * i; // Adjust the vertical position based on the item index

            itemCheckboxes[i].setBounds(60, 20 + yOffset, 150, 20);
            itemCheckboxes[i].setFont(new Font("Arial", Font.BOLD, 16));

            quantityFields[i].setBounds(280, 20 + yOffset, 30, 20);
            quantityFields[i].setFont(new Font("Arial", Font.BOLD, 16));

            priceLabels[i].setBounds(330, 20 + yOffset, 150, 20);
            priceLabels[i].setFont(new Font("Arial", Font.BOLD, 16));

            frame.add(itemCheckboxes[i]);
            frame.add(quantityFields[i]);
            frame.add(priceLabels[i]);
            frame.add(backButton);
        }

        calculateButton = new JButton("Calculate Total Cost");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 20));
        calculateButton.setBounds(200, 450, 300, 30); // Set bounds for the button

        discountLabel = new JLabel("Discount: Ksh. 0");
        discountLabel.setFont(new Font("Arial", Font.BOLD, 18));
        discountLabel.setBounds(200, 500, 200, 20); // Set bounds for the discount label

        totalCostLabel = new JLabel("Total Cost: Ksh. 0 ");
        totalCostLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalCostLabel.setBounds(200, 530, 200, 20); // Set bounds for the total cost label

        frame.add(calculateButton);
        frame.add(discountLabel);
        frame.add(totalCostLabel);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalCost = 0;
                int discount = 0;

                for (int i = 0; i < itemCheckboxes.length; i++) {
                    if (itemCheckboxes[i].isSelected()) {
                        int quantity = Integer.parseInt(quantityFields[i].getText());
                        String item = items[i];
                        int itemPrice = Integer.parseInt(item.split("\\(")[1].replaceAll("[^0-9]", ""));
                        int itemTotalPrice = quantity * itemPrice;
                        totalCost += itemTotalPrice;

                        // Example: Apply a 5% discount if the item price is over 500 Ksh.
                        if (itemPrice > 500) {
                            discount += (itemTotalPrice * 5) / 100;
                        }
                    }
                }

                discountLabel.setText("Discount: Ksh. " + discount);
                totalCostLabel.setText("Total Cost: Ksh. " + totalCost);
                JOptionPane.showInputDialog(null, ("Enter MPesa Number"));
                JOptionPane.showMessageDialog(null, "An Mpesa prompt\n Has Been Sent To The MPesa Number\nPlease Enter MPesa Pin To Complete Transaction!\nAmount " + totalCostLabel.getText() + " Will Be Deducted From Your MPesa Account!\n");
                JOptionPane.showMessageDialog(null, " Successfully Paid!");
                frame.dispose();

            }
        });

        frame.setSize(800, 600); // Set the frame size
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewSale(new JFrame()));
    }
}
