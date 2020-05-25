import java.lang.Math;

public class Match{
    Player player1;
    Player player2;
    boolean pointWinner;
    
    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        
        cointossToDecideInitialServer();
    }
        
    public void cointossToDecideInitialServer() {
        if (Math.random() < 0.5) {
            player1.serving = true;
        }
        else {
            player2.serving = true;
        }
    }
    
    public void playPoint() {
        getPointWinner();
        updateScore();
    }
        
        
    public void playGame() {
        while (true) {
            playPoint();
            if (isNewGame() || isMatchDone()) {
                break;
            } 
        }
    }
    
    public boolean isNewGame() {
        return ((player1.points == 0) && (player2.points == 0));
    }
        
    
    public void playSet() {
        while (true) {
            playGame();
            if (isNewSet() || isMatchDone()) {
                break;
            }
        }
    }
        
                
    public boolean isNewSet() {
        return ((player1.games == 0) && (player2.games == 0));
    }
        
    
    public void playMatch() {
        while (!isMatchDone()) {
            playSet();
        } 
    }
        
    
    public void getPointWinner() {
        if (player1.serving) {
            if (Math.random() < player1.prob) {
                pointWinner = true;
            }
            else {
                pointWinner = false;
            } 
        }
        else {
            if (Math.random() < player2.prob) {
                pointWinner = false;
            }
            else {
                pointWinner = true;
            }  
        }
    }
        
                
    public void updateScore() {
        if (!isInTiebreak()) {
            updateGameScore();
        }
        else {
            updateTiebreakScore();
        }
    }
        
    
    public void updateGameScore() {
        if (pointWinner) {
            if (player1.points <= 3 && player2.points <= 3) {
                player1.points += 1;
            }
            else if (player1.points == 4 ) {
                player1.points += 1;
            }   
            else if (player2.points == 4) {
                player2.points -= 1;
            }  
        }
        else {
            if (player1.points <= 3 && player2.points <= 3) {
                player2.points += 1;
            }
            else if (player2.points == 4) {
                player2.points += 1;
            }
            else if (player1.points == 4) {
                player1.points -= 1;
            }
        }   
        if (isGameDone()) {
            updateSetScore();
        }
    }
        
    
    public void updateSetScore() {
        if (player1.points > player2.points) {
            player1.games += 1;
        }  
        else {
            player2.games += 1;
        }
        player1.points = 0;
        player2.points = 0;
        changeServer();
        if (isSetDone()) {
            updateMatchScore();
        }
    }
        
    
    public void updateMatchScore() {
        if (player1.games > player2.games) {
            player1.sets += 1;
        }
        else {
            player2.sets += 1;
        }
        if (!isMatch5Sets()) {
            recordPreviousSetScore();
            player1.games = 0;
            player2.games = 0;
        }
    }
        
    
    public void updateTiebreakScore() {
        if (pointWinner) {
            player1.points += 1;
        }
        else {
            player2.points += 1;
        }
        if (isTiebreakDone()) {
            updateMatchScoreAfterTiebreak();
        } 
        else {
            changeServerInTiebreak();
        }
    }
        
    
    public void updateMatchScoreAfterTiebreak() {
        if (player1.points > player2.points) {
            player1.games += 1;
            player1.sets += 1;
        } 
        else {
            player2.games += 1;
            player2.sets += 1;
        }
        if (!isMatch5Sets()) {
            recordPreviousSetScore();
            recordPreviousTiebreakScore();
            changeServerAtEndOfTiebreak();
            player1.games = 0;
            player2.games = 0;
            player1.points = 0;
            player2.points = 0;
        }
            
    }
        
        
    public boolean isInTiebreak() {
        if (player1.games == 6 && player2.games == 6) {
            return true;
        }
        else {
            return false;
        }
    }
        
    
    public void changeServer() {
        player1.serving = !player1.serving;
        player2.serving = !player2.serving;
    }
    
    public void changeServerInTiebreak() {
        int points = player1.points + player2.points;
        if (points % 2 == 1) {
            changeServer();
        }
    }
        
    
    public void changeServerAtEndOfTiebreak() {
        int points = player1.points + player2.points;
        if (points % 4 == 0 || points % 4 == 1) {
            changeServer();
        }
            
    }
        
    
    public boolean isGameDone() {
        boolean gameDone = false;
        if (player1.points == 4 && player2.points <= 2) {
            gameDone = true;
        }  
        else if (player2.points == 4 && player1.points <= 2) {
            gameDone =true;
        } 
        else if (player1.points == 5 || player2.points == 5) {
            gameDone = true;
        } 
        return gameDone;
    }
        
    
    public boolean isTiebreakDone() {
        boolean tiebreakDone = false;
        if (player1.points == 7 && player2.points <= 5) {
            tiebreakDone = true;
        }  
        else if (player2.points == 7 && player1.points <= 5) {
            tiebreakDone = true;
        }
        else if (player1.points >=6 && player2.points >= 6 && Math.abs(player1.points - player2.points) == 2) {
            tiebreakDone = true;
        }
        return tiebreakDone;
    }
        
    
    public boolean isSetDone() {
        boolean setDone = false;
        if (player1.games == 6 && player2.games <=4) {
            setDone = true;
        } 
        else if (player2.games == 6 && player1.games <=4) {
            setDone = true;
        }
        else if (player1.games == 7 && player2.games == 5) {
            setDone = true;
        }
        else if (player2.games == 7 && player1.games == 5) {
            setDone = true;
        }
        return setDone;
    }
        
    
    public boolean isMatchDone() {
        return (player1.sets == 3 || player2.sets == 3);
    }
        
        
    public boolean isMatch5Sets() {
        int setsPlayed = player1.sets + player2.sets;
        return setsPlayed == 5;
    }
        
    
    public void recordPreviousSetScore() {
        int sets = player1.sets + player2.sets;
        if (sets == 1) {
            player1.previousSetScore1 = Integer.toString(player1.games);
            player2.previousSetScore1 = Integer.toString(player2.games);
        }
        else if (sets == 2) {
            player1.previousSetScore2 = Integer.toString(player1.games);
            player2.previousSetScore2 = Integer.toString(player2.games);
        }
        else if (sets == 3) {
            player1.previousSetScore3 = Integer.toString(player1.games);
            player2.previousSetScore3 = Integer.toString(player2.games);
        }
            
        else if (sets == 4) {
            player1.previousSetScore4 = Integer.toString(player1.games);
            player2.previousSetScore4 = Integer.toString(player2.games);
        }
    }
        

    public void recordPreviousTiebreakScore() {
        int sets = player1.sets + player2.sets;
        if (sets == 1) {
            player1.previousTiebreakScore1 = Integer.toString(player1.points);
            player2.previousTiebreakScore1 = Integer.toString(player2.points);
        }
        else if (sets == 2) {
            player1.previousTiebreakScore2 = Integer.toString(player1.points);
            player2.previousTiebreakScore2 = Integer.toString(player2.points);
        }
        else if (sets == 3) {
            player1.previousTiebreakScore3 = Integer.toString(player1.points);
            player2.previousTiebreakScore3 = Integer.toString(player2.points);
        } 
        else if (sets == 4) {
            player1.previousTiebreakScore4 = Integer.toString(player1.points);
            player2.previousTiebreakScore4 = Integer.toString(player2.points);
        }
    }
}