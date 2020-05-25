import javax.swing.*;
import java.awt.*;

class InfoPanel extends JPanel {
    GridBagConstraints gc;
    JTextField time;
    JTextField matchTime;
    JLabel finalLabel;
    JLabel rolex;
    Color gold;
    Color gray;
    
    public InfoPanel() {
        setBackground(new Color(0, 80, 0));
        gold = new Color(255, 215, 0);
        gray = new Color(40, 40, 40);
        
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;
        
        gc.gridx = 0;
        gc.gridy = 1;
        time = new JTextField("14:05");
        time.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        time.setHorizontalAlignment(SwingConstants.CENTER);
        time.setEditable(false);
        time.setForeground(gold);
        time.setBackground(gray);
        time.setFont(new Font("", Font.PLAIN, 24));
        add(time, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        matchTime = new JTextField("0:05");
        matchTime.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        matchTime.setHorizontalAlignment(SwingConstants.CENTER);
        matchTime.setEditable(false);
        matchTime.setForeground(gold);
        matchTime.setBackground(gray);
        matchTime.setFont(new Font("", Font.PLAIN, 24));
        add(matchTime, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 3;
        gc.anchor = GridBagConstraints.CENTER;
        finalLabel = new JLabel("FINAL");
        finalLabel.setFont(new Font("", Font.PLAIN, 25));
        finalLabel.setForeground(Color.white);
        add(finalLabel, gc);
              
        gc.gridx = 1;
        gc.gridy = 3;
        gc.gridheight = 1;
        gc.anchor = GridBagConstraints.CENTER;
        JLabel rolex = new JLabel("ROLEX");
        rolex.setForeground(new Color(255, 215, 0));
        add(rolex, gc);  
    }
}