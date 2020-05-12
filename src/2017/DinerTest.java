import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DinerTest {

    @Test
    public void occupiedTest(){
        Table table = new SimpleTable(5);
        Diner diner = new Diner(table);
        assertFalse(diner.isOccupied(table));

        Group group = new Group(5);
        diner.addSeating(group);
        assertTrue(diner.isOccupied(table));

        diner.removeSeating(table.getNumber());
        assertFalse(diner.isOccupied(table));
    }
}
