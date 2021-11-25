import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadData {
    private String[][] hotelData;
    private String[][] reservationData;

    /*
    reads the 14Hotels.csv file and converts it into a 2d array,
    includes first two lines at the top of the csv file which are the headings
     */
    public String[][] readHotelFile() throws FileNotFoundException {
        File hotelFile = new File("scr/l4Hotels.csv");
        Scanner in = new Scanner(hotelFile);

        int count = countLines(hotelFile);
        hotelData = new String[count][12];

        //writes each line onto the 2d array
        String currentLine;
        int i = 0;
        while (in.hasNext()){
            currentLine = in.nextLine();
            hotelData[i] = currentLine.split(",");
            i++;
        }
        in.close();
        return hotelData;
    }


    /*
    reads the Reservations.csv file and converts it into a 2d array,
    includes line at the top of the csv file as the first row of the 2d array
    */
    public String[][] readReservationFile() throws FileNotFoundException {
        File reservationFile = new File("src/Reservations.csv");
        Scanner in = new Scanner(reservationFile);

        int count = countLines(reservationFile);
        reservationData = new String[count][];

        //writes each line to the 2d array
        int i = 0;
        String currentLine;
        while (in.hasNext()){
            currentLine = in.nextLine();
            reservationData[i] = currentLine.split(",");
            i++;
        }
        in.close();
        return reservationData;
    }

    //adds one hotel to the l4hotel.csv file
    public void writeHoteldata(Hotel hotel) throws IOException {
        File reservationFile = new File("scr/l4Hotels.csv");
        FileWriter fw = new FileWriter(reservationFile, true);
        PrintWriter pw = new PrintWriter(fw);
        ArrayList<Room> rooms = hotel.getRooms();

        for(int i = 0; i < rooms.size(); i++){
            pw.print("\n");
            if(i == 0){
                pw.print(hotel.getStar() + "-star");
            }
            pw.print(",");
            pw.print((rooms.get(i)).getType());
            pw.print(",");
            pw.print((hotel.numOfRooms((rooms.get(i)).getType())));
            pw.print(",");
            pw.print(1);
            pw.print(",");
            pw.print((rooms.get(i)).getMaxOccupancy());
            pw.print(",");
            pw.print((rooms.get(i)).getPrice("MON"));
            pw.print(",");
            pw.print((rooms.get(i)).getPrice("TUE"));
            pw.print(",");
            pw.print((rooms.get(i)).getPrice("WED"));
            pw.print(",");
            pw.print((rooms.get(i)).getPrice("THURS"));
            pw.print(",");
            pw.print((rooms.get(i)).getPrice("FRI"));
            pw.print(",");
            pw.print((rooms.get(i)).getPrice("SAT"));
            pw.print(",");
            pw.print((rooms.get(i)).getPrice("SUN"));
        }
        pw.close();
    }

    //adds one reservation to the reservations.csv file
    public void writeReservation(Reservation reservation) throws IOException {
        File reservationFile = new File("src/Reservations.csv");
        FileWriter fw = new FileWriter(reservationFile, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.print("\n");
        pw.print(reservation.getNumber());
        pw.print(",");
        pw.print(reservation.getName());
        pw.print(",");
        pw.print(reservation.getType());
        pw.print(",");
        pw.print((reservation.getCheckIn()).toString());
        pw.print(",");
        pw.print((reservation.getCheckOut()).toString());
        pw.print(",");
        pw.print(reservation.getNumOfRooms());
        pw.print(",");
        pw.print(String.valueOf(reservation.getTotalCost()));
        pw.close();
    }

    //counts the number of lines in a csv file
    public int countLines(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);

        //counts the number of lines in Reservations.csv
        int count = 0;
        while (in.hasNext()) {
            in.nextLine();
            count++;
        }

        in.close();
        return count;
    }

}
