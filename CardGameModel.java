/**
 * Created by mattmorgan on 2/8/16.
 */
public interface CardGameModel<K> extends GenericCardGameModel<K> {

  /**
   * Plays the card at the given index at in the given player's hand
   * @param playerNo the player we are looking at
   * @param cardIdx the index of the card in the given player's hand
   */
  void play(int playerNo, int cardIdx);

  /**
   * tells us the player that is currently playing
   * @return the int of the player currently playing
   */
  int getCurrentPlayer();

  /**
   * decides if the game is over
   * @return true if the game is over, false otherwise.
   */
  boolean isGameOver();

}
