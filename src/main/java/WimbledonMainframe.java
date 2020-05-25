import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WimbledonMainframe extends JFrame{
    public JPanel contentPanel;
    private InfoPanel infoPanel;
    private ScorePanel scorePanel;
    private ButtonPanel buttonPanel;
    private Match match;
    public NewMatchDialog newMatchDialog;
    public Border padding;
    
    public WimbledonMainframe() {
        super("Wimbledon Final");
        
        getContentPane().setBackground(new Color(0, 80, 0));
        
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        padding = BorderFactory.createLineBorder(new Color(0, 80, 0), 10);
        contentPanel.setBorder(padding);

        setContentPane(contentPanel);
        
        infoPanel = new InfoPanel();
        contentPanel.add(infoPanel, BorderLayout.PAGE_START);
        
        scorePanel = new ScorePanel();
        contentPanel.add(scorePanel, BorderLayout.CENTER);
        
        buttonPanel = new ButtonPanel();
        contentPanel.add(buttonPanel, BorderLayout.PAGE_END);
        
        newMatchDialog = new NewMatchDialog();
        buttonPanel.setButtonListener(new ButtonListener() {
            public void buttonEventOccurred(ButtonEvent e) {
                String action = e.getAction();
                if (action ==  "new") {
                    getPlayerInfo();
                }
                else if(action == "point") {
                    match.playPoint();
                }
                else if(action == "game") {
                    match.playGame();
                }
                else if(action == "set") {
                    match.playSet();
                }
                else if(action == "match") {
                    match.playMatch();
                }
                if (match != null) {
                    scorePanel.setScore(match);
                    if (match.isMatchDone()) {
                        buttonPanel.deactivateInGameButtons();
                    }
                }
                
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setVisible(true);
    }
    
    private void getPlayerInfo() {
        int result = JOptionPane.showConfirmDialog(WimbledonMainframe.this, newMatchDialog, 
        "Player Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                Player player1 = new Player(newMatchDialog.getPlayer1Name(), Float.parseFloat(newMatchDialog.getPlayer1Prob()));
                Player player2 = new Player(newMatchDialog.getPlayer2Name(), Float.parseFloat(newMatchDialog.getPlayer2Prob()));
                
                match = new Match(player1, player2); 
                buttonPanel.activateInGameButtons();
            } catch (NumberFormatException ev) {
                JOptionPane.showMessageDialog(WimbledonMainframe.this, "Probabilities must be in range (0, 1)");
                getPlayerInfo();
            } catch (IllegalArgumentException ev) {
                JOptionPane.showMessageDialog(WimbledonMainframe.this, "Probabilities must be in range (0, 1)");
                getPlayerInfo();
            }
        }
    }
}