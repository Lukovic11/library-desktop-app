package form;

import controller.Communication;
import domain.Administrator;
import domain.Author;
import domain.Book;
import domain.Member;
import domain.Order;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuForm extends javax.swing.JFrame {

    Administrator a;
    
    public MenuForm(Administrator a) {
        this.a=a;
        initComponents();
        prepareForm();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        lblSlika = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuBarBook = new javax.swing.JMenu();
        createBook = new javax.swing.JMenuItem();
        searchBook = new javax.swing.JMenuItem();
        MenuBarMember = new javax.swing.JMenu();
        createMember = new javax.swing.JMenuItem();
        searchMember = new javax.swing.JMenuItem();
        MenuBarOrder = new javax.swing.JMenu();
        createOrder = new javax.swing.JMenuItem();
        searchOrder = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dobrodošli!");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 500, 350));
        setForeground(java.awt.Color.white);
        setSize(new java.awt.Dimension(500, 600));

        lblSlika.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSlika.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ivana\\Downloads\\output-onlinepngtools.png")); // NOI18N
        lblSlika.setToolTipText("");

        MenuBarBook.setText("Knjiga");

        createBook.setText("Kreiraj knjigu");
        createBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBookActionPerformed(evt);
            }
        });
        MenuBarBook.add(createBook);

        searchBook.setText("Pretraži knjigu");
        searchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookActionPerformed(evt);
            }
        });
        MenuBarBook.add(searchBook);

        MenuBar.add(MenuBarBook);

        MenuBarMember.setText("Član");

        createMember.setText("Kreiraj člana");
        createMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMemberActionPerformed(evt);
            }
        });
        MenuBarMember.add(createMember);

        searchMember.setText("Pretraži člana");
        searchMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMemberActionPerformed(evt);
            }
        });
        MenuBarMember.add(searchMember);

        MenuBar.add(MenuBarMember);

        MenuBarOrder.setText("Nalog");

        createOrder.setText("Kreiraj nalog");
        createOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createOrderActionPerformed(evt);
            }
        });
        MenuBarOrder.add(createOrder);

        searchOrder.setText("Pretraži nalog");
        searchOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOrderActionPerformed(evt);
            }
        });
        MenuBarOrder.add(searchOrder);

        MenuBar.add(MenuBarOrder);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(lblSlika, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblSlika, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBookActionPerformed
        try {
            Book b = new Book();
            b.setTitle("def");
            Author author = new Author(0l);
            b.setAuthor(author);
            b.setAvailable(false);
            b = Communication.getInstance().createBook(b);
            int x = JOptionPane.showConfirmDialog(this, "Sistem je kreirao novu knjigu", "", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if (x == 0) {
                new CreateBookForm(b).setVisible(true);
            } else {
                Communication.getInstance().deleteBook(b);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da kreira novu knjigu.", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createBookActionPerformed

    private void createMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMemberActionPerformed
        try {
            Member m = new Member();
            m.setFirstname("def");
            m.setLastname("def");
            m.setIdCardNumber(0l);
            m = Communication.getInstance().createMember(m);
            int x = JOptionPane.showConfirmDialog(this, "Sistem je kreirao novog člana", "", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if (x == 0) {
                new CreateMemberForm(m).setVisible(true);
            } else {
                Communication.getInstance().deleteMember(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da kreira novog člana.", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createMemberActionPerformed

    private void searchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookActionPerformed
        new BookSearchOptionsForm().setVisible(true);
    }//GEN-LAST:event_searchBookActionPerformed

    private void searchMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMemberActionPerformed
        new MemberSearchForm().setVisible(true);
    }//GEN-LAST:event_searchMemberActionPerformed

    private void createOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createOrderActionPerformed
        try {
            Order o = new Order();
            o.setAdministrator(a);
            o.setIssueDate(LocalDate.now(ZoneId.systemDefault()));
            o.setValidUntil(LocalDate.now(ZoneId.systemDefault()));
            Member m = new Member(0l);
            o.setStatus(false);
            o.setMember(m);
            o = Communication.getInstance().createOrder(o);
            int x = JOptionPane.showConfirmDialog(this, "Sistem je kreirao nov nalog", "", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if (x == 0) {
                new OrderForm(o,a).setVisible(true);
            } else {
                Communication.getInstance().deleteOrder(o);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da kreira nov nalog.", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createOrderActionPerformed

    private void searchOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchOrderActionPerformed
        new OrderSearchForm().setVisible(true);
    }//GEN-LAST:event_searchOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuBarBook;
    private javax.swing.JMenu MenuBarMember;
    private javax.swing.JMenu MenuBarOrder;
    private javax.swing.JMenuItem createBook;
    private javax.swing.JMenuItem createMember;
    private javax.swing.JMenuItem createOrder;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblSlika;
    private javax.swing.JMenuItem searchBook;
    private javax.swing.JMenuItem searchMember;
    private javax.swing.JMenuItem searchOrder;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
    }

}
