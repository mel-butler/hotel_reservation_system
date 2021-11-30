
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ReservationList {
    private ArrayList<Reservations> checkedIn = new ArrayList<Reservations>();
    private ArrayList<Reservations> checkedOut = new ArrayList<Reservations>();
    private ArrayList<Reservations> cancellations = new ArrayList<Reservations>();

    public ReservationList(String[][] checkInData, String[][] checkOutData, String[][] cancellations, Hotel hotel) {
        createCheckedIn(checkInData, hotel);
        createCheckedOut(checkOutData, hotel);
        createCancellations(cancellations, hotel);
    }

    public void createCheckedIn(String[][] checkInData, Hotel hotel) {
        ArrayList<Room> room;
        for (int i = 1; i < checkInData.length; i++) {
            int number = Integer.parseInt(checkInData[i][0]);

            int count = 0;
            for (int z = 0; z < checkedIn.size(); z++) {
                if (number == checkedIn.get(z).getNumber()) {
                    count++;
                }
            }
            if (count == 0) {
                if (checkInData[i][7].equals("Classic Single") || checkInData[i][7].equals("Classic Twin") || checkInData[i][7].equals("Classic Double")) {
                    room = hotel.getArray("3");
                } else if (checkInData[i][7].equals("Executie Double") || checkInData[i][7].equals("Executive Twin") || checkInData[i][7].equals("Executive Single")) {
                    room = hotel.getArray("4");
                } else {
                    room = hotel.getArray("5");
                }

                String name = checkInData[i][1];
                boolean resType = Boolean.parseBoolean(checkInData[i][2]);
                String dateFrom = checkInData[i][3];
                int numOfDays = Integer.parseInt(checkInData[i][5]);
                int numOfRooms = Integer.parseInt(checkInData[i][6]);
                String roomTypes = checkInData[i][7];
                int numOfOccupancy = Integer.parseInt(checkInData[i][8]);

                double feeCharge = Double.parseDouble(checkInData[i][9]);

                Reservations res = new Reservations(name,dateFrom, resType, numOfDays, numOfRooms, roomTypes,numOfOccupancy,feeCharge);
                int loop = 1;
                for (int j = 0; j < room.size(); j++) {
                    if ((roomTypes.equals(room.get(j).getRoomType())) == true) {
                        if (loop <= numOfRooms) {
                            room.get(j).getBooked().add(res);
                            loop++;
                        } else {
                            checkedIn.add(res);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void createCheckedOut(String[][] checkOutData, Hotel hotel) {
        ArrayList<Room> room;
        for (int i = 1; i < checkOutData.length; i++) {
            int number = Integer.parseInt(checkOutData[i][0]);
            int count = 0;
            for (int z = 0; z < checkedOut.size(); z++) {
                if (number == checkedOut.get(z).getNumber()) {
                    count++;
                }
            }
            if (count == 0) {
                if (checkOutData[i][7].equals("Classic Single") || checkOutData[i][7].equals("Classic Twin") || checkOutData[i][7].equals("Classic Double")) {
                    room = hotel.getArray("3");
                } else if (checkOutData[i][7].equals("Executie Double") || checkOutData[i][7].equals("Executive Twin") || checkOutData[i][7].equals("Executive Single")) {
                    room = hotel.getArray("4");
                } else {
                    room = hotel.getArray("5");
                }

                String name = checkOutData[i][1];
                boolean resType = Boolean.parseBoolean(checkOutData[i][2]);
                String dateFrom = checkOutData[i][3];
                int numOfDays = Integer.parseInt(checkOutData[i][5]);
                int numOfRooms = Integer.parseInt(checkOutData[i][6]);
                String roomTypes = checkOutData[i][7];
                int numOfOccupancy = Integer.parseInt(checkOutData[i][8]);

                double feeCharge = Double.parseDouble(checkOutData[i][9]);

                Reservations res = new Reservations(name,dateFrom, resType, numOfDays, numOfRooms, roomTypes, numOfOccupancy,feeCharge);
                int loop = 1;
                double sevenYears = 220898664000.0;
                GregorianCalendar present = new GregorianCalendar();
                if((present.getTimeInMillis() - res.getDateTo().getTimeInMillis()) < sevenYears){
                    for (int j = 0; j < room.size(); j++) {
                        if ((roomTypes.equals(room.get(j).getRoomType())) == true) {
                            if (loop <= numOfRooms) {
                                room.get(j).getBooked().add(res);
                                loop++;
                            } else {
                                checkedOut.add(res);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void createCancellations(String[][] cancellationsData, Hotel hotel) {
        ArrayList<Room> room;
        for (int i = 1; i < cancellationsData.length; i++) {
            int number = Integer.parseInt(cancellationsData[i][0]);
            int count = 0;
            for (int z = 0; z < cancellations.size(); z++) {
                if (number == cancellations.get(z).getNumber()) {
                    count++;
                }
            }
            if (count == 0) {
                if (cancellationsData[i][7].equals("Classic Single") || cancellationsData[i][7].equals("Classic Twin") || cancellationsData[i][7].equals("Classic Double")) {
                    room = hotel.getArray("3");
                } else if (cancellationsData[i][7].equals("Executie Double") || cancellationsData[i][7].equals("Executive Twin") || cancellationsData[i][7].equals("Executive Single")) {
                    room = hotel.getArray("4");
                } else {
                    room = hotel.getArray("5");
                }

                String name = cancellationsData[i][1];
                boolean resType = Boolean.parseBoolean(cancellationsData[i][2]);
                String dateFrom = cancellationsData[i][3];
                int numOfDays = Integer.parseInt(cancellationsData[i][5]);

                int numOfRooms = Integer.parseInt(cancellationsData[i][6]);
                String roomTypes = cancellationsData[i][7];
                int numOfOccupancy = Integer.parseInt(cancellationsData[i][8]);

                double feeCharge = Double.parseDouble(cancellationsData[i][9]);

                Reservations res = new Reservations(name, dateFrom,resType,numOfDays,numOfRooms, roomTypes,numOfOccupancy,feeCharge);
                int loop = 1;
                double sevenYears = 220898664000.0;
                GregorianCalendar present = new GregorianCalendar();
                if((present.getTimeInMillis() - res.getDateTo().getTimeInMillis()) < sevenYears){
                    for (int j = 0; j < room.size(); j++) {
                        if ((roomTypes.equals(room.get(j).getRoomType())) == true) {
                            if (loop <= numOfRooms) {
                                room.get(j).getBooked().add(res);
                                loop++;
                            } else {
                                cancellations.add(res);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean checkIn(int num, ReservationData data) {
        GregorianCalendar present = new GregorianCalendar();
        for (int i = 0; i < data.getList().size(); i++) {
            if (data.getList().get(i).getNumber() == num) {
                if (data.getList().get(i).getDateFrom().after(present)) {

                } else {
                    checkedIn.add(data.getList().get(i));
                    data.getList().remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkOut(int num) {

        for (int i = 0; i < this.checkedIn.size(); i++) {
            if (this.checkedIn.get(i).getNumber() == num) {
                checkedOut.add(this.checkedIn.get(i));
                checkedIn.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Reservations> getCheckedIn() {
        return checkedIn;
    }

    public ArrayList<Reservations> getCheckedOut() {
        return checkedOut;
    }

    public ArrayList<Reservations> getCancellations() {
        return cancellations;
    }
}

