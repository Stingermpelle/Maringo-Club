//package wins.otherwins;
//
//import wins.Welcome;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ClubMembership {
    private JFrame previousWindow;
    public ClubMembership(JFrame previousWindow) {
        JFrame frame = new JFrame();
        frame.setTitle("Club Members");
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcTop = new GridBagConstraints();
        gbcTop.insets = new Insets(10, 10, 10, 10);
        gbcTop.anchor = GridBagConstraints.WEST;

        JLabel membersLabel = new JLabel("CLUB MEMBERSHIP MANAGEMENT");
        membersLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        membersLabel.setFocusable(false);
        gbcTop.gridx = 0;
        gbcTop.gridy = 2;
        topPanel.add(membersLabel, gbcTop);

        frame.add(topPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();

        JPanel membersPanel = new JPanel(new BorderLayout());
        JLabel minorsLabel = new JLabel("CLUB MEMBERS");
        minorsLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        membersPanel.setFocusable(false);
        membersPanel.add(minorsLabel, BorderLayout.NORTH);

        String url = "jdbc:mysql://localhost:3306/maringosportsclub";
        String username = "root";
        String password = "";

        DefaultTableModel tableModel = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `members`");

            tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnLabel(columnIndex));
            }

            while ((resultSet.next())) {

                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            resultSet.close();
            connection.close();

        } catch (Exception e1) {
            System.out.println(e1);
            e1.printStackTrace();
        }

        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1180, 500));
        table.setEnabled(false);
        table.setFont(new Font("Arial", Font.BOLD, 12));
        table.setFillsViewportHeight(true);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = table.getSelectedRow();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        membersPanel.add(scrollPane);

        frame.add(mainPanel, BorderLayout.CENTER);

        JPanel gamesPlayedPanel = new JPanel(new BorderLayout());

        DefaultTableModel tableModel1 = null;

        JButton addMemberButton = new JButton("NEW MEMBER");
        addMemberButton.setFocusable(false);
        addMemberButton.setFont(new Font("Arial", Font.BOLD, 18));
        addMemberButton.setPreferredSize(new Dimension(200, 50));
        addMemberButton.setBackground(new Color(50, 64, 64));
        addMemberButton.setForeground(Color.green);
        addMemberButton.setBorderPainted(false);
        addMemberButton.setFocusPainted(false);

        addMemberButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addMemberButton.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addMemberButton.setBorderPainted(false);
            }
        });

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMember(frame);
                frame.dispose();
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setFocusable(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.setBackground(new Color(50, 64, 64));
        backButton.setForeground(Color.white);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setBorderPainted(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousWindow.setVisible(true);
                frame.dispose();
            }
        });


        mainPanel.add(membersPanel);
        mainPanel.add(gamesPlayedPanel);
        //mainPanel.add(seniorsPanel);
        mainPanel.add(backButton);
        mainPanel.add(addMemberButton);
        //mainPanel.add(deleteMemberButton);

        frame.setSize(1200, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ClubMembership(new JFrame());
    }
}
