import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddMember {
    private JFrame previousWindow;
    public AddMember(JFrame previousWindow) {
        JFrame frame = new JFrame("MARINGO SPORTS CLUB");
        JLabel registration = new JLabel("Maringo Sports Club Registration");
        registration.setFont(new Font("poppins", Font.BOLD, 20));
        registration.setBounds(200, 0, 1000, 50);

        JLabel name = new JLabel("Full Name");
        name.setBounds(10, 80, 150, 40);
        name.setFont(new Font("poppins", Font.BOLD, 14));

        JTextField namefield = new JTextField(20);
        namefield.setBounds(140, 85, 250, 30);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("poppins", Font.BOLD, 14));
        gender.setBounds(10, 120, 150, 40);
        JComboBox<String> combogender = new JComboBox<>(new String[]{"Male", "Female"});
        combogender.setBounds(135, 125, 80, 30);
//        JCheckBox male = new JCheckBox("male");
//        male.setFont(new Font("poppins", Font.BOLD, 14));
//        male.setBounds(135, 120, 80, 40);
//        JCheckBox female = new JCheckBox("female");
//        female.setFont(new Font("poppins", Font.BOLD, 14));
//        female.setBounds(220, 120, 150, 40);

        JLabel contactlabel=new JLabel("Contact Details");
        contactlabel.setBounds(10,160,150,40);
        contactlabel.setFont(new Font("poppins",Font.BOLD,14));
        JTextField confield=new JTextField(20);
        confield.setBounds(140,165,200,30);

        JLabel kin = new JLabel("Next of Kin");
        kin.setFont(new Font("poppins", Font.BOLD, 14));
        kin.setBounds(10, 210, 150, 40);

        JTextField kinfield = new JTextField(20);
        kinfield.setBounds(140, 215, 250, 30);

        JLabel dob = new JLabel("Sub Counties");
        dob.setFont(new Font("poppins", Font.BOLD, 14));
        dob.setBounds(10, 260, 150, 40);
        JComboBox<String> subcounty = new JComboBox<>(new String[]{"Embakasi", "Donholm", "Kayole", "Masimba", "Jacaranda", "Komarock", "Manyanja Rd", "Nasra"});
        subcounty.setBounds(140, 265, 100, 30);

        JLabel contact = new JLabel("Year of Birth");
        contact.setFont(new Font("poppins", Font.BOLD, 14));
        contact.setBounds(10, 310, 150, 40);

        JTextField contactfield = new JTextField(20);
        contactfield.setBounds(140, 315, 150, 30);

        JLabel school = new JLabel("School/College");
        school.setFont(new Font("poppins", Font.BOLD, 14));
        school.setBounds(10, 360, 150, 40);

        JTextField schoolfield = new JTextField(20);
        schoolfield.setBounds(140, 365, 250, 30);

        JLabel game = new JLabel("Games of interest");
        game.setFont(new Font("poppins", Font.BOLD, 14));
        game.setBounds(10, 410, 150, 40);

        JCheckBox football = new JCheckBox("Football");
        JCheckBox basketball = new JCheckBox("Basketball");
        JCheckBox swimming = new JCheckBox("Swimming");
        JCheckBox hockey = new JCheckBox("Hockey");
        JCheckBox table = new JCheckBox("Rugby");
        JCheckBox pool = new JCheckBox("Chess");
        JCheckBox chess = new JCheckBox("Draft");

        football.setFont(new Font("poppins", Font.BOLD, 14));
        football.setBounds(140, 410, 90, 40);
        basketball.setFont(new Font("poppins", Font.BOLD, 14));
        basketball.setBounds(230, 410, 150, 40);
        swimming.setFont(new Font("poppins", Font.BOLD, 14));
        swimming.setBounds(140, 440, 100, 40);
        hockey.setFont(new Font("poppins", Font.BOLD, 14));
        hockey.setBounds(240, 440, 150, 40);
        table.setFont(new Font("poppins", Font.BOLD, 14));
        table.setBounds(140, 470, 80, 40);
        pool.setFont(new Font("poppins", Font.BOLD, 14));
        pool.setBounds(220, 470, 70, 40);
        chess.setFont(new Font("poppins", Font.BOLD, 14));
        chess.setBounds(290, 470, 70, 40);

        JLabel weight = new JLabel("Weight(in KG)");
        weight.setFont(new Font("poppins", Font.BOLD, 14));
        weight.setBounds(420, 80, 150, 40);

        JTextField weightfield = new JTextField(20);
        weightfield.setBounds(570, 85, 100, 30);

        JLabel height = new JLabel("Height(cm)");
        height.setFont(new Font("poppins", Font.BOLD, 14));
        height.setBounds(420, 130, 150, 40);

        JTextField heightfield = new JTextField(20);
        heightfield.setBounds(570, 135, 100, 30);

        JLabel special = new JLabel("Special needs");
        special.setFont(new Font("poppins", Font.BOLD, 14));
        special.setBounds(420, 180, 150, 40);
        JComboBox<String> comboSpecialNeeds = new JComboBox<>(new String[]{"No", "Yes"});
        comboSpecialNeeds.setBounds(570,185 , 50, 30);

        JLabel membership = new JLabel("Membership");
        membership.setFont(new Font("poppins", Font.BOLD, 14));
        membership.setBounds(420, 230, 150, 40);
        JComboBox<String> comboMembership = new JComboBox<>(new String[]{"Individual", "Group"});
        comboMembership.setBounds(570, 235, 80, 30);

        JLabel userlabel = new JLabel("Username");
        userlabel.setFont(new Font("poppins", Font.BOLD, 14));
        userlabel.setBounds(420, 400, 150, 40);
        JTextField userfield = new JTextField(20);
        userfield.setBounds(570, 405, 170, 30);

        JLabel passlabel = new JLabel("Password");
        passlabel.setFont(new Font("poppins", Font.BOLD, 14));
        passlabel.setBounds(420, 450, 150, 40);
        JPasswordField passfield = new JPasswordField(20);
        passfield.setBounds(570, 455, 170, 30);

        JLabel feelabel = new JLabel("Membership Fee");
        feelabel.setFont(new Font("poppins", Font.BOLD, 14));
        feelabel.setBounds(420, 330, 150, 40);
        JTextField fee = new JTextField("1000");
        fee.setFocusable(false);
        fee.setFont(new Font("Arial", Font.BOLD, 15));
        fee.setForeground(Color.red);
        fee.setEditable(false);
        fee.setBounds(570, 335, 50, 30);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(registration,BorderLayout.CENTER);
        frame.add(titlePanel,BorderLayout.NORTH);


        JLabel errorLabel = new JLabel("Failure! Please fill all the blank fields");
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setForeground(Color.red);
        titlePanel.add(errorLabel, BorderLayout.SOUTH);
        errorLabel.setVisible(false);

        JLabel grouplabel = new JLabel("Group Name");
        grouplabel.setFont(new Font("poppins", Font.BOLD, 14));
        grouplabel.setBounds(420, 280, 150, 40);
        JTextField groupfield = new JTextField(20);
        groupfield.setBounds(570, 285, 170, 30);
        grouplabel.setVisible(false);
        groupfield.setVisible(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(registration);
        panel.add(name);
        panel.add(namefield);
        panel.add(gender);
        panel.add(combogender);
        panel.add(kin);
        panel.add(kinfield);
        panel.add(dob);
        panel.add(subcounty);
        panel.add(contact);
        panel.add(contactfield);
        panel.add(school);
        panel.add(schoolfield);
        panel.add(game);
        panel.add(weight);
        panel.add(weightfield);
        panel.add(height);
        panel.add(heightfield);
        panel.add(special);
        panel.add(comboSpecialNeeds);
        panel.add(football);
        panel.add(basketball);
        panel.add(hockey);
        panel.add(pool);
        panel.add(chess);
        panel.add(swimming);
        panel.add(table);
        panel.add(membership);
        panel.add(comboMembership);
        panel.add(fee);
        panel.add(feelabel);
        panel.add(userlabel);
        panel.add(userfield);
        panel.add(passlabel);
        panel.add(passfield);
        panel.add(contactlabel);
        panel.add(confield);
        panel.add(grouplabel);
        panel.add(groupfield);

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        comboMembership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboMembership.getSelectedItem() == "Group") {
                    grouplabel.setVisible(true);
                    groupfield.setVisible(true);
                    fee.setText("500");
                } else {
                    grouplabel.setVisible(false);
                    groupfield.setVisible(false);
                    fee.setText("1000");
                }
            }
        });

        JButton register = new JButton("REGISTER");
        panel.add(register);
        register.setFont(new Font("poppins", Font.BOLD, 25));
        register.setBounds(450, 510, 200, 42);

        JButton backButton= new JButton("BACK");
        backButton.setFont(new Font("poppins", Font.BOLD, 25));
        backButton.setBounds(100, 510, 150, 40);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousWindow.setVisible(true);
                frame.dispose();

            }
        });

        panel.add(backButton);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                ClubMember member = null;
                if (namefield.getText().isBlank() ||
                        kinfield.getText().isBlank() || schoolfield.getText().isBlank() ||
                        heightfield.getText().isBlank() || weightfield.getText().isBlank()) {

                    errorLabel.setVisible(true);
                    //registerButton.hide();
                    System.out.println("Failed, Fill all the fields!");
                } else {
                    //(namefield.getText(), contactfield.getText(), schoolfield.getText(),heightfield.getText(),
                    //weightfield.getText(), kinfield.getText(), (String) comboSpecialNeeds.getSelectedItem(),
                    //(String) comboMembership.getSelectedItem());
                    //JOptionPane.showMessageDialog(frame, "Registration Successful");
                    member = new ClubMember(namefield.getText(), (String) subcounty.getSelectedItem(),
                            userfield.getText(), passfield.getText(), heightfield.getText(),
                            weightfield.getText(), game.getText(), (String) comboSpecialNeeds.getSelectedItem(),
                            (String) comboMembership.getSelectedItem());
                    JOptionPane.showMessageDialog(frame, "Registration Successful");
                    previousWindow.setVisible(true);
                    frame.dispose();

                }
                //previousWindow.setVisible(true);
                //frame.dispose();


                String FullName = namefield.getText();
                String NextofKin = kinfield.getText();
                String Username = userfield.getText();
                String Password = passfield.getText();
                int Contact = Integer.parseInt(confield.getText());
                String SubCounty = (String) subcounty.getSelectedItem();
                int YearofBirth = Integer.parseInt(contactfield.getText());
                String School = schoolfield.getText();
                int Weight = Integer.parseInt(weightfield.getText());
                int Height = Integer.parseInt(heightfield.getText());
                String Specialneeds = (String) comboSpecialNeeds.getSelectedItem();
                String Membership = (String) comboMembership.getSelectedItem();
                String GroupName = groupfield.getText();
                int Fee = Integer.parseInt(fee.getText());
                String Gender= (String) combogender.getSelectedItem();
                //String Games ="";

                String url = "jdbc:mysql://localhost:3306/maringosportsclub";
                String username = "root";
                String password = "";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection connection = DriverManager.getConnection(url, username, password);

                    System.out.println("Connected!");

                    //PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `members`(`Name`, `Next of Kin`, `Y.O.B`, `Weight`, `Height`, `School`) " +
                    //     "VALUES ('Emmanuel Nyabicha','Ogeto','2004','59','169','KU')");
                    PreparedStatement pstmt = connection.prepareStatement("INSERT INTO members(`FullName`, `NextofKin`, `Username`,`Password`,`Contact`, `SubCounty`, `YearofBirth`,`School`,`Weight`,`Height`,`Specialneeds`,`Membership`,`GroupName`,`Fee`,`Gender`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, FullName);
                    pstmt.setString(2, NextofKin);
                    pstmt.setString(3, Username);
                    pstmt.setString(4, Password);
                    pstmt.setInt(5, Contact);
                    pstmt.setString(6, SubCounty);
                    pstmt.setInt(7, YearofBirth);
                    pstmt.setString(8, School);
                    pstmt.setInt(9, Weight);
                    pstmt.setInt(10, Height);
                    pstmt.setString(11, Specialneeds);
                    pstmt.setString(12, Membership);
                    pstmt.setString(13, GroupName);
                    pstmt.setInt(14, Fee);
                    pstmt.setString(15,Gender);
                    //pstmt.setString(16,Games);
                    pstmt.executeUpdate();

                    Statement statement = connection.createStatement();

                    //statement.executeUpdate("INSERT INTO members(`Full Name`, `Next of Kin`, `Year of Birth`,`Contact Details`, `Sub-Counties`, `School`,`Games of Interest`,`Gender`,`Weight`,`Height`,`Special Needs`,`Membership`,`Group Name`,`Fee`) VALUES (`"+Full_Name+"`,`"+Next_of_Kin+"`,`"+Year_of_Birth+"`,`"+Contact_Details+"`,`"+Sub_Counties+"`,`"+School+"`,`"+Games_of_Interest+"`,`"+Gender+"`,`"+Weight+"`,`"+Height+"`,`"+Special_Needs+"`,`"+Membership+"`,`"+Group_Name+"`,`"+Fee+"`)");

                    ResultSet resultSet = statement.executeQuery("SELECT * FROM members");

                    while ((resultSet.next())) {
                        //System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
                    }

                    resultSet.close();
                    connection.close();

                } catch (Exception e1) {
                    System.out.println(e1);
                    e1.printStackTrace();
                }

                System.out.println(member.getMembershipType());
            }

            });
        }



        //frame.add(mainPanel, BorderLayout.CENTER);

        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setVisible(true);


    public static void main(String[] args) {

        new AddMember(new JFrame());
    }
}
