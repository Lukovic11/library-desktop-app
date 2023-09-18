package form;

import components.AutoCompletion;
import controller.Communication;
import domain.Author;
import domain.Book;
import form.util.FormView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivana
 */
public class CreateBookForm extends javax.swing.JFrame {

    Book book;
    Book b;
    Author a;

    /**
     *
     * @param book
     */
    public CreateBookForm(Book book) {
        this.book = book;
        initComponents();
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        cmbAuthor = new javax.swing.JComboBox();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnNewBook = new javax.swing.JButton();
        btnViewBooks = new javax.swing.JButton();
        btnNewAuthor = new javax.swing.JButton();
        btnUpdateAuthors = new javax.swing.JButton();
        btnAvailable = new javax.swing.JCheckBox();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiraj knjigu");

        jLabel1.setText("Naziv knjige:");

        jLabel2.setText("Autor:");

        btnSave.setText("Sačuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Dostupnost:");

        btnNewBook.setText("Kreiraj novu knjigu");
        btnNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookActionPerformed(evt);
            }
        });

        btnViewBooks.setText("Prikazi sve knjige");
        btnViewBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBooksActionPerformed(evt);
            }
        });

        btnNewAuthor.setText("Kreiraj");
        btnNewAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAuthorActionPerformed(evt);
            }
        });

        btnUpdateAuthors.setText("Ažuriraj");
        btnUpdateAuthors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAuthorsActionPerformed(evt);
            }
        });

        btnAvailable.setSelected(true);
        btnAvailable.setText("Dostupna");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(btnUpdateAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewBook, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewAuthor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateAuthors)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnAvailable))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnNewBook)
                    .addComponent(btnViewBooks))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            book.setTitle(txtTitle.getText().trim());
            book.setAuthor((Author) cmbAuthor.getSelectedItem());
            book.setAvailable(btnAvailable.isSelected());

            if (txtTitle.getText().trim().isEmpty() || cmbAuthor.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti knjigu.\\nSva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book x = Communication.getInstance().saveBook(book);

            if (x == null) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti knjigu.", "", JOptionPane.ERROR_MESSAGE);
            } else {
                ImageIcon imageIcon = new ImageIcon("greentick.jpg");
                JOptionPane.showMessageDialog(null, "Sistem je zapamtio knjigu.", "", JOptionPane.INFORMATION_MESSAGE, imageIcon);
            }

            txtTitle.setEditable(false);
            cmbAuthor.setEnabled(false);
            btnAvailable.setEnabled(false);
            btnSave.setEnabled(false);

            btnNewBook.setEnabled(true);
            btnNewBook.setVisible(true);
            btnViewBooks.setEnabled(true);
            btnViewBooks.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(CreateBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookActionPerformed
        try {
            this.dispose();
            b = new Book();
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
        } catch (Exception ex) {
            Logger.getLogger(CreateBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewBookActionPerformed

    private void btnViewBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBooksActionPerformed
        new BookSearchForm(FormView.FORM_VIEW).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewBooksActionPerformed

    private void btnNewAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAuthorActionPerformed
        try {
            a=new Author();
            a.setFirstname("def");
            a.setLastname("def");
            a=Communication.getInstance().createAuthor(a);
            if(a==null){
                JOptionPane.showMessageDialog(this, "Sistem ne može da kreira autora.", "Greska.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int x=JOptionPane.showConfirmDialog(this, "Sistem je kreirao novog autora.", "Nov autor.", JOptionPane.OK_CANCEL_OPTION);
            if(x==0){
                new CreateAuthorForm(a).setVisible(true);
            }else{
                Communication.getInstance().deleteAuthor(a);
            }
        } catch (Exception ex) {
            Logger.getLogger(CreateBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewAuthorActionPerformed

    private void btnUpdateAuthorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAuthorsActionPerformed
        try {
            fillCmbAuthors();
        } catch (Exception ex) {
            Logger.getLogger(CreateBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateAuthorsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btnAvailable;
    private javax.swing.JButton btnNewAuthor;
    private javax.swing.JButton btnNewBook;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdateAuthors;
    private javax.swing.JButton btnViewBooks;
    private javax.swing.JComboBox cmbAuthor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        try {
            fillCmbAuthors();
            btnAvailable.setSelected(true);
            btnNewBook.setEnabled(false);
            btnNewBook.setVisible(false);
            btnViewBooks.setEnabled(false);
            btnViewBooks.setVisible(false);

            this.getRootPane().setDefaultButton(btnSave);
        } catch (Exception ex) {
            Logger.getLogger(CreateBookForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    if (book.getTitle().equals("def") || book.getTitle().equals("")
                            || cmbAuthor.getSelectedIndex() == -1) {
                        Communication.getInstance().deleteBook(book);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CreateBookForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        AutoCompletion.enable(cmbAuthor);
    }

    private void fillCmbAuthors() throws Exception {
        List<Author> authors = Communication.getInstance().getAllAuthors();

            for (Author au : authors) {
                cmbAuthor.addItem(au);
            }
            cmbAuthor.setSelectedIndex(-1);
    }
    
    

}
