package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.utils.ConsoleUtil;

import java.util.Date;

public class DisplayFreeRoomsByDate implements Action {

    @Override
    public void execute() throws Exception {

        BookingController bookingController = BookingController.getInstance();
        RoomController roomController = RoomController.getInstance();

        System.out.print("Введите количество дней, по истечению которых номера должны быть свободны: ");
        long days = ConsoleUtil.getScanner().nextLong();
        Date outDate = new Date();
        outDate.setTime(outDate.getTime() + days * 86400000L);

        for (Booking booking : bookingController.getAllBookings()) {
            if (booking.getRoom().getStatus() == RoomStatus.SERVED &&
                    booking.getCheckOutDate().getTime() <= outDate.getTime()) {
                roomController.displayRoomInfo(booking.getRoom().getId());
            }
        }
        
    }

}
