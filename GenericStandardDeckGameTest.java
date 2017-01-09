import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by mattmorgan on 2/3/16.
 */


/**
 * tests the methods in GenericStandardDeckGame
 */
public class GenericStandardDeckGameTest {

  /**
   * tests the getDeck method
   */
  @Test
  public void testGetDeck1() {
    GenericStandardDeckGame g1 =
      new GenericStandardDeckGame(new ArrayList<Player>(), new ArrayList<Card>());
    g1.getDeck();
  }

  /**
   * tests StartPlay's exceptions
   * @throws Exception Illegal ArgumentException when deck is too small
   */
  @Test(expected = IllegalArgumentException.class) public void testStartPlay1() {
    Card ha = new Card(Card.Suit.Heart, Card.Value.A);
    Card hk = new Card(Card.Suit.Heart, Card.Value.K);
    Card s7 = new Card(Card.Suit.Spade, Card.Value.Seven);
    Card c3 = new Card(Card.Suit.Club, Card.Value.Three);
    Card d2 = new Card(Card.Suit.Diamond, Card.Value.Two);
    Card c3copy = new Card(Card.Suit.Club, Card.Value.Three);
    Player carrie = new Player(new ArrayList<Card>(Arrays.asList(s7, hk, c3copy, d2, ha, c3)));

    GenericStandardDeckGame g1 =
      new GenericStandardDeckGame(new ArrayList<Player>(),
        new ArrayList<Card>(Arrays.asList(s7, hk, c3copy, d2, ha, c3)));

    g1.startPlay(1, new ArrayList<Card>(Arrays.asList(s7, hk, c3copy, d2, ha, c3)));
  }

  /**
   * tests StartPlay's exceptions
   * @throws Exception Illegal ArgumentException when not enough players
   */
  @Test(expected = IllegalArgumentException.class) public void testStartPlay2() {
    GenericStandardDeckGame g1 =
      new GenericStandardDeckGame(new ArrayList<Player>(), new ArrayList<Card>());
    g1.startPlay(0, new ArrayList<Card>());
  }

  /**
   * tests the the method actually distributes cards
   */
  @Test public void testStartPlay3() {
    GenericStandardDeckGame g = new GenericStandardDeckGame();
    Card ha = new Card(Card.Suit.Heart, Card.Value.A);
    Card hk = new Card(Card.Suit.Heart, Card.Value.K);
    Card s7 = new Card(Card.Suit.Spade, Card.Value.Seven);
    Card c3 = new Card(Card.Suit.Club, Card.Value.Three);
    Card d2 = new Card(Card.Suit.Diamond, Card.Value.Two);
    Card c3copy = new Card(Card.Suit.Club, Card.Value.Three);

    g.startPlay(g.numPlayers(), g.deck);
    assertEquals(g.players.get(0).hand.size(), 26);
    assertEquals(g.players.get(1).hand.size(), 26);

  }

  /**
   * test the numplayers gives the correct number of players
   */
  @Test
  public void testNumPlayers1() {
    GenericStandardDeckGame g = new GenericStandardDeckGame();
    assertEquals(g.numPlayers(), 2);
  }


  /**
   * tests getgamestate when noone has cards
   */
  @Test
  public void testGetGameState1() {
    GenericStandardDeckGame g = new GenericStandardDeckGame();
    assertEquals(g.getGameState(), "Number of players: 2\nPlayer 1 : \nPlayer 2 : ");

  }

  /**
   * tests getgamestate when the cards have been dealt
   */
  @Test
  public void testGetGameState2() {
    GenericStandardDeckGame g = new GenericStandardDeckGame();

    GenericStandardDeckGame p = new GenericStandardDeckGame
      (new ArrayList<Player>(Arrays.asList(new Player(new ArrayList<Card>()),
        new Player(new ArrayList<Card>()),
        new Player(new ArrayList<Card>()))), new ArrayList<Card>());



    assertEquals(p.getGameState(), "Number of players: 3\nPlayer 1 : \nPlayer 2 : \nPlayer 3 : ");
    g.startPlay(2, g.deck);
    assertEquals(g.getGameState(), "Number of players: 2\nPlayer 1 : " +
      g.players.get(0).printHand() + "\nPlayer 2 : " + g.players.get(1).printHand());

  }
}
