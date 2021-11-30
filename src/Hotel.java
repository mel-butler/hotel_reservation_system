import java.util.ArrayList;
import java.io.FileNotFoundException;
public class Hotel {
    private ArrayList<Room> threeStar = new ArrayList<Room>();
    private ArrayList<Room> fourStar =  new ArrayList<Room>();
    private ArrayList<Room> fiveStar =  new ArrayList<Room>();
    private String choice;

    /*
    Hotels Constructor creates 3 hotels by calling the method that belongs to the three of them. Giving the 2D array.
    */
    public Hotel(String info [][]) throws FileNotFoundException{ //Use 2D array to create hotels
        create3Star(info);
        create4Star(info);
        create5Star(info);
    }

    /*
    Creates a 3 Star hotel using a 2D Array created from the l4hotels.csv file
    */
    public void create3Star(String info[][]){
        for(int i = 0; i < 3; i++){
            String roomType = info[i+9][1];
            int minOccupancy = Character.getNumericValue(info[i+9][3].charAt(0));
            int maxOccupancy = Character.getNumericValue(info[i+9][4].charAt(0));
            int numOfRooms = Integer.parseInt(info[i+9][2]);
            double[] rates = new double[7];
            for(int j = 0; j < 7; j++){
                rates[j] = Double.parseDouble(info[i+9][j+5]);
            }
            for(int x = 0; x < numOfRooms; x++){
                Room room = new Room(roomType, minOccupancy, maxOccupancy, rates, numOfRooms);
                threeStar.add(room);
            }
        }
    }

    /*
    Creates a 4 Star hotel using a 2D Array created from the l4hotels.csv file
    */
    public void create4Star(String info[][]){
        for(int i = 0; i < 3; i++){
            String roomType = info[i+6][1];
            int minOccupancy = Character.getNumericValue(info[i+6][3].charAt(0));
            int maxOccupancy = Character.getNumericValue(info[i+6][4].charAt(0));
            int maxNoRooms = Integer.parseInt(info[i+6][2]);
            double[] rates = new double[7];
            for(int j = 0; j < 7; j++){
                rates[j] = Double.parseDouble(info[i+6][j+5]);
            }
            for(int x = 0; x < maxNoRooms; x++){
                Room room = new Room(roomType, minOccupancy,maxOccupancy, rates, maxNoRooms);
                fourStar.add(room);
            }
        }
    }

    /*
    Creates a 5 Star hotel using a 2D Array created from the l4hotels.csv file
    */
    public void create5Star(String info[][]){
        for(int i = 0; i < 4; i++){
            String roomType = info[i+2][1];
            int minOccupancy = Character.getNumericValue(info[i+2][3].charAt(0));
            int maxOccupancy = Character.getNumericValue(info[i+2][4].charAt(0));
            int maxNoRooms= Integer.parseInt(info[i+2][2]);
            double[] rates = new double[7];
            for(int j = 0; j < 7; j++){
                rates[j] = Double.parseDouble(info[i+2][j+5]);
            }
            for(int x = 0; x < maxNoRooms; x++){
                Room room = new Room(roomType, minOccupancy, maxOccupancy,rates, maxNoRooms);
                fiveStar.add(room);
            }
        }
    }

    /*
    The current hotel is chosen by the user.
    */
    public String getArrayString(String choice){
        String hotel = "3Star";
        if(choice.equals("3")){
            hotel = "3Star";
        }else if(choice.equals("4")){
            hotel = "4Star";
        }else if(choice.equals("5")){
            hotel = "4Star";
        }
        return hotel;
    }

    /*
    Gets a list of the room types for the current hotel.
    */
    public ArrayList<String> getUniqueRoomTypes(ArrayList<Room> list){
        ArrayList<String> uniqueTypes = new ArrayList<String>();
        uniqueTypes.add(list.get(0).getRoomType());
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).getRoomType() != list.get(i - 1).getRoomType()){
                uniqueTypes.add(list.get(i).getRoomType());
            }
        }
        return uniqueTypes;
    }

    public ArrayList<Room> getThreeStar() {
        return threeStar;
    }

    public ArrayList<Room> getFourStar() {
        return fourStar;
    }

    public ArrayList<Room> getFiveStar() {
        return fiveStar;
    }

    public ArrayList<Room> getArray(String choice){
        ArrayList<Room> room;
        room = getThreeStar();
        if(choice.equals("3")){
            room = getThreeStar();
        }else if(choice.equals("4")){
            room = getFourStar();
        }else if(choice.equals("5")){
            room = getFiveStar();
        }
        return room;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getMinOccupancy(String roomType){
        int min = 0;
        for(int i = 0; i < getArray(this.choice).size(); i++){
            if((roomType.equals(getArray(this.choice).get(i).getRoomType())) == true){
                min = getArray(this.choice).get(i).getMinOccupancy();
                return min;
            }
        }
        return min;
    }

    public int getMaxOccupancy(String roomType){
        int max = 0;
        for(int i = 0; i < getArray(this.choice).size(); i++){
            if((roomType.equals(getArray(this.choice).get(i).getRoomType())) == true){
                max = getArray(this.choice).get(i).getMaxOccupancy();
                return max;
            }
        }
        return max;
    }

    public int getMaxRooms(String roomType){
        int max = 0;
        for(int i = 0; i < getArray(this.choice).size(); i++){
            if((roomType.equals(getArray(this.choice).get(i).getRoomType())) == true){
                max = getArray(this.choice).get(i).getMaxNoRooms();
                return max;
            }
        }
        return max;
    }
}