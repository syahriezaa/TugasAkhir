
package pages;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;


public class edit_peminjaman extends javax.swing.JDialog {
    
    private static Point point = new Point();
    
    DefaultTableModel tbl1 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel tbl2 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public edit_peminjaman(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        
        setSize(760, 578);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setUndecorated(true);
        
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });
        
        initComponents();
        
        nis.setEnabled(false);
        nama.setEnabled(false);
        jurusan.setEnabled(false);
        kode.setEnabled(false);
        judul.setEnabled(false);
        jenis.setEnabled(false);
        id_peminjaman.setVisible(false);
        
        tampil_data(id);
        tampil_buku();
        tampil_murid();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        close_btn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_murid = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_buku = new javax.swing.JTable();
        cari_murid = new placeholder.search_student();
        cari_buku = new placeholder.search_book();
        data_murid = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jurusan = new javax.swing.JTextField();
        data_buku = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jenis = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        judul = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        id_peminjaman = new javax.swing.JLabel();
        save_btn = new javax.swing.JPanel();
        save = new javax.swing.JLabel();
        reset_btn = new javax.swing.JPanel();
        reset = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        header.setBackground(new java.awt.Color(81, 67, 250));
        header.setPreferredSize(new java.awt.Dimension(718, 47));

        close_btn.setFont(new java.awt.Font("Tahoma", 1, 20));
        close_btn.setForeground(new java.awt.Color(255, 255, 255));
        close_btn.setText("×");
        close_btn.setToolTipText("Keluar?");
        close_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_btnMouseClicked(evt);
            }
        });
        close_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                close_btnKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(732, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn)
        );

        tbl_murid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NIS", "Nama", "Jurusan"
            }
        ));
        tbl_murid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_muridMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_murid);

        tbl_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku", "Tanggal Terbit"
            }
        ));
        tbl_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_buku);

        cari_murid.setToolTipText("Cari Murid");
        cari_murid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cari_muridKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cari_muridKeyTyped(evt);
            }
        });

        cari_buku.setToolTipText("Cari Buku");
        cari_buku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cari_bukuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cari_bukuKeyTyped(evt);
            }
        });

        data_murid.setBackground(new java.awt.Color(255, 255, 255));
        data_murid.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Murid"));

        jLabel1.setText("NIS");

        nis.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Nama");

        nama.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setText("Jurusan");

        jurusan.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout data_muridLayout = new javax.swing.GroupLayout(data_murid);
        data_murid.setLayout(data_muridLayout);
        data_muridLayout.setHorizontalGroup(
            data_muridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nis)
            .addComponent(nama)
            .addGroup(data_muridLayout.createSequentialGroup()
                .addGroup(data_muridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jurusan)
        );
        data_muridLayout.setVerticalGroup(
            data_muridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_muridLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        data_buku.setBackground(new java.awt.Color(255, 255, 255));
        data_buku.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Buku"));

        jLabel4.setText("Kode Buku");

        kode.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Jenis Buku");

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ensiklopedia", "Novel", "Komik", "Biografi", "Dongeng", "Karya Ilmiah" }));

        jLabel6.setText("Judul Buku");

        judul.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setText("Tanggal Peminjaman (YYYY-MM-DD)");

        javax.swing.GroupLayout data_bukuLayout = new javax.swing.GroupLayout(data_buku);
        data_buku.setLayout(data_bukuLayout);
        data_bukuLayout.setHorizontalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kode)
            .addComponent(jenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(judul)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_bukuLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_peminjaman))
                    .addGroup(data_bukuLayout.createSequentialGroup()
                        .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(tanggal)
        );
        data_bukuLayout.setVerticalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(id_peminjaman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        save_btn.setBackground(new java.awt.Color(81, 67, 250));

        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("Simpan");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout save_btnLayout = new javax.swing.GroupLayout(save_btn);
        save_btn.setLayout(save_btnLayout);
        save_btnLayout.setHorizontalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );
        save_btnLayout.setVerticalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        reset_btn.setBackground(new java.awt.Color(81, 67, 250));

        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reset.setText("Reset");
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout reset_btnLayout = new javax.swing.GroupLayout(reset_btn);
        reset_btn.setLayout(reset_btnLayout);
        reset_btnLayout.setHorizontalGroup(
            reset_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );
        reset_btnLayout.setVerticalGroup(
            reset_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cari_murid)
                    .addComponent(cari_buku)
                    .addComponent(data_murid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(cari_murid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data_murid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        data_murid.getAccessibleContext().setAccessibleName("Ubah Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {
        save();
    }

    private void cari_bukuKeyTyped(java.awt.event.KeyEvent evt) {
        search_book();
    }

    private void cari_bukuKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_book();
        }
    }

    private void cari_muridKeyTyped(java.awt.event.KeyEvent evt) {
        search_murid();
    }

    private void cari_muridKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_murid();
        }
    }

    private void tbl_muridMouseClicked(java.awt.event.MouseEvent evt) {
        clicktbl_murid();
    }

    private void close_btnKeyPressed(java.awt.event.KeyEvent evt) {
        this.setVisible(false);
    }

    private void close_btnMouseClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
    }

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {
        String id = id_peminjaman.getText();
        tampil_data(id);
    }

    private void tbl_bukuMouseClicked(java.awt.event.MouseEvent evt) {
        clicktbl_buku();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(edit_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                edit_peminjaman dialog = new edit_peminjaman(new javax.swing.JFrame(), true, 0+"");
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
    
    private void tampil_data(String id) {
        id_peminjaman.setText(id);
        try {
            Connection con = new database.connection().configDB();
            String sql = "SELECT * FROM peminjaman WHERE id = '"+id+"'";
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                nis.setText(rs.getString("nis"));
                nama.setText(rs.getString("nama"));
                jurusan.setText(rs.getString("jurusan"));
                kode.setText(rs.getString("kode"));
                judul.setText(rs.getString("judul"));
                tanggal.setText(rs.getString("tanggal"));
                
                try {
                    String sql2 = "SELECT * FROM buku WHERE kode = '"+rs.getString("kode")+"'";
                    java.sql.ResultSet hasil = st.executeQuery(sql2);
                    
                    if (hasil.next()) {
                        jenis.setSelectedIndex(hasil.getInt("jenis")-1);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal menampilkan Frame!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    this.setVisible(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan Frame!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private void tampil_buku() {
        Object []baris = {"Kode Buku", "Judul Buku", "Tanggal Terbit"};
        tbl1 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_buku.setModel(tbl1);
        
        try {
            Connection con = new database.connection().configDB();
            String sql = "SELECT * FROM buku ORDER BY id ASC";
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String kode = rs.getString("kode");
                String judul = rs.getString("judul");
                String tanggal = rs.getString("tanggal");
                
                String[] data = {kode, judul, tanggal};
                tbl1.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATA!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private void tampil_murid() {
        Object []baris = {"NIS", "Nama", "Jurusan"};
        tbl2 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_murid.setModel(tbl2);
        
        try {
            Connection con = new database.connection().configDB();
            String sql = "SELECT * FROM murid ORDER BY id ASC";
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String nis = rs.getString("nis");
                String nama = rs.getString("nama");
                String jurusan = rs.getString("jurusan");
                
                String[] data = {nis, nama, jurusan};
                tbl2.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATA!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private void search_book() {
        String query = cari_buku.getText();
        
        Object []baris = {"Kode Buku", "Judul Buku", "Tanggal Terbit"};
        tbl1 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_buku.setModel(tbl1);
        
        try {
            Connection con = new database.connection().configDB();
            String sql = "SELECT * FROM buku WHERE BINARY "
                    + "kode LIKE '%"+query+"%' "
                    + "OR judul LIKE '%"+query+"%' "
                    + "OR tanggal LIKE '%"+query+"%' "
                    + "OR pengarang LIKE '%"+query+"%' "
                    + "ORDER BY id ASC";
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet hasil = stmt.executeQuery(sql);
            
            while (hasil.next()) {
                String kode = hasil.getString("kode");
                String judul = hasil.getString("judul");
                String tanggal = hasil.getString("tanggal");
                
                String[] data = {kode, judul, tanggal};
                tbl1.addRow(data);
            }
        } catch (Exception e) {}
    }
    
    private void search_murid() {
        String query = cari_murid.getText();
        
        Object []baris = {"NIS", "Nama", "Jurusan"};
        tbl2 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_murid.setModel(tbl2);
        
        try {
            Connection con = new database.connection().configDB();
            String sql = "SELECT * FROM murid WHERE BINARY "
                    + "nis LIKE '%"+query+"%' "
                    + "OR nama LIKE '%"+query+"%' "
                    + "OR jurusan LIKE '%"+query+"%' "
                    + "ORDER BY id ASC";
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet hasil = stmt.executeQuery(sql);
            
            while (hasil.next()) {
                String nis = hasil.getString("nis");
                String nama = hasil.getString("nama");
                String jurusan = hasil.getString("jurusan");
                
                String[] data = {nis, nama, jurusan};
                tbl2.addRow(data);
            }
        } catch (Exception e) {}
    }
    
    private void clicktbl_murid() {
        int baris = tbl_murid.getSelectedRow();
        
        nis.setText((String)tbl2.getValueAt(baris, 0));
        nama.setText((String)tbl2.getValueAt(baris, 1));
        jurusan.setText((String)tbl2.getValueAt(baris, 2));
    }
    
    private void clicktbl_buku() {
        int baris = tbl_buku.getSelectedRow();
        
        kode.setText((String)tbl1.getValueAt(baris, 0));
        judul.setText((String)tbl1.getValueAt(baris, 1));
        
        try {
            Connection con = new database.connection().configDB();
            String sql = "SELECT * FROM buku WHERE kode = '"+(String)tbl1.getValueAt(baris, 0)+"'";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet rs = stat.executeQuery(sql);
            
            if (rs.next()) {
                jenis.setSelectedIndex(rs.getInt("jenis")-1);
            }
            
        } catch (Exception e) {}
    }
    
    private void save() {
        String id, getnis, getnama, getjurusan, getkode, getjudul, gettanggal;
        
        getnis = nis.getText();
        getnama = nama.getText();
        getjurusan = jurusan.getText();
        getkode = kode.getText();
        getjudul = judul.getText();
        gettanggal = tanggal.getText();
        
        id = id_peminjaman.getText();
        
        if (!empty(gettanggal)) {
            try {
                Connection con = new database.connection().configDB();
                String sql = "UPDATE peminjaman SET nis = ?, nama = ?, jurusan = ?, kode = ?, judul = ?, tanggal = ? WHERE id = '"+id+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, getnis);
                stat.setString(2, getnama);
                stat.setString(3, getjurusan);
                stat.setString(4, getkode);
                stat.setString(5, getjudul);
                stat.setString(6, gettanggal);
                stat.executeUpdate();
                
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Data BERHASIL Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "GAGAL Mengubah Data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan masukkan Tanggal Peminjaman!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }

    private javax.swing.JPanel body;
    private javax.swing.JTextField cari_buku;
    private javax.swing.JTextField cari_murid;
    private javax.swing.JLabel close_btn;
    private javax.swing.JPanel data_buku;
    private javax.swing.JPanel data_murid;
    private javax.swing.JPanel header;
    private javax.swing.JLabel id_peminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField jurusan;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nis;
    private javax.swing.JLabel reset;
    private javax.swing.JPanel reset_btn;
    private javax.swing.JLabel save;
    private javax.swing.JPanel save_btn;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTable tbl_buku;
    private javax.swing.JTable tbl_murid;
}
