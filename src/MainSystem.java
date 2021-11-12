import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainSystem {

    private ReadData read = new ReadData();

    public static void main(String[] args) throws Exception {
        MainSystem mainsys = new MainSystem();
        Hotel hotel = new Hotel(mainsys.getRead().readHotelFile());
        Menu mainMenu = new Menu();
        mainMenu.menu(hotel, mainsys);
    }

    /*
    If the room is available add it to the Reservation list. And then write the Reservation to the res.csv file.
    If the room is available return true.
     */
    public boolean roomDetails(Reservations newRes, Hotel hotel) {
        if (data.checkAvailability(newRes, hotel, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomType())) {
            data.getList().add(newRes);
            if (newRes.getRoomsNum() > 1) {
                for (int i = 1; i < newRes.getRoomsNum(); i++) {
                    if (data.checkAvailability(newRes, hotel, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomType())) {

                    } else {
                        data.findRoom(newRes.getNumber(), hotel);
                        return false;
                    }
                }
                read.writeReservation(hotel, data);
                return true;
            } else if (newRes.getRoomsNum() == 1) {
                read.writeReservation(hotel, data);
                return true;
            }
        } else {
            return false;
        }
        //return false;

        if (data.checkAvailability(newRes, hotel, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomType())) {
            data.getList().add(newRes);
            if (newRes.getRoomsNum() > 1) {
                for (int i = 1; i < newRes.getRoomsNum(); i++) {
                    if (data.checkAvailability(newRes, hotel, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomType())) {
                    } else {
                        data.findRoom(newRes.getNumber(), hotel);
                        return false;
                    }
                }
                return true;
            } else if (newRes.getRoomsNum() == 1) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public double getTotalCost(Reservation newRes, Hotels hotel) {
        int start = newRes.getDateFrom().get(Calendar.DAY_OF_WEEK);
        if (start == 1) {
            start = 6;
        } else {
            start = start - 2;
        }
        int numDays = newRes.getNumberNights();
        double[] rates = data.getRates(newRes, hotel);
        double totalCost = 0;
        if (numDays == 1) {
            totalCost = rates[start];
        } else {
            while (numDays > 0) {
                while (start < rates.length) {
                    totalCost = totalCost + rates[start];
                    start++;
                    numDays--;
                    if (numDays == 0) {
                        break;
                    }
                }
                start = 0;
            }
        }
        int numRooms = newRes.getRoomsNum();
        totalCost = totalCost * numRooms;
        boolean ap = newRes.isResType();
        if (ap == false) {
            totalCost = ((totalCost / 100) * 5) + totalCost;
        }
        return totalCost;
    }

    public boolean isValidDate(String inDate) {

        if (inDate == null) {
            System.out.println("Date is null");
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            System.out.println("Wrong format");
            return false;
        }

        dateFormat.setLenient(false);

        try {
            //parse the inDate parameter
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            System.out.println("Invalid Date");
            return false;

        }
        return true;
    }


    public boolean isDateInFuture(String date) {
        if (isValidDate(date)) {
            GregorianCalendar today = new GregorianCalendar();
            String[] f = date.split("/");
            int d = Integer.parseInt(f[0]);
            int m = Integer.parseInt(f[1]) - 1;
            int y = Integer.parseInt(f[2]);
            GregorianCalendar future = new GregorianCalendar(y, m, d);
            if (future.getTimeInMillis() > today.getTimeInMillis()) {
                return true;
            }
            System.out.println("Date not in future");
        }
        return false;
    }

    public ReadData getRead () {
        return read;
    }
}

