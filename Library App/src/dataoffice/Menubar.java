package dataoffice;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menubar extends JMenuBar {

    //declaration of the private variables used in the program 
    //for creating the JMenu for the program
    private JMenu fileMenu, bookMenu, memberMenu, searchMenu, loanMenu, space;
    //for creating the JMenuItem for JMenu
    final JMenuItem exit, addBook, listBook, addMember, listMember, deleteMember,
            searchBooksAndMembers, borrowBook, returnBook;
    //for creating an imageIcon
    private final ImageIcon[] icons;
    //for creating the name of the image file 16*16
    private final String[] imageName16 = {"images/Print16.gif", "images/Exit16.gif",
        "images/Add16.gif", "images/List16.gif",
        "images/Edit16.gif", "images/Delete16.gif",
        "images/Information16.gif", "images/Find16.gif",
        "images/Export16.gif", "images/Import16.gif",};

    public Menubar() {
        //for adding book, member, search, loan & help Menus to the menu bar
        this.add(fileMenu = new JMenu("File"));
        this.add(space = new JMenu("                "));

        this.add(bookMenu = new JMenu("B o o k s"));
        this.add(space = new JMenu("                                                  "));

        this.add(memberMenu = new JMenu("M e m b e r s"));
        this.add(space = new JMenu("                            "));

        this.add(searchMenu = new JMenu("S e a r c h"));
        this.add(space = new JMenu("                                       "));

        this.add(loanMenu = new JMenu("L o a n"));
        /**
         * for setting the Mnemonic
         */
        fileMenu.setMnemonic('f');
        bookMenu.setMnemonic('b');
        memberMenu.setMnemonic('m');
        searchMenu.setMnemonic('s');
        loanMenu.setMnemonic('l');

        //for setting the image icons
        icons = new ImageIcon[12];
        for (int i = 0; i < imageName16.length; i++) {
            icons[i] = new ImageIcon(ClassLoader.getSystemResource(imageName16[i]));
        }
        fileMenu.add(exit = new JMenuItem("Exit", icons[1]));

        //for adding add, list, listAvailble, listBorrowed, edit & remove Books and book information to the bookMenu
        bookMenu.add(addBook = new JMenuItem("Add Book", icons[2]));
        bookMenu.add(listBook = new JMenuItem("List All Books", icons[3]));

        //for adding add, list, edit & remove Members and member information to the memberMenu
        memberMenu.add(addMember = new JMenuItem("Add Member", icons[2]));
        memberMenu.add(listMember = new JMenuItem("List All Members", icons[3]));
        memberMenu.add(deleteMember = new JMenuItem("Delete Member", icons[5]));

        //for adding add, list & remove Members to the memberMenu
        searchMenu.add(searchBooksAndMembers = new JMenuItem("Search", icons[7]));

        //for adding borrow & return books to the loanMenu
        loanMenu.add(borrowBook = new JMenuItem("Borrow a Book", icons[8]));
        loanMenu.add(returnBook = new JMenuItem("Return a Book", icons[9]));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        searchBooksAndMembers.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        addBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        listBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        addMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        listMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        deleteMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

        borrowBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        returnBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
    }
}
