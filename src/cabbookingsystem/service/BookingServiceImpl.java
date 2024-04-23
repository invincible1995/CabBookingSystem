package cabbookingsystem.service;

import java.util.List;
import java.util.UUID;

import cabbookingsystem.entity.Booking;
import cabbookingsystem.entity.VehicalDetails;
import cabbookingsystem.storage.StorageService;

public class BookingServiceImpl implements BookingService {
    VehicleService vehicleService;
    StorageService storageService;

    public BookingServiceImpl(VehicleService vehicleService, StorageService storageService) {
        this.vehicleService = vehicleService;
        this.storageService = storageService;
    }

    @Override
    public Booking book(String riderUserId, Double lat, Double lon) {
        //TODO check for valid rider
        //find cab
        VehicalDetails cab = vehicleService.find(lat, lon);
        //TODO lock the cab
        Booking booking = new Booking();
        booking.setBookingId(UUID.randomUUID().toString());
        booking.setCarNumber(cab.getCarNumber());
        booking.setRiderUserId(riderUserId);
        storageService.book(booking);
        return booking;
    }

    @Override
    public List<Booking> history(String riderUserId) {
        //TODO check for valid rider
        List<Booking> bookingHistory = storageService.rideHistory(riderUserId);
        return bookingHistory;
    }

    @Override
    public Boolean endTrip(Long timeStamp, String bookingId) {
        storageService.endTrip(timeStamp, bookingId);
        return true;
    }


}
