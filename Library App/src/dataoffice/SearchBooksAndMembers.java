package dataoffice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchBooksAndMembers extends JInternalFrame {

    private final CommonVarriables CommonVarriables = new CommonVarriables();
    private final String usersTable = CommonVarriables.tablesToCreate[0];

    //for creating the North Panel
    private final JPanel northPanel = new JPanel();
    //for creating the label
    private final JLabel Titled = new JLabel("Search for Books and Members");

    //for creating the center
    private final JPanel center = new JPanel();

    //for creating the Center Panel
    private final JPanel centerBooksPanel = new JPanel();
    //for creating an Internal Panel in the center panel
    private final JPanel searchBooksPanel = new JPanel();
    //for creating an Internal Panel in the center panel
    private final JPanel searchBooksButtonPanel = new JPanel();

    //for creating the table
    private final JLabel searchBooksLabel = new JLabel(" Search by: ");
    //for creating JComboBox
    private final JComboBox searchBooksTypes;
    //for creating String[]
    private final String[] booksTypes = {"SerialNo", "Title", "Author", "Publisher", "Subject", "Class", "ShelfNo", "DateAdded", "Available", "NumberOfAvailbleBooks"};
    //for creating the label
    private final JLabel booksKey = new JLabel(" Write the Keyword: ");
    //for cearting the text field
    private JTextField booksKeyTextField = new JTextField();
    //for creating the button
    private final JButton searchBooksButton = new JButton("Search");

    //for creating the Center Panel
    private final JPanel centerMembersPanel = new JPanel();
    //for creating an Internal Panel in the center panel
    private final JPanel searchMembersPanel = new JPanel();
    //for creating an Internal Panel in the center panel
    private final JPanel searchMembersButtonPanel = new JPanel();

    //for creating the table
    private final JLabel searchMembersLabel = new JLabel(" Search by: ");
    //for creating JComboBox
    private final JComboBox searchMembersTypes;
    //for creating String[]
    private final String[] membersTypes = {"FirstName", "MiddleName", "Surname", "PostalAddress", "PhoneNumber", "AltPhoneNumber", "EmailAddress", "Username", "DateAdded", "NumberOfBooks"};
    //for creating the label
    private final JLabel membersKey = new JLabel(" Write the Keyword: ");
    //for cearting the text field
    private JTextField membersKeyTextField = new JTextField();
    //for creating the button
    private final JButton searchMembersButton = new JButton("Search");

    //for creating the south panel
    private final JPanel southPanel = new JPanel();
    //for creating the button
    private final JButton cancelButton = new JButton("Cancel");

    //for creating an array of string to store the data
    private String[] booksData;
    private String[] membersData;
    //create objects from another classes for using them in the ActionListener
    private ListSearchBooks listBooks;
    private ListSearchMembers listMembers;
    private Books book;
    private Members member;

    //for checking the information from the text field
    public boolean isBooksDataCorrect() {
        booksData = new String[2];
        booksData[0] = searchBooksTypes.getSelectedItem().toString();
        for (int i = 1; i < booksData.length; i++) {
            if (!booksKeyTextField.getText().equals("")) {
                if (searchBooksTypes.getSelectedItem().toString().equals("SerialNo")) {
                    booksData[i] = booksKeyTextField.getText().trim();
                } else {
                    booksData[i] = "%" + booksKeyTextField.getText().trim() + "%";
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //for checking the information from the text field
    public boolean isMembersDataCorrect() {
        membersData = new String[2];
        membersData[0] = searchMembersTypes.getSelectedItem().toString();
        for (int i = 1; i < membersData.length; i++) {
            if (!membersKeyTextField.getText().equals("")) {
                if (searchMembersTypes.getSelectedItem().toString().equals("Username")) {
                    membersData[i] = membersKeyTextField.getText().trim();
                } else {
                    membersData[i] = "%" + membersKeyTextField.getText().trim() + "%";
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //constructor of searchBooksAndMembers
    public SearchBooksAndMembers() {
        //for setting the title for the internal frame
        super("Search", false, true, false, true);
        //for setting the icon
        setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Find16.gif")));
        //for getting the graphical user interface components display area
        Container cp = getContentPane();

        //for setting the layout
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //for setting the font
        Titled.setFont(new Font("Segoe UI", Font.BOLD, 14));
        //for adding the label
        northPanel.add(Titled);
        //for adding the north panel to the container
        cp.add("North", northPanel);

        //for setting the layout
        center.setLayout(new BorderLayout());

        //for setting the layout
        centerBooksPanel.setLayout(new BorderLayout());
        //for setting the layout
        searchBooksPanel.setLayout(new GridLayout(2, 2, 1, 25));
        //for adding the label
        searchBooksPanel.add(searchBooksLabel);
        //for adding the JComboBos[]
        searchBooksPanel.add(searchBooksTypes = new JComboBox(booksTypes));
        //for adding the label
        searchBooksPanel.add(booksKey);
        //for adding the text field
        searchBooksPanel.add(booksKeyTextField);
        //for adding the internal panel to the panel
        centerBooksPanel.add("North", searchBooksPanel);

        //for setting the layout
        searchBooksButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //for adding the button
        searchBooksButtonPanel.add(searchBooksButton);
        //for adding the internal panel to the center panel
        centerBooksPanel.add("South", searchBooksButtonPanel);
        //for setting the border
        centerBooksPanel.setBorder(BorderFactory.createTitledBorder("Search for a books:"));
        //for adding center panel to the center
        center.add("West", centerBooksPanel);

        //for setting the layout
        centerMembersPanel.setLayout(new BorderLayout());
        //for setting the layout
        searchMembersPanel.setLayout(new GridLayout(2, 2, 1, 25));
        //for adding the label
        searchMembersPanel.add(searchMembersLabel);
        //for adding the JComboBos[]
        searchMembersPanel.add(searchMembersTypes = new JComboBox(membersTypes));
        //for adding the label
        searchMembersPanel.add(membersKey);
        //for adding the text field
        searchMembersPanel.add(membersKeyTextField);
        //for adding the internal panel to the panel
        centerMembersPanel.add("North", searchMembersPanel);

        //for setting the layout
        searchMembersButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //for adding the button
        searchMembersButtonPanel.add(searchMembersButton);
        //for adding the internal panel to the center panel
        centerMembersPanel.add("South", searchMembersButtonPanel);
        //for setting the border
        centerMembersPanel.setBorder(BorderFactory.createTitledBorder("Search for a members:"));
        //for adding center panel to the center
        center.add("East", centerMembersPanel);

        //for adding the center to the container
        cp.add("Center", center);

        /**
         * for setting the font to the labels & buttons
         */
        searchBooksLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        searchBooksTypes.setFont(new Font("Segoe UI", Font.BOLD, 14));
        booksKey.setFont(new Font("Segoe UI", Font.BOLD, 14));
        booksKeyTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchBooksButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        searchMembersLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        searchMembersTypes.setFont(new Font("Segoe UI", Font.BOLD, 14));
        membersKey.setFont(new Font("Segoe UI", Font.BOLD, 14));
        membersKeyTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchMembersButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //for setting the layout
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //for adding the button
        southPanel.add(cancelButton);
        //for setting the border
        southPanel.setBorder(BorderFactory.createEtchedBorder());
        //for adding the south panel to the container
        cp.add("South", southPanel);

        /**
         * *********************************************************************
         * for adding the action listener to the button,first the text will be *
         * taken from the JTextField and passing them to listSearchBooks object*
         * *********************************************************************
         */
        searchBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //for checking if there is a missing information
                if (isBooksDataCorrect()) {
                    book = new Books();
                    String bookQuery = "SELECT * FROM " + CommonVarriables.tablesToCreate[2] + " WHERE  " + booksData[0] + " LIKE  '" + booksData[1] + "'";
                    book.connection(bookQuery);
                    String isDataAvailable = book.getIsData();
                    if (isDataAvailable.equalsIgnoreCase("available")) {
                        listBooks = new ListSearchBooks(bookQuery);
                        getParent().add(listBooks);
                        try {
                            listBooks.setSelected(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(SearchBooksAndMembers.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No Match(es)", "Error", JOptionPane.ERROR_MESSAGE);
                        booksKeyTextField.setText(null);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please, complete the information", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        searchMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (isMembersDataCorrect()) {
                    member = new Members();
                    //FirstName, MiddleName, Surname, PostalAddress, PhoneNumber, AltPhoneNumber, EmailAddress, DateAdded, NumberOfBooks
                    String memberQuery = "SELECT *  FROM " + usersTable + " WHERE  " + membersData[0] + " LIKE  '" + membersData[1] + "'";
                    System.out.println(memberQuery);
                    member.connection(memberQuery);
                    String Username = null;
                    Username = member.getUsername();
                    if (!Username.equalsIgnoreCase(null)) {
                        listMembers = new ListSearchMembers(memberQuery);
                        getParent().add(listMembers);
                        try {
                            listMembers.setSelected(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(SearchBooksAndMembers.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No Match(es)", "Error", JOptionPane.ERROR_MESSAGE);
                        membersKeyTextField.setText(null);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please, complete the information", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        //for adding the action listener for the button to dispose the frame
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        //for setting the visible to true
        setVisible(true);
        //show the internal frame
        pack();
    }
}
