import java.util.ArrayList;

public class Room{
    private String roomType;
    private int minOccupancy;
    private int maxOccupancy;
    private double[] rates = new double[7];
    private int maxNumOfRooms;
    private ArrayList<Reservations> booked = new ArrayList<Reservations>();

    /*
    Creates a room object
    */
    public Room(String roomType, int minOccupancy, int maxOccupancy, double[] rates, int maxNumOfRooms) {
        this.roomType = roomType;
        this.minOccupancy = minOccupancy;
        this.maxOccupancy = maxOccupancy;
        this.rates = rates;
        this.maxNumOfRooms = maxNumOfRooms;
    }

    public ArrayList<Reservations> getBooked() {
        return booked;
    }

    public String getRoomType() {
        return roomType;
    }
    public int getMinOccupancy(){
        return minOccupancy;
    }
    public int getMaxOccupancy(){
        return maxOccupancy;
    }

    public double[] getRates() {
        return rates;
    }

    public int getMaxNoRooms() {
        return maxNumOfRooms;
    }
}
