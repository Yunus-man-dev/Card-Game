package cardgame;

import java.util.ArrayList;

// Cardgame
// author:Eralp Yiğit Boz, Ahmet Zeki
// date:
public class CardGame {
    // properties
    Cards fullPack;
    ArrayList<Player> players;
    ScoreCard scoreCard;
    Cards[] cardsOnTable;
    int roundNo;
    int turnOfPlayer;

    // constructors
    public CardGame(Player p1, Player p2, Player p3, Player p4) {
        // ToDo
        this.fullPack = new Cards(true);
        this.fullPack.shuffle();
        this.players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);

        for (int i = 0; i < 52; i++) {
            players.get(i % 4).add(fullPack.getTopCard());
        }
        cardsOnTable = new Cards[4];
        for (int i = 0; i < 4; i++) {
            cardsOnTable[i] = new Cards(false);
        }
        scoreCard = new ScoreCard(4);
        this.roundNo = 1;
        this.turnOfPlayer = 0;
    }

    // methods
    public boolean playTurn(Player p, Card c) {
        if (!isTurnOf(p) || c == null) { 
            return false;
        }

        
        cardsOnTable[turnOfPlayer].addTopCard(c);

        turnOfPlayer = (turnOfPlayer + 1) % 4;

        
        if (turnOfPlayer == 0) {
            int winnerIndex = -1;
            int highestValue = -1;

            
            for (int i = 0; i < 4; i++) {
                
                Card topCard = cardsOnTable[i].getTopCard();
                if (topCard != null) {
                    int value = topCard.getFaceValue();
                    if (value > highestValue) {
                        highestValue = value;
                        winnerIndex = i;
                    }
                }
            }

            if (winnerIndex != -1) {
                scoreCard.update(winnerIndex + 1, 1);
            }

            roundNo++;
        }
        return true;
    }

    public boolean isTurnOf(Player p) {

        if (p == players.get(getTurnOfPlayerNo())) {
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        for (Player p : players) {
            if (p.hand.getValid() > 0) {
                return false;
            }
        }
        return true;
    }

    public int getScore(int playerNumber) {
        // ToDo
        return scoreCard.getScore(playerNumber);
    }

    public String getName(int playerNumber) {
        return players.get(playerNumber).getName();
    }

    public int getRoundNo() {
        // ToDo

        return roundNo;
    }

    public int getTurnOfPlayerNo() {

        return turnOfPlayer;
    }

    public Player[] getWinners() {

        int playerOneScore = scoreCard.getScore(1);
        int playerTwoScore = scoreCard.getScore(2);
        int playerThreeScore = scoreCard.getScore(3);
        int playerFourScore = scoreCard.getScore(4);

        int maxScore = Math.max(
                Math.max(playerOneScore, playerTwoScore),
                Math.max(playerThreeScore, playerFourScore));

        int winnerCount = 0;
        if (playerOneScore == maxScore)
            winnerCount++;
        if (playerTwoScore == maxScore)
            winnerCount++;
        if (playerThreeScore == maxScore)
            winnerCount++;
        if (playerFourScore == maxScore)
            winnerCount++;

        Player[] winners = new Player[winnerCount];
        int index = 0;

        if (playerOneScore == maxScore) {
            winners[index] = players.get(0);
            index++;
        }
        if (playerTwoScore == maxScore) {
            winners[index] = players.get(1);
            index++;
        }
        if (playerThreeScore == maxScore) {
            winners[index] = players.get(2);
            index++;
        }
        if (playerFourScore == maxScore) {
            winners[index] = players.get(3);
            index++;
        }

        return winners;
    }

    public String showScoreCard() {
        return scoreCard.toString();
    }

}