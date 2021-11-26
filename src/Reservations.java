import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reservations {
    private int number;
    private String name;
    private String type; //S or AP
    private String email;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numOfRooms = 0;
    private ArrayList<String> roomTypes;
    private int[] roomOccupancy;
    private double totalCost = 0;

    //go back and account for room type
    public Reservations(int number, String name, String email, String type, LocalDate checkIn, LocalDate checkOut, Room[] rooms){
        this.number = number;
        this.name = name;
        this.email = email;
        this.type = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        for(int i = 0; i < rooms.length; i++){
            roomTypes.add(i, rooms[i].getType());
            roomOccupancy[i] = (rooms[i].getOccupancy());
            numOfRooms++;
            totalCost += rooms[i].getPrice();
        }
        if (type == "AP") totalCost += totalCost * .95;
    }


    public int getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getType(){
        return type;
    }

    public LocalDate getCheckIn(){
        return checkIn;
    }

    public LocalDate getCheckOut(){
        return checkOut;
    }

    public int getNumOfRooms(){
        return numOfRooms;
    }

    public double getTotalCost(){ return totalCost; }

}