package pages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.text.*;


public class edit_siswa extends javax.swing.JDialog {
    
    private static Point point = new Point();


    public edit_siswa(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        
        setSize(540, 281);
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
        
        ((AbstractDocument)nis.getDocument()).setDocumentFilter(new DocumentFilter() {
            Pattern regEx = Pattern.compile("\\d*");
            
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
        
        nis.setEnabled(false);
        idnya.setVisible(false);
        tanggal.setEnabled(false);
        idnya.setText(id);
        tampil(id);
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        close_btn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jurusan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tempat_lahir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tanggal_lahir = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        save_btn = new javax.swing.JPanel();
        save = new javax.swing.JLabel();
        reset_btn = new javax.swing.JPanel();
        reset = new javax.swing.JLabel();
        idnya = new javax.swing.JLabel();

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
                .addContainerGap(512, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn)
        );

        jLabel1.setText("NIS");

        nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nisKeyPressed(evt);
            }
        });

        jLabel3.setText("Nama Lengkap");

        jLabel4.setText("Jurusan");

        jurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknik Komputer dan Jaringan", "Teknik Kendaraan Ringan Otomotif", "Teknik dan Bisnis Sepeda Motor", "Otomatisasi dan Tata Kelola Perkantoran", "Akuntansi dan Keuangan Lembaga", "Bisnis Daring dan Pemasaran" }));

        jLabel5.setText("Tempat Lahir");

        jLabel6.setText("Tanggal Lahir (YYYY-MM-DD)");

        jLabel2.setText("Tanggal Siswa Masuk (YYYY-MM-DD)");

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
            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        save_btnLayout.setVerticalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
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
            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        reset_btnLayout.setVerticalGroup(
            reset_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jurusan, 0, 245, Short.MAX_VALUE)
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idnya))
                            .addComponent(nama)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(nis))
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel5))
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(tempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tempat_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(nis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tanggal_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(nama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(idnya))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

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

    private void close_btnMouseClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
    }

    private void close_btnKeyPressed(java.awt.event.KeyEvent evt) {

        this.setVisible(false);
    }

    private void nisKeyPressed(java.awt.event.KeyEvent evt) {
    }

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {
        String getnis = nis.getText();
        String getnama = nama.getText();
        String gettempat = tempat_lahir.getText();
        String gettl = tanggal_lahir.getText();
        String getjurusan = (String)jurusan.getSelectedItem();
        String gettanggal = tanggal.getText();
        
        if (!empty(getnama) || !empty(gettempat) || !empty(gettl) || !empty(gettanggal)) {
            try {
                Connection con = new database.connection().configDB();
                String sql = "UPDATE murid SET nama = ?, tempat_lahir = ?, tanggal_lahir = ?, jurusan = ?, tanggal = ? WHERE id = '"+idnya.getText()+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, getnama);
                stat.setString(2, gettempat);
                stat.setString(3, gettl);
                stat.setString(4, getjurusan);
                stat.setString(5, gettanggal);
                stat.executeUpdate();
                String sql2 = "UPDATE peminjaman SET nama = ? WHERE nis = '"+getnis+"'";
                java.sql.PreparedStatement stat2 = con.prepareStatement(sql2);
                stat2.setString(1, getnama);
                stat2.executeUpdate();

                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Data BERHASIL Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "GAGAL Mengubah Data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {
        tampil(idnya.getText());
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                edit_siswa dialog = new edit_siswa(new javax.swing.JFrame(), true, "0");
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
    
    public void tampil(String id) {
        try {
            Connection con = new database.connection().configDB();
            String sql = "SELECT * FROM murid WHERE id = '"+id+"'";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            
            if (hasil.next()) {
                nis.setText(hasil.getString("nis"));
                nama.setText(hasil.getString("nama"));
                tempat_lahir.setText(hasil.getString("tempat_lahir"));
                tanggal_lahir.setText(hasil.getString("tanggal_lahir"));
                jurusan.setSelectedItem(hasil.getString("jurusan"));
                tanggal.setText(hasil.getString("tanggal"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan Frame!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }

    private javax.swing.JPanel body;
    private javax.swing.JLabel close_btn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel idnya;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jurusan;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nis;
    private javax.swing.JLabel reset;
    private javax.swing.JPanel reset_btn;
    private javax.swing.JLabel save;
    private javax.swing.JPanel save_btn;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField tanggal_lahir;
    private javax.swing.JTextField tempat_lahir;
}
