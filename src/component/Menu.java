package component;

import event.EventMenu;
import event.EventMenuSelected;
import event.EventShowPopupMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javafx.animation.Animation;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import swing.MenuAnimation;
import swing.MenuItem;
import swing.scrollbar.ScrollBarCustom;

public class Menu extends javax.swing.JPanel {

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }
    
    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
    }
    
    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/13.png")), "Trang chủ"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/1.png")), "Nhập hàng", "Phiếu nhập", "Nhà cung cấp", "Loại sản phẩm", "Thương hiệu", "Sản phẩm"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/2.png")), "Bán hàng", "Hóa đơn", "Khách hàng", "Khuyến mãi"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/3.png")), "Tra cứu"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/4.png")), "Thống kê", "Sender", "Inbox", "User"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/5.png")), "Nhân viên"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/6.png")), "Student", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/7.png")), "Library", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/8.png")), "Holiday", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/9.png")), "Calendar", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/10.png")), "Chat App", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/11.png")), "Contace", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/12.png")), "File Manager", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/13.png")), "Our Centres"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/14.png")), "Gallery"));
    }
    
    private void addMenu(ModelMenu menu){
        MenuItem menuItem = new MenuItem(menu, getEventMenu(), event, panel.getComponentCount());
        panel.add(menuItem, "h 40!");
    }
    
    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) { // khi click vào menu cha
                if(enableMenu) {
                    if(showMenu) {
                        if(open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    }else{
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }
    
    public void hideAllMenu() {
        for(Component com:panel.getComponents()) {
            MenuItem item = (MenuItem)com;
            if(item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile2 = new component.Profile();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(profile2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
//  phương thức dùng để vẽ nội dung của JPanel
// Hệ thống sẽ tự động gọi hàm paintComponent() của JPanel mỗi khi cần cập nhật giao diện,
// khi cửa sổ được mở hoặc kích thước của JPanel thay đổi.
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
// KEY_ANTIALIASING làm khóa và VALUE_ANTIALIAS_ON làm giá trị để bật chế độ làm mịn
// (anti-aliasing) cho các đường vẽ, giúp làm mịn các cạnh và góc của các hình vẽ.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
// Điểm đầu tiên của gradient(33,105,249) có tọa độ (0, 0)
// Điểm cuối của gradient(93,58,196) có tọa độ (getWidth(), 0)
//        GradientPaint gra = new GradientPaint(0,0, new Color(33,105,249), getWidth(), 0, new Color(93,58,196));
        GradientPaint gra = new GradientPaint(0,0, new Color(172,84,255), getWidth(), 0, new Color(0,177,255));
        g2.setPaint(gra); // Thiết lập màu cho graphics
        g2.fillRect(0, 0, getWidth(), getHeight()); // vẽ hcn từ tọa độ (0,0) với kích thước full của Jpanel
        super.paintComponent(grphcs);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private component.Profile profile2;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
