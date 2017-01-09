import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
/**
 * Created by mattmorgan on 2/12/16.
 */
public class WhistControllerTest {
  /**
   * usues the
   * @param lines the outputs from the controller
   * @return
   */
  public static Interaction prints(String... lines) {
    return (input, output) -> {
      for (String line : lines) {
        output.append(line);
      }
    };
  }

  public static Interaction inputs(String in) {
    return (input, output) -> {
      input.append(in);
    };
  }
  @Test
  public void testController() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("");
    WhistController controller = new WhistController(in, out);
    controller.testRun(new WhistModel(), inputs("15 0 15"), prints(
      "Number of players: 2\n"
      + "Player 1 : A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n"
      + "Player 2 : K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n"
      + "Player 1 : 0 hands won\n" + "Player 2 : 0 hands won\n" + "Turn: Player 1\n"
      + "Number of players: 2\n"
      + "Player 1 : A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n"
      + "Player 2 : K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n"
      + "Player 1 : 0 hands won\n" + "Player 2 : 0 hands won\n" + "Turn: Player 2\n"
      + "Try again, that was invalid input: 0\n" + "Number of players: 2\n"
      + "Player 1 : A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n"
      + "Player 2 : K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦, K♥, J♥, 9♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n"
      + "Player 1 : 0 hands won\n" + "Player 2 : 0 hands won\n" + "Turn: Player 2\n"
      + "Number of players: 2\n"
      + "Player 1 : A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣, K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♥, Q♥, 8♥, 6♥, 4♥, 2♥, K♠, J♠, 9♠, 7♠, 5♠, 3♠\n"
      + "Player 2 : K♣, J♣, 9♣, 7♣, 5♣, 3♣, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦, K♥, J♥, 7♥, 5♥, 3♥, A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠\n"
      + "Player 1 : 0 hands won\n"
      + "Player 2 : 1 hands won\n"
      + "Turn: Player 1"));
  }
}
