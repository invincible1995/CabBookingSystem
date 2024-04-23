package cabbookingsystem.service;



import java.util.List;

import cabbookingsystem.entity.Booking;

public interface BookingService {
    Booking book(String riderUserId, Double lat, Double lon);
    List<Booking> history(String riderUserId);
    Boolean endTrip(Long timeStamp, String bookingId);
}
