import javax.swing.*;
import java.awt.*;

public class NewMatchDialog extends JPanel {
    GridBagConstraints gc;
    JLabel player1NameLabel;
    JLabel player1ProbLabel;
    JLabel player2NameLabel;
    JLabel player2ProbLabel;
    JTextField player1NameText;
    JTextField player1ProbText;
    JTextField player2NameText;
    JTextField player2ProbText;
    
    public NewMatchDialog() {
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_END;
        
        player1NameLabel = new JLabel("Player 1 Name ");
        gc.gridx = 0; 
        gc.gridy = 0;
        add(player1NameLabel, gc);
        
        player1NameText= new JTextField(25);
        gc.gridx = 1; 
        gc.gridy = 0;
        add(player1NameText, gc);
        
        player2NameLabel = new JLabel("Player 2 Name ");
        gc.gridx = 0; 
        gc.gridy = 2;
        add(player2NameLabel, gc);
        
        player2NameText= new JTextField(25);
        gc.gridx = 1; 
        gc.gridy = 2;
        add(player2NameText, gc);
        
        player1ProbLabel = new JLabel("Player 1 Prob ");
        gc.gridx = 0; 
        gc.gridy = 1;
        add(player1ProbLabel, gc);
        
        player1ProbText= new JTextField(25);
        gc.gridx = 1; 
        gc.gridy = 1;
        add(player1ProbText, gc);
        
        player2ProbLabel = new JLabel("Player 2 Prob ");
        gc.gridx = 0; 
        gc.gridy = 3;
        add(player2ProbLabel, gc);
        
        player2ProbText= new JTextField(25);
        gc.gridx = 1; 
        gc.gridy = 3;
        add(player2ProbText, gc);
        
    }
    
    public String getPlayer1Name() {
        return player1NameText.getText();
    }
    
    public String getPlayer2Name() {
        return player2NameText.getText();
    }
    
    public String getPlayer1Prob() {
        return player1ProbText.getText();
    }
    
    public String getPlayer2Prob() {
        return player2ProbText.getText();
    }
}