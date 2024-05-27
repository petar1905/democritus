package github.petar1905.services;

import github.petar1905.models.Media;
import github.petar1905.models.Rent;
import github.petar1905.models.User;

interface RentServiceMethods {
    Rent[] getAllRents();
    Rent[] getRents(User user);
    Rent[] getRents(Media media);
}

public class RentService implements RentServiceMethods {
    private static RentService singleInstance = null;

    private RentService() {}

    public static synchronized RentService getInstance() {
        if (singleInstance == null) {
            singleInstance = new RentService();
        }
        return singleInstance;
    }

    @Override
    public Rent[] getAllRents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllRents'");
    }

    @Override
    public Rent[] getRents(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRents'");
    }

    @Override
    public Rent[] getRents(Media media) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRenters'");
    }
}
