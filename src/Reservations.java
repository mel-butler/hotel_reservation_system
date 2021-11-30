import java.lang.reflect.Array;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Reservations {
    private int number;
    private String name;
    private String dateF;
    private String dateT;
    private boolean reservType;
    private GregorianCalendar dateFrom;
    private GregorianCalendar dateTo;
    private int numberOfDays;
    private int numOfRooms = 0;
    private String roomTypes;
    private int occupancy = 0;
    private double totalCost = 0;
    private double feecharge;
    private int numOfOccupancy;



    //go back and account for room type
    public Reservations(String name, String dateFrom, boolean reservType, int days, int numOfRooms, String roomTypes, int numOfOccupancy,double feecharge) {

        this.number = (int) (Math.random() * 1000);
        this.name = name;
        this.dateF = dateFrom;
        String[] f = dateFrom.split("/");
        int d = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]) - 1;
        int y = Integer.parseInt(f[2]);
        int length = d + days;
        this.dateT = length + "/" + (m+1) + "/" + y;
        this.dateFrom = new GregorianCalendar(y, m, d);
        this.dateTo = new GregorianCalendar(y, m, d + days);
        this.reservType = reservType;
        this.numberOfDays = days;
        this.numOfOccupancy = numOfOccupancy;
        this.numOfRooms = numOfRooms;
        this.roomTypes = roomTypes;
        this.feecharge = feecharge;

    }

    public Reservations(int number, String name, String dateFrom, boolean reservType, int days, int numOfRooms, String roomTypes, int numOfOccupancy, double feecharge) {

        this.number = number;
        this.name = name;
        this.dateF = dateFrom;

        String[] f = dateFrom.split("/");
        int d = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]) - 1;
        int y = Integer.parseInt(f[2]);
        int length = d + days;
        this.dateT = length + "/" + (m+1) + "/" + y;
        this.dateFrom = new GregorianCalendar(y, m, d);
        this.dateTo = new GregorianCalendar(y, m, d + days);
        this.reservType = reservType;
        this.numberOfDays = days;
        this.numOfOccupancy = numOfOccupancy;
        this.numOfRooms = numOfRooms;
        this.roomTypes = roomTypes;
        this.feecharge = feecharge;

    }


    public int getNumber() {
            return number;
        }

        public String getName () {
            return name;
        }
         public String getDateF() {
        return dateF;
        }

         public String getDateT() {
        return dateT;
        }
        public boolean getReservType(){
        return  reservType;
        }
        public GregorianCalendar getDateFrom () {

            return dateFrom;
        }

        public GregorianCalendar getDateTo () {
            return dateTo;
        }
        public double getFeeCharge(){
          return feecharge;
        }

        public int getNumOfRooms () {

            return numOfRooms;
        }

    public void setNumOfOccupancy(int numOfOccupancy) {
        this.numOfOccupancy = numOfOccupancy;
    }

    public int getNumOfOccupancy() {
        return numOfOccupancy;
    }

    public String getRoomTypes(){
        return roomTypes;
        }

        public int getNumberOfDays(){
        return numberOfDays;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public double setTotalCost(double totalCost){
          return this.totalCost = totalCost;
        }
         public double getTotalCost () {
          return totalCost;
    }

          public double setFeeCharge(double feecharge){
          return this.feecharge = feecharge;
        }

    }
