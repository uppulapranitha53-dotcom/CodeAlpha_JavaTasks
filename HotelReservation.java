import java.util.Scanner;

class Room {
    int roomNumber;
    String type;
    boolean isBooked;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }
}

public class HotelReservation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Room[] rooms = {
                new Room(101, "Standard"),
                new Room(102, "Deluxe"),
                new Room(103, "Suite")
        };

        int choice;

        do {
            System.out.println("\n--- Hotel Menu ---");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Room r : rooms) {
                        System.out.println("Room " + r.roomNumber + " (" + r.type + ") - " +
                                (r.isBooked ? "Booked" : "Available"));
                    }
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int bookNum = sc.nextInt();

                    for (Room r : rooms) {
                        if (r.roomNumber == bookNum && !r.isBooked) {
                            r.isBooked = true;
                            System.out.println("Room booked successfully!");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelNum = sc.nextInt();

                    for (Room r : rooms) {
                        if (r.roomNumber == cancelNum && r.isBooked) {
                            r.isBooked = false;
                            System.out.println("Booking cancelled!");
                            break;
                        }
                    }
                    break;
            }

        } while (choice != 0);
    }
}