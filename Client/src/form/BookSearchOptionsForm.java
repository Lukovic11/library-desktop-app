package form;

import form.util.FormView;

/**
 *
 * @author Ivana
 */
public class BookSearchOptionsForm extends javax.swing.JFrame {

    /**
     *
     */
    public BookSearchOptionsForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTitle = new javax.swing.JButton();
        btnAuthor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraživanje knjige");

        btnTitle.setText("Pretraživanje po naslovu");
        btnTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTitleActionPerformed(evt);
            }
        });

        btnAuthor.setText("Pretraživanje po autoru  ");
        btnAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthorActionPerformed
        new BookSearchForm(FormView.FORM_AUTHOR_SEARCH).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAuthorActionPerformed

    private void btnTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitleActionPerformed
        new BookSearchForm(FormView.FORM_TITLE_SEARCH).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTitleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuthor;
    private javax.swing.JButton btnTitle;
    // End of variables declaration//GEN-END:variables
}
