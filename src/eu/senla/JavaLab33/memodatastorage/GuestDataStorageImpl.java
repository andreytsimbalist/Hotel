package eu.senla.JavaLab33.memodatastorage;

import eu.senla.JavaLab33.api.data.GuestDataStorage;
import eu.senla.JavaLab33.model.Guest;

public class GuestDataStorageImpl extends AbstractDataStorageImpl<Guest> implements GuestDataStorage {

    private static GuestDataStorage instance;

    public static GuestDataStorage getInstance() {
        if (instance == null) {
            instance = new GuestDataStorageImpl();
        }
        return instance;
    }

}
