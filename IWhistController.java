/**
 * Created by mattmorgan on 2/8/16.
 */
import java.io.IOException;

/**
 * interface for the Controller of Whist
 */
public interface IWhistController {
  /**
   * Starts the game provided the number of players
   * When the caller calls this method, that call ends only when the game has ended.
   * @param game the game model for this game
   * @param numPlayers the number of players to start this game
   */
  void startGame(CardGameModel game, int numPlayers) throws IOException;
}
