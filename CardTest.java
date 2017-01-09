/**
 * Created by mattmorgan on 2/18/16.
 */

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mattmorgan on 2/3/16.
 */


/**
 * tests methods in card class
 */
public class CardTest {
  /**
   * tests printing a card
   */
  @Test
  public void testPrintCard1() {
    Card SA = new Card(Card.Suit.Spade,Card.Value.A);
    assertEquals("A♠", SA.toString());
  }
}
