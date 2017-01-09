import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by mattmorgan on 2/3/16.
 */


/**
 * tests the Card Comparator
 */
public class CardComparatorTest {
  /**
   * tests cards with difference values
   */
  @Test
  public void testCompareValue() {
    Card H5 = new Card(Card.Suit.Heart,Card.Value.Five);
    Card H4 = new Card(Card.Suit.Heart,Card.Value.Four);
    assertEquals(new CardComparator().compare(H4, H5), 1);
  }

  @Test
  public void testCompareValue2() {
    Card H5 = new Card(Card.Suit.Heart,Card.Value.Five);
    Card H4 = new Card(Card.Suit.Heart,Card.Value.Four);
    assertEquals(new CardComparator().compare(H5, H4), -1);
  }

  /**
   * tests comparing equal cards
   */
  @Test
  public void testCompareSame() {
    Card H5 = new Card(Card.Suit.Heart,Card.Value.Five);
    Card H5copy = new Card(Card.Suit.Heart,Card.Value.Five);
    assertEquals(new CardComparator().compare(H5, H5copy), 0);
  }

  /**
   * test comparing by suit
   */
  @Test
  public void testCompareSuite1() {
    Card H5 = new Card(Card.Suit.Heart,Card.Value.Five);
    Card C4 = new Card(Card.Suit.Club,Card.Value.Four);
    assertEquals(new CardComparator().compare(H5, C4), 1);
  }

  @Test
  public void testCompareSuite2() {
    Card H5 = new Card(Card.Suit.Heart,Card.Value.Five);
    Card C4 = new Card(Card.Suit.Club,Card.Value.Four);
    assertEquals(new CardComparator().compare(C4, H5), -1);
  }


}
