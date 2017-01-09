import java.util.*;

/**
 * Created by mattmorgan on 2/3/16.
 */


/**
 * Represents a player in a game
 */
public class Player {

  /**
   * represents a list of cards in a player's hand
   */
  public List<Card> hand;

  /**
   * the number of wins the player currently has
   */
  private int wins;

  /**
   * adds a card to the player's hand
   * @param card the card that will be added.
   */
  public void addCard(Card card){
    this.hand.add(card);
  }


  /**
   * the constructor for a player
   * @param hand the cards a player has
   */
  public Player(List<Card> hand){
    this.hand = hand;
    this.wins = 0;
  }

  /**
   * a zero constructor for a player
   */
  public Player(){
    this.hand = new ArrayList<Card>();
    this.wins = 0;
  }

  /**
   * sorts a hand using the alphabetical card comparator
   */
  public void sortHand(){

    Collections.sort(hand, new CardComparator());
  }

  /**
   * prints a player's hand
   * @return a string is the cards in a player's hand.
   */
  public String printHand(){
    String stringhand = "";
    for(int i = 0; i < hand.size(); i++) {
      if ((i == hand.size() - 1) && (i == 0)) {
        stringhand = stringhand + hand.get(i).toString();
      }
      else if (i == hand.size() - 1){
        stringhand = stringhand + " " + hand.get(i).toString();
      }
      else if (i == 0) {
        stringhand = stringhand + hand.get(i).toString() + ",";
      }
      else {
        stringhand = stringhand + " " + hand.get(i).toString() + ",";
      }
    }
    return stringhand;
  }

  /**
   * returns the number of wins a player has
   * @return wins a player has
   */
  public int getWins() {
    return this.wins;
  }

  /**
   * adds a win to a player who won
   */
  public void addWin() {
    this.wins = this.wins + 1;
  }

  /**
   * gets the card from the player's have and the given index
   * @param cardIndex the index of the card in the player's hand
   * @return the card at this index
   */
  public Card getPlayersCard(int cardIndex) {
    return this.hand.get(cardIndex);
  }

  /**
   * give's a players hand
   * @return the List</Card> the player has
   */
  public List<Card> giveHand() {
    return this.hand;
  }


  /**
   * removes a player's card from his hand
   * @param card the card to be removed
   */
  public void removePlayersCard(Card card) {
    this.hand.remove(card);
  }

  /**
   * decides who had more wins
   * @param other_p the other person we are comaparing
   * @return the player iwth more wins
   */
  public Player hasMoreWins(Player other_p){
    if (this.wins > other_p.wins) {
      return this;
    }
    else {
      return other_p;
    }
  }

  /**
   * decides if a player has cards
   * @return true if the play has at least one card in hand, false otherwise.
   */
  public boolean hasCards(){
    return this.hand.size() > 0;
  }

  /**
   * decides if this player has the given card
   * @param card the card that is being searched for
   * @return true if the player has this card in their hand, false otherwise
   */
  public boolean hasCard(Card card) {
    if (this.hand.contains(card)) {
      return true;
    }
    else {
      return false;
    }
  }

  public boolean hasCardOfSuit(Card.Suit suit) {
    boolean has_suit = false;
    for (int i = 0; i < hand.size(); i++) {
      Card curr_card = hand.get(i);
      if (curr_card.getSuit() == suit) {
        has_suit = true;
      }
    }
    return has_suit;
  }

}
