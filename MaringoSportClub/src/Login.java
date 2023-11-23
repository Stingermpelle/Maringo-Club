import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public static void main(String[]args){
        new Login(new JFrame());}
    private JFrame previousWindow;
    public Login(JFrame previousWindow){

        JFrame frame = new JFrame();
        frame.setTitle("MARINGO SPORTS CLUB");
        // frame.setResizable(false);

        JLabel loginlabel = new JLabel("LOGIN");
        loginlabel.setFont(new Font("poppins", Font.BOLD, 25));
        loginlabel.setBounds(300, 80, 240, 40);

        JLabel userlabel = new JLabel("Username");
        userlabel.setFont(new Font("poppins", Font.BOLD, 18));
        userlabel.setBounds(10, 180, 240, 40);

        JTextField userfield = new JTextField();
        userfield.setBounds(150, 180, 240, 40);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("poppins", Font.BOLD, 18));
        password.setBounds(10, 270, 240, 40);

        JPasswordField passfield = new JPasswordField();
        passfield.setBounds(150, 270, 240, 40);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(160, 370, 150, 40);
        loginButton.setFont(new Font("poppins", Font.BOLD, 18));
        JButton signup = new JButton("Sign up");
        signup.setBounds(450, 370, 150, 40);
        signup.setFont(new Font("poppins", Font.BOLD, 18));

        JButton backButton=new JButton("BACK");
        backButton.setBounds(300, 450, 150, 40);
        backButton.setFont(new Font("poppins", Font.BOLD, 18));

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(loginlabel,BorderLayout.CENTER);
        frame.add(titlePanel,BorderLayout.NORTH);


        JLabel errorLabel = new JLabel("Failed! Please fill all the blank fields");
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setForeground(Color.red);
        titlePanel.add(errorLabel, BorderLayout.SOUTH);
        errorLabel.setVisible(false);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(loginlabel);
        panel.add(userlabel);
        panel.add(userfield);
        panel.add(password);
        panel.add(passfield);
        panel.add(loginButton);
        panel.add(signup);
        panel.add(backButton);

        frame.add(panel);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMember(frame);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                if (userfield.getText().isBlank() ||
                        passfield.getText().isBlank()) {

                    errorLabel.setVisible(true);
                    System.out.println("Failed, Fill all the fields!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                    frame.dispose();
                    new HomePage(frame);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                previousWindow.setVisible(true);
                frame.dispose();
            }
        });
    }
}



