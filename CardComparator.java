import java.util.*;

/**
 * Created by mattmorgan on 2/3/16.
 */
public class CardComparator implements Comparator<Card> {


  /**
   * compares cards first alphabetically by their suit,
   * then by value of their card
   * @param c1 card
   * @param c2 second card
   * @return -1 is c1 < c2, 0 if c1 = c2, and 1 if c1 > c2
   */
  @Override public int compare(Card c1, Card c2) {
    if (c1.suit.compareTo(c2.suit) < 0) {
      return -1;
    }
    else if (c1.suit.compareTo(c2.suit) > 0) {
      return 1;
    }
    else {
      return c1.value.compareTo(c2.value);
    }
  }

  /**
   * constructor
   */
  public CardComparator(){};
}
