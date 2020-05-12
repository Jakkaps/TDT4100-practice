import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Game {
    private Collection<DiceScorer> rules;

    public Game(Collection<DiceScorer> rules) {
        this.rules = rules;
    }

    public Collection<Dice> computeDiceScore(Dice dice) {
        Collection<Dice> result = new ArrayList<>();

        while (true){
            Dice bestDice = new Dice(0);

            for (DiceScorer rule : rules) {
               Dice scoreDice = rule.getScore(dice);

               if (scoreDice != null && scoreDice.getScore() > bestDice.getScore()) {
                  bestDice = scoreDice;
               }
            }

            if (bestDice.getScore() == -1){
                break;
            }

            result.add(bestDice);
            dice = dice.remove(bestDice);
        }

        return result;
    }

  public static void main(String[] args) {
    Dice dice1 = new Dice(Arrays.asList(1, 3, 3, 3, 3, 4, 4, 4, 5), 5);
    Dice dice2 = new Dice(Arrays.asList(1, 1, 1, 5), 3);
    Game game = new Game(Arrays.asList(new ThreeOrMoreOfAKind()));

    Collection<Dice> doe = Arrays.asList(dice1, dice2);
    System.out.println(doe.stream().mapToInt(Dice::getScore).sum());
  }
}
