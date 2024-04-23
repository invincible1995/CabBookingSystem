package cabbookingsystem.storage;



import java.sql.SQLException;
import java.util.List;

import cabbookingsystem.entity.Booking;
import cabbookingsystem.entity.VehicalDetails;
import cabbookingsystem.entity.Driver;
import cabbookingsystem.entity.Rider;

public interface StorageService {
    Boolean saveRider(Rider rider);
    Boolean saveDriver(Driver driver);
    Boolean saveVehicle(VehicalDetails cab);
    Boolean updateLocation(VehicalDetails cab);
    Boolean book(Booking booking);
    VehicalDetails find(Double lat, Double lon, Double maxDistance);
    List<Booking> rideHistory(String riderUserId);
    Boolean endTrip(Long timeStamp, String bookingId);

    Rider getRiderWithRiderUserID(String riderUserId);
}
