
package model;

import javax.swing.Icon;

public class ModelMenu {
    Icon icon;
    private String menuName;
    private String subMenu[];

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String[] getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }

//  Dấu ba chấm (...) trong khai báo tham số cho phép truyền vào bất kỳ số lượng tham số nào,
// và các tham số đó đc lưu vào biến subMenu dưới dạng mảng các chuỗi
    public ModelMenu(Icon icon, String menuName, String... subMenu) {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }

    public ModelMenu() {
    }

    

    
}
