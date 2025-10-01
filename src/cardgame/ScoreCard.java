package cardgame;

import java.util.ArrayList;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:Emir Zeybek
// date:01/10/25
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo-1];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo-1] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    

    // Yunus: this method always returns the player 1 in the arraylist, and t
    public ArrayList<Integer> getWinners()
    {
        // ToDo
        ArrayList<Integer> winnerPlayers = new ArrayList<>();
        int maxPoint = -1;
        for (int i = 0; i < scores.length; i++) {
            if( maxPoint < scores[i]){
                maxPoint = scores[i];
                winnerPlayers.add(i + 1);
            }
        }
        return winnerPlayers;

        
    }



    
} // end class ScoreCard
