
import java.util.*;

/**
 * Created by mattmorgan on 2/1/16.
 */
public interface GenericCardGameModel<K> {

  /**
   * gets the deck of cards required for the given game
   * @return an entire deck of cards as a list<K>
   */
  public <K> List<K> getDeck();


  /**
   * starts play of a card game by distributing
   * @param numPlayers the number of players playing the game
   *                   throws exception if:
   *                   - number of players is less than one.
   *                   - deck is invalid
   */
  public void startPlay(int numPlayers, List<K> deck);


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
  String getGameState();



}
