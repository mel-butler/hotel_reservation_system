
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CmdLineInterface {
    /*
    Run the menu. If the menu terminates so does the program.
    */
    public void menu(Hotel hotel, MainSystem mainsys) throws IOException{
        boolean run = true;
        Scanner in = new Scanner(System.in);
        
        while(run){
            boolean repeatInput = true;

            System.out.println("Welcome to the L4hotels reservation system. Please select one of the options:\n" + "Choose a hotel:\n" +
                    "3) Star, 4) Star, 5) Star or Q)uit");
            String choice = in.next().toUpperCase();
            
            while(repeatInput){
                try{
                    if(choice.equals("3")|| choice.equals("4")|| choice.equals("5") || choice.equals("Q") ){
                        repeatInput  = false;
                    }else{
                        throw new InputMismatchException("Not a valid option");
                    }
                }catch(InputMismatchException ex){
                    System.out.println("Incorrect input, please try again");
                    System.out.println("Welcome to the L4hotels reservation system. Please select one of the options:\n" + "Choose a hotel:\n" +
                            "3) Star, 4) Star, 5) Star");
                    in.nextLine();
                    choice = in.next().toUpperCase();
                }
            }
            if(choice.equals("Q")){
                System.out.println("Thank you for using the L4 Hotels booking system.");
                break;
            }
            hotel.setChoice(choice);



            System.out.println("Log in as: S)upervisor, D)esk admin, U)ser, Q)uit");
            choice = in.next().toUpperCase();
            repeatInput = true;

            while(repeatInput){
                try{
                    if(choice.equals("S")|| choice.equals("D")|| choice.equals("U") || choice.equals("Q")){
                        repeatInput  = false;
                    }else{
                        throw new InputMismatchException("Not a valid option");
                    }
                }catch(InputMismatchException ex){
                    System.out.println("Incorrect input, please try again");
                    System.out.println("Log in as:\n S)upervisor, D)esk admin, U)ser, Q)uit");;
                    in.nextLine();
                    choice = in.next().toUpperCase();
                }
            }


            if(choice.equals("S")){
                System.out.println("Please enter your password");
                if(in.next().equals("password")){
                    System.out.println("Welcome please choose an option:\n N)ew Reservation, C)ancellation, Check I)n, Check O)ut");
                    choice = in.next().toUpperCase();
                    repeatInput = true;
                    
                    while(repeatInput){
                        try{
                            if(choice.equals("N")|| choice.equals("C") || choice.equals("I") || choice.equals("O") ){
                                repeatInput  = false;
                            }else{
                                throw new InputMismatchException("Not a valid option");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Incorrect input, please try again");
                            System.out.println("Welcome please choose an option:\n N)ew Reservation, C)ancellation, Check I)n, Check O)ut");
                            in.nextLine();
                            choice = in.next().toUpperCase();
                        }
                    }



                    if(choice.equals("N")){
                        resMenu(hotel, mainsys);
                        
                    }else if(choice.equals("C")){

                        System.out.println("Enter your reservation number.");
                        int resNumber = 0;
                        repeatInput = true;
                        
                        while(repeatInput){
                            try{
                                resNumber = in.nextInt();
                                if(mainsys.getData().cancellations(resNumber, hotel, mainsys)){
                                    System.out.println("Reservation has been removed from the database.");
                                    mainsys.getRead().writeReservations(hotel, mainsys.getData());
                                }else{
                                    System.out.println("Reservation Number was not found");
                                }
                                repeatInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Please enter an integer number");
                                System.out.println("Enter your reservation number.");
                                in.nextLine();
                            }
                        }

                    }else if(choice.equals("I")){
                        System.out.println("Enter your reservation number.");
                        int resNumber = 0;
                        repeatInput = true;

                        while(repeatInput){
                            try{
                                resNumber = in.nextInt();
                                if(mainsys.getCheckData().checkIn(resNumber, mainsys.getData())){
                                    System.out.println("Checked In");
                                    mainsys.getRead().writeReservations(hotel, mainsys.getData());
                                    mainsys.getRead().writeCheckIns(hotel, mainsys.getCheckData());
                                }else{
                                    System.out.println("Cannot check in, please check that your reservation number is correct");
                                }
                                repeatInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Please enter an integer number");
                                System.out.println("Enter your reservation number.");
                                in.nextLine();
                            }
                        }

                    }else if(choice.equals("O")){
                        System.out.println("Enter your reservation number.");
                        int resNumber = 0;
                        repeatInput = true;
                        while(repeatInput){
                            try{
                                resNumber = in.nextInt();
                                if(mainsys.getCheckData().checkOut(resNumber)){
                                    System.out.println("Checked Out");
                                    mainsys.getRead().writeReservations(hotel, mainsys.getData());
                                    mainsys.getRead().writeCheckIns(hotel, mainsys.getCheckData());
                                    mainsys.getRead().writeCheckOuts(hotel, mainsys.getCheckData());
                                }else{
                                    System.out.println("Cannot check out, please check that your reservation number is correct");
                                }
                                repeatInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Please enter an integer number");
                                System.out.println("Enter your reservation number.");
                                in.nextLine();
                            }
                        }
                    }
                }
                
            }else if(choice.equals("D")){
                System.out.println("Please enter your password");
                if(in.next().equals("reception")){
                    System.out.println("Welcome please choose an option:\n N)ew Reservation, C)ancellation, Check I)n, Check O)ut");
                    choice = in.next().toUpperCase();
                    repeatInput = true;

                    while(repeatInput){
                        try{
                            if(choice.equals("N")|| choice.equals("C") || choice.equals("I") || choice.equals("O") ){
                                repeatInput  = false;
                            }else{
                                throw new InputMismatchException("Not a valid option");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Incorrect input, please try again");
                            System.out.println("Welcome please choose an option:\n N)ew Reservation, C)ancellation, Check I)n, Check O)ut");
                            in.nextLine();
                            choice = in.next().toUpperCase();
                        }
                    }



                    if(choice.equals("N")){
                        resMenu(hotel, mainsys);
                    }else if(choice.equals("C")){

                        System.out.println("Enter your reservation number.");
                        int resNumber = 0;
                        repeatInput = true;

                        while(repeatInput){
                            try{
                                resNumber = in.nextInt();
                                if(mainsys.getData().cancellations(resNumber, hotel, mainsys)){
                                    System.out.println("Reservation has been removed from the database.");
                                    mainsys.getRead().writeReservations(hotel, mainsys.getData());
                                }else{
                                    System.out.println("Reservation Number was not found");
                                }
                                repeatInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Please enter an integer number");
                                System.out.println("Enter your reservation number.");
                                in.nextLine();
                            }
                        }

                    }else if(choice.equals("I")){

                        System.out.println("Enter your reservation number.");
                        int resNumber = 0;
                        repeatInput = true;

                        while(repeatInput){
                            try{
                                resNumber = in.nextInt();
                                if(mainsys.getCheckData().checkIn(resNumber, mainsys.getData())){
                                    System.out.println("Checked In");
                                    mainsys.getRead().writeReservations(hotel, mainsys.getData());
                                    mainsys.getRead().writeCheckIns(hotel, mainsys.getCheckData());
                                }else{
                                    System.out.println("Cannot check in, please check that your reservation number is correct");
                                }
                                repeatInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Please enter an integer number");
                                System.out.println("Enter your reservation number.");
                                in.nextLine();
                            }
                        }

                    }else if(choice.equals("O")){
                        System.out.println("Enter your reservation number.");
                        int resNumber = 0;
                        repeatInput = true;

                        while(repeatInput){
                            try{
                                resNumber = in.nextInt();
                                if(mainsys.getCheckData().checkOut(resNumber)){
                                    System.out.println("Checked Out");
                                    mainsys.getRead().writeReservations(hotel, mainsys.getData());
                                    mainsys.getRead().writeCheckIns(hotel, mainsys.getCheckData());
                                    mainsys.getRead().writeCheckOuts(hotel, mainsys.getCheckData());
                                }else{
                                    System.out.println("Cannot check out, please check that your reservation number is correct");
                                }
                                repeatInput  = false;

                            }catch(InputMismatchException ex){
                                System.out.println("Please enter an integer number");
                                System.out.println("Enter your reservation number.");
                                in.nextLine();
                            }
                        }
                    }
                }

            }else if(choice.equals("U")){
                System.out.println("Welcome please choose an option:\n N)ew Reservation, C)ancellation");
                choice = in.next().toUpperCase();
                repeatInput = true;

                while(repeatInput){
                    try{
                        if(choice.equals("N")|| choice.equals("C")){
                            repeatInput  = false;
                        }else{
                            throw new InputMismatchException("Not a valid option");
                        }
                    }catch(InputMismatchException ex){
                        System.out.println("Incorrect input, please try again");
                        System.out.println("Welcome please choose an option:\n N)ew Reservation, C)ancellation");
                        in.nextLine();
                        choice = in.next().toUpperCase();
                    }
                }

                if(choice.equals("N")){
                    resMenu(hotel, mainsys);
                }else if(choice.equals("C")){


                    System.out.println("Enter your reservation number.");
                    int resNumber = 0;
                    repeatInput = true;

                    while(repeatInput){
                        try{
                            resNumber = in.nextInt();
                            if(mainsys.getData().cancellations(resNumber, hotel, mainsys)){
                                System.out.println("Reservation has been removed from the database.");
                                mainsys.getRead().writeReservations(hotel, mainsys.getData());
                            }else{
                                System.out.println("Reservation Number was not found");
                            }
                            repeatInput  = false;

                        }catch(InputMismatchException ex){
                            System.out.println("Please enter an integer number");
                            System.out.println("Enter your reservation number.");
                            in.nextLine();
                        }
                    }
                }
            }else if(choice.equals("Q")){
                    System.out.println("Thank you for using the L4 Hotels reservation system.");
                    break;
            }
        }
    }

    /*
    Menu for creating user reservations.
    */
    public void resMenu(Hotel hotel, MainSystem mainsys){
        boolean run = true;
        Scanner in = new Scanner(System.in);
        mainsys.getRead().printInfo();
        System.out.println("Please view our rates and hotels available for bookings above.");
        
        while(run){
            boolean available = true;
            while(available){

                System.out.println("What type of room would you like:");
                ArrayList<String> rmTypes = new ArrayList<String>();
                rmTypes = hotel.getUniqueRoomTypes(hotel.getArray(hotel.getChoice()));
                for(int i = 0; i < rmTypes.size(); i++){
                    System.out.println(i + ")" + rmTypes.get(i));
                }
                String choices = in.next().toUpperCase();
                if(rmTypes.size() == 4){
                    boolean repeatInput = true;
                    
                    while(repeatInput){
                        try{
                            if(choices.equals("0") || choices.equals("1") || choices.equals("2") || choices.equals("3")){
                                repeatInput  = false;
                            }else{
                                throw new InputMismatchException("Not a valid option");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Incorrect input, please try again");
                            for(int i = 0; i < rmTypes.size(); i++){
                                System.out.println(i + ")" + rmTypes.get(i));
                            }
                            in.nextLine();
                            choices = in.next().toUpperCase();
                        }
                    }

                }else{

                    boolean repeatInput = true;
                    
                    while(repeatInput){
                        try{
                            if(choices.equals("0") || choices.equals("1") || choices.equals("2")){
                                repeatInput  = false;
                            }else{
                                throw new InputMismatchException("Not a valid option");
                            }
                        }catch(InputMismatchException ex){
                            System.out.println("Incorrect input, please try again");
                            for(int i = 0; i < rmTypes.size(); i++){
                                System.out.println(i + ")" + rmTypes.get(i));
                            }
                            in.nextLine();
                            choices = in.next().toUpperCase();
                        }
                    }
                }
                int select = Integer.parseInt(choices);
                String roomTypes = rmTypes.get(select);


                System.out.println("how many rooms would you like:");
                int NumOfRooms = 1;
                boolean repeatInput = true;

                while(repeatInput){
                    try{
                        NumOfRooms = in.nextInt();
                        if(NumOfRooms > hotel.getMaxRooms(roomTypes)){
                            throw new InputMismatchException("You have selected too many rooms");
                        }else if(NumOfRooms < 1){
                            throw new InputMismatchException("Please choose at least 1 room");
                        }
                        repeatInput  = false;

                    }catch(InputMismatchException ex){
                        System.out.println("Please try again (" + ex +")");
                        System.out.println("how many rooms would you like:");
                        in.nextLine();
                    }
                }


                System.out.println("Arrival date in the format(DD/MM/YYYY):");
                String from = in.next();
                while(mainsys.isDateInFuture(from) == false){
                    System.out.println("Arrival date format(DD/MM/YYYY):");
                    in.nextLine();
                    from = in.next();
                }
                System.out.println("How many days would you like to stay:");
                int numOfDays = 0;
                repeatInput = true;

                while(repeatInput){
                    try{
                        numOfDays = in.nextInt();
                        if(numOfDays < 1){
                            throw new InputMismatchException("Please choose at least one day.");
                        }
                        repeatInput  = false;

                    }catch(InputMismatchException ex){
                        System.out.println("Please try again (" + ex +")");
                        System.out.println("How many days would you like to stay:");
                        in.nextLine();
                    }
                }


                Reservations can = new Reservations("name", from, true,  numOfDays, NumOfRooms, roomTypes, 1, 10.0);

                if(mainsys.checkRoomNoWrite(can, hotel)){
                    System.out.println("Rooms available.");
                    mainsys.getData().findRoom(can.getNumber(), hotel);
                }else{
                    System.out.println("Rooms unavailable.");
                    break;
                }

                System.out.println("Please enter your name:");
                in.nextLine();
                String name = in.nextLine();

                System.out.println("Please select your booking type:\n S)tandard Booking or A)dvanced Purchace:");
                String choice = in.next().toUpperCase();
                boolean resType = true;
                repeatInput = true;

                while(repeatInput){
                    try{
                        if(choice.equals("S")|| choice.equals("A")){
                            repeatInput  = false;
                        }else{
                            throw new InputMismatchException("Not a valid option");
                        }
                    }catch(InputMismatchException ex){
                        System.out.println("Incorrect input, please try again");
                        System.out.println("Please select your booking type:\n S)tandard Booking or A)dvanced Purchace:");
                        in.nextLine();
                        choice = in.next().toUpperCase();
                    }
                }

                if(choice.equals("S")){
                    resType = true;
                }else if(choice.equals("A")){
                    resType = false;
                }

                System.out.println("Please enter number of guests:");
                int occupancy= 1;
                repeatInput = true;

                while(repeatInput){
                    try{
                        occupancy = in.nextInt();
                        if(occupancy > hotel.getMaxOccupancy(roomTypes)){
                            throw new InputMismatchException("Too many guests");
                        }else if(occupancy < 1){
                            throw new InputMismatchException("You must input at least 1 guest");
                        }
                        repeatInput  = false;

                    }catch(InputMismatchException ex){
                        System.out.println("Please try again (" + ex +")");
                        System.out.println("Enter number of Guests:");
                        in.nextLine();
                    }
                }

                System.out.println("Guest number " + occupancy);
                Reservations newRes = mainsys.createRes(hotel,name, from, resType,numOfDays,NumOfRooms,roomTypes,occupancy, 0.0);
                double totalCost =  mainsys.getTotalCost(newRes, hotel);
                System.out.println("Total Cost: " + totalCost + "\nWould you like to book this room\n Y)es N)o");
                choice = in.next().toUpperCase();
                repeatInput = true;

                while(repeatInput){
                    try{
                        if(choice.equals("Y") || choice.equals("N")){
                            repeatInput  = false;
                        }else{
                            throw new InputMismatchException("Not a valid option");
                        }
                    }catch(InputMismatchException ex){
                        System.out.println("Incorrect input, please try again");
                        System.out.println("Would you like to book this room\n Y)es N)o");
                        in.nextLine();
                        choice = in.next().toUpperCase();
                    }
                }

                if(choice.equals("Y")){

                    System.out.println("Please pay your fee \n(this is supposed to represent billing, just enter an amount equal to total cost):");
                    double feecharge = 0.00;

                    repeatInput = true;
                    while(repeatInput){
                        try{
                            feecharge = in.nextDouble();
                            if(feecharge != totalCost){
                                throw new InputMismatchException("Amount entered is insufficient");
                            }else if(feecharge < 0){
                                throw new InputMismatchException("Cannot accept negative values");
                            }
                            newRes.setFeeCharge(feecharge);
                            repeatInput  = false;

                        }catch(InputMismatchException ex){
                            System.out.println("Please try again (" + ex + ")");
                            in.nextLine();
                        }
                    }

                    if(mainsys.addToList(newRes, hotel)){
                        System.out.println("Thank you for making a reservation. Your reservation number is " + newRes.getNumber() );
                        System.out.println();
                        run = false;
                    }else{
                        System.out.println("We are currently fully booked");
                        System.out.println();
                    }
                }else if(choice.equals("N")){
                    run = false;
                }
                break;
            }
        }
    }
}