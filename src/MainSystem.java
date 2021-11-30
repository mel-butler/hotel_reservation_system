
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainSystem {
    private CSVHandler read = new CSVHandler();
    private ReservationData data;
    private ReservationList checkData;

    public static void main(String[] args) throws Exception {
        MainSystem mainsys = new MainSystem();
        Hotel hotel = new Hotel(mainsys.getRead().readHotelCSV());

        ReservationData data = new ReservationData(mainsys.getRead().readResCSV(), hotel);
        mainsys.setData(data);

        ReservationList checkData = new ReservationList(mainsys.getRead().checkInFile(), mainsys.getRead().checkOutFile(), mainsys.getRead().cancellationsFile(), hotel);
        mainsys.setCheckData(checkData);
        CmdLineInterface mainMenu = new CmdLineInterface();
        mainMenu.menu(hotel, mainsys);
    }


    /*
    Creates a new reservation.
    */
    public Reservations createRes(Hotel hotel, String name, String dateFrom, boolean reservType, int daysNum, int numOfRooms, String roomTypes, int numOfOccupancy, double totalcost) {
        Reservations newRes = new Reservations(name, dateFrom, reservType, daysNum, numOfRooms, roomTypes, numOfOccupancy, totalcost);
        return newRes;
    }

    /*
    If the room is available add it to the Reservation list. And then write the Reservation to the res.csv file.
    */
    public boolean addToList(Reservations newRes, Hotel hotel) {
        if (data.checkAvailability(newRes, hotel, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomTypes())) {
            data.getList().add(newRes);
            if (newRes.getNumOfRooms() > 1) {
                for (int i = 1; i < newRes.getNumOfRooms(); i++) {
                    if (data.checkAvailability(newRes, hotel, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomTypes())) {

                    } else {
                        data.findRoom(newRes.getNumber(), hotel);
                        return false;
                    }
                }
                read.writeReservations(hotel, data);
                return true;
            } else if (newRes.getNumOfRooms() == 1) {
                read.writeReservations(hotel, data);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    /*
    If the room is available return true.
    */
    public boolean checkRoomNoWrite(Reservations newRes, Hotel hotel) {
        if (data.checkAvailability(newRes, hotel, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomTypes())) {
            data.getList().add(newRes);
            if (newRes.getNumOfRooms() > 1) {
                for (int i = 1; i < newRes.getNumOfRooms(); i++) {
                    if (data.checkAvailability(newRes, hotel, newRes.getDateFrom(), newRes.getDateTo(), newRes.getRoomTypes())) {
                    } else {
                        data.findRoom(newRes.getNumber(), hotel);
                        return false;
                    }
                }
                return true;
            } else if (newRes.getNumOfRooms() == 1) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }


    /*
    Return the total cost of the passed in Reservation Object
    */
    public double getTotalCost(Reservations newRes, Hotel hotel) {
        int start = newRes.getDateFrom().get(Calendar.DAY_OF_WEEK);
        if (start == 1) {
            start = 6;
        } else {
            start = start - 2;
        }
        int numOfDays = newRes.getNumberOfDays();
        double[] rates = data.getRates(newRes, hotel);
        double totalCost = 0;
        if (numOfDays == 1) {
            totalCost = rates[start];
        } else {
            while (numOfDays > 0) {
                while (start < rates.length) {
                    totalCost = totalCost + rates[start];
                    start++;
                    numOfDays--;
                    if (numOfDays == 0) {
                        break;
                    }
                }
                start = 0;
            }
        }
        int numRooms = newRes.getNumOfRooms();
        totalCost = totalCost * numRooms;
        boolean resType = newRes.getReservType();
        //if true then type = standard booking
        //if false then type = advanced purchase
        if (resType == false) {
            totalCost = ((totalCost / 100) * 5) + totalCost;
        }
        return totalCost;
    }

    public boolean isValidDate(String inDate) {// Not my method http://www.javadb.com/check-if-a-string-is-a-valid-date

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
            GregorianCalendar present = new GregorianCalendar();
            String[] f = date.split("/");
            int d = Integer.parseInt(f[0]);
            int m = Integer.parseInt(f[1]) - 1;
            int y = Integer.parseInt(f[2]);
            GregorianCalendar future = new GregorianCalendar(y, m, d);
            if (future.getTimeInMillis() > present.getTimeInMillis()) {
                return true;
            }
            System.out.println("Date not in future");
        }
        return false;
    }


    public void setData(ReservationData data) {
        this.data = data;
    }

    public void setCheckData(ReservationList checkData) {
        this.checkData = checkData;
    }

    public ReservationList getCheckData() {
        return checkData;
    }

    public CSVHandler getRead() {
        return read;
    }

    public ReservationData getData() {
        return data;
    }


}


