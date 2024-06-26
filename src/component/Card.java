
package component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import model.ModelCard;

public class Card extends javax.swing.JPanel {

    public Color getColorGradient() {
        return colorGradient;
    }

    public void setColorGradient(Color colorGradient) {
        this.colorGradient = colorGradient;
    }

    private Color colorGradient;
    public Card() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(112,69,246));
        colorGradient = new Color(255,255,255);
        pro.setBackground(new Color(255,255,255,100));
        pro.setForeground(Color.WHITE);
    }
    
    public void setData(ModelCard data) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lbTitle.setText(data.getTitle());
        lbValues.setText(df.format(data.getValues()));
        lbIcon.setIcon(data.getIcon());
        pro.setValue(data.getPercentage());
        lbPer.setText(df.format(data.getPercentage()) + "%");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbValues = new javax.swing.JLabel();
        lbPer = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        pro = new swing.ProgressBarCustom();
        lbTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(214, 217, 223));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbValues.setBackground(new java.awt.Color(214, 217, 223));
        lbValues.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbValues.setForeground(new java.awt.Color(255, 255, 255));
        lbValues.setText("Values");

        lbPer.setBackground(new java.awt.Color(214, 217, 223));
        lbPer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPer.setForeground(new java.awt.Color(255, 255, 255));
        lbPer.setText("0%");

        lbIcon.setBackground(new java.awt.Color(214, 217, 223));
        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbTitle.setBackground(new java.awt.Color(214, 217, 223));
        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("Tittle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValues)
                            .addComponent(lbTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pro, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPer)
                        .addGap(4, 4, 4))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbValues))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0,getHeight(), getBackground(), getWidth(), 0, colorGradient);
        g2.setPaint(gra); // Thiết lập màu cho graphics
        g2.fillRect(0, 0, getWidth(), getHeight()); // vẽ hcn từ tọa độ (0,0) với kích thước full của Jpanel
        super.paintComponent(grphcs);
        super.paintComponent(grphcs); 
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbPer;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValues;
    private swing.ProgressBarCustom pro;
    // End of variables declaration//GEN-END:variables
}
