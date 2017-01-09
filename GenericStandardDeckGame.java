import java.util.*;

/**
 * Created by mattmorgan on 2/1/16.
 */
public class GenericStandardDeckGame implements GenericCardGameModel<Card> {

  /**
   * represents the  players in a game in a list
   */
  List<Player> players;

  /**
   * the deck from a Generic Standard Deck Game
   */
  List<Card> deck;


  /**
   * gets the deck of cards required for the given gamee
   * @return an entire deck of cards as a list<Cards>
   */
  @Override
  public List<Card> getDeck() {
    deck = new ArrayList<Card>();
    for (Card.Suit s : Card.Suit.values()) {
      for (Card.Value v : Card.Value.values()) {
        deck.add(new Card(s,v));
      }
    }
    return deck;
  }

  /**
   * starts play of a card game by distributing
   * @param numPlayers the number of players playing the game
   *                   throws exception if less than one.
   */
  @Override
  public void startPlay(int numPlayers, List<Card> deck) {
    this.players.clear();
    if (!this.hasCorrectNumberOfPlayers(numPlayers)){
      throw new IllegalArgumentException("invalid number of players!");
    }
    else if (!this.isDeckValid()) {
      throw new IllegalArgumentException("invalid deck!");
    }
    for (int j = 0; j < numPlayers; j++) {
      //can create a seperate Create player method.
      this.players.add(new Player());
    }
    for (int i = 0; i < deck.size(); i++) {
      players.get(i % numPlayers).addCard(deck.get(i));
    }
  }

  public boolean hasCorrectNumberOfPlayers(int num){
    return num > 0;
  }

  public boolean isDeckValid(){
    Set<Card> card_set = new HashSet<Card>(this.deck);
    return
      (this.deck.size() == 52) &&
      (deck.size() == card_set.size()) &&
      (!card_set.contains(null));
  }

  /**
   * uses the list of players to determine howmany players there are.
   * @return the number of players
   */
  public int numPlayers(){
    return players.size();
  }



  /**
   * details the current state of the game
   * @return a string describing the the current state of the game
   * in the following format:
   * Number of players: N (printed as a normal decimal number)
   * Player 1: cards in sorted order (printed as a comma-separated list)
   * Player 2: cards in sorted order (printed as a comma-separated list)
   * ...
   * Player N: cards in sorted order (printed as a comma-separated list)
   */
  @Override
  public String getGameState() {
    String message = String.format("Number of players: %d", players.size());
    for (int i = 0; i < players.size(); i++) {
      message = message + String.format("\nPlayer %d : ", (i + 1)) + players.get(i).printHand();
    }
    return message;
  }

  /**
   * construct for a Generic Standard DeckGame with no parameters
   */
  public GenericStandardDeckGame() {
    this.players = new ArrayList<Player>(Arrays.asList(
      new Player(new ArrayList<Card>()), new Player(new ArrayList<Card>())));
    this.deck = this.getDeck();
  }

  /**
   * construct for a Generic Standard DeckGame
   */
  public GenericStandardDeckGame(List<Player> players, List<Card> deck) {
    this.players = players;
    this.deck = deck;
  }

}
