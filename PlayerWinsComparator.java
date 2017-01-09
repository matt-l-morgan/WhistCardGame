import java.util.Comparator;

/**
 * Created by mattmorgan on 2/19/16.
 */
public class PlayerWinsComparator implements Comparator<Player>{

  @Override public int compare(Player p1, Player p2) {
    if (p1.getWins() > p2.getWins()) {
      return 1;
    }
    else if (p1.getWins() < p2.getWins()) {
      return -1;
    }
    else {
      return 0;
    }
  }
}
