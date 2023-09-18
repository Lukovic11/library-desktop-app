package form;

import components.AutoCompletion;
import controller.Communication;
import domain.Author;
import domain.Book;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivana
 */
public class BookDetailsForm extends javax.swing.JFrame {

    Book book;

    /**
     *
     * @param book
     */
    public BookDetailsForm(Book book) {
        this.book = book;
        initComponents();
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBook = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rbtnAvailable = new javax.swing.JRadioButton();
        cmbAuthors = new javax.swing.JComboBox();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalji");

        jLabel1.setText("Naziv knjige:");

        jLabel2.setText("Autor:");

        btnEdit.setText("Omogući izmenu");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Zapamti");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Dostupnost:");

        rbtnAvailable.setText("Dostupna");

        btnDelete.setText("Obriši");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBook))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbtnAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbAuthors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbtnAvailable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        txtBook.setEditable(true);
        cmbAuthors.setEnabled(true);
        rbtnAvailable.setEnabled(true);
        btnSave.setEnabled(true);
        btnSave.setVisible(true);
        btnEdit.setEnabled(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            book.setTitle(txtBook.getText().trim());
            book.setAuthor((Author) cmbAuthors.getSelectedItem());
            book.setAvailable(rbtnAvailable.isSelected());

            Communication.getInstance().saveBook(book);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio knjigu", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
            btnSave.setEnabled(false);
            btnEdit.setEnabled(true);
            txtBook.setEditable(false);
            cmbAuthors.setEnabled(false);
            rbtnAvailable.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(BookDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (book.getAvailable() == false) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da obriše knjigu.\nRazlog: knjiga je iznajmljena.", "", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int x = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete knjigu?", "", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            try {
                Communication.getInstance().deleteBook(book);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao podatke o knjizi.", "", JOptionPane.INFORMATION_MESSAGE);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(false);
                btnDelete.setEnabled(false);
            } catch (Exception ex) {
                Logger.getLogger(BookDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbAuthors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton rbtnAvailable;
    private javax.swing.JTextField txtBook;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        JOptionPane.showMessageDialog(this, "Sistem je učitao knjigu.", "", JOptionPane.INFORMATION_MESSAGE);
        txtBook.setText(book.getTitle());
        txtBook.setEditable(false);
        btnSave.setEnabled(false);
        btnSave.setVisible(false);
        rbtnAvailable.setSelected(book.getAvailable());
        rbtnAvailable.setEnabled(false);

        List<Author> authors;
        try {
            authors = Communication.getInstance().getAllAuthors();

            for (Author a : authors) {
                cmbAuthors.addItem(a);
            }

            cmbAuthors.setSelectedItem(book.getAuthor());
            cmbAuthors.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(BookDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        AutoCompletion.enable(cmbAuthors);
    }
}
