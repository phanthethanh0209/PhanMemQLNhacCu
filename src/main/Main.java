
package main;

import component.Header;
import component.Menu;
import event.EventMenuSelected;
import event.EventShowPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.animation.Animation;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import ql_cuahang_nhaccu_form.FormMain;
import ql_cuahang_nhaccu_form.FormHome;
import ql_cuahang_nhaccu_form.Frm_HoaDon;
import ql_cuahang_nhaccu_form.Frm_KhachHang;
import ql_cuahang_nhaccu_form.Frm_KhuyenMai;
import ql_cuahang_nhaccu_form.Frm_LoaiSP;
import ql_cuahang_nhaccu_form.Frm_NhaCungCap;
import ql_cuahang_nhaccu_form.Frm_NhanVien;
import ql_cuahang_nhaccu_form.Frm_PhieuNhap;
import ql_cuahang_nhaccu_form.Frm_SanPham;
import ql_cuahang_nhaccu_form.Frm_ThuongHieu;
import ql_cuahang_nhaccu_form.Frm_testconnect;
import swing.MenuItem;
import swing.PopupMenu;
import swing.icon.GoogleMaterialDesignIcons;
import swing.icon.IconFontSwing;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private FormMain main;
    private Animator animator;
    
    public Main() {
        initComponents();
        init();
    }
    
    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
//  "fill" có nghĩa là các thành phần con sẽ được căn chỉnh và mở rộng để lấp đầy không gian của cell cha.
        
//  "0[]0[100%, fill]0" có nghĩa là có hai cột, cột thứ hai có chiều rộng là 100% và căn chỉnh fill.
//  Chiều rộng là 100%: Điều này có nghĩa là cột sẽ được thiết lập với chiều rộng là 100% của không gian cung cấp
//  Căn chỉnh fill: Điều này chỉ định rằng các thành phần con nằm trong cột sẽ được căn chỉnh
//  và mở rộng để lấp đầy toàn bộ không gian của cột đó.

//  "0[fill, top]0" - Hàng này có khoảng trống ở trên và dưới,
//  và các thành phần trong hàng được lấp đầy toàn bộ không gian theo chiều cao có sẵn của layout
//  và được căn chỉnh lên trên của hàng.
//sử dụng các ràng buộc trong MigLayout để xác định kích thước và vị trí của các thành phần trong giao diện.
// Khi cửa sổ thay đổi kích thước, các thành phần sẽ tự động điều chỉnh dựa trên các ràng buộc này.(responsive)

        bg.setLayout(layout);
        menu  = new Menu();
        header = new Header();
        main = new FormMain();
        // viết nội dung cho các sk đã khai báo bên interface
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
//                System.out.println("Menu Index: " + menuIndex + " Sub menu: " + subMenuIndex);
                if(menuIndex == 0){
                    main.showForm(new FormHome());
                }
                if(menuIndex == 1) {
                    if(subMenuIndex == 0) {
                        main.showForm(new Frm_PhieuNhap());
                    }else if(subMenuIndex == 1) {
                        main.showForm(new Frm_NhaCungCap());
                    }else if(subMenuIndex == 2) {
                        main.showForm(new Frm_LoaiSP());
                    }else if(subMenuIndex == 3) {
                        main.showForm(new Frm_ThuongHieu());
                    }else if(subMenuIndex == 4) {
                        main.showForm(new Frm_SanPham());
                    }
                }else if(menuIndex == 2) {
                    if(subMenuIndex == 0) {
                        main.showForm(new Frm_HoaDon());
                    }else if(subMenuIndex == 1) {
                        main.showForm(new Frm_KhachHang());
                    }else if(subMenuIndex == 2) {
                        main.showForm(new Frm_KhuyenMai());
                    }
                }
                else if(menuIndex == 3) {
//                    main.showForm(new Frm_TraCuu());
                    main.showForm(new Frm_NhanVien());
                }
                else if(menuIndex == 4) {
//                    main.showForm(new Frm_TraCuu());
                }
                else if(menuIndex == 5) {
//                    main.showForm(new Frm_NhanVien());
                }
            }
        });
        // sự kiện mở menu dạng nhỏ
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem)com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 60;
                int y = Main.this.getY() + com.getY() + 126;
//                System.out.println( Main.this.getX());
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        
        menu.initMenuItem(); // khởi tạo menu
        bg.add(menu, "w 230!,  spany 2");    // chiều rộng 230 pixel và chiếm một số lượng hàng là 2.   
        bg.add(header, "h 50!, wrap"); // cao 50 pixel và sẽ được wrap (xuống dòng) sau khi thêm vào.
        bg.add(main, "w 100%, h 100%");

        // đóng mở menu
        TimingTarget target = new TimingTargetAdapter(){
            // phương thức đc gọi trong quá trình thực hiện hiệu ứng
            @Override
            public void timingEvent(float f) {
                double width;
                // nếu menu đang mở thì thu menu và ngược lại
                if(menu.isShowMenu()){
                    width = 60 + (170*(1f-f));
                }else{
                    width = 60 + (170*f);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2"); // set lại chiều rộng cho menu (tức là đóng hoặc mở menu)
                menu.revalidate(); // vẽ lại menu với chiều rộng mới
            }

            //Phương thức được gọi khi hiệu ứng kết thúc
            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu()); // sẽ đặt lại menu (tức là menu đã đóng thì set đã đóng và ngược lại)
                menu.setEnableMenu(true); // menu đc phép sử dụng
            }

        };
        
//        khi gọi phương thức animator.start(), 
//        nó sẽ bắt đầu chạy hiệu ứng và kích hoạt các hàm trong TimingTarget, bao gồm cả timingEvent
        animator = new Animator(500, target);
        animator.setResolution(0); //thiết lập độ phân giải
        animator.setDeceleration(0.5f);//thiết lập độ giảm tốc của animator.
        animator.setAcceleration(0.5f); //thiết lập độ tăng tốc của animator.
        // khi click vào nút đóng menu ở header
        header.addMenuEvent(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { // nếu header đc click
                if(!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false); // khi animator running thì menu sẽ kh đc phép sd
                if(menu.isShowMenu()) { // menu đc bật thì ẩn các menu 
                    menu.hideAllMenu();
                }
            }
        });
        // init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        
        main.showForm(new FormHome()); // bắt đầu là form Home
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1474, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 855, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
