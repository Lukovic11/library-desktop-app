package form;

import components.ReadBooksTableModel;
import controller.Communication;
import domain.Book;
import domain.Member;
import domain.ReadBook;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadBooksForm extends javax.swing.JFrame {

    List<ReadBook> readBooks;
    Member member;
    
    public ReadBooksForm(Member member) {
        initComponents();
        this.member=member;
        prepareTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBooks;
    // End of variables declaration//GEN-END:variables

    private void prepareTable() {
        try {
            readBooks = Communication.getInstance().getReadBooks(member);
            List<Book> books=Communication.getInstance().getAllBooks();
            for(ReadBook rb:readBooks){
                for(Book b:books){
                    if(rb.getBook().getId().equals(b.getId())){
                        rb.setBook(b);
                    }
                }
            }
            tblBooks.setModel(new ReadBooksTableModel(readBooks));
        } catch (Exception ex) {
            Logger.getLogger(ReadBooksForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
