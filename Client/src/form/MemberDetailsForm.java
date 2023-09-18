package form;

import controller.Communication;
import domain.Member;
import domain.Order;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivana
 */
public class MemberDetailsForm extends javax.swing.JFrame {

    Member member;

    /**
     *
     * @param member
     */
    public MemberDetailsForm(Member member) {
        this.member = member;
        initComponents();
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        txtIdCardNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalji");

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Broj lične karte:");

        btnDelete.setText("Obriši");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Omogući izmenu");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUpdate.setText("Zapamti");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtIdCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnUpdate))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        txtFirstname.setEditable(true);
        txtLastname.setEditable(true);
        txtIdCardNumber.setEditable(true);
        btnUpdate.setEnabled(true);
        btnUpdate.setVisible(true);
        btnEdit.setEnabled(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            List<Order> orders = Communication.getInstance().getAllOrders();
            for(Order o:orders){
                if(o.getMember().getId().equals(member.getId())){
                    JOptionPane.showMessageDialog(this, "Sistem ne može da obriše člana.\nRazlog: Otvoreni nalozi", "", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            int x = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete podatke o članu?", "", JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                try {
                    Communication.getInstance().deleteMember(member);
                    JOptionPane.showMessageDialog(this, "Sistem je obrisao podatke o članu.", "", JOptionPane.INFORMATION_MESSAGE);
                    btnEdit.setEnabled(false);
                    btnUpdate.setEnabled(false);
                    btnDelete.setEnabled(false);
                } catch (Exception ex) {
                    Logger.getLogger(MemberDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MemberDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (txtFirstname.getText().trim().isEmpty() || txtLastname.getText().trim().isEmpty() || txtIdCardNumber.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.\nSva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtFirstname.getText().trim().matches("[a-zA-Z]+") && txtLastname.getText().trim().matches("[a-zA-Z]+")) {

        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.\nPolja za ime i prezime smeju da sadrže smo slova!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        member.setFirstname(txtFirstname.getText().toLowerCase().trim());
        member.setLastname(txtLastname.getText().trim().toLowerCase());
        Long id = Long.valueOf(txtIdCardNumber.getText().trim());
        member.setIdCardNumber(id);

        if (txtIdCardNumber.getText().trim().length() != 9) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.\nNevalidan broj lične karte!", "Greska!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Member x = Communication.getInstance().saveMember(member);
                if (x == null) {
                    JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti podatke o članu.", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    ImageIcon imageIcon = new ImageIcon("greentick.jpg");
                    JOptionPane.showMessageDialog(null, "Sistem je zapamtio podatke o članu.", "", JOptionPane.PLAIN_MESSAGE, imageIcon);

                }
            } catch (Exception ex) {
                Logger.getLogger(MemberDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        btnUpdate.setEnabled(false);
        btnEdit.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtIdCardNumber;
    private javax.swing.JTextField txtLastname;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        JOptionPane.showMessageDialog(this, "Sistem je učitao člana.");
        txtFirstname.setText(member.getFirstname());
        txtLastname.setText(member.getLastname());
        txtIdCardNumber.setText(member.getIdCardNumber().toString());
        txtFirstname.setEditable(false);
        txtLastname.setEditable(false);
        txtIdCardNumber.setEditable(false);
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);

    }
}
