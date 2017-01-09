import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.Format;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by mattmorgan on 2/12/16.
 */
public class WhistController implements IWhistController{
  final Readable rd;
  final Appendable ap;

  /**
   * constructor for a WhistController
   * @param rd the readable input the controller takes in
   * @param ap the appendable outpu the controller removes.
   */
  public WhistController(Readable rd, Appendable ap) {
    this.rd = rd;
    this.ap = ap;
  }

  @Override
  public void startGame(CardGameModel game, int numPlayers){
    List<Card> Cards = game.getDeck();
    Collections.shuffle(Cards);
    startGame(game, numPlayers, Cards);
  }

   void startGame(CardGameModel game, int numPlayers, List<Card> deck) {
    Objects.requireNonNull(game);
    Scanner scan = new Scanner(this.rd);
    while (!game.isGameOver() && scan.hasNext()) {
      int card_index = scan.nextInt();
      try {
          ap.append(game.getGameState() + "\n");
          game.play(game.getCurrentPlayer(), card_index);
      }
      catch (IllegalArgumentException e) {
        try {
          ap.append("Try again, that was invalid input: " + card_index +"\n");
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      ap.append(game.getGameState());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.print(this.ap.toString());
  }


  //Collections.Shuffle(deck) <-- to shuffle a deck in tests

  public void testRun(WhistModel model, Interaction... interactions) {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    WhistController controller = new WhistController(input, actualOutput);
    controller.startGame(new WhistModel(), 2);
    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }
}
