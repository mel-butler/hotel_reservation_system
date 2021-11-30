

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ReservationData{
    private ArrayList<Reservations> list = new ArrayList<Reservations>();

    public ReservationData(){
    }

    /*
    Populates the List of reservations from the res.csv file.
    */
    public ReservationData(String[][] resData, Hotel hotel){
        ArrayList<Room> room;
        for(int i = 1; i< resData.length; i++){
            int number = Integer.parseInt(resData[i][0]);
            int count = 0;
            for(int z = 0; z< list.size(); z++){
                if(number == list.get(z).getNumber()){
                    count++;
                }
            }
            if(count == 0){
                if(resData[i][7].equals("Classic Single") || resData[i][7].equals("Classic Twin") || resData[i][7].equals("Classic Double")){
                    room = hotel.getArray("3");
                }else if(resData[i][7].equals("Executie Double") || resData[i][7].equals("Executive Twin") || resData[i][7].equals("Executive Single")){
                    room = hotel.getArray("4");
                }else{
                    room = hotel.getArray("5");
                }

                String name = resData[i][1];
                boolean resType = Boolean.parseBoolean(resData[i][2]);
                String dateFrom = resData[i][3];

                int days = Integer.parseInt(resData[i][5]);
                int numOfRooms = Integer.parseInt(resData[i][6]);
                String roomTypes = resData[i][7];
                int numOfOccupancy = Integer.parseInt(resData[i][8]);
                double feecharge = Double.parseDouble(resData[i][9]);

                Reservations res = new Reservations(number,name, dateFrom, resType,days, numOfRooms, roomTypes, numOfOccupancy,feecharge);
                int loop = 1;
                for(int j = 0; j < room.size(); j++){
                    if((roomTypes.equals(room.get(j).getRoomType())) == true){
                        if(loop <= numOfRooms){
                            room.get(j).getBooked().add(res);
                            loop++;
                        }else{
                            list.add(res);
                            break;
                        }
                    }
                }
            }
        }
    }

    /*
    Checks if a room is available and adds a reservation object to both the list of reservations and to the rooms associated with the object.
    */
    public boolean checkAvailability(Reservations res, Hotel hotel, GregorianCalendar dateFrom, GregorianCalendar dateTo, String roomType){// Get rid of SString parameter
        GregorianCalendar dateF = null;
       GregorianCalendar dateT = null;
        int pos = 0;
        for(int i = 0; i < hotel.getArray(hotel.getChoice()).size(); i++){
            if((roomType.equals(hotel.getArray(hotel.getChoice()).get(i).getRoomType())) == true){
                if(hotel.getArray(hotel.getChoice()).get(i).getBooked().size() > 0){
                    for(int j = 0; j < hotel.getArray(hotel.getChoice()).get(i).getBooked().size(); j++){
                        dateF = hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j).getDateFrom();
                        dateT = hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j).getDateTo();
                        if((dateFrom.before(dateF) && dateTo.before(dateF)) || (dateFrom.after(dateT) && dateTo.after(dateT))){
                            if(hotel.getArray(hotel.getChoice()).get(i).getBooked().size() == j+1){
                                pos = i;
                                hotel.getArray(hotel.getChoice()).get(pos).getBooked().add(res);
                                return true;
                            }
                        }else{
                            break;
                        }
                    }
                }else{
                    hotel.getArray(hotel.getChoice()).get(i).getBooked().add(res);
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Gets the rates for the roomType associated with the Reservation object passed in.
    */
    public double[] getRates(Reservations res, Hotel hotel){
        for(int i = 0; i < hotel.getArray(hotel.getChoice()).size(); i++){
            if((res.getRoomTypes().equals(hotel.getArray(hotel.getChoice()).get(i).getRoomType())) == true){
                return hotel.getArray(hotel.getChoice()).get(i).getRates();
            }
        }
        return null;
    }

    /*
    Finds a Reservation and cancels it removes it from the Reservation List
    */
    public boolean findRoom(int num, Hotel hotel){
        GregorianCalendar greg = new GregorianCalendar();
        for(int i = 0; i < hotel.getArray(hotel.getChoice()).size(); i++){
            for(int j = 0; j < hotel.getArray(hotel.getChoice()).get(i).getBooked().size(); j++){
                if(num == hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j).getNumber()){
                    if(hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j).getReservType()){
                        if((hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j).getDateFrom().getTimeInMillis() - greg.getTimeInMillis()) > 172800000 ){
                            hotel.getArray(hotel.getChoice()).get(i).getBooked().remove(j);
                        }else{
                            System.out.println("Too close to checkin date to cancel!");
                            return false;
                        }
                    }else{
                        System.out.println("Not allowed cancel AP reservations!");
                        return false;
                    }
                }
            }
        }


        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getNumber() == num){
                if((list.get(i).getDateFrom().getTimeInMillis() - greg.getTimeInMillis()) > 172800000 ){
                    list.remove(i);
                }
            }
        }
        return true;
    }

    /*
    Finds a Reservation and removes it from the Reservation List and removes it
    */
    public boolean cancellations(int num, Hotel hotel, MainSystem mainsys){
        GregorianCalendar greg = new GregorianCalendar();
        boolean flip = false;
        Reservations cancelled = null;
        for(int i = 0; i < hotel.getArray(hotel.getChoice()).size(); i++){
            for(int j = 0; j < hotel.getArray(hotel.getChoice()).get(i).getBooked().size(); j++){
                if(num == hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j).getNumber()){
                    if(hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j).getReservType()){
                        if((hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j).getDateFrom().getTimeInMillis() - greg.getTimeInMillis()) > 172800000 ){
                            cancelled = hotel.getArray(hotel.getChoice()).get(i).getBooked().get(j);
                            hotel.getArray(hotel.getChoice()).get(i).getBooked().remove(j);
                            flip = true;

                        }else{
                            System.out.println("Too close to checkin date to cancel!");
                            return false;
                        }
                    }else{
                        System.out.println("Not allowed cancel AP reservations!");
                        return false;
                    }
                }
            }
        }

        if(flip == false){
            return false;
        }
        mainsys.getCheckData().getCancellations().add(cancelled);
        mainsys.getRead().writeCancellations(hotel, mainsys.getCheckData());
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getNumber() == num){
                if((list.get(i).getDateFrom().getTimeInMillis() - greg.getTimeInMillis()) > 172800000 ){
                    list.remove(i);
                }
            }
        }
        return true;
    }

    public ArrayList<Reservations> getList() {
        return list;
    }
}
