package Session01_ExceptionAndAssertions;

import java.util.Scanner;

public class Hotel {
    private int capacity;
    private int roomOccupied;
    private int nextReservation = 0;
    private int nextReservationId = 1;
    private final int maxReservation = 3;
    private RoomReservation[] reservations;
    Scanner scan = new Scanner(System.in);
    public Hotel(){
        this.capacity = 10;
        reservations = new RoomReservation[maxReservation];
    }

    public void displayReservationDetails(RoomReservation item){
        System.out.println("Your room reservation details are: ");
        System.out.println("ID: " + item.reservationID + "Name: " + item.customerName + "Roombooked: " +item.roomBooked);
    }

    public void setCapacity() {
        int cap;
        try {
            System.out.println("Enter your capacity: ");
            cap = scan.nextInt();
            if (cap <= 0) {
                throw new RoomNotAvailableException();
            }
            this.capacity += cap;
        }catch (RoomNotAvailableException e) {
                e.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void bookRoom(){
        try {
            System.out.println("Enter customer Name: ");
            String customerName = scan.nextLine();
            System.out.println("How many room you want book: ");
            int rooms = scan.nextInt();

            if (rooms <= 0) {
                throw new RoomNotAvailableException();
            }
            int available = capacity - roomOccupied;
            if (rooms > available) {
                throw new RoomNotAvailableException(available);
            } else {
                RoomReservation item = new RoomReservation();
                item.customerName = customerName;
                item.roomBooked = rooms;
                item.reservationID = nextReservationId++;
                reservations[nextReservationId++] = item;
                roomOccupied += rooms;
                System.out.println("Successfully!");
                displayReservationDetails(item);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Full room");
        }catch (RoomNotAvailableException e){
            System.out.println("Exception occupied: " + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
