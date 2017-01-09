import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by mattmorgan on 2/3/16.
 */


/**
 * test all the methods in the PLayer class
 */
public class PlayerTest {

  /**
   * tests adding a card to empty hand
   */
  @Test
  public void testAddCard1() {
    Card h1 = new Card(Card.Suit.Heart, Card.Value.A);
    Player matt = new Player(new ArrayList<Card>());
    Player kim = new Player(new ArrayList<Card>(Arrays.asList(h1)));
    matt.addCard(h1);
    assertEquals(matt.hand, kim.hand);
  }

  /**
   * tests adding card to hang that contains cards already
   */
  @Test
  public void testAddCard2() {
    Card ha = new Card(Card.Suit.Heart,Card.Value.A);
    Card s7 = new Card(Card.Suit.Spade, Card.Value.Seven);
    Player matt = new Player(new ArrayList<Card>());
    Player kim = new Player(new ArrayList<Card>(Arrays.asList(ha, s7)));
    matt.addCard(ha);
    matt.addCard(s7);
    assertEquals(matt.hand, kim.hand);
  }

  /**
   * tests sorting cards
   */
  @Test
  public void testSortHand1() {
    Card ha = new Card(Card.Suit.Heart, Card.Value.A);
    Card hk = new Card(Card.Suit.Heart, Card.Value.K);
    Card s7 = new Card(Card.Suit.Spade, Card.Value.Seven);
    Card c3 = new Card(Card.Suit.Club, Card.Value.Three);
    Card d2 = new Card(Card.Suit.Diamond, Card.Value.Two);
    Card c3copy = new Card(Card.Suit.Club, Card.Value.Three);
    Player carrie = new Player(new ArrayList<Card>(Arrays.asList(s7, hk, c3copy, d2, ha, c3)));
    Player joe = new Player(new ArrayList<Card>(Arrays.asList(c3copy, c3, d2, ha, hk, s7)));
    carrie.sortHand();
    assertEquals(carrie.hand, joe.hand);
  }

  /**
   * test sorting hand that are empty
   */
  @Test
  public void testSortHand2() {
    Player carrie = new Player(new ArrayList<Card>());
    carrie.sortHand();
    assertEquals(carrie.hand, new ArrayList<Card>());
  }

  /**
   * tests printing a hand with one element
   */
  @Test
  public void testPrintHand1() {
    Card ha = new Card(Card.Suit.Heart, Card.Value.A);
    Player matt = new Player(new ArrayList<Card>(Arrays.asList(ha)));
    assertEquals(matt.printHand(), "A♥");
  }

  /**
   * tests printing an empty hand
   */
  @Test
  public void testPrintHand2() {
    Player matt = new Player(new ArrayList<Card>());
    assertEquals(matt.printHand(), "");
  }

  /**
   * tests printing a hand with many cards.
   */
  @Test
  public void testPrintHand3() {
    Card ha = new Card(Card.Suit.Heart, Card.Value.A);
    Card hk = new Card(Card.Suit.Heart, Card.Value.K);
    Card s7 = new Card(Card.Suit.Spade, Card.Value.Seven);
    Card c3 = new Card(Card.Suit.Club, Card.Value.Three);
    Card d2 = new Card(Card.Suit.Diamond, Card.Value.Two);
    Card c3copy = new Card(Card.Suit.Club, Card.Value.Three);
    Player carrie = new Player(new ArrayList<Card>(Arrays.asList(s7, hk, c3copy, d2, ha, c3)));
    assertEquals(carrie.printHand(), "7♠, K♥, 3♣, 2♦, A♥, 3♣");
  }

  /**
   * test the win methods for a player
   */
  @Test
  public void testwin() {
    Player carrie = new Player(new ArrayList<Card>());
    assertEquals(carrie.getWins(), 0);
    carrie.addWin();
    assertEquals(carrie.getWins(), 1);
  }

  @Test
  public void testgetPlayerCard() {
    Card ha = new Card(Card.Suit.Heart, Card.Value.A);
    Card hk = new Card(Card.Suit.Heart, Card.Value.K);
    Card s7 = new Card(Card.Suit.Spade, Card.Value.Seven);
    Card c3 = new Card(Card.Suit.Club, Card.Value.Three);
    Card d2 = new Card(Card.Suit.Diamond, Card.Value.Two);
    Card c3copy = new Card(Card.Suit.Club, Card.Value.Three);
    Player carrie = new Player(new ArrayList<Card>(Arrays.asList(s7, hk, c3copy, d2, ha, c3)));
    assertEquals(carrie.getPlayersCard(2), c3copy);
  }

  @Test
  public void testremovePlayersCard() {
    Card ha = new Card(Card.Suit.Heart, Card.Value.A);
    Card hk = new Card(Card.Suit.Heart, Card.Value.K);
    Card s7 = new Card(Card.Suit.Spade, Card.Value.Seven);
    Card c3 = new Card(Card.Suit.Club, Card.Value.Three);
    Card d2 = new Card(Card.Suit.Diamond, Card.Value.Two);
    Card c3copy = new Card(Card.Suit.Club, Card.Value.Three);
    Player carrie = new Player(new ArrayList<Card>(Arrays.asList(s7, hk, c3copy, d2, ha, c3)));
    carrie.removePlayersCard(hk);
    assertEquals(carrie.printHand(), "7♠, 3♣, 2♦, A♥, 3♣");
  }
}
