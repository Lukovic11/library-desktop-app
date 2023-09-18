package form;

import controller.Communication;
import domain.Author;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.RegularValidator;

public class CreateAuthorForm extends javax.swing.JFrame {

    Author author;
    Author x;
    List<Author> authors = new ArrayList<>();
    IValidator validator = new RegularValidator();

    public CreateAuthorForm(Author author) {
        initComponents();
        this.author = author;
        prepareForm();
        cmbListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbAuthor = new javax.swing.JComboBox();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnEditAuthor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiraj / Izmeni autora");
        setResizable(false);

        jLabel1.setText("Autor:");

        jLabel2.setText("Ime:");

        jLabel3.setText("Prezime:");

        btnSave.setText("Sačuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEditAuthor.setText("Izmeni");
        btnEditAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbAuthor, 0, 200, Short.MAX_VALUE)
                            .addComponent(txtFirstname)
                            .addComponent(txtLastname))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnEditAuthor))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        try {

            String firstname = txtFirstname.getText().trim();
            String lastname = txtLastname.getText().trim();

            try {
                validator.validateAuthor(firstname, lastname);
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            for(Author a:authors){
                if(a.getFirstname().matches(firstname)&&a.getLastname().matches(lastname)){
                    JOptionPane.showMessageDialog(this, "Autor već postoji u bazi.", "", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            Author a = (Author) cmbAuthor.getSelectedItem();

            if (a == null) {
                author.setFirstname(firstname);
                author.setLastname(lastname);
                System.out.println(author);
                x = Communication.getInstance().saveAuthor(author);
            } else {
                a.setFirstname(firstname);
                a.setLastname(lastname);
                System.out.println(a);
                x = Communication.getInstance().saveAuthor(a);
            }

            if (x == null) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti autora.", "", JOptionPane.ERROR_MESSAGE);
            } else {
                ImageIcon imageIcon = new ImageIcon("greentick.jpg");
                JOptionPane.showMessageDialog(null, "Sistem je zapamtio autora.", "", JOptionPane.PLAIN_MESSAGE, imageIcon);
                btnEditAuthor.setVisible(true);
                btnEditAuthor.setEnabled(true);
                fillCmbAuthor(x);
                cmbAuthor.setSelectedItem(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CreateAuthorForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAuthorActionPerformed
        cmbAuthor.setEnabled(true);
        cmbAuthor.setSelectedItem(x);
    }//GEN-LAST:event_btnEditAuthorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditAuthor;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbAuthor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtLastname;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        btnEditAuthor.setEnabled(false);
        btnEditAuthor.setVisible(false);
        fillCmbAuthor(author);
        cmbAuthor.setEnabled(false);
        this.setLocationRelativeTo(null);
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    closeWarning();
                } catch (Exception ex) {
                    Logger.getLogger(CreateBookForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void closeWarning() throws Exception {
        if (cmbAuthor.getSelectedIndex()==-1) {
            JOptionPane.showMessageDialog(this, "Niste sačuvali autora.\n", "", JOptionPane.INFORMATION_MESSAGE);
            Communication.getInstance().deleteAuthor(author);
        }
    }
    
    

    private void fillCmbAuthor(Author author) {
        try {
            authors = Communication.getInstance().getAllAuthors();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for (Author a : authors) {
            cmbAuthor.addItem(a);
        }
        cmbAuthor.setSelectedIndex(-1);
    }

    private void cmbListener() {
        cmbAuthor.addActionListener((e) -> {
            Author a = (Author) cmbAuthor.getSelectedItem();
            if (a != null) {
                txtFirstname.setText(a.getFirstname());
                txtLastname.setText(a.getLastname());
            }
        });
    }
    

}
