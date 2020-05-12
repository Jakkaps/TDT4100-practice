import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Handles guests arriving at and departing from a Diner.
 */
public class GuestManager implements CapacityListener {
    private Diner diner;
    private List<Group> waiting = new ArrayList<>();

    public GuestManager(Diner diner) {
        this.diner = diner;
        diner.addListener(this);
    }

    /**
    * Handles arriving groups, by either seating them immediately
    *  (if possible) or putting them in queue. Those enqueued will
    * be seated when the Diner's (change in) capacity allows.
    * @param group
    */
    public void groupArrived(Group group) {
        waiting.add(group);
        seatAllPossible();
    }

    /**
    * Handles departing groups, by removing their seating.
    * @param tableNum the table where the group was seated
    */
    public void groupDeparted(int tableNum) {
        diner.removeSeating(tableNum);
        seatAllPossible();
    }

    private void seatAllPossible(){
        for (Group group : waiting){
            diner.addSeating(group);
        }
    }

    @Override
    public void capacityChanged(Diner diner) {
        seatAllPossible();
    }
}
