package form;

import components.AutoCompletion;
import controller.Communication;
import domain.Administrator;
import domain.Book;
import domain.Member;
import domain.Order;
import domain.OrderItem;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import components.BooksTableModel;

public class OrderForm extends javax.swing.JFrame {

    Administrator a;
    List<Member> members;
    List<Book> books;
    List<Book> chosenBooks = new ArrayList<>();
    Order order;

    public OrderForm(Order order,Administrator a) {
        this.order = order;
        this.a=a;
        initComponents();
        prepareForm();
        cmbListener();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbMember = new javax.swing.JComboBox();
        cmbBook = new javax.swing.JComboBox();
        btnNewOrder = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnViewOrders = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nalog");

        jLabel5.setText("Član:");

        jLabel6.setText("Datum izdavanja:");

        jLabel8.setText("Knjiga:");

        btnNewOrder.setText("Kreiraj nov nalog");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });

        btnSave.setText("Sačuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnViewOrders.setText("Prikaži naloge");
        btnViewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrdersActionPerformed(evt);
            }
        });

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBooks);

        jLabel1.setText("Izabrane knjige:");

        btnDelete.setText("Ukloni iz naloga");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbMember, 0, 296, Short.MAX_VALUE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbBook, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewOrder)
                    .addComponent(btnSave)
                    .addComponent(btnViewOrders))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        try {
            Order o = new Order();
            o.setAdministrator(a);
            o.setIssueDate(LocalDate.now());
            o.setValidUntil(LocalDate.now());
            Member m = new Member(0l);
            o.setStatus(false);
            o.setMember(m);
            o = Communication.getInstance().createOrder(o);
            new OrderForm(o,a).setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tblBooks.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(this, "Izaberite jedan red!", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Book book = new Book();
        String naziv = (String) tblBooks.getModel().getValueAt(tblBooks.getSelectedRow(), 0);
        for (Book b : chosenBooks) {
            if (b.getTitle().equals(naziv)) {
                book = b;
            }
        }
        chosenBooks.remove(book);
        prepareTable(chosenBooks);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (chosenBooks.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Izaberite knjige!");
                return;
            }
            int x = validateForm();
            if (x == 1) {
                return;
            }
            Date dateD = dateChooser.getDate();
            LocalDate issueDate = dateD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            order.setIssueDate(issueDate);
            LocalDate validUntil = issueDate.plusMonths(1);
            order.setValidUntil(validUntil);
            order.setAdministrator(a);
            order.setMember((Member) cmbMember.getSelectedItem());
            order = Communication.getInstance().saveOrder(order);
            
            for (Book b : chosenBooks) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setBook(b);
                orderItem.setVracena(false);
                orderItem = Communication.getInstance().createOrderItem(orderItem);
                Communication.getInstance().saveOrderItem(orderItem);
                b.setAvailable(false);
                Communication.getInstance().saveBook(b);
            }

            JOptionPane.showMessageDialog(this, "Sistem je zapamtio nalog");
            btnSave.setEnabled(false);
            btnNewOrder.setEnabled(true);
        } catch (Exception e) {
            try {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti nalog. " + e.getMessage());
                Communication.getInstance().deleteOrder(order);
            } catch (Exception ex) {
                Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnViewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrdersActionPerformed
        new OrderSearchForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewOrdersActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnViewOrders;
    private javax.swing.JComboBox cmbBook;
    private javax.swing.JComboBox cmbMember;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBooks;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        try {
            prepareTable(chosenBooks);
            btnNewOrder.setEnabled(false);
            members = Communication.getInstance().getAllMembers();
            books = Communication.getInstance().getAllBooks();
            List<Book> availableBooks = new ArrayList<>();
            for (Book b : books) {
                if (b.getAvailable() == true) {
                    availableBooks.add(b);
                }
            }

            for (Member m : members) {
                cmbMember.addItem(m);
            }
            for (Book b : availableBooks) {
                cmbBook.addItem(b);
            }

            cmbBook.setSelectedIndex(-1);
            cmbMember.setSelectedIndex(-1);
        } catch (Exception ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    closeWarning();
                } catch (Exception ex) {
                    Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        AutoCompletion.enable(cmbMember);
        AutoCompletion.enable(cmbBook);
    }

    private void prepareTable(List<Book> chosenBooks) {
        tblBooks.setModel(new BooksTableModel((chosenBooks)));
    }

    private void cmbListener() {
        cmbBook.addActionListener((e) -> {
            if(chosenBooks.contains(cmbBook.getSelectedItem())){
                JOptionPane.showMessageDialog(this, "Već ste uneli izabranu knjigu!", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            chosenBooks.add((Book) cmbBook.getSelectedItem());
            prepareTable(chosenBooks);
        });
    }

    private int validateForm() {
        if (cmbMember.getSelectedIndex() == -1 || dateChooser.getDate() == null  || cmbBook.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Morate da popunite sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        return 0;
    }

    public void closeWarning() throws Exception {
        if (cmbMember.getSelectedIndex() == -1 || dateChooser.getDate() == null || cmbBook.getSelectedIndex() == -1 || chosenBooks.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sistem nije zapamtio podatke o nalogu\nNapravilno uneti podaci.", "Upozorenje", JOptionPane.ERROR_MESSAGE);
            Communication.getInstance().deleteOrder(order);
        }
    }
}