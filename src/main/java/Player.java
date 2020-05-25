public class Player{
    public String name;
    public float prob;
    public int points;
    public int games;
    public int sets;
    public boolean serving;
    public String previousSetScore1;
    public String previousTiebreakScore1;
    public String previousSetScore2;
    public String previousTiebreakScore2;
    public String previousSetScore3;
    public String previousTiebreakScore3;
    public String previousSetScore4;
    public String previousTiebreakScore4;
    
    public Player(String name, float prob){
        this.name = name;
        if (prob <= 0 || prob >= 1) {
            throw new IllegalArgumentException("Probability is not in valid range.");
        }
        this.prob = prob;
        points = 0;
        games = 0;
        sets = 0;
        serving = false;
        previousSetScore1 = "";
        previousTiebreakScore1 = "";
        previousSetScore2 = "";
        previousTiebreakScore2 = "";
        previousSetScore3 = "";
        previousTiebreakScore3 = "";
        previousSetScore4 = "";
        previousTiebreakScore4 = "";
    }
}