import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Reservations {
    private int number;
    private String name;
    private String type; //S or AP
    private String email;
    private String dateFrom;
    private int numOfNights;
    private int numOfRooms;
    private GregorianCalendar fromDate;
    private GregorianCalendar toDate;
    private int numOfPeople = 0;
    private ArrayList<String> roomTypes;
    private int[] roomOccupancy;
    private double totalCost = 0;

    //creating a reservations object for user input - mel
    public Reservations(String name, String email, String type, String dateFrom, int numOfNights,
                        int numOfPeople, Room[] rooms){
        this.name = name;
        this.email = email;
        this.dateFrom = dateFrom;
        // turns date String into a Gregorian calendar
        String[] from = dateFrom.split("/");
        int day, month, year;
        day = Integer.parseInt(from[0]);
        month = Integer.parseInt(from[1]) - 1;
        year = Integer.parseInt(from[2]);
        int stayPeriod = day + numOfNights;
        this.fromDate = new GregorianCalendar(year, month, day);
        this.toDate = new GregorianCalendar(year, month, day);
        this.type = type;
        this.numOfPeople = numOfPeople;
        for(int i = 0; i < rooms.length; i++){
            roomTypes.add(i, rooms[i].getType());
            roomOccupancy[i] = (rooms[i].getOccupancy());
            numOfRooms++;
            totalCost += rooms[i].getPrice(); // something to do with the day erm
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