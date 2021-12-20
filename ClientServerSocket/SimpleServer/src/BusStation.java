import java.util.ArrayList;
import java.util.List;

public class BusStation {
    private List<Trip> trips;

    public synchronized List<Trip> getTrips() {
        return trips;
    }

    public BusStation(List<Trip> trips) {
        this.trips = trips;
    }
}
