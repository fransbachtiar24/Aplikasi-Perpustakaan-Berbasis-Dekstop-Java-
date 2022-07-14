/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

package Tampilan;

import java.awt.Dialog;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author achmad-pc
 */
public class daftarPinjam extends javax.swing.JDialog {

    /** Creates new form daftarPinjam */
    
    DefaultTableModel dtm;
    PreparedStatement preparedStatement;
    private Integer id;
    Connection conec;
    Statement state;
    ResultSet res;
    String database;
    
    public String dateChooser;
    public String dateChooser1;
    
    
    public DefaultTableModel kembali = new  DefaultTableModel();
    
    public daftarPinjam(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        tablepinjam.setModel(kembali);
        tampilTable();
        dead();
    }
    
    public void reset(){
        kembali.removeRow(0);
    }
    
    public void clear(){
        kp.setText("");
        np.setText("");
        jb.setText("");
        tb.setText("");
        Date clear = null;
        tgl.setDate(clear);
        tgl1.setDate(clear);
        kt.setText("");
        dd.setText("");
        cbktr.setSelectedItem("");
        cbsts.setSelectedItem("");
    }
    
    public void dead(){
        kp.setEnabled(false);
        np.setEnabled(false);
        jb.setEnabled(false);
        tb.setEnabled(false);
        tgl.setEnabled(false);
    }
    
    public void hitung(){
        try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String tanggalkembali = String.valueOf(format.format(tgl.getDate()));
            Date TglKembali = (Date) format.parse(tanggalkembali);
            
            String tanggalditerima = String.valueOf(format.format(tgl1.getDate()));
            Date Tglditerima = (Date) format.parse(tanggalditerima);
            long telat = Math.abs(Tglditerima.getTime() - TglKembali.getTime());
            kt.setText("" + TimeUnit.MILLISECONDS.toDays(telat));
            
            int dnd, telat1, hasil;
            dnd = 10000;
            telat1 = Integer.valueOf(kt.getText());
            hasil = telat1 * dnd;
            dd.setText(String.valueOf(hasil));
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampilTable(){
        kembali.setRowCount(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_perpustakaan", "root", "");
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select * from pengembalian");
            String[] kolom = {"Kode Peminjam","Nama Peminjam","Judul Buku","Tanggal Kembali","Tanggal Terima","Keterlambatan","Total Buku","Keterangan","Denda","Status"};
            kembali.setColumnIdentifiers(kolom);
            while(res.next()){
            Object[] data = new Object[10];                        
            data[0] = res.getString("kode_peminjam");
            data[1] = res.getString("nama_peminjam");
            data[2] = res.getString("judul_buku");
            data[3] = res.getString("tgl_kembali");
            data[4] = res.getString("tgl_terima");
            data[5] = res.getString("keterlambatan");
            data[6] = res.getString("total_buku");
            data[7] = res.getString("keterangan");
            data[8] = res.getString("denda");
            data[9] = res.getString("status");
            
          
            kembali.addRow(data);
            
            
        }
    }   catch (ClassNotFoundException ex) { 
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepinjam = new javax.swing.JTable();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        tb = new javax.swing.JTextField();
        jb = new javax.swing.JTextField();
        np = new javax.swing.JTextField();
        tgl1 = new com.toedter.calendar.JDateChooser();
        tgl = new com.toedter.calendar.JDateChooser();
        kp = new javax.swing.JTextField();
        dd = new javax.swing.JTextField();
        kt = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        hapus = new com.k33ptoo.components.KButton();
        cbktr = new javax.swing.JComboBox<>();
        cbsts = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        FS = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar Pengembalian");

        jPanel1.setBackground(new java.awt.Color(188, 206, 251));

        jPanel2.setBackground(new java.awt.Color(24, 119, 242));

        jLabel1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Daftar Pengembalian");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        kGradientPanel1.setBackground(new java.awt.Color(188, 206, 251));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        tablepinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablepinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepinjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepinjam);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        kGradientPanel2.setBackground(new java.awt.Color(188, 206, 251));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        tb.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tb.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Buku", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 13))); // NOI18N

        jb.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jb.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Judul Buku", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 13))); // NOI18N
        jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionPerformed(evt);
            }
        });

        np.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        np.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama Peminjam", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 13))); // NOI18N
        np.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npActionPerformed(evt);
            }
        });

        tgl1.setBackground(new java.awt.Color(255, 255, 255));
        tgl1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tanggal Diterima", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 13))); // NOI18N
        tgl1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl1PropertyChange(evt);
            }
        });

        tgl.setBackground(new java.awt.Color(255, 255, 255));
        tgl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tanggal kembali", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 13))); // NOI18N
        tgl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglPropertyChange(evt);
            }
        });

        kp.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        kp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kode Peminjam", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 13))); // NOI18N
        kp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kpActionPerformed(evt);
            }
        });

        dd.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        dd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Denda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 13))); // NOI18N

        kt.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        kt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Keterlambatan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 13))); // NOI18N

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-edit-32.png"))); // NOI18N
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setText("HAPUS");
        hapus.setkBackGroundColor(new java.awt.Color(147, 41, 30));
        hapus.setkEndColor(new java.awt.Color(147, 41, 30));
        hapus.setkHoverEndColor(new java.awt.Color(147, 41, 30));
        hapus.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        hapus.setkHoverStartColor(new java.awt.Color(237, 33, 58));
        hapus.setkSelectedColor(new java.awt.Color(147, 41, 30));
        hapus.setkStartColor(new java.awt.Color(237, 33, 58));
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        cbktr.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        cbktr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--KETERANGAN--", "TEPAT WAKTU", "TERLAMBAT" }));
        cbktr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbktrActionPerformed(evt);
            }
        });

        cbsts.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        cbsts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--STATUS--", "DI KEMBALIKAN", "BELUM DIKEMBALIKAN" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-receipt-32.png"))); // NOI18N
        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-refresh-24.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(kp, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(np, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tb, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(kt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbktr, 0, 175, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbsts, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(137, 137, 137)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(np, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit)
                            .addComponent(cbktr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbsts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton2))
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        FS.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton3.setText("Cari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
                        .addGap(16, 16, 16))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(FS, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_perpustakaan", "root", "");
            Statement smt = null;
            String sql = ("Delete from pengembalian "+ "Where kode_peminjam ='"+kembali.getValueAt(tablepinjam.getSelectedRow(), 0)+"'");
            smt = connection.createStatement();
            PreparedStatement p2=(PreparedStatement) connection.prepareStatement(sql);
            p2.executeUpdate();
            tampilTable();
            clear();      
            dead();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void tablepinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepinjamMouseClicked
        // TODO add your handling code here:
        int id = tablepinjam.getSelectedRow();        
        kp.setText(tablepinjam.getValueAt(id, 0).toString());
        np.setText(tablepinjam.getValueAt(id, 1).toString());
        jb.setText(tablepinjam.getValueAt(id, 2).toString());
        Date format = null;
        Date format1 = null;
        try {
            format = new SimpleDateFormat("yyyy-MM-dd").parse((String)tablepinjam.getValueAt(tablepinjam.getSelectedRow(), 3).toString());
            format1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)tablepinjam.getValueAt(tablepinjam.getSelectedRow(), 4).toString());
        } catch (ParseException ex) {
            Logger.getLogger(pengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }
        tgl.setDate(format);
        tgl1.setDate(format1);
        kt.setText(tablepinjam.getValueAt(id, 5).toString());
        tb.setText(tablepinjam.getValueAt(id, 6).toString());        
        cbktr.setSelectedItem(tablepinjam.getValueAt(id, 7).toString());
        dd.setText(tablepinjam.getValueAt(id, 8).toString());  
        cbsts.setSelectedItem(tablepinjam.getValueAt(id, 9).toString());
        dead();
        
    }//GEN-LAST:event_tablepinjamMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        dateChooser = String.valueOf(format.format(tgl.getDate()));
        dateChooser1 = String.valueOf(format.format(tgl1.getDate()));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_perpustakaan", "root", "");
            preparedStatement = connection.prepareStatement("update pengembalian set kode_peminjam = ?, nama_peminjam = ?, judul_buku = ?, tgl_kembali = ?,tgl_terima = ?,keterlambatan = ?,total_buku = ?, keterangan = ?, denda = ?, status = ? where kode_peminjam = '"+kp.getText()+"' ");
            preparedStatement.setString(1, kp.getText());
            preparedStatement.setString(2, np.getText());
            preparedStatement.setString(3, jb.getText());
            preparedStatement.setString(4, dateChooser);
            preparedStatement.setString(5, dateChooser1);
            preparedStatement.setString(6, kt.getText());
            preparedStatement.setString(7, tb.getText());
            preparedStatement.setString(8, cbktr.getSelectedItem().toString());
            preparedStatement.setString(9, dd.getText());
            preparedStatement.setString(10, cbsts.getSelectedItem().toString());            
            preparedStatement.execute();
            connection.close();
            tampilTable();
            clear();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editActionPerformed

    private void kpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kpActionPerformed

    private void cbktrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbktrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbktrActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_perpustakaan", "root", "");
            Statement statement = connection.createStatement();
            String file = "src/laporan/struk.jrxml";
            HashMap param =  new HashMap();
            ResultSet res = statement.executeQuery("select * from pengembalian");
            param.put("kode_peminjam", String.valueOf(kp.getText()));            
            File file1 = new File(file);
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, connection);
            JasperViewer.viewReport(jp, false);
            JasperViewer jasperViewer = new JasperViewer(jp, false);
            JDialog dialog = new JDialog();
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle("Struk Pengembalian");
            dialog.setAlwaysOnTop(true);
            dialog.setModalityType(Dialog.ModalityType.MODELESS);
            dialog.setModal(true);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(daftarPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglPropertyChange
        // TODO add your handling code here:
        if (tgl.getDate() != null) {
            SimpleDateFormat FormatTanggal = new SimpleDateFormat("yyyy-MM-dd");
            dateChooser = String.valueOf(FormatTanggal.format(tgl.getDate()));
        }
    }//GEN-LAST:event_tglPropertyChange

    private void tgl1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl1PropertyChange
        // TODO add your handling code here:
        if (tgl1.getDate() != null) {
            SimpleDateFormat FormatTanggal = new SimpleDateFormat("yyyy-MM-dd");
            dateChooser = String.valueOf(FormatTanggal.format(tgl1.getDate()));
        }
    }//GEN-LAST:event_tgl1PropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        hitung();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String cari = FS.getText();
        if(FS.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, state);
            FS.requestFocus();
        }
        else{
            DefaultTableModel DTM = new DefaultTableModel();
            DTM.addColumn("kode_peminjam");
            DTM.addColumn("nama_peminjam");
            DTM.addColumn("judul_buku");
            DTM.addColumn("tgl_kembali");
            DTM.addColumn("tgl_terima");
            DTM.addColumn("keterlambatan");
            DTM.addColumn("total_buku");
            DTM.addColumn("keterangan");
            DTM.addColumn("denda");
            DTM.addColumn("status");
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/db_perpustakaan";
            String user = "root";
            String pass= "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conec = DriverManager.getConnection(url,user,pass);
            String sql = "select * from pengembalian where nama_peminjam like '%"+cari+"%'";
            Statement stat = conec.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                DTM.addRow(new Object []{rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)});
            }
            tablepinjam.setModel(DTM);
            
            kp.setText("");
            np.setText("");
            jb.setText("");
            FS.setEnabled(true);
            FS.requestFocus();
        }   catch (SQLException ex) {
                Logger.getLogger(pinjam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void npActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npActionPerformed

    private void jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbActionPerformed

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
            java.util.logging.Logger.getLogger(daftarPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftarPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftarPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftarPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                daftarPinjam dialog = new daftarPinjam(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FS;
    private javax.swing.JComboBox<String> cbktr;
    private javax.swing.JComboBox<String> cbsts;
    private javax.swing.JTextField dd;
    private javax.swing.JButton edit;
    private com.k33ptoo.components.KButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jb;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField kp;
    private javax.swing.JTextField kt;
    private javax.swing.JTextField np;
    private javax.swing.JTable tablepinjam;
    private javax.swing.JTextField tb;
    private com.toedter.calendar.JDateChooser tgl;
    private com.toedter.calendar.JDateChooser tgl1;
    // End of variables declaration//GEN-END:variables

}
