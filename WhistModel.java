import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mattmorgan on 2/8/16.
 */
public class WhistModel extends GenericStandardDeckGame implements CardGameModel<Card> {

  /**
   * represents the  players in a game in a list
   */
  private List<Player> players;

  /**
   * the deck from a Generic Standard Deck Game
   */
  private List<Card> deck;

  private Hand currentHand;

  /**
   * the player who's turn it currently is
   */
  private Player currentplayer;


  public WhistModel(){
    this.players = new ArrayList<Player>(Arrays.asList(
      new Player(new ArrayList<Card>()), new Player(new ArrayList<Card>())));

    this.deck = this.getDeck();
    this.currentHand = new Hand();
    this.currentplayer = this.players.get(0);
    this.dealDeck();
  }


  public void dealDeck() {
    for (int i = 0; i < deck.size(); i++) {
      int player_num = i % players.size();
      players.get(player_num).addCard(deck.get(i));
    }
    for (int j = 0; j < this.players.size(); j++) {
      Collections.sort(players.get(j).hand,new CardComparator());
    }
  }

  /**
   * Plays the card at the given index at in the given player's hand
   * makes the next player the current player
   * A player's cards are assumed to be sorted
   * @param playerNo the player we are looking at
   * @param cardIdx the index of the card in the given player's hand
   */
  @Override
  public void play(int playerNo, int cardIdx) {
    Player currplayer = players.get(playerNo);
    Card currcard = currplayer.getPlayersCard(cardIdx);
    if (currplayer.hasCardOfSuit(currentHand.giveSuit()) &&
      !(currcard.getSuit() == currentHand.giveSuit())) {
      throw new IllegalArgumentException("You have a card of the Current Suit!");
    }
    else if (currplayer != this.currentplayer) {
      throw new IllegalArgumentException("Not Your turn!");
    }
    else if (cardIdx > currplayer.giveHand().size() - 1) {
      throw new IllegalArgumentException("No Such Card!");
    }
    else if (players.indexOf(currplayer) == 0) {
      currentHand.changeSuit(currplayer.getPlayersCard(cardIdx).getSuit());
      currentHand.addCard(currplayer.getPlayersCard(cardIdx));
      currentplayer = players.get(playerNo + 1);
    }
    else if (players.indexOf(currplayer) == players.size() - 1) {
      currentHand.addCard(currplayer.getPlayersCard(cardIdx));
      Card winning_card = Collections.max(this.currentHand.validCards(), new CardComparator());
      for (int i = 0; i < this.players.size(); i++) {
        Player observed_player = players.get(i);
        if (observed_player.hasCard(winning_card)) {
          observed_player.addWin();
        }
      }
      removeHandFromPlayers();
      this.currentHand = new Hand();
      this.currentplayer = players.get(0);
    }
    else {
      currentHand.addCard(currplayer.getPlayersCard(cardIdx));
      this.currentplayer = players.get(playerNo + 1);
    }
  }

  /**
   * removes the cards in the current hand from their respective player's hands
   * Note: the deck constructor ensures that no 2 players have the same cards.
   */
  public void removeHandFromPlayers() {
    for (int i = 0; i < this.currentHand.giveCards().size(); i++) {
      Card observed_card = this.currentHand.giveCards().get(i);
      for (int j = 0; j < this.players.size(); j++) {
        Player observed_player = this.players.get(j);
        if (observed_player.hasCard(observed_card)) {
          observed_player.removePlayersCard(observed_card);
        }
      }
    }
  }

  /**
   * give the player who's turn it currently is
   * @return number of the player
   */
  @Override
  public int getCurrentPlayer() {
    if (this.isGameOver()) throw new IllegalStateException("Game is over");
    return players.indexOf(currentplayer);
  }

  /**
   * decides if the game is over
   * @return true is game is over, otherwise returns false
   */
  @Override
  public boolean isGameOver() {
    int amount_of_players = 0;
    for (int k = 0; k < players.size(); k++) {
      if (players.get(k).hasCards()) {
        amount_of_players = amount_of_players + 1;
      }
    }
    if (amount_of_players == 1) {
      return true;
    }
    else if (amount_of_players == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   *
   * @return
   */
  @Override
  public String getGameState() {
    String message = String.format("Number of players: %d", players.size());
    for (int i = 0; i < players.size(); i++) {
      message = message + String.format("\nPlayer %d : ", (i + 1)) + players.get(i).printHand();
    }
    for (int i = 0; i < players.size(); i++) {
      message = message + String.format("\nPlayer %d : %d hands won", (i + 1),
        players.get(i).getWins());
    }
    if (this.isGameOver()) {
      message = message + String.format("\nGame over. Player %d won.", (players.indexOf(this.hasMostWins()) + 1));
    }
    else {
      message = message + String.format("\nTurn: Player %d", this.getCurrentPlayer() + 1);
    }
    return message;
  }

  public Player hasMostWins(){
    return Collections.max(players, new PlayerWinsComparator());
  }
}
