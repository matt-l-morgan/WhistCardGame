import java.util.Objects;

/**
 * Created by mattmorgan on 2/1/16.
 */

public class Card {
  /**
   * an enum of the suite of a card, only possible suits are:
   * clubs, diamonds, hearts, spades
   */
  public enum Suit {
    Club("♣"), Diamond("♦"), Heart("♥"), Spade("♠");
    private final String asString;
    Suit(String asString) {
      this.asString = asString;
    }

    /**
     * gives the string representation of a suit
     * @return the asString field of this suit
     */
    public String toString(){
      return this.asString;
    }
  }
  public enum Value {
    A("A"), K("K"), Q("Q"), J("J"), Ten("10"), Nine("9"), Eight("8"), Seven("7"),
    Six("6"), Five("5"), Four("4"), Three("3"), Two("2");
    /**
     * a value as a string
     */
    private final String asString;

    /**
     * the constructor for a Value
     * @param asString the string representation of a Value
     */
    Value(String asString) {
      this.asString = asString;
    }

    public String toString(){
      return this.asString;
    }
  }

  /**
   * the suite of the given card
   */
  final Suit suit;
  /**
   * the Value of a card
   */
  final Value value;

  /**
   * prints a card as a string
   * @return a string representation of this card.
   */
  public String toString(){
    return value.toString() + suit.toString();
  }


  /**
   * constructor of a card
   * @param suite the suite of the card
   * @param value the value of the card
   */
  public Card(Suit suit, Value value) {
    this.suit = Objects.requireNonNull(suit);
    this.value = Objects.requireNonNull(value);
  }

  /**
   * gets the suit of this card
   * @return the suit of the current card
   */
  public Suit getSuit(){
    return this.suit;
  }


  /**
   * overriding equals for Card class
   * @param c another card
   * @return a boolean of equality
   */
  public boolean equals(Card c){
    return ((this.value == c.value) && (this.suit == c.suit));
  }


}
