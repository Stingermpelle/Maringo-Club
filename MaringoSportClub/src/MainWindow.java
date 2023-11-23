import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    public MainWindow() {
        JFrame frame = new JFrame();

        frame.setTitle("Maringo Sports Club");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(255, 255, 255));

        JLabel registration = new JLabel("WELCOME TO MARINGO SPORTS CLUB ");
        registration.setFont(new Font("poppins", Font.BOLD, 35));
        registration.setBounds(50, 0, 2000, 100);

        JLabel Image= new JLabel(new ImageIcon("src/Bosi/sport icon.jpg"));
        Image.setBounds(25,100,500,430);
        frame.add(Image);

        JButton membershipButton=new JButton("Login");
        membershipButton.setFont(new Font("poppins", Font.BOLD, 25));
        membershipButton.setBounds(550,140 , 200, 80);
        JButton registrationButton=new JButton("Sign Up");
        registrationButton.setFont(new Font("poppins", Font.BOLD, 25));
        registrationButton.setBounds(550, 320, 200, 80);


        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.add(membershipButton);
        panel.add(registrationButton);
        panel.add(registration);

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        membershipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(frame);
            }
        });

//        reportsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new AddMember(frame);
//            }
//        });

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMember(frame);
            }
        });

//        facilitationButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new GameFacilitation(frame);
//            }
//        });

//        storeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new StoreItems(frame);
//            }
//        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new RoundButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setBackground(new Color(0, 0, 128, 207)); // Navy Blue
//        button.setBackground(new Color(0, 0, 128, 245));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return button;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}

class RoundButton extends JButton {
    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }
}
