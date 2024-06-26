
package swing;

import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuAnimation {
    private final MigLayout layout;
    private final MenuItem menuItem;
    private Animator animator;
    private boolean open;

    public MenuAnimation(MigLayout layout, Component component) {
        this.layout = layout;
        this.menuItem = (MenuItem)component;
        initAnimator(component, 200);
    }
    
    public MenuAnimation(MigLayout layout, Component component, int duration) {
        this.layout = layout;
        this.menuItem = (MenuItem)component;
        initAnimator(component, duration);
    }

    private void initAnimator(Component component, int duration) {
        int height = component.getPreferredSize().height; // chiều cao của component
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {//sự kiện xảy ra trong quá trình thực hiện animation
            //fraction là phần trăm của quãng thời gian đã trôi qua trong quá trình animation (0-1)
                float h;
                if(open) { // Kiểm tra xem menu có đang mở hay không để xác định chiều cao của menu.
                    h = 40 + ((height-40) * fraction); //  tính toán chiều cao mới của menuItem
                    menuItem.setAlpha(fraction); // đặt độ trong suốt của menuItem
                }
                else{
                    h = 40 + ((height-40) * (1f - fraction)); 
                    menuItem.setAlpha(1f - fraction);
                }
                
                // đặt lại ràng buộc của thành phần menuItem với chiều cao mới
                layout.setComponentConstraints(menuItem, "h " + h + "!");
                component.revalidate(); // yêu cầu hệ thống làm mới bố cục của component
                component.repaint(); //vẽ lại component để hiển thị lại menuItem với chiều cao mới đã được cập nhật.
            }
        };
        animator = new Animator(duration, target);
        animator.setResolution(0); // đặt độ phân giải (resolution) của animator, độ phân giải tối ưu mặc định.
        animator.setDeceleration(0.5f); // đặt hệ số giảm tốc (deceleration) cho animation, 0.5f cho biết rằng animation sẽ được giảm tốc với mức độ vừa phải
    }
    
    public void openMenu() {
        open = true;
        animator.start();
    }
    
    public void closeMenu() {
        open = false;
        animator.start();
    }
    
    
}
