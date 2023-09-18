package form;

import components.AutoCompletion;
import controller.Communication;
import domain.Member;
import domain.Order;
import domain.OrderItem;
import domain.ReadBook;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OrderDetailsForm extends javax.swing.JFrame {

    Order order;
    List<Member> members;
    List<OrderItem> orderItems;
    List<OrderItem> selectedOrderItems;

    public OrderDetailsForm(Order order) {
        this.order = order;
        initComponents();
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupStatus = new javax.swing.ButtonGroup();
        btnGroupReturned = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        cmbMember = new javax.swing.JComboBox();
        rbtnOpen = new javax.swing.JRadioButton();
        rbtnClosed = new javax.swing.JRadioButton();
        cmbOrderItems = new javax.swing.JComboBox();
        rbtnYes = new javax.swing.JRadioButton();
        rbtnNo = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalji o nalogu");
        setPreferredSize(new java.awt.Dimension(450, 350));

        jLabel1.setText("Datum izdavanja:");

        jLabel2.setText("Vratiti do:");

        jLabel4.setText("Član:");

        jLabel5.setText("Status:");

        jLabel6.setText("Stavka: ");

        jLabel7.setText("Vraćena:");

        btnGroupStatus.add(rbtnOpen);
        rbtnOpen.setText("Otvoren");

        btnGroupStatus.add(rbtnClosed);
        rbtnClosed.setText("Zatvoren");

        btnGroupReturned.add(rbtnYes);
        rbtnYes.setText("Da");
        rbtnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnYesActionPerformed(evt);
            }
        });

        btnGroupReturned.add(rbtnNo);
        rbtnNo.setText("Ne");
        rbtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoActionPerformed(evt);
            }
        });

        btnSave.setText("Sačuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMember, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtnClosed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbOrderItems, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rbtnOpen)
                    .addComponent(rbtnClosed))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbOrderItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbtnYes)
                    .addComponent(rbtnNo))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            LocalDate lclDate1 = date1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate lclDate2 = date2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            order.setIssueDate(lclDate1);
            order.setValidUntil(lclDate2);
            order.setMember((Member) cmbMember.getSelectedItem());
            order.setStatus(rbtnClosed.isSelected());
            for(int i=0;i<cmbOrderItems.getItemCount();i++){
                OrderItem oi = (OrderItem) cmbOrderItems.getItemAt(i);
                if(oi.isVracena()==false){
                    if(order.isStatus()==true){
                        JOptionPane.showMessageDialog(this, "Ne možete da zatvorite nalog jer nisu sve knjige vraćene!", "", JOptionPane.INFORMATION_MESSAGE);
                        order.setStatus(false);
                        return;
                    }
                }
            }
            boolean flag=true;
            for(int i=0;i<cmbOrderItems.getItemCount();i++){
                OrderItem oi = (OrderItem) cmbOrderItems.getItemAt(i);
                if(oi.isVracena()==false){
                    flag=false;
                }
            }
            if(flag==true && !order.isStatus()){
                int x=JOptionPane.showConfirmDialog(this, "Sve knjige su vraćene.\nDa li želite da zatvorite nalog?", "", JOptionPane.YES_NO_OPTION);
                    if(x==0){
                        order.setStatus(true);
                    }
            }
            Communication.getInstance().saveOrder(order);
            if (rbtnClosed.isSelected()) {
                for (OrderItem oi : selectedOrderItems) {
                    oi.setVracena(true);
                    Communication.getInstance().saveOrderItem(oi);
                    ReadBook rb = new ReadBook(order.getMember(), oi.getBook());
                    Communication.getInstance().createReadBook(rb);
                }
            }
            for(int i=0;i<cmbOrderItems.getItemCount();i++){
                OrderItem oi = (OrderItem) cmbOrderItems.getItemAt(i);
                if(oi.isVracena()){
                    oi.getBook().setAvailable(true);
                    Communication.getInstance().saveBook(oi.getBook());
                }
                Communication.getInstance().saveOrderItem(oi);
            }
            if(order.isStatus()){
                for (OrderItem oi : selectedOrderItems) {
                    ReadBook rb = new ReadBook(order.getMember(), oi.getBook());
                    Communication.getInstance().createReadBook(rb);
                }
            }
            
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio podatke o nalogu. ");
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void rbtnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnYesActionPerformed
        if (rbtnYes.isSelected()) {
            try {
                OrderItem orderItem = (OrderItem) cmbOrderItems.getSelectedItem();
                orderItem.setVracena(true);
            } catch (Exception ex) {
                Logger.getLogger(OrderDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rbtnYesActionPerformed

    private void rbtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoActionPerformed
        if (rbtnNo.isSelected()) {
            try {
                OrderItem orderItem = (OrderItem) cmbOrderItems.getSelectedItem();
                orderItem.setVracena(false);
            } catch (Exception ex) {
                Logger.getLogger(OrderDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rbtnNoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupReturned;
    private javax.swing.ButtonGroup btnGroupStatus;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbMember;
    private javax.swing.JComboBox cmbOrderItems;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton rbtnClosed;
    private javax.swing.JRadioButton rbtnNo;
    private javax.swing.JRadioButton rbtnOpen;
    private javax.swing.JRadioButton rbtnYes;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        try {
            JOptionPane.showMessageDialog(this, "Sistem je učitao nalog.");
            cmbListener();
            date1.setDate(Date.from(order.getIssueDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            date2.setDate(Date.from(order.getValidUntil().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            members = Communication.getInstance().getAllMembers();
            for (Member m : members) {
                cmbMember.addItem(m);
            }
            Member member = order.getMember();

            cmbMember.setSelectedItem(member);

            rbtnClosed.setSelected(false);
            rbtnOpen.setSelected(false);

            rbtnClosed.setSelected(order.isStatus());
            rbtnOpen.setSelected(!order.isStatus());

            orderItems = Communication.getInstance().getAllOrderItems();
            selectedOrderItems = new ArrayList<>();
            for (OrderItem oi : orderItems) {
                if (oi.getOrder().getOrderId().equals(order.getOrderId())) {
                    selectedOrderItems.add(oi);
                }
            }
            for (OrderItem oi : selectedOrderItems) {
                cmbOrderItems.addItem(oi);
            }
            cmbOrderItems.setSelectedIndex(-1);
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        AutoCompletion.enable(cmbMember);
    }

    private void cmbListener() {
        cmbOrderItems.addActionListener((e) -> {
            OrderItem orderItem = (OrderItem) cmbOrderItems.getSelectedItem();
            if(orderItem!=null){
                rbtnYes.setSelected(orderItem.isVracena());
                rbtnNo.setSelected(!orderItem.isVracena());
            }
        });
    }
}
