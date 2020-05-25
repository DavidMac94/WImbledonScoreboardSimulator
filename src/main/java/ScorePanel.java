import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class ScorePanel extends JPanel {
    private JLabel previousSetsLabel;
    private JLabel setsLabel;
    private JLabel gamesLabel;
    private JLabel pointsLabel;
    private JTextField player1Set1;
    private JTextField player1Set2;
    private JTextField player1Set3;
    private JTextField player1Set4;
    private JTextField player2Set1;
    private JTextField player2Set2;
    private JTextField player2Set3;
    private JTextField player2Set4;
    private JTextField player1Tiebreak1;
    private JTextField player1Tiebreak2;
    private JTextField player1Tiebreak3;
    private JTextField player1Tiebreak4;
    private JTextField player2Tiebreak1;
    private JTextField player2Tiebreak2;
    private JTextField player2Tiebreak3;
    private JTextField player2Tiebreak4;
    private JTextField player1Name;
    private JTextField player2Name;
    private JLabel versusLabel;
    private JTextField player1Sets;
    private JTextField player1Games;
    private JTextField player1Points;
    private JTextField player2Sets;
    private JTextField player2Games;
    private JTextField player2Points;
    private HideableComponent<ServingDot> player1ServingDot;
    private HideableComponent<ServingDot> player2ServingDot;
    
    private GridBagConstraints gc;
    private Insets insets;
    
    private ArrayList<JTextField> scoreTextFields;
    private ArrayList<JTextField> tiebreakTextFields;
    
    private Color gold;
    private Color gray;
    private Color green;
    
    
    public ScorePanel() {
        setBackground(new Color(0, 80, 0));
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        insets = new Insets(0, 2, 0, 2);
        
        gray = new Color(40, 40, 40);
        gold = new Color(255, 215, 0);
        green = new Color(0, 80, 0);
        
        
        previousSetsLabel = new JLabel("PREVIOUS SETS");
        previousSetsLabel.setFont(new Font("", Font.PLAIN, 12));
        previousSetsLabel.setForeground(Color.white);
        addToLayout(previousSetsLabel, 0, 0, 4, 1, 0f, 0f);
        
        player1Name = new JTextField("");
        player1Name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        player1Name.setHorizontalAlignment(SwingConstants.CENTER);
        player1Name.setEditable(false);
        player1Name.setForeground(gold);
        player1Name.setBackground(gray);
        player1Name.setFont(new Font("", Font.PLAIN, 24));
        gc.fill = GridBagConstraints.HORIZONTAL;
        addToLayout(player1Name, 4, 1, 1, 1, 1f, 1f);
        
        player2Name = new JTextField("");
        player2Name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        player2Name.setHorizontalAlignment(SwingConstants.CENTER);
        player2Name.setEditable(false);
        player2Name.setForeground(gold);
        player2Name.setBackground(gray);
        player2Name.setFont(new Font("", Font.PLAIN, 24));
        addToLayout(player2Name, 4, 3, 1, 1, 1, 1f);
        
        gc.fill = GridBagConstraints.NONE;
        
        versusLabel = new JLabel("v");
        versusLabel.setForeground(gold);
        versusLabel.setFont(new Font("", Font.PLAIN, 18));
        JPanel versusLabelPanel = new JPanel();
        versusLabelPanel.setBackground(green);
        versusLabelPanel.add(versusLabel);
        addToLayout(versusLabelPanel, 4, 2, 1, 1, 0.8f, 0f);
        
        setsLabel = new JLabel("SETS");
        setsLabel.setFont(new Font("", Font.PLAIN, 12));
        setsLabel.setForeground(Color.white);
        addToLayout(setsLabel, 6, 0, 1, 1, 0f, 1f);
        
        gamesLabel = new JLabel("GAMES");
        gamesLabel.setFont(new Font("", Font.PLAIN, 12));
        gamesLabel.setForeground(Color.white);
        addToLayout(gamesLabel, 7, 0, 1, 1, 0f, 1f);
        
        pointsLabel = new JLabel("POINTS");
        pointsLabel.setFont(new Font("", Font.PLAIN, 12));
        pointsLabel.setForeground(Color.white);
        addToLayout(pointsLabel, 8, 0, 1, 1, 0f, 1f);
        
        scoreTextFields = new ArrayList<>();
        
        player1Set1 = new JTextField("", 1);
        scoreTextFields.add(player1Set1);
        addToLayout(player1Set1, 0, 1, 1, 1, 0f, 1f);
        
        player1Set2 = new JTextField("", 1);
        scoreTextFields.add(player1Set2);
        addToLayout(player1Set2, 1, 1, 1, 1, 0f, 1f);
        
        player1Set3 = new JTextField("", 1);
        scoreTextFields.add(player1Set3);
        addToLayout(player1Set3, 2, 1, 1, 1, 0f, 1f);
        
        player1Set4 = new JTextField("", 1);
        scoreTextFields.add(player1Set4);
        addToLayout(player1Set4, 3, 1, 1, 1, 0f, 1f);
        
        player2Set1 = new JTextField("", 1);
        scoreTextFields.add(player2Set1);
        addToLayout(player2Set1, 0, 3, 1, 1, 0f, 1f);
        
        player2Set2 = new JTextField("", 1);
        scoreTextFields.add(player2Set2);
        addToLayout(player2Set2, 1, 3, 1, 1, 0f, 1f);
        
        player2Set3 = new JTextField("", 1);
        scoreTextFields.add(player2Set3);
        addToLayout(player2Set3, 2, 3, 1, 1, 0f, 1f);
        
        player2Set4 = new JTextField("", 1);
        scoreTextFields.add(player2Set4);
        addToLayout(player2Set4, 3, 3, 1, 1, 0f, 1f);
        
        player1Sets = new JTextField("", 2);
        scoreTextFields.add(player1Sets);
        addToLayout(player1Sets, 6, 1, 1, 1, 0f, 1f);
        
        player1Games = new JTextField("", 2);
        scoreTextFields.add(player1Games);
        addToLayout(player1Games, 7, 1, 1, 1, 0f, 1f);
        
        player1Points = new JTextField("", 2);
        scoreTextFields.add(player1Points);
        addToLayout(player1Points, 8, 1, 1, 1, 0f, 1f);
        
        player2Sets = new JTextField("", 2);
        scoreTextFields.add(player2Sets);
        addToLayout(player2Sets, 6, 3, 1, 1, 0f, 1f);
        
        player2Games = new JTextField("", 2);
        scoreTextFields.add(player2Games);
        addToLayout(player2Games, 7, 3, 1, 1, 0f, 1f);
        
        player2Points = new JTextField("", 2);
        scoreTextFields.add(player2Points);
        addToLayout(player2Points, 8, 3, 1, 1, 0f, 1f);
        
        for (JTextField textField: scoreTextFields) {
            textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
            textField.setEditable(false);
            textField.setForeground(gold);
            textField.setBackground(gray);
            textField.setFont(new Font("", Font.PLAIN, 24));
        }
        
        tiebreakTextFields = new ArrayList<>();
        
        gc.anchor = GridBagConstraints.PAGE_START;
        
        player1Tiebreak1 = new JTextField("", 2);
        tiebreakTextFields.add(player1Tiebreak1);
        addToLayout(player1Tiebreak1, 0, 2, 1, 1, 0f, 0f);
        
        player1Tiebreak2 = new JTextField("", 2);
        tiebreakTextFields.add(player1Tiebreak2);
        addToLayout(player1Tiebreak2, 1, 2, 1, 1, 0f, 0f);
        
        player1Tiebreak3 = new JTextField("", 2);
        tiebreakTextFields.add(player1Tiebreak3);
        addToLayout(player1Tiebreak3, 2, 2, 1, 1, 0f, 0f);
        
        player1Tiebreak4 = new JTextField("", 2);
        tiebreakTextFields.add(player1Tiebreak4);
        addToLayout(player1Tiebreak4, 3, 2, 1, 1, 0f, 0f);
        
        player2Tiebreak1 = new JTextField("", 2);
        tiebreakTextFields.add(player2Tiebreak1);
        addToLayout(player2Tiebreak1, 0, 4, 1, 1, 0f, 0f);
        
        player2Tiebreak2 = new JTextField("", 2);
        tiebreakTextFields.add(player2Tiebreak2);
        addToLayout(player2Tiebreak2, 1, 4, 1, 1, 0f, 0f);
        
        player2Tiebreak3 = new JTextField("", 2);
        tiebreakTextFields.add(player2Tiebreak3);
        addToLayout(player2Tiebreak3, 2, 4, 1, 1, 0f, 0f);
        
        player2Tiebreak4 = new JTextField("", 2);
        tiebreakTextFields.add(player2Tiebreak4);
        addToLayout(player2Tiebreak4, 3, 4, 1, 1, 0f, 0f);
        
        for (JTextField textField: tiebreakTextFields) {
            textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            textField.setHorizontalAlignment(SwingConstants.CENTER);
            textField.setEditable(false);
            textField.setForeground(Color.white);
            textField.setBackground(green);
            textField.setFont(new Font("", Font.PLAIN, 10));
        }
        
        gc.anchor = GridBagConstraints.CENTER;
        player1ServingDot = new HideableComponent<ServingDot>(new ServingDot());
        player1ServingDot.setHidden(true);
        addToLayout(player1ServingDot, 5, 1, 1, 1, 0f, 0f);
        
        player2ServingDot = new HideableComponent<ServingDot>(new ServingDot());
        player2ServingDot.setHidden(true);
        addToLayout(player2ServingDot, 5, 3, 1, 1, 0f, 0f);
    }
    
    private <E extends JComponent> void addToLayout(E e, int x, int y, int width, int height, float weightx, float weighty) {
        // Do gridbag stuff
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.insets = insets;
        gc.weightx = weightx;
        gc.weighty = weighty;
        add(e, gc);
    }
    
    public void setScore(Match match) {
        player1Set1.setText(match.player1.previousSetScore1);
        player1Set2.setText(match.player1.previousSetScore2);
        player1Set3.setText(match.player1.previousSetScore3);
        player1Set4.setText(match.player1.previousSetScore4);
        player2Set1.setText(match.player2.previousSetScore1);
        player2Set2.setText(match.player2.previousSetScore2);
        player2Set3.setText(match.player2.previousSetScore3);
        player2Set4.setText(match.player2.previousSetScore4);
        player1Tiebreak1.setText(match.player1.previousTiebreakScore1);
        player1Tiebreak2.setText(match.player1.previousTiebreakScore2);
        player1Tiebreak3.setText(match.player1.previousTiebreakScore3);
        player1Tiebreak4.setText(match.player1.previousTiebreakScore4);
        player2Tiebreak1.setText(match.player2.previousTiebreakScore1);
        player2Tiebreak2.setText(match.player2.previousTiebreakScore2);
        player2Tiebreak3.setText(match.player2.previousTiebreakScore3);
        player2Tiebreak4.setText(match.player2.previousTiebreakScore4);
        player1Name.setText(match.player1.name);
        player2Name.setText(match.player2.name);
        player1Sets.setText(Integer.toString(match.player1.sets));
        player1Games.setText(Integer.toString(match.player1.games));
        player2Sets.setText(Integer.toString(match.player2.sets));
        player2Games.setText(Integer.toString(match.player2.games));
        
        if (match.isInTiebreak() || match.isMatchDone()) {
            player1Points.setText(Integer.toString((match.player1.points)));
            player2Points.setText(Integer.toString((match.player2.points)));
        }
        else {
            player1Points.setText(changeToGameScore(match.player1.points));
            player2Points.setText(changeToGameScore(match.player2.points));
        }
        
        if (match.player1.serving) {
            player1ServingDot.setHidden(false);
            player2ServingDot.setHidden(true);
        }
        else {
            player1ServingDot.setHidden(true);
            player2ServingDot.setHidden(false);
        }
    }
    
    public String changeToGameScore(int score) {
        String[] gameScores = {"0", "15", "30", "40", "A"};
        return gameScores[score];
    }
    
    class ServingDot extends JPanel {
        public void paint(Graphics g) {
            g.setColor(new Color(255, 215, 0));
            g.fillOval(0, 0, 10, 10);
        }
    }
}