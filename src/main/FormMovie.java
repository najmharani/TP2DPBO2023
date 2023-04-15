/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import login.User;

/**
 *
 * @author nazuh
 */
public class FormMovie extends javax.swing.JFrame {
    
    dbConnection db;
    boolean isUpdate;
    ArrayList<Director> listDirector;
    Movie movie;
    String filename;
    User user;
    
    /**
     * Creates new form FormMovie
     */
    public FormMovie() {
        initComponents();
        db = new dbConnection();
        isUpdate = false;
        listDirector = new ArrayList<Director>();
        
        fieldJudul.setText("");
        fieldTahun.setText("");
        
        setDropdown();
    }
    
    public FormMovie(User user) {
        initComponents();
        db = new dbConnection();
        isUpdate = false;
        listDirector = new ArrayList<Director>();
        this.user = user;
        
        fieldJudul.setText("");
        fieldTahun.setText("");
        
        setDropdown();
    }
    
    public FormMovie(User user, Movie movie) {
        initComponents();
        db = new dbConnection();
        isUpdate = true;
        listDirector = new ArrayList<Director>();
        this.movie = movie;
        this.user = user;
        
        fieldJudul.setText(movie.getTitle());
        fieldTahun.setText(movie.getYear());
        
        setDropdown();
        
        dropdown.setSelectedItem(movie.getDirector_name());
        
        try{
            File file_awal = new File(movie.getPoster());
            ImageIcon icon = new ImageIcon(file_awal.toString());
            Image img = icon.getImage().getScaledInstance(lblPoster.getWidth(),lblPoster.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon poster = new ImageIcon(img);
            lblPoster.setIcon(poster);
            this.filename = file_awal.getAbsolutePath();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void setDropdown(){
        ResultSet res = db.selectQuery("SELECT * FROM director");
        
        try{
            while(res.next()){
                listDirector.add(new Director(res.getInt("id_director"), res.getString("name"), res.getString("nationality")));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        for(Director dir : listDirector){
            dropdown.addItem(dir.getName());
        }
    }
    
    public void insertData() throws IOException{
        String title = fieldJudul.getText();
        String year = fieldTahun.getText();
        String dir_name = (String) dropdown.getSelectedItem();
        int id_director = -1;
                
        for(Director dir : listDirector){
            if(dir_name.equals(dir.getName())){
                id_director = dir.getId_director();
            }
        }
        
        if(title.isEmpty() || year.isEmpty()){
            JOptionPane.showMessageDialog(null, "Data judul dan tahun belum lengkap!");
        }else{
            String newpath = "src/images";
            File fileawal = null;
            File fileakhir = null;
            String ext = this.filename.substring(filename.lastIndexOf('.')+1);
            fileawal = new File(filename);
            fileakhir = new File(newpath +"/"+ title + "." + ext);
            System.out.println(fileakhir);
            String poster = newpath +"/"+ title + "." + ext;
            System.out.println(poster);
            String sql = "INSERT INTO movie VALUES(NULL,'"+title+"', '"+year+"', '"+id_director+"','"+poster+"')";
            db.updateQuery(sql);
            Files.copy(fileawal.toPath(), fileakhir.toPath());
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
        }
    }
    
    public void updateData() throws IOException{
        String title = fieldJudul.getText();
        String year = fieldTahun.getText();
        String dir_name = (String) dropdown.getSelectedItem();
        int id_director = -1;
                
        for(Director dir : listDirector){
            if(dir_name.equals(dir.getName())){
                id_director = dir.getId_director();
            }
        }
        if(title.isEmpty() || year.isEmpty()){
            JOptionPane.showMessageDialog(null, "Data judul dan tahun belum lengkap!");
        }else{
            String newpath = "src/images";
            File fileawal = null;
            File fileakhir = null;
            String ext = this.filename.substring(filename.lastIndexOf('.')+1);
            fileawal = new File(filename);
            fileakhir = new File(newpath +"/"+ title + "." + ext);
            String poster = newpath +"/"+ title + "." + ext;
            
            String sql = "UPDATE movie SET title = '"+title+"', year = '"+year+"', id_director = '"+ id_director +"', poster = '"+ poster +"' WHERE id_movie = '"+ this.movie.getId_movie() +"'";
            db.updateQuery(sql);
            
            Files.copy(fileawal.toPath(), fileakhir.toPath());

            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fieldJudul = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldTahun = new javax.swing.JTextField();
        dropdown = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        lblPoster = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Form Movie");

        fieldJudul.setText("jTextField1");

        jLabel2.setText("Judul");

        jLabel3.setText("Tahun");

        fieldTahun.setText("jTextField2");

        dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdownActionPerformed(evt);
            }
        });

        jLabel4.setText("Director");

        btnAdd.setText("Submit");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("Poster");

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        lblPoster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBrowse)
                            .addComponent(fieldJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(fieldTahun)
                            .addComponent(dropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoster, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(9, 9, 9)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(lblPoster, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnAdd)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnBrowse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(isUpdate == false){
            try {
                insertData();
            } catch (IOException ex) {
                Logger.getLogger(FormMovie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                updateData();
            } catch (IOException ex) {
                Logger.getLogger(FormMovie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dispose();

        MainFrame main = new MainFrame(this.user);
        main.setVisible(true);

    }//GEN-LAST:event_btnAddActionPerformed

    private void dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdownActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dropdownActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(f.toString());
            Image img = icon.getImage().getScaledInstance(lblPoster.getWidth(),lblPoster.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon poster = new ImageIcon(img);
            lblPoster.setIcon(poster);
            this.filename = f.getAbsolutePath();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JComboBox<String> dropdown;
    private javax.swing.JTextField fieldJudul;
    private javax.swing.JTextField fieldTahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblPoster;
    // End of variables declaration//GEN-END:variables
}
