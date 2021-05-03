package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.data.GuestDataStorage;
import eu.senla.JavaLab33.api.repositories.GuestRepository;
import eu.senla.JavaLab33.memodatastorage.GuestDataStorageImpl;
import eu.senla.JavaLab33.model.Guest;

public class GuestRepositoryImpl extends AbstractRepositoryImpl<Guest> implements GuestRepository {

    private static GuestRepository instance;

    private static GuestDataStorage guestDataStorage;

    public GuestRepositoryImpl() {
        abstractDataStorage = GuestDataStorageImpl.getInstance();
        guestDataStorage = (GuestDataStorage) abstractDataStorage;
    }

    public static GuestRepository getInstance() {
        if (instance == null) {
            instance = new GuestRepositoryImpl();
        }
        return instance;
    }

}
