

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private int star;
    private ArrayList<Room> rooms;
    private ArrayList<Reservations> reservations;

    // hotel is assumed to be in the same format as the hotels are written in the csv files (EXCLUDING headings), eg
    // Hotel type, Room type, Number of Rooms,Occupancy-min,Occupancy-max,Mon,Tues,Wed,Thurs,Fri,Sat,Sun
    //
    //  5-star, Deluxe Double,  35, 1,  2,  75, 75, 75, 80, 90, 90, 75
    //  null  , Deluxe Twin,    25, 1,  2,  75, 75, 75, 80, 90, 90, 75
    //  null  , Deluxe Single,  10, 1,  2,  70, 70, 70, 75, 80, 80, 65
    //  null  , Deluxe Family,  10, 1,  3,  80, 80, 80, 80, 100,100,80
    //
    //  (more or less lines for depending on number of rooms)
    public Hotel(String[][] hotelInfo){
        star = Integer.valueOf(hotelInfo[0][0]);
        for(int i = 0; i < hotelInfo.length; i++){
            Room currentRoom = new Room(hotelInfo[i][1], Integer.valueOf(hotelInfo[i][4]), Double.valueOf(hotelInfo[i][5]), Double.valueOf(hotelInfo[i][6]), Double.valueOf(hotelInfo[i][7]), Double.valueOf(hotelInfo[i][8]), Double.valueOf(hotelInfo[i][9]), Double.valueOf(hotelInfo[i][10]), Double.valueOf(hotelInfo[i][11]));
            for(int j = 0; j < Integer.valueOf(hotelInfo[i][2]); j++){
                rooms.add(currentRoom);
            }
        }
    }

    public void makeReservation( String name, String email, String type, String dateFrom, int numOfNights, int numOfPeople, Room[] rooms){
        Reservations reservation = new Reservations(name, email, type, dateFrom, numOfNights, numOfPeople, rooms);
        reservations.add(reservation);
    }


    //if we decide to keep a cancellations csv file this method needs to be updated to write to the csv file
    public void cancellation(Reservations cancellation){
        reservations.remove(cancellation);
    }

    //this method returns the amount of rooms of a certain type
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
