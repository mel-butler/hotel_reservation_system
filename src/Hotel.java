
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private int star;
    private ArrayList<Room> rooms;
    private ArrayList<Reservations> reservations;

    //hotel is assumed to be in the same format as the hotels are written in the csv files
    //this class is not finished just putting it into the github for now
    public Hotel(int star, String[][] hotelInfo){
        //add code
    }

    public void makeReservation( String name, String email, String type, String dateFrom, int numOfNights, int numOfPeople, Room[] rooms){
        Reservations reservation = new Reservations(name, email, type, dateFrom, numOfNights, numOfPeople, rooms);
        reservations.add(reservation);
    }

    public void cancellation(Reservations cancellation){
        reservations.remove(cancellation);
    }

    public int numOfRooms(String type){
        int count = 0;
        for(Room room: rooms){
            if(room.getType() == type){
                count++;
            }
        }
        return count;
    }

    public int getStar(){
        return star;
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }



}