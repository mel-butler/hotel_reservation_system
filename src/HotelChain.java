import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;

public class HotelChain {
    // i'm gonna create an arraylist containing type room
    private ArrayList<Room> threeStarHotel = new ArrayList<>();
    private ArrayList<Room> fourStarHotel = new ArrayList<>();
    private ArrayList<Room> fiveStarHotel = new ArrayList<>();

    /* Creates three hotels by calling the three hotel methods */
    public HotelChain(String info[][]) throws FileSystemNotFoundException {
        setThreeStarHotel(info);
        setFourStarHotel(info);
        setFiveStarHotel(info);
    }

    /* Creats hotels by using information from a l4hotels.csv file */
    public void setThreeStarHotel(String info[][]){

    }

    public void setFourStarHotel(String info[][]){

    }

    public void setFiveStarHotel(String info[][]) {
    }



}
