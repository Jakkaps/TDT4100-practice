import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeOrMoreOfAKind implements DiceScorer{
    @Override
    public Dice getScore(Dice dice) {
        int maxScore = 0;
        int bestNum = 0;

        for (int i = 1; i <= 6; i++){
            int score = calculateScore(i, dice);
            if (score > maxScore){
                maxScore = score;
                bestNum = i;
            }
        }

        List<Integer> winnerNums = new ArrayList<>();
        for (int i = 0; i < dice.getValueCount(bestNum); i++){
            winnerNums.add(bestNum);
        }

        return maxScore > 0 ? new Dice(winnerNums, maxScore) : null;
    }

    private int calculateScore(int num, Dice dice){
        int valueCount = dice.getValueCount(num);
        if (valueCount < 3){
            return 0;
        }

        int score = num*100;

        return score * (int) Math.pow(2, valueCount - 3);
    }

  public static void main(String[] args) {
        Dice dice = new Dice(Arrays.asList(3, 3, 3, 3, 3, 5, 5, 5, 5, 5), -1);
        System.out.println(new ThreeOrMoreOfAKind().getScore(dice));
  }
}
