
package component;

import java.awt.event.ActionListener;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
    }
    
    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new swing.ImageAvatar();
        lbRole = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonBadges1 = new swing.ButtonBadges();
        buttonBadges2 = new swing.ButtonBadges();
        cmdMenu = new swing.ButtonBadges();

        setBackground(new java.awt.Color(255, 255, 255));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.jpg"))); // NOI18N

        lbRole.setForeground(new java.awt.Color(127, 127, 127));
        lbRole.setText("Admin");

        lbUserName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(127, 127, 127));
        lbUserName.setText("Username");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonBadges1.setForeground(new java.awt.Color(65, 196, 205));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/message.png"))); // NOI18N
        buttonBadges1.setBadges(5);

        buttonBadges2.setForeground(new java.awt.Color(255, 67, 67));
        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notification.png"))); // NOI18N
        buttonBadges2.setBadges(12);

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbUserName)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(459, Short.MAX_VALUE)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(143, 143, 143)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRole))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonBadges buttonBadges1;
    private swing.ButtonBadges buttonBadges2;
    private swing.ButtonBadges cmdMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private swing.ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
