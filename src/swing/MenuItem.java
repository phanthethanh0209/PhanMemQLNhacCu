
package swing;

import event.EventMenu;
import event.EventMenuSelected;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import model.ModelMenu;
import net.miginfocom.swing.MigLayout;

public class MenuItem extends javax.swing.JPanel {
    
    private float alpha;
    private ModelMenu menu;
    private boolean open;
    private EventMenuSelected eventSelected;
    private int index;

    public ModelMenu getMenu() {
        return menu;
    }
    
    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public EventMenuSelected getEventSelected() {
        return eventSelected;
    }

    public void setEventSelected(EventMenuSelected eventSelected) {
        this.eventSelected = eventSelected;
    }

    public int getIndex() {
        return index;
    }
    
    // Khởi tạo MenuItem
    public MenuItem(ModelMenu menu, EventMenu event, EventMenuSelected eventSelected, int index) {
        initComponents();
        this.menu = menu;
        this.eventSelected = eventSelected;
        this.index = index;
        setOpaque(false); // set cho MenuItem trong suốt 
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill,35!]"));
//"wrap": các thành phần sẽ được xếp hàng ngang khi không còn đủ không gian.
//"fillx": làm cho các thành phần trên cùng một hàng ngang sẽ được kéo dài theo chiều ngang.
//"insets 0": Đặt lề (padding) của layout thành 0, tức là không có lề nào xung quanh các thành phần.
        MenuButton firstItem = new MenuButton(menu.getIcon(),"     " + menu.getMenuName());
        Font f = new Font("Tahoma", Font.PLAIN , 16);
        firstItem.setFont(f);
        // khi Menu chính đc click
        firstItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(menu.getSubMenu().length>0){ // ktra mục menu cha có menu con nào không
                    if(event.menuPressed(MenuItem.this, !open)) {
                        open = !open;
                    }
                }
                eventSelected.menuSelected(index, -1);
            }
        });
        add(firstItem); // thêm menu button(firstItem) vào MenuItem để hiển thị trên giao diện
        
        // Submenu
        int subMenuIndex = -1;
        for(String st:menu.getSubMenu()) {
            MenuButton item = new MenuButton(st);
            item.setFont(f);
            item.setIndex(++subMenuIndex); // gán chỉ số index cho các menu con
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eventSelected.menuSelected(index, item.getIndex()); // biết được menu chính và menu con nào đã được chọn
                }
            });
            add(item);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getPreferredSize().height; // getPreferredSize() thường tính toán kích thước ưu tiên dựa trên nội dung bên trong của thành phần
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(50, 50, 50));
        
//AlphaComposite.SRC_OVER chỉ ra rằng pixel mới được vẽ sẽ chồng lên pixel đã có trên hình vẽ,
// sử dụng độ trong suốt của pixel mới để làm cho pixel kết quả.
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)); 
        g2.fillRect(0, 2, width, 38); // tô màu mới cho menu chính 
        g2.setComposite(AlphaComposite.SrcOver); // Khôi phục độ mờ về giá trị mặc định.
        g2.fillRect(0, 40, width, height - 40); // tô màu mới cho submenu  
        g2.setColor(new Color(100, 100, 100));
        g2.drawLine(30, 40, 30, height-17); // vẽ line cho các submenu tđ1(30, 40), tđ2(50, height-17), gốc là  tọa độ (0, 0) của g2
        for(int i = 0; i < menu.getSubMenu().length; i++) { // lặp qua các submenu để vẽ nhánh 
            int y = ((i+1) * 35 + 40) - 17;
            g2.drawLine(30, y, 38, y);
        }
        if(menu.getSubMenu().length > 0) {
            createArrowButton(g2);
        }
        
        super.paintComponent(grphcs);
    }

    // tạo icon down và up cho menu chính
    private void createArrowButton(Graphics2D g2) {
        int size = 4;
        int y = 19;
        int x = 205;
        g2.setColor(new Color(230, 230, 230));
        float ay = alpha * size;
        float ay1 = (1f-alpha)*size;
        g2.drawLine(x, (int)(y+ay), x+4, (int)(y+ay1));
        g2.drawLine(x+4 ,(int)(y+ay1), x+8,  (int)(y+ay));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
