package form;

import controller.Communication;
import domain.Author;
import domain.Book;
import form.util.FormView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import components.BooksTableModel;

/**
 *
 * @author Ivana
 */
public class BookSearchForm extends javax.swing.JFrame {

    List<Book> books;
    List<Book> newBooks;
    int mode;

    /**
     *
     * @param mode
     */
    public BookSearchForm(int mode) {
        this.mode = mode;
        initComponents();
        prepareForm();
        try {
            prepareTable(Communication.getInstance().getAllBooks());
        } catch (Exception ex) {
            Logger.getLogger(BookSearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCriteria = new javax.swing.JLabel();
        txtCriteria = new javax.swing.JTextField();
        btnSearchTitle = new javax.swing.JButton();
        btnSearchAuthor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnChoice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraživanje knjige");

        lblCriteria.setText("Kriterijum:");

        btnSearchTitle.setText("Pretraži");
        btnSearchTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTitleActionPerformed(evt);
            }
        });

        btnSearchAuthor.setText("Pretraži");
        btnSearchAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAuthorActionPerformed(evt);
            }
        });

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Naziv", "Autor"
            }
        ));
        jScrollPane2.setViewportView(tblBooks);

        btnDetails.setText("Detalji");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnUpdate.setText("Ažuriraj");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSearch.setText("Pretraži");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnChoice.setText("Vrati se na izbor");
        btnChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearchTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchAuthor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblCriteria))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchAuthor)
                        .addComponent(btnDetails)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearchTitle)
                        .addComponent(btnChoice))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdate)
                        .addComponent(btnSearch)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTitleActionPerformed
        String title = txtCriteria.getText().toLowerCase().trim();

        newBooks = new ArrayList<>();

        try {
            books = Communication.getInstance().getAllBooks();
        } catch (Exception ex) {
            Logger.getLogger(BookSearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                newBooks.add(b);
            }
        }
        prepareTable(newBooks);
        if (newBooks.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe knjige po zadatoj vrednosti.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Sistem je nasao knjige po zadatoj vrednosti.", "", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSearchTitleActionPerformed

    private void btnSearchAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAuthorActionPerformed
        try {
            String author = txtCriteria.getText().toLowerCase().trim();

            newBooks = new ArrayList<>();

            books = Communication.getInstance().getAllBooks();

            List<Author> authors = Communication.getInstance().getAllAuthors();

            for (Author a : authors) {
                if ((a.getFirstname() + " " + a.getLastname()).matches(author) || a.getFirstname().matches(author) || a.getLastname().matches(author)) {
                    for (Book b : books) {
                        if (b.getAuthor().getAuthorId().equals(a.getAuthorId())) {
                            newBooks.add(b);
                        }
                    }
                }
            }

            prepareTable(newBooks);
            if (newBooks.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da nađe knjige po zadatoj vrednosti.", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Sistem je nasao knjige po zadatoj vrednosti.", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(BookSearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchAuthorActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        try {
            Book book = new Book();
            books = Communication.getInstance().getAllBooks();
            String naziv = (String) (tblBooks.getModel().getValueAt(tblBooks.getSelectedRow(), 0));
            for (Book b : books) {
                if (b.getTitle().equals(naziv)) {
                    book = b;
                    break;
                }
            }
            new BookDetailsForm(book).setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da učita izabranu knjigu.", "", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            books = Communication.getInstance().getAllBooks();
            prepareTable(books);
        } catch (Exception ex) {
            Logger.getLogger(BookSearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.dispose();
        new BookSearchOptionsForm().setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoiceActionPerformed
        this.dispose();
        new BookSearchOptionsForm().setVisible(true);
    }//GEN-LAST:event_btnChoiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoice;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchAuthor;
    private javax.swing.JButton btnSearchTitle;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCriteria;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTextField txtCriteria;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        switch (mode) {
            case FormView.FORM_TITLE_SEARCH -> {
                btnSearchAuthor.setEnabled(false);
                btnSearchAuthor.setVisible(false);
                btnSearch.setEnabled(false);
                btnSearch.setVisible(false);
                this.setTitle("Pretraživanje po naslovu");
            }
            case FormView.FORM_AUTHOR_SEARCH -> {
                btnSearchTitle.setEnabled(false);
                btnSearchTitle.setVisible(false);
                btnSearch.setEnabled(false);
                btnSearch.setVisible(false);
                this.setTitle("Pretraživanje po autoru");
            }
            default -> {
                btnSearchAuthor.setEnabled(false);
                btnSearchAuthor.setVisible(false);
                btnSearchTitle.setEnabled(false);
                btnSearchTitle.setVisible(false);
                lblCriteria.setVisible(false);
                txtCriteria.setEditable(false);
                txtCriteria.setVisible(false);
                this.setTitle("Prikaz knjiga");
                btnChoice.setEnabled(false);
                btnChoice.setVisible(false);
            }

        }
    }

    private void prepareTable(List<Book> books) {
        tblBooks.setModel(new BooksTableModel(books));
    }
}
