import java.util.ArrayList;

public class Room {

    private String type;
    //array of the rooms prices on each day, index 0 = monday, 1 = tuesday .... 6 = sunday
    private double[] prices;
    private int maxOccupancy;
    private int occupancy;

    //constructor which accepts room prices individually
    public Room(String type,  int maxOccupancy,  double priceMon, double priceTues, double priceWed, double priceThurs, double priceFri, double priceSat, double priceSun){
        double[] prices = {priceMon, priceTues, priceWed, priceThurs, priceFri, priceSat, priceSun};
        this.type = type;
        this.prices = prices;
        this.maxOccupancy = maxOccupancy;
    }

    //constructor which accepts room prices as an array
    public Room(String type,  int maxOccupancy,  double[] prices){
        this.type = type;
        this.prices = prices;
        this.maxOccupancy = maxOccupancy;
    }

    //this method along with the occupancy data field and getOccupancy method may not be needed in the final project
    public void setOccupancy(int occupancy){
        this.occupancy = occupancy;
    }

    public String getType(){
        return type;
    }

    public int getOccupancy(){
        return occupancy;
    }

    public int getMaxOccupancy(){
        return maxOccupancy;
    }

    //returns the rooms price on a specified day
    public double getPrice(String day) throws IllegalArgumentException {
        double price;
        switch(day.toUpperCase()){
            case "MON":
            case "MONDAY":
                price = prices[0];
                break;

            case "TUE":
            case "TUES":
            case "TUESDAY":
                price = prices[1];
                break;

            case "WED":
            case "WEDNESDAY":
                price = prices[2];
                break;

            case "THUR":
            case "THURS":
            case "THURSDAY":
                price = prices[3];
                break;

            case "FRI":
            case "FRIDAY":
                price = prices[4];
                break;

            case "SAT":
            case "SATDAY":
                price = prices[5];
                break;

            case "SUN":
            case "SUNDAY":
                price = prices[6];
                break;

            default:
                throw new IllegalArgumentException("Day inputted is invalid");
        }
        return price;
    }

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
