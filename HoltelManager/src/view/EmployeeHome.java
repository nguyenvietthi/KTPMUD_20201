/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Bean.Branch;
import Bean.Employee;
import Bean.HotelRoom;
import DAO.BranchDAO;
import DAO.AttendanceDAO;
import DAO.BillDAO;
import DAO.NhanVienDAO;
import DAO.PhongKhachSanDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import thread.Clock;

/**
 *
 * @author VIETTHI_PC
 */
public class EmployeeHome extends javax.swing.JFrame {

    /**
     * Creates new form HomeF
     */
    private List<JPanel> list;
    private Employee nhanVien;
    private Branch branch;
    private List<HotelRoom> listR;
    private int[] ListMaHoaDon = new int[12];

    public EmployeeHome(int EmployeeNumber) {
        initComponents();
        Clock n = new Clock(clock);
        n.start();
        setInit(EmployeeNumber);
        setList();
        ShowRoom();
        setUI();
    }

    private void setInit(int EmployeeNumber) {
        nhanVien = NhanVienDAO.getEmployee(EmployeeNumber);
        branch = BranchDAO.getBranch(nhanVien.getBranchCode());
    }

    private void ShowRoom() {
        int soPhong = PhongKhachSanDAO.SoPhongChiNhanh(nhanVien.getBranchCode());
        for (int i = 11; i >= soPhong; i--) {
            list.get(i).removeAll();
            list.get(i).setOpaque(false);
        }
    }

    void setList() {
        list = new ArrayList<>();
        list.add(Room1);
        list.add(Room2);
        list.add(Room3);
        list.add(Room4);
        list.add(Room5);
        list.add(Room6);
        list.add(Room7);
        list.add(Room8);
        list.add(Room9);
        list.add(Room10);
        list.add(Room11);
        list.add(Room12);
        listR = PhongKhachSanDAO.getListPhongKhachSan(nhanVien.getBranchCode());
    }

    private void setUI() {
        for (int i = 0; i < listR.size(); i++) {
            if (listR.get(i).isStatus()) {
                list.get(i).setBackground(new java.awt.Color(255, 153, 102));
                ListMaHoaDon[i] = BillDAO.getBill(i + 1, nhanVien.getBranchCode()).getBillCode();
            } else {
                list.get(i).setBackground(new java.awt.Color(247, 247, 247));
            }
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(ListMaHoaDon[i]);
        }
        EmployeeName.setText("NHÂN VIÊN: " + nhanVien.getName().toUpperCase());
        txtChiNhanh.setText("Chi Nhánh " + branch.getBranchName());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        homejp = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnNhapKho = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dd = new javax.swing.JPanel();
        btnDiemDanh = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtChiNhanh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Room4 = new javax.swing.JPanel();
        txtR4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Room1 = new javax.swing.JPanel();
        txtR1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Room2 = new javax.swing.JPanel();
        txtR2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Room3 = new javax.swing.JPanel();
        txtR3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Room8 = new javax.swing.JPanel();
        txtR8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Room5 = new javax.swing.JPanel();
        txtR5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Room6 = new javax.swing.JPanel();
        txtR6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Room7 = new javax.swing.JPanel();
        txtR7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Room12 = new javax.swing.JPanel();
        txtR12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Room9 = new javax.swing.JPanel();
        txtR9 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Room10 = new javax.swing.JPanel();
        txtR10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Room11 = new javax.swing.JPanel();
        txtR11 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        EmployeeName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - Nhan Vien");
        setLocation(new java.awt.Point(369, 145));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(179, 205, 224));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 91, 150));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_business_girl_hotel_room_120px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WELCOME");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 52, -1, -1));

        homejp.setBackground(new java.awt.Color(100, 151, 177));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TRANG CHỦ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout homejpLayout = new javax.swing.GroupLayout(homejp);
        homejp.setLayout(homejpLayout);
        homejpLayout.setHorizontalGroup(
            homejpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        homejpLayout.setVerticalGroup(
            homejpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(homejp, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 280, 300, 60));

        pnNhapKho.setBackground(new java.awt.Color(100, 151, 177));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("KHO");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnNhapKhoLayout = new javax.swing.GroupLayout(pnNhapKho);
        pnNhapKho.setLayout(pnNhapKhoLayout);
        pnNhapKhoLayout.setHorizontalGroup(
            pnNhapKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );
        pnNhapKhoLayout.setVerticalGroup(
            pnNhapKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(pnNhapKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 305, -1));

        dd.setBackground(new java.awt.Color(100, 151, 177));

        btnDiemDanh.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnDiemDanh.setForeground(new java.awt.Color(255, 255, 255));
        btnDiemDanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDiemDanh.setText("ĐIỂM DANH");
        btnDiemDanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDiemDanhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDiemDanhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDiemDanhMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ddLayout = new javax.swing.GroupLayout(dd);
        dd.setLayout(ddLayout);
        ddLayout.setHorizontalGroup(
            ddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDiemDanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );
        ddLayout.setVerticalGroup(
            ddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDiemDanh, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 305, -1));

        jPanel4.setBackground(new java.awt.Color(204, 102, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setToolTipText("");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_exit_50px_1.png"))); // NOI18N
        jLabel32.setText("Đăng xuất");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel32MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 730, 200, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 800));

        txtChiNhanh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtChiNhanh.setText("Chi Nhánh Hai Bà Trưng");
        jPanel1.add(txtChiNhanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_delete_52px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, -1, -1));

        clock.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clock.setText("20:22:30 AM");
        clock.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                clockAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 100, 40));

        jPanel10.setLayout(new java.awt.CardLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Room4.setBackground(new java.awt.Color(247, 247, 247));
        Room4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR4MouseClicked(evt);
            }
        });
        Room4.add(txtR4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Phòng 04");
        Room4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 190, 170));

        Room1.setBackground(new java.awt.Color(247, 247, 247));
        Room1.setEnabled(false);
        Room1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR1MouseClicked(evt);
            }
        });
        Room1.add(txtR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        Room1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Phòng 01");
        Room1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 190, 170));

        Room2.setBackground(new java.awt.Color(247, 247, 247));
        Room2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR2MouseClicked(evt);
            }
        });
        Room2.add(txtR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Phòng 02");
        Room2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 190, 170));

        Room3.setBackground(new java.awt.Color(247, 247, 247));
        Room3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR3MouseClicked(evt);
            }
        });
        Room3.add(txtR3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Phòng 03");
        Room3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 190, 170));

        Room8.setBackground(new java.awt.Color(247, 247, 247));
        Room8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR8MouseClicked(evt);
            }
        });
        Room8.add(txtR8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Phòng 08");
        Room8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 190, 170));

        Room5.setBackground(new java.awt.Color(247, 247, 247));
        Room5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR5MouseClicked(evt);
            }
        });
        Room5.add(txtR5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Phòng 05");
        Room5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 190, 170));

        Room6.setBackground(new java.awt.Color(247, 247, 247));
        Room6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR6MouseClicked(evt);
            }
        });
        Room6.add(txtR6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Phòng 06");
        Room6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 190, 170));

        Room7.setBackground(new java.awt.Color(247, 247, 247));
        Room7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR7MouseClicked(evt);
            }
        });
        Room7.add(txtR7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Phòng 07");
        Room7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 190, 170));

        Room12.setBackground(new java.awt.Color(247, 247, 247));
        Room12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR12MouseClicked(evt);
            }
        });
        Room12.add(txtR12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Phòng 12");
        Room12.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 190, 170));

        Room9.setBackground(new java.awt.Color(247, 247, 247));
        Room9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR9MouseClicked(evt);
            }
        });
        Room9.add(txtR9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Phòng 09");
        Room9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 190, 170));

        Room10.setBackground(new java.awt.Color(247, 247, 247));
        Room10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR10MouseClicked(evt);
            }
        });
        Room10.add(txtR10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Phòng 10");
        Room10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 190, 170));

        Room11.setBackground(new java.awt.Color(247, 247, 247));
        Room11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtR11MouseClicked(evt);
            }
        });
        Room11.add(txtR11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 170));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_room_120px_1.png"))); // NOI18N
        Room11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 0, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("Phòng 11");
        Room11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 127, -1, -1));

        jPanel7.add(Room11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 190, 170));

        jPanel10.add(jPanel7, "card2");

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 890, 700));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel30.setText("Khách Sạn HUST");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        EmployeeName.setText("NHÂN VIÊN: NGUYỄN VIỆT THI");
        EmployeeName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeNameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EmployeeNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EmployeeNameMouseExited(evt);
            }
        });
        jPanel1.add(EmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 1190, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        homejp.setBackground(new Color(204, 102, 0));

    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        homejp.setBackground(new Color(100, 151, 177));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        pnNhapKho.setBackground(new Color(204, 102, 0));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        pnNhapKho.setBackground(new Color(100, 151, 177));
    }//GEN-LAST:event_jLabel4MouseExited

    private void btnDiemDanhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiemDanhMouseEntered
        // TODO add your handling code here:
        dd.setBackground(new Color(204, 102, 0));
    }//GEN-LAST:event_btnDiemDanhMouseEntered

    private void btnDiemDanhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiemDanhMouseExited
        // TODO add your handling code here:
        dd.setBackground(new Color(100, 151, 177));
    }//GEN-LAST:event_btnDiemDanhMouseExited

    private void jLabel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseEntered

    private void jLabel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseExited

    private void btnDiemDanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiemDanhMouseClicked
        // TODO add your handling code here:
        //System.out.println(AttendanceDAO.Check(nhanVien.getEmployeeNumber()));
        if (!AttendanceDAO.check(nhanVien.getEmployeeCode())) {
            if (AttendanceDAO.attendant(nhanVien)) {
                JOptionPane.showMessageDialog(this, "Điểm danh thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hôm nay bạn đã điểm danh!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDiemDanhMouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel32MouseClicked

    private void EmployeeNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeNameMouseEntered
        // TODO add your handling code here:
        EmployeeName.setForeground(new Color(100, 151, 177));
    }//GEN-LAST:event_EmployeeNameMouseEntered

    private void EmployeeNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeNameMouseExited
        // TODO add your handling code here:
        EmployeeName.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_EmployeeNameMouseExited

    private void clockAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_clockAncestorAdded
        // TODO add your handling code here

    }//GEN-LAST:event_clockAncestorAdded

    private void EmployeeNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeNameMouseClicked
        // TODO add your handling code here:
        new ThongTin(nhanVien, "NV").setVisible(true);

    }//GEN-LAST:event_EmployeeNameMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txtR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR1MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(1);
    }//GEN-LAST:event_txtR1MouseClicked

    private void txtR2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR2MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(2);
    }//GEN-LAST:event_txtR2MouseClicked

    private void txtR3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR3MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(3);
    }//GEN-LAST:event_txtR3MouseClicked

    private void txtR4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR4MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(4);
    }//GEN-LAST:event_txtR4MouseClicked

    private void txtR5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR5MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(5);
    }//GEN-LAST:event_txtR5MouseClicked

    private void txtR6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR6MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(6);
    }//GEN-LAST:event_txtR6MouseClicked

    private void txtR7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR7MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(7);
    }//GEN-LAST:event_txtR7MouseClicked

    private void txtR8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR8MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(8);
    }//GEN-LAST:event_txtR8MouseClicked

    private void txtR9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR9MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(9);
    }//GEN-LAST:event_txtR9MouseClicked

    private void txtR10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR10MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(10);
    }//GEN-LAST:event_txtR10MouseClicked

    private void txtR11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR11MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(11);
    }//GEN-LAST:event_txtR11MouseClicked

    private void txtR12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtR12MouseClicked
        // TODO add your handling code here:
        checkTrangThaiNhanPhong(12);
    }//GEN-LAST:event_txtR12MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new Kho(nhanVien).setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void checkTrangThaiNhanPhong(int MaPhong) {
        if (!listR.get(MaPhong - 1).isStatus()) {
            new NhapThongTinKhachHang(MaPhong, this).setVisible(true);
        } else {
            new ThanhToan(MaPhong, ListMaHoaDon[MaPhong - 1], branch.getBranchCode() , this).setVisible(true);
        }
    }

    protected void traPhong(int MaPhong) {
        listR.get(MaPhong - 1).setStatus(false);
        if (PhongKhachSanDAO.setPhong(listR.get(MaPhong - 1))) {
            ListMaHoaDon[MaPhong - 1] = 0;
            setUI();
        }
    }

    protected void nhanPhong(int MaPhong, int MaKhachHang) {
        int click = JOptionPane.showConfirmDialog(this, "Xác nhận nhận phòng!", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (click == 0) {
            if (BillDAO.addBill(nhanVien, listR.get(MaPhong - 1).getRoomCode(), MaKhachHang, 0.1)) {
                listR.get(MaPhong - 1).setStatus(true);
                if (PhongKhachSanDAO.setPhong(listR.get(MaPhong - 1))) {
                    ListMaHoaDon[MaPhong - 1] = BillDAO.getBill(MaPhong, nhanVien.getBranchCode()).getBillCode();
                    setUI();
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmployeeName;
    private javax.swing.JPanel Room1;
    private javax.swing.JPanel Room10;
    private javax.swing.JPanel Room11;
    private javax.swing.JPanel Room12;
    private javax.swing.JPanel Room2;
    private javax.swing.JPanel Room3;
    private javax.swing.JPanel Room4;
    private javax.swing.JPanel Room5;
    private javax.swing.JPanel Room6;
    private javax.swing.JPanel Room7;
    private javax.swing.JPanel Room8;
    private javax.swing.JPanel Room9;
    private javax.swing.JLabel btnDiemDanh;
    private javax.swing.JLabel clock;
    private javax.swing.JPanel dd;
    private javax.swing.JPanel homejp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel pnNhapKho;
    private javax.swing.JLabel txtChiNhanh;
    private javax.swing.JLabel txtR1;
    private javax.swing.JLabel txtR10;
    private javax.swing.JLabel txtR11;
    private javax.swing.JLabel txtR12;
    private javax.swing.JLabel txtR2;
    private javax.swing.JLabel txtR3;
    private javax.swing.JLabel txtR4;
    private javax.swing.JLabel txtR5;
    private javax.swing.JLabel txtR6;
    private javax.swing.JLabel txtR7;
    private javax.swing.JLabel txtR8;
    private javax.swing.JLabel txtR9;
    // End of variables declaration//GEN-END:variables

}
