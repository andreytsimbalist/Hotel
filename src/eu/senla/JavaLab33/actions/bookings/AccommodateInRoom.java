package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.controllers.GuestController;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.exceptions.NoRoomException;
import eu.senla.JavaLab33.exceptions.WrongChoiceException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccommodateInRoom implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();
        BookingController bookingController = BookingController.getInstance();
        GuestController guestController = GuestController.getInstance();

        System.out.println("Количество людей для заселения: ");
        int count = ConsoleUtil.getScanner().nextInt();
        List<Room> rooms = roomController.getRoomsByCapacity(count);
        if (rooms.isEmpty()) {
            throw new NoRoomException();
        } else {
            roomController.getRoomsByStatus(RoomStatus.AVAILABLE)
                    .forEach(room -> roomController.displayRoomInfo(room.getId()));
        }

        System.out.print("ID номера для заселения: ");
        long id = ConsoleUtil.getScanner().nextLong();

        Booking booking = new Booking();
        booking.setRoom(roomController.getRoom(id));
        booking.setRegistrationDate(new Date());
        booking.setFacilities(new ArrayList<>());

        System.out.print("Сколько дней будете гостить: ");
        int days = ConsoleUtil.getScanner().nextInt();
        booking.setCheckOutDate(new Date(Long.parseLong(booking.getRegistrationDate().toString()) +
                days * 86400000L));

        byte choice;
        for (int i = 0; i < count; i++) {
            guestController.getAllGuests().
                    forEach(guest -> guestController.displayGuestInfo(guest.getId()));
            System.out.print("В списке есть ваши данные? (1 - да, 2 - нет)\nВаш выбор: ");
            choice = ConsoleUtil.getScanner().nextByte();
            switch (choice){
                case 1:
                    System.out.print("ID ваших данных: ");
                    booking.getGuests().add(guestController.getById(ConsoleUtil.getScanner().nextLong()));
                    break;
                case 2:
                    System.out.print("Имя: ");
                    String name = ConsoleUtil.getScanner().next();
                    System.out.print("Фамилия: ");
                    String surname = ConsoleUtil.getScanner().next();
                    System.out.print("Номер телефона: ");
                    String phone = ConsoleUtil.getScanner().next();
                    booking.getGuests().
                            add(guestController.getById(guestController.createGuest(name, surname, phone)));
                    break;
                default:
                    throw new WrongChoiceException();
            }
        }

        bookingController.createBooking(booking);

        System.out.println();

        roomController.changeRoomStatus(id, RoomStatus.SERVED);

        System.out.println("Заселение прошло успешно.\n");
    }

}
