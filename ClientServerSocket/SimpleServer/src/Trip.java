import java.util.Calendar;

public class Trip {

    private final String data;

    private final Calendar date;

    private final int[][] seats;

    public Trip(String data, Calendar date) {
        this.data = data;
        this.date = date;
        seats = new int[9][4];
    }

    public Calendar getDate() {
        return date;
    }

    public int[][] getSeats() {
        return seats;
    }

    public String getData() {
        return data;
    }

    public boolean reserve(int row, int place) {
        if (seats[row][place] == 0) {
            seats[row][place] = 1;
            return true;
        }
        return false;
    }

}
