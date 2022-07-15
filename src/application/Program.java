package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(checkOut.before(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            if (checkIn.before(new Date()) || checkOut.before(new Date())) {
                System.out.println("Error in reservation: Check-out and check-in must be before current date.");
            } else if (checkOut.before(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }
        sc.close();
    }

}
