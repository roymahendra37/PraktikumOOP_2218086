/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TugasPraktikum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author royma
 */
public class GUI_SewaStudioMusik extends javax.swing.JFrame {
    String nama1, tlp1, tgl1, bln1, thn1, jam1, durasi1, jenis1;
    /**
     * Creates new form GUI_SewaStudioMusik
     */
    public GUI_SewaStudioMusik() {
        initComponents();
        tampil();
//        //Mengambil model data dari tabel dan menyimpannya dalam objek DefaultTableModel dataModel
//        DefaultTableModel dataModel = (DefaultTableModel) table_pemesanan.getModel();
//        //Mendapatkan jumlah baris yang ada dalam model data saat ini
//        int rowCount = dataModel.getRowCount();
//        while (rowCount > 0){
//            //Menghapus baris terakhir dari model data
//            dataModel.removeRow(rowCount - 1);
//            //Memperbarui nilai rowCount setelah penghapusan baris terakhir
//            rowCount = dataModel.getRowCount();
//        }
    }
    public void clear() {
        txtNama.setText("");
        txtTlp.setText("");
        txtTgl.setText("");
        txtBln.setText("");
        txtThn.setText("");
        txtJam.setText("");
        txtDurasi.setText("");
        btnGjenis.clearSelection();
    }
    public Connection conn;
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_2218086?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_SewaStudioMusik.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_SewaStudioMusik.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_SewaStudioMusik.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("NAMA");
        tabelhead.addColumn("NOMOR");
        tabelhead.addColumn("TANGGAL");
        tabelhead.addColumn("BULAN");
        tabelhead.addColumn("TAHUN");
        tabelhead.addColumn("JAM");
        tabelhead.addColumn("DURASI");
        tabelhead.addColumn("JENIS");
        tabelhead.addColumn("BIAYA");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_sewastudio";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString("nama"), res.getString("tlp"), res.getString("tgl"), res.getString("bln"), res.getString("thn"), res.getString("jam"),res.getString("durasi"),res.getString("jenis"),res.getString("biaya")});
            }
            table_pemesanan.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    public void refresh() {
        new GUI_SewaStudioMusik().setVisible(true);
        this.setVisible(false);
    }
    public void insert() {
        String nama = txtNama.getText();
        String tlp = txtTlp.getText();
        String tgl = txtTgl.getText();
        String bln = txtBln.getText();
        String thn = txtThn.getText();
        String jam = txtJam.getText();
        int durasi = Integer.parseInt(txtDurasi.getText());
        int biaya ;
        String jenis;
        if (RbtnBiasa.isSelected()) {
            jenis = "Biasa";
            biaya = durasi * 45000;
        } else {
            jenis = "Lengkap";
            biaya = durasi * 55000;
        }
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_sewastudio (nama, tlp, tgl, bln, thn, jam, durasi, jenis, biaya)"
            +"VALUES('" + nama + "','" + tlp + "','" + tgl + "','" + bln + "','"
                    + thn + "','" + jam + "','" + durasi + "','" + jenis + "','" + biaya + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Pemesan!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    public void update() {
        String nama = txtNama.getText();
        String tlp = txtTlp.getText();
        String tgl = txtTgl.getText();
        String bln = txtBln.getText();
        String thn = txtThn.getText();
        String jam = txtJam.getText();
        int durasi = Integer.parseInt(txtDurasi.getText());
        int biaya ;
        String jenis;
        if (RbtnBiasa.isSelected()) {
            jenis = "Biasa";
            biaya = durasi * 45000;
        } else {
            jenis = "Lengkap";
            biaya = durasi * 55000;
        }
        String namalama = nama1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_sewastudio SET nama='" + nama + "'," + "tlp='" + tlp + "',"
                    + "tgl='" + tgl + "'" + ",bln='" + bln + "',thn='" + thn + "',jam='"
                    + jam + "',durasi='" + durasi + "',jenis='" + jenis + "',biaya='" + biaya + "' WHERE nama = '" + namalama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Pemesan Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_sewastudio WHERE nama='" + txtNama.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }
    public void cari() {
        try {
            try ( Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM tb_sewastudio WHERE `nama`  LIKE '%" + txtCari.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txtNama.setText(rs.getString("nama"));
                    txtTlp.setText(rs.getString("tlp"));
                    txtTgl.setText(rs.getString("tgl"));
                    txtBln.setText(rs.getString("bln"));
                    txtThn.setText(rs.getString("thn"));
                    txtJam.setText(rs.getString("jam"));
                    txtDurasi.setText(rs.getString("durasi"));
                    String jenis = rs.getString("jenis");
                    if (jenis.equalsIgnoreCase("Biasa")) {
                        RbtnBiasa.setSelected(true);
                    } else {
                        RbtnLengkap.setSelected(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }
    public void itempilih() {
        txtNama.setText(nama1);
        txtTlp.setText(tlp1);
        txtTgl.setText(tgl1);
        txtBln.setText(bln1);
        txtThn.setText(thn1);
        txtJam.setText(jam1);
        txtDurasi.setText(durasi1);
        if (jenis1.equalsIgnoreCase("Biasa")) {
            RbtnBiasa.setSelected(true);
        } else {
            RbtnLengkap.setSelected(true);
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

        btnGjenis = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RbtnBiasa = new javax.swing.JRadioButton();
        RbtnLengkap = new javax.swing.JRadioButton();
        txtNama = new javax.swing.JTextField();
        txtTlp = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        txtTgl = new javax.swing.JTextField();
        txtBln = new javax.swing.JTextField();
        txtThn = new javax.swing.JTextField();
        txtJam = new javax.swing.JTextField();
        txtDurasi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_pemesanan = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnBatalSewa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ROY'S MUSIC STUDIO");
        jLabel1.setToolTipText("");

        jLabel2.setText("Nama Pemesan");

        jLabel3.setText("No.Tlp");

        jLabel4.setText("Tanggal");

        jLabel5.setText("Jam");

        jLabel6.setText("Durasi");

        jLabel7.setText("Jenis Studio");

        btnGjenis.add(RbtnBiasa);
        RbtnBiasa.setText("Biasa");
        RbtnBiasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnBiasaActionPerformed(evt);
            }
        });

        btnGjenis.add(RbtnLengkap);
        RbtnLengkap.setText("Lengkap");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txtThn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThnActionPerformed(evt);
            }
        });

        txtJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJamActionPerformed(evt);
            }
        });

        jLabel8.setText("tgl");

        jLabel9.setText("bln");

        jLabel10.setText("thn");

        jLabel11.setText("Jam");

        jLabel12.setText("WIB");

        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        table_pemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NAMA", "NOMOR", "TANGGAL", "BULAN", "TAHUN", "JAM", "DURASI", "JANIS", "BIAYA"
            }
        ));
        table_pemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pemesananMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_pemesanan);

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnBatalSewa.setText("BATAL SEWA");
        btnBatalSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalSewaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKeluar)
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(34, 34, 34)
                                .addComponent(btnHapus)
                                .addGap(33, 33, 33)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCari))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(RbtnBiasa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBln, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtThn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(RbtnLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBatal))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTlp, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBatalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKeluar)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBatalSewa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbtnBiasa)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbtnLengkap)
                    .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnUpdate)
                    .addComponent(btnCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RbtnBiasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnBiasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbtnBiasaActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
        
//        // Mengambil model data dari tabel
//        DefaultTableModel dataModel = (DefaultTableModel) 
//        table_pemesanan.getModel();
//        // Inisialisasi sebuah ArrayList bernama 'list'
//        List list = new ArrayList<>();
//        // Mengatur tabel untuk membuat kolom dari model secara otomatis
//        table_pemesanan.setAutoCreateColumnsFromModel(true);
//        
//        // Membuat instance dari kelas StudioMusik
//        StudioMusik std = new StudioMusik();
//        // Mengatur data Nama menggunakan nilai dari komponen txtNama
//        std.dataNama (txtNama.getText());
//        // Mengatur data Tlp menggunakan nilai dari komponen txtTlp
//        std.dataTlp (txtTlp.getText());
//        // Mengatur data Tanggal menggunakan nilai dari komponen txtTgl
//        std.tgl = txtTgl.getText();
//        // Mengatur data Bulan menggunakan nilai dari komponen txtBln
//        std.bulan = txtBln.getText();
//        // Mengatur data Tahun menggunakan nilai dari komponen txtThn
//        std.tahun = txtThn.getText();
//        // Mengatur data Jam menggunakan nilai dari komponen txtJam
//        std.jam = txtJam.getText();
//        try{
//            // Mengatur data Durasi menggunakan nilai dari komponen txtDurasi
//            std.durasi = Integer.parseInt(txtDurasi.getText());
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(rootPane, "INPUTAN DURASI BERUPA ANGKA!!!");
//        }finally{
//            // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel
//            JOptionPane.showMessageDialog(null, "Data Sukses Ditambahkan");
//        }
//
//        // Mengatur jenis studio sesuai dengan radio button yang dipilih
//        if (RbtnBiasa.isSelected()){
//            std.JenisStudio = RbtnBiasa.getText();//jika memilih jenis studio Biasa
//            std.total = std.hitBiasa();//menyimpan total harga studio Biasa
//        }
//        else {
//            std.JenisStudio = RbtnLengkap.getText();//jika memilih jenis studio Lengkap
//            std.total = std.hitLengkap();//menyimpan total harga studio Lengkap
//        }
//
//        // Menambahkan data-data dari objek Mahasiswa ke dalam ArrayList 'list'
//        list.add(std.cetakNama());
//        list.add(std.cetakTlp());
//        list.add(std.tgl);
//        list.add(std.bulan);
//        list.add(std.tahun);
//        list.add(std.jam);
//        list.add(std.durasi);
//        list.add(std.JenisStudio);
//        list.add(std.total);
//        // Menambahkan baris baru ke model tabel menggunakan data dari ArrayList 'list'
//        dataModel.addRow(list.toArray());
//        // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen
//        clear();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtThnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThnActionPerformed

    private void txtJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJamActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        dispose(); //menutup program
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
        //Mengambil model data dari tabel dan menyimpannya dalam objek DefaultTableModel dataModel
//        DefaultTableModel dataModel = (DefaultTableModel) table_pemesanan.getModel();
//        //Mendapatkan jumlah baris yang ada dalam model data saat ini
//        int rowCount = dataModel.getRowCount();
//        int x = 0;
//        while (rowCount > x){
//            //Menghapus baris terakhir dari model data
//            dataModel.removeRow(rowCount-1);
//            //Memperbarui nilai rowCount setelah penghapusan baris terakhir
//            rowCount = dataModel.getRowCount();
//            //variabel bantu untuk menghapus baris terakhir
//            x = rowCount;
//        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clear();//untuk membersihkan textField
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void table_pemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pemesananMouseClicked
        // TODO add your handling code here:
        int tabel = table_pemesanan.getSelectedRow();
        nama1 = table_pemesanan.getValueAt(tabel, 0).toString();
        tlp1 = table_pemesanan.getValueAt(tabel, 1).toString();
        tgl1 = table_pemesanan.getValueAt(tabel, 2).toString();
        bln1 = table_pemesanan.getValueAt(tabel, 3).toString();
        thn1 = table_pemesanan.getValueAt(tabel, 4).toString();
        jam1 = table_pemesanan.getValueAt(tabel, 5).toString();
        durasi1 = table_pemesanan.getValueAt(tabel, 6).toString();
        jenis1 = table_pemesanan.getValueAt(tabel, 7).toString();
        itempilih();
    }//GEN-LAST:event_table_pemesananMouseClicked

    private void btnBatalSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalSewaActionPerformed
        // TODO add your handling code here:
        new GUI_BatalSewa().setVisible(true);
    }//GEN-LAST:event_btnBatalSewaActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_SewaStudioMusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_SewaStudioMusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_SewaStudioMusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_SewaStudioMusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_SewaStudioMusik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbtnBiasa;
    private javax.swing.JRadioButton RbtnLengkap;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalSewa;
    private javax.swing.JButton btnCari;
    private javax.swing.ButtonGroup btnGjenis;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_pemesanan;
    private javax.swing.JTextField txtBln;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtDurasi;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTgl;
    private javax.swing.JTextField txtThn;
    private javax.swing.JTextField txtTlp;
    // End of variables declaration//GEN-END:variables
}
