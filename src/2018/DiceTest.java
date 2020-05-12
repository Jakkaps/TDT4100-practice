import org.junit.Before;
import org.junit.Test;

public class DiceTest {
    @Test
    public void valueOfTest() {
        Dice dice = new Dice(() -> 1, 3);
        // assertDieValues(dice, 1, 1, 1);
    }

}
