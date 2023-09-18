package form;

import controller.Communication;
import domain.Member;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivana
 */
public class CreateMemberForm extends javax.swing.JFrame {

    Member member;

    /**
     *
     * @param member
     */
    public CreateMemberForm(Member member) {
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
        jLabel3 = new javax.swing.JLabel();
        txtIDCard = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCreateNew = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiraj člana");

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Broj lične karte:");

        btnSave.setText("Sačuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCreateNew.setText("Kreiraj novog člana");
        btnCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewActionPerformed(evt);
            }
        });

        btnView.setText("Prikaži sve članove");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstname)
                            .addComponent(txtLastname)
                            .addComponent(txtIDCard)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreateNew, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIDCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateNew)
                    .addComponent(btnSave)
                    .addComponent(btnView))
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (txtFirstname.getText().trim().isEmpty() || txtLastname.getText().trim().isEmpty() || txtIDCard.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.\nSva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (txtFirstname.getText().trim().matches("[a-zA-Z]+") && txtLastname.getText().trim().matches("[a-zA-Z]+")) {
                
            } else {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.\nPolja za ime i prezime smeju da sadrže smo slova!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!(txtIDCard.getText().matches("[0-9]+"))) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.\nPolje za broj lične karte sme da sadrži samo brojeve!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!(txtIDCard.getText().length() == 9)) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.\nPolje za broj lične karte mora da sadrži 9 cifara!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Member> ms=Communication.getInstance().getAllMembers();
            for(Member m:ms){
                if(m.getIdCardNumber().equals(Long.valueOf(txtIDCard.getText().trim()))){
                    JOptionPane.showMessageDialog(this, "Uneti JMBG Već postoji u sistemu.", "", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            member.setFirstname(txtFirstname.getText().toLowerCase().trim());
            member.setLastname(txtLastname.getText().trim().toLowerCase());
            Long id = Long.valueOf(txtIDCard.getText().trim());
            member.setIdCardNumber(id);
            
            if (txtIDCard.getText().trim().length() != 9) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.\nNevalidan broj lične karte!", "Greska!", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Member x = Communication.getInstance().saveMember(member);
                    if (x == null) {
                        JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana.", "", JOptionPane.ERROR_MESSAGE);
                    } else {
                        ImageIcon imageIcon = new ImageIcon("greentick.jpg");
                        JOptionPane.showMessageDialog(null, "Sistem je uneo clana.", "", JOptionPane.PLAIN_MESSAGE, imageIcon);
                        btnCreateNew.setEnabled(true);
                        btnView.setEnabled(true);
                        btnCreateNew.setVisible(true);
                        btnView.setVisible(true);
                        btnSave.setEnabled(false);
                        txtFirstname.setEditable(false);
                        txtLastname.setEditable(false);
                        txtIDCard.setEditable(false);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CreateMemberForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CreateMemberForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        this.dispose();
        new MemberSearchForm().setVisible(true);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewActionPerformed
        try {
            Member m = new Member();
            m.setFirstname("def");
            m.setLastname("def");
            m.setIdCardNumber(0l);
            m = Communication.getInstance().createMember(m);
            int x = JOptionPane.showConfirmDialog(this, "Sistem je kreirao novog člana", "", JOptionPane.OK_CANCEL_OPTION);
            if (x == 0) {
                this.dispose();
                new CreateMemberForm(m).setVisible(true);
            } else {
                Communication.getInstance().deleteMember(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(CreateMemberForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtIDCard;
    private javax.swing.JTextField txtLastname;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        this.getRootPane().setDefaultButton(btnSave);
        btnCreateNew.setEnabled(false);
        btnView.setEnabled(false);
        btnCreateNew.setVisible(false);
        btnView.setVisible(false);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    if (member.getFirstname().equals("def") || member.getLastname().equals("def")
                            || member.getFirstname().equals("") || member.getLastname().equals("")
                            || member.getIdCardNumber() == null) {
                        Communication.getInstance().deleteMember(member);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CreateBookForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
