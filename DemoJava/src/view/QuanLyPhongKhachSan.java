/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Bean.Branch;
import Bean.HotelRoom;
import DAO.ChiNhanhDAO;
import DAO.PhongKhachSanDAO;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIETTHI_PC
 */
public class QuanLyPhongKhachSan extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyNhanVien
     */
    DefaultComboBoxModel TenChiNhanh;
    private List<Branch> chiNhanh;
    private DefaultTableModel model;

    public QuanLyPhongKhachSan() {
        initComponents();
        setUI();
        setComboBox();
        showList();
    }

    private void setUI() {
        model = (DefaultTableModel) tblchiNhanh.getModel();
        tblchiNhanh.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblchiNhanh.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        //   jTable1.getTableHeader().setOpaque(false);
        tblchiNhanh.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblchiNhanh.getColumnModel().getColumn(0).setPreferredWidth(110);
        tblchiNhanh.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblchiNhanh.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblchiNhanh.getColumnModel().getColumn(3).setPreferredWidth(130);
        tblchiNhanh.getColumnModel().getColumn(4).setPreferredWidth(300);
        tblchiNhanh.getColumnModel().getColumn(5).setPreferredWidth(130);

    }
    private void setComboBox(){
        List<Branch> cn = ChiNhanhDAO.getList();
        TenChiNhanh = new DefaultComboBoxModel();
        TenChiNhanh.addElement("Tất cả");
        for (int i = 0; i < cn.size(); i++) {
            TenChiNhanh.addElement(cn.get(i));
        }
        cbbChiNhanh.setModel(TenChiNhanh);
    }
    private String TrangThai(boolean bl) {
        if (bl) {
            return "Đang thuê";
        } else {
            return "Trống";
        }
    }

    private String GioiTinh(boolean bl) {
        if (bl) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    public void showList() {
        chiNhanh = ChiNhanhDAO.getChiNhanh();
        model.setRowCount(0);
        for (Branch a : chiNhanh) {
             List<HotelRoom> pks = PhongKhachSanDAO.getListPhongKhachSan(a.getBranchCode());
            for(HotelRoom b : pks){
                model.addRow(new Object[]{a.getBranchCode(), a.getBranchName(),
                    b.getRoomCode(), b.getPrice(), b.getDescription(),TrangThai(b.isStatus())});
            }  
        }
    }
     public void showList(Branch cn) {
        model.setRowCount(0);
             List<HotelRoom> pks = PhongKhachSanDAO.getListPhongKhachSan(cn.getBranchCode());
            for(HotelRoom b : pks){
                model.addRow(new Object[]{cn.getBranchCode(), cn.getBranchName(),
                    b.getRoomCode(), b.getPrice(), b.getDescription(),TrangThai(b.isStatus())});
            }  
            model.setRowCount(pks.size() + 13);
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtChinhSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblchiNhanh = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbbChiNhanh = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin nhân viên");
        setLocation(new java.awt.Point(495, 190));
        setMinimumSize(new java.awt.Dimension(930, 700));
        setPreferredSize(new java.awt.Dimension(930, 590));

        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtChinhSua.setBackground(new java.awt.Color(46, 204, 113));
        txtChinhSua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtChinhSua.setText("Chỉnh sửa");
        txtChinhSua.setBorder(null);
        txtChinhSua.setBorderPainted(false);
        txtChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtChinhSuaMouseClicked(evt);
            }
        });
        jPanel1.add(txtChinhSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 130, 40));

        tblchiNhanh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblchiNhanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nguyễn Việt Thi", null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã chi nhánh", "Chi nhánh", "Mã phòng", "Giá thuê", "Mô tả", "Trạng thái"
            }
        ));
        tblchiNhanh.setRowHeight(35);
        jScrollPane1.setViewportView(tblchiNhanh);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 920, 420));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_24px.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cbbChiNhanh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbChiNhanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chi nhánh Hai Bà Trưng" }));
        cbbChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChiNhanhActionPerformed(evt);
            }
        });
        jPanel3.add(cbbChiNhanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 260, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtChinhSuaMouseClicked
        // TODO add your handling code here:
        int y =tblchiNhanh.getSelectedRow();
        int MaPhong = (int) tblchiNhanh.getValueAt(y, 2);
        int MaChiNhanh = (int) tblchiNhanh.getValueAt(y, 0);
        HotelRoom a = PhongKhachSanDAO.Phong(MaChiNhanh, MaPhong);
        new ChinhSuaPhongKhachSan(a, this).setVisible(true);
        this.setEnabled(false);
        /*int y = tblchiNhanh.getSelectedRow();
        new ThongTin(nv.get(y), "GD").setVisible(true);
        // this.dispose();*/
    }//GEN-LAST:event_txtChinhSuaMouseClicked

    private void cbbChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChiNhanhActionPerformed
        // TODO add your handling code here:
        try {
            Branch chiNhanh = (Branch)cbbChiNhanh.getSelectedItem();
            showList(chiNhanh);
        } catch (Exception e) {
            showList();
        }
        
        
        System.out.println(chiNhanh);
    }//GEN-LAST:event_cbbChiNhanhActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhongKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhongKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhongKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhongKhachSan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyPhongKhachSan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbbChiNhanh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblchiNhanh;
    private javax.swing.JButton txtChinhSua;
    // End of variables declaration//GEN-END:variables
}