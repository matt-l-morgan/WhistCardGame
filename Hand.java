import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created by mattmorgan on 2/9/16.
 */
public class Hand {

  /**
   * the list of cards that is the current hand of the game
   */
  private List<Card> cards;

  /**
   * the current suit for the hand
   */
  private Card.Suit currentSuit;

  /**
   * zero agument constuctor that initalizes a hand
   */
  public Hand() {
    this.cards = new ArrayList<Card>();
    this.currentSuit = null;
  }

  /**
   * adds a card to a hand's cards
   * @param newCard
   */
  public void addCard(Card newCard) {
    this.cards.add(newCard);
  }

  /**
   * resets the current hand to the start
   */
  public void resetHand() {
    this.cards = new ArrayList<Card>();
    this.currentSuit = null;
  }

  /**
   * removes the given card from the hand's cards.
   * @param card the card to be removed.
   */
  public void removeCard(Card card) {
    this.cards.remove(card);
  }

  /**
   * changes the current suit of the hand
   * @param suit the suit to be changed to
   */
  public void changeSuit(Card.Suit suit) {
    this.currentSuit = suit;
  }

  /**
   * gives the current suit of the hand
   * @return the currentSuit of the hand
   */
  public Card.Suit giveSuit() {
    return this.currentSuit;
  }

  /**
   * give the current cards
   * @return the cards of the current have
   */
  public List<Card> giveCards(){
    return this.cards;
  }

  /**
   * tells us the highest value card in the list of cards
   * @return the card with the highest value
   */
  public Card highestCard() {
    return Collections.max(this.cards, new CardComparator());
  }

  /**
   * decides if each card is valid, if so, it buts it in the new validcard list
   * @return the list of valid cards
   */
  public List<Card> validCards() {
    List<Card> valid_cards = new ArrayList<Card>();
    for (int i = 0; i < this.cards.size(); i++) {
      Card curr_card = this.cards.get(i);
      if (curr_card.getSuit() == this.currentSuit) {
        valid_cards.add(curr_card);
      }
    }
    return  valid_cards;
  }
}
