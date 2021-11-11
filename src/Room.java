import java.util.ArrayList;

public class Room {
    private  String roomType;
    private int minOccupancy;
    private int maxOccupancy;
    private double[] rates = new double[];

    public Room(String roomType, int minOccupancy, int maxOccupancy, double[] rates){
        this.roomType = roomType;
        this.minOccupancy = minOccupancy;
        this.maxOccupancy = maxOccupancy;
        this.rates = rates;
    }

}
