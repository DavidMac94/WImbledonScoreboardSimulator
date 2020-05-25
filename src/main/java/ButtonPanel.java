import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel{
    private JButton newButton;
    private JButton pointButton;
    private JButton gameButton;
    private JButton setButton;
    private JButton matchButton;
    private ButtonListener buttonListener;
    
    public ButtonPanel() {
        setBackground(new Color(0, 80, 0));
        
        newButton = new JButton("New Match");
        pointButton = new JButton("Play Point");
        gameButton = new JButton("Play Game");
        setButton = new JButton("Play Set");
        matchButton = new JButton("Play Match");
        
        deactivateInGameButtons();
        
        add(newButton);
        add(pointButton);
        add(gameButton);
        add(setButton);
        add(matchButton);
        
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "new";
                
                ButtonEvent ev = new ButtonEvent(this, action);
                
                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });
        
        pointButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "point";
                
                ButtonEvent ev = new ButtonEvent(this, action);
                
                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });
        
        gameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "game";
                
                ButtonEvent ev = new ButtonEvent(this, action);
                
                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });
        
        setButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "set";
                
                ButtonEvent ev = new ButtonEvent(this, action);
                
                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });
        
        matchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "match";
                
                ButtonEvent ev = new ButtonEvent(this, action);
                
                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });
        
        
        
    }
    
    public void setButtonListener (ButtonListener listener) {
        this.buttonListener = listener;
    }
    
    public void activateInGameButtons() {
        pointButton.setEnabled(true);
        gameButton.setEnabled(true);
        setButton.setEnabled(true);
        matchButton.setEnabled(true);
    }
    
    public void deactivateInGameButtons() {
        pointButton.setEnabled(false);
        gameButton.setEnabled(false);
        setButton.setEnabled(false);
        matchButton.setEnabled(false);
    }
    
}