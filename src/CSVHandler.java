import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CSVHandler {
    private String[][] info;
    private String[][] res;

    /*
    Reads in l4Hotels.csv file and returns the information as a 2d array
    */
    public String[][] readHotelCSV() throws FileNotFoundException
    {
        File file = new File("l4Hotels.csv");
        Scanner in = new Scanner(file);

        String currentLine;
        this.info = new String[12][12];
        int j = 0;

        while(in.hasNext()){
            currentLine = in.nextLine();
            this.info[j] = currentLine.split(",");
            j++;
        }
        in.close();
        return info;
    }

    /*
    Reads in res.csv file and returns the information as a 2d array
    */
    public String[][] readResCSV() throws FileNotFoundException
    {
        File file = new File("res.csv");
        Scanner count = new Scanner(file);

        String currentLine;
        String c;
        int j = 0;

        while(count.hasNext()){
            c = count.nextLine();
            j++;
        }
        count.close();
        Scanner in = new Scanner(file);
        this.res = new String[j][12];
        j = 0;

        while(in.hasNext()){
            currentLine = in.nextLine();
            this.res[j] = currentLine.split(",");
            j++;
        }
        in.close();
        return res;
    }

    /*
    Reads in checkin.csv file and returns the information as a 2d array
    */
    public String[][] checkInFile() throws FileNotFoundException
    {
        File file = new File("checkin.csv");
        Scanner count = new Scanner(file);
        String currentLine;
        String c;
        int j = 0;

        while(count.hasNext()){
            c = count.nextLine();
            j++;
        }
        count.close();
        Scanner in = new Scanner(file);
        this.res = new String[j][12];
        j = 0;

        while(in.hasNext()){
            currentLine = in.nextLine();
            this.res[j] = currentLine.split(",");
            j++;
        }
        in.close();
        return res;
    }

    /*
    Reads in checkout.csv file and returns the information as a 2d array
    */
    public String[][] checkOutFile() throws FileNotFoundException
    {
        File file = new File("checkout.csv");
        Scanner count = new Scanner(file);
        String currentLine;
        String c;
        int j = 0;

        while(count.hasNext()){
            c = count.nextLine();
            j++;
        }
        count.close();
        Scanner in = new Scanner(file);
        this.res = new String[j][12];
        j = 0;

        while(in.hasNext()){
            currentLine = in.nextLine();
            this.res[j] = currentLine.split(",");
            j++;
        }
        in.close();
        return res;
    }
    /*
    Reads in cancellations.csv file and returns the information as a 2d array
    */
    public String[][] cancellationsFile() throws FileNotFoundException
    {
        File file = new File("cancellations.csv");
        Scanner count = new Scanner(file);
        String currentLine;
        String c;
        int j = 0;

        while(count.hasNext()){
            c = count.nextLine();
            j++;
        }
        count.close();
        Scanner in = new Scanner(file);
        this.res = new String[j][12];
        j = 0;

        while(in.hasNext()){
            currentLine = in.nextLine();
            this.res[j] = currentLine.split(",");
            j++;
        }
        in.close();
        return res;
    }

    /*
    Writes to res.csv file
    */
    public void writeReservations(Hotel hotelel, ReservationData data){
        try{
            FileWriter writer = new FileWriter("res.csv");
            writer.write("Reservation Number");
            writer.write(",");
            writer.write("Name");
            writer.write(",");
            writer.write("Standard Booking");

            writer.write(",");
            writer.write("Date From");
            writer.write(",");
            writer.write("Date To");
            writer.write(",");
            writer.write("number of days");
            writer.write(",");
            writer.write("Number of Rooms");
            writer.write(",");
            writer.write("Room Type");
            writer.write(",");
            writer.write("Number of Occupancy");
            writer.write(",");
            writer.write("Fee Charge");
            writer.write("\n");

            for(int i = 0; i < data.getList().size(); i++){
                writer.write(String.valueOf(data.getList().get(i).getNumber()));
                writer.write(",");
                writer.write(data.getList().get(i).getName());
                writer.write(",");
                if(data.getList().get(i).getReservType()){
                    writer.write("True");
                }else{
                    writer.write("False");
                }
                writer.write(",");
                writer.write(data.getList().get(i).getDateF());


                writer.write(",");
                writer.write(data.getList().get(i).getDateT());
                writer.write(",");
                writer.write(""+data.getList().get(i).getNumberOfDays());
                writer.write(",");
                writer.write(""+data.getList().get(i).getNumOfRooms());
                writer.write(",");
                writer.write(data.getList().get(i).getRoomTypes());
                writer.write(",");
                writer.write(""+data.getList().get(i).getNumOfOccupancy());
                //   System.out.println("ERROR: "+ data.getList().get(i).getNumOfOccupancy() );

                writer.write(",");
                writer.write(String.valueOf(data.getList().get(i).getFeeCharge()));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
    Writes to checkin.csv file
    */
    public void writeCheckIns(Hotel hotelel, ReservationList checkin){
        try{
            FileWriter writer = new FileWriter("checkin.csv");
            writer.write("Reservation Number");
            writer.write(",");
            writer.write("Name");
            writer.write(",");
            writer.write("Standard Booking");

            writer.write(",");
            writer.write("Date From");
            writer.write(",");
            writer.write("Date To");
            writer.write(",");
            writer.write("number of days");
            writer.write(",");
            writer.write("Number of Rooms");
            writer.write(",");
            writer.write("Room Type");
            writer.write(",");

            writer.write("Number of Occupancy");

            writer.write(",");
            writer.write("Fee Charge");
            writer.write("\n");
            for(int i = 0; i < checkin.getCheckedIn().size(); i++){
                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getNumber()));
                writer.write(",");
                writer.write(checkin.getCheckedIn().get(i).getName());
                writer.write(",");
                if(checkin.getCheckedIn().get(i).getReservType()){
                    writer.write("True");
                }else{
                    writer.write("False");
                }

                writer.write(",");
                writer.write(checkin.getCheckedIn().get(i).getDateF());
                writer.write(",");
                writer.write(checkin.getCheckedIn().get(i).getDateT());
                writer.write(",");

                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getNumberOfDays()));
                writer.write(",");
                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getNumOfRooms()));
                writer.write(",");
                writer.write(checkin.getCheckedIn().get(i).getRoomTypes());
                writer.write(",");

                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getNumOfOccupancy()));
                writer.write(",");

                writer.write(String.valueOf(checkin.getCheckedIn().get(i).getFeeCharge()));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
    Writes to checkout.csv file
    */
    public void writeCheckOuts(Hotel hotelel, ReservationList checkout){
        try{
            FileWriter writer = new FileWriter("checkout.csv");
            writer.write("Reservation Number");
            writer.write(",");
            writer.write("Name");
            writer.write(",");
            writer.write("Standard Booking");

            writer.write(",");
            writer.write("Date From");
            writer.write(",");
            writer.write("Date To");
            writer.write(",");
            writer.write("number of days");
            writer.write(",");
            writer.write("Number of Rooms");
            writer.write(",");
            writer.write("Room Type");
            writer.write(",");

            writer.write("Number of Occupancy");
            writer.write(",");
            writer.write("Fee Charge");
            writer.write("\n");
            for(int i = 0; i < checkout.getCheckedOut().size(); i++){
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getNumber()));
                writer.write(",");
                writer.write(checkout.getCheckedOut().get(i).getName());
                writer.write(",");
                if(checkout.getCheckedOut().get(i).getReservType()){
                    writer.write("True");
                }else{
                    writer.write("False");
                }

                writer.write(",");
                writer.write(checkout.getCheckedOut().get(i).getDateF());
                writer.write(",");
                writer.write(checkout.getCheckedOut().get(i).getDateT());
                writer.write(",");

                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getNumberOfDays()));
                writer.write(",");
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getNumOfRooms()));
                writer.write(",");
                writer.write(checkout.getCheckedOut().get(i).getRoomTypes());
                writer.write(",");
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getNumOfOccupancy()));
                writer.write(",");
                writer.write(String.valueOf(checkout.getCheckedOut().get(i).getFeeCharge()));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /*
    Writes to cancellations.csv file
    */
    public void writeCancellations(Hotel hotelel, ReservationList cancellations){
        try{
            FileWriter writer = new FileWriter("cancellations.csv");
            writer.write("Reservation Number");
            writer.write(",");
            writer.write("Name");
            writer.write(",");
            writer.write("Standard Booking");
            writer.write(",");
            writer.write("Date From");
            writer.write(",");
            writer.write("Date To");
            writer.write(",");
            writer.write("number of days");
            writer.write(",");
            writer.write("Number of Rooms");
            writer.write(",");
            writer.write("Room Type");
            writer.write(",");

            writer.write("Number of Occupancy");
            writer.write(",");

            writer.write("Fee Charge");
            writer.write("\n");
            for(int i = 0; i < cancellations.getCancellations().size(); i++){
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getNumber()));
                writer.write(",");
                writer.write(cancellations.getCancellations().get(i).getName());
                writer.write(",");
                if(cancellations.getCancellations().get(i).getReservType()){
                    writer.write("True");
                }else{
                    writer.write("False");
                }
                writer.write(",");


                writer.write(cancellations.getCancellations().get(i).getDateF());
                writer.write(",");
                writer.write(cancellations.getCancellations().get(i).getDateT());
                writer.write(",");
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getNumberOfDays()));

                writer.write(",");
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getNumOfRooms()));
                writer.write(",");
                writer.write(cancellations.getCancellations().get(i).getRoomTypes());
                writer.write(",");
                writer.write(String.valueOf(cancellations.getCancellations().get(i).getNumOfOccupancy()));
                writer.write(",");

                writer.write(String.valueOf(cancellations.getCancellations().get(i).getFeeCharge()));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
    Prints out information from the l4hotels.csv file
    */
    public void printInfo(){
        for(int i = 0; i < info.length; i++){
            for(int j = 0; j < info[i].length; j++){
                System.out.print(info[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}
