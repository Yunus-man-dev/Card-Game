import java.util.ArrayList;
import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Ahmet Zeki Eralp Yiğit Boz
// date:
public class CardGameTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Start of CardGameTest\n");

        // CONSTANTS

        // VARIABLES
        Card a = new Card(0);
        Card b = new Card(12);
        Card c = new Card(25);

        Cards cards = new Cards(true);
        Cards onTable = new Cards(false);
        ScoreCard scores = new ScoreCard(4);
        Player p1 = new Player("Player1");
        Player p2 = new Player("Player2");
        Player p3 = new Player("Player3");
        Player p4 = new Player("Player4");
        CardGame game = new CardGame(p1, p2, p3, p4);

        // PROGRAM CODE

        // test Card class
        System.out.println("Card\n");
        System.out.println("Card 1: " + a);
        System.out.println();
        System.out.println("Card 2: " + b);
        System.out.println();
        System.out.println("Card 3: " + c);

        System.out.println("Face value of a: " + a.getFaceValue());
        System.out.println("Suit of a: " + a.getSuit());
        System.out.println("a equals b? " + a.equals(b));
        System.out.println("b compareTo c: " + b.compareTo(c));

        // test Cards class
        System.out.println("\nCards\n");
        System.out.println("Full deck created. Number of cards: " + cards.getValid());
        cards.shuffle();
        System.out.println(cards.getTopCard());
        cards.addTopCard(a);
        System.out.println(cards.getTopCard());
        System.out.println(cards.getTopCard());
        System.out.println(cards.getTopCard());
        System.out.println("Number of cards: " + cards.getValid());

        // test ScoreCard class
        System.out.println("\nScoreCard");
        scores = new ScoreCard(4);
        scores.update(1, 1);
        scores.update(2, 2);
        scores.update(3, 3);
        scores.update(4, 1);
        System.out.println("\n" + scores);
        System.out.println("winenr: " + scores.getWinners());

        // test Player class
        System.out.println("\nPlayer\n");
        p1.add(a);
        p1.add(new Card(10));
        p1.add(new Card(17));
        p2.add(b);
        p2.add(new Card(34));
        p3.add(new Card(40));
        p3.add(new Card(41));
        p4.add(new Card(4));
        p4.add(new Card(27));

        Card played = p1.playCard();
        System.out.println("Cards in hand: " + p1.hand.getValid());
        System.out.println("Player 1 play:" + played);
        System.out.println("Remain cards number: " + p1.hand.getValid());

        // test CardGame class
        System.out.println("\nCardGame\n");
        System.out.println("Player1's name: " + game.getName(0));
        System.out.println("Player2's name: " + game.getName(1));

        System.out.println("Game round number: " + game.getRoundNo());
        System.out.println("Turn of player no: " + game.getTurnOfPlayerNo());
        System.out.println("Is it Player1's turn? " + game.isTurnOf(p1));

        boolean playedTurn = game.playTurn(p1, a);
        System.out.println("Player1  play card a: " + playedTurn);

        System.out.println("Is game over? " + game.isGameOver());

        System.out.println("ScoreCard:\n" + game.showScoreCard());

        Player[] winners = game.getWinners();
        System.out.println("Winner(s):");
        for (Player w : winners) {
            System.out.println(w.getName());
        }

        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.

        System.out.println("\nEnd of CardGameTest\n");
    }

} // end of class CardGameTest
