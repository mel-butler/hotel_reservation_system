import java.util.ArrayList;

public class Room {
    private  String roomType;
    private int minOccupancy;
    private int maxOccupancy;
    private double[] rates = new double[10];

    public Room(String roomType, int minOccupancy, int maxOccupancy, double[] rates){
        this.roomType = roomType;
        this.minOccupancy = minOccupancy;
        this.maxOccupancy = maxOccupancy;
        this.rates = rates;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getMinOccupancy() {
        return minOccupancy;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public double[] getRates() {
        return rates;
    }
}
