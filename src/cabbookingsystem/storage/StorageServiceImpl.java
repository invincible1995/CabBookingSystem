package cabbookingsystem.storage;



import java.util.*;

import cabbookingsystem.entity.Booking;
import cabbookingsystem.entity.VehicalDetails;
import cabbookingsystem.entity.Driver;
import cabbookingsystem.entity.Rider;

public class StorageServiceImpl implements StorageService {
    public static final String COMPLETED = "COMPLETED";
    private Map<String, Rider> riderStorage;
    private Map<String, Driver> driverStorage;
    private Map<String, VehicalDetails> vehicleStorage;
    private Map<String, Booking> bookingStorage;

    public StorageServiceImpl() {
        this.riderStorage = new HashMap<>();
        this.driverStorage = new HashMap<>();
        this.vehicleStorage = new HashMap<>();
        this.bookingStorage = new HashMap<>();
    }

    public Boolean saveRider(Rider rider) {
        StringBuffer sb = new StringBuffer();
        sb.append(rider.getMobile_no());
        String riderUniqueId = sb.toString();
        if(this.riderStorage.get(riderUniqueId) != null){
            throw new RuntimeException("Rider already exist in the system");
        }
        this.riderStorage.put(riderUniqueId, rider);
        System.out.println(" : riderStorage :"+riderStorage);
        return true;
    }

    @Override
    public Boolean saveDriver(Driver driver) {
        StringBuffer sb = new StringBuffer();
        sb.append(driver.getMobile_no());
        String driverUniqueId = sb.toString();
        if(this.driverStorage.get(driverUniqueId) != null){
            throw new RuntimeException("Driver already exist in the system");
        }
        this.driverStorage.put(driverUniqueId, driver);
        System.out.println(" : driverStorage :"+driverStorage);
        return true;
    }

    @Override
    public Boolean saveVehicle(VehicalDetails cab) {
        if(this.vehicleStorage.get(cab.getCarNumber()) != null){
            throw new RuntimeException("CabDetails already exist in the system");
        }
        this.vehicleStorage.put(cab.getCarNumber(), cab);
        System.out.println(" : vehicleStorage :"+vehicleStorage);
        return true;
    }

    @Override
    public Boolean updateLocation(VehicalDetails cab) {
        if(this.vehicleStorage.get(cab.getCarNumber()) == null){
            throw new RuntimeException("CabDetails does not exist in the system");
        }
        VehicalDetails cabInDb = this.vehicleStorage.get(cab.getCarNumber());
        cabInDb.setLat(cab.getLat());
        cabInDb.setLon(cab.getLon());
        this.vehicleStorage.put(cab.getCarNumber(), cabInDb);
        System.out.println(" : vehicleStorage After CabDetails lat lon :"+vehicleStorage);
        return true;
    }

    @Override
    public Boolean book(Booking booking) {
        this.bookingStorage.put(booking.getBookingId(), booking);
        Rider rider = this.riderStorage.get(booking.getRiderUserId());
        //System.out.println(booking.getRiderUserId());
        List<String> bookingHistory = rider.getBookingHistory();
        if(bookingHistory == null){
            bookingHistory = new ArrayList<>();
        }
        bookingHistory.add(booking.getBookingId());
        rider.setBookingHistory(bookingHistory);
        this.riderStorage.put(booking.getRiderUserId(), rider);
        System.out.println(" bookingStorage :"+bookingStorage);
        System.out.println(" riderStorage after updating ride history :"+riderStorage.get(booking.getRiderUserId()).getBookingHistory().toString());
        return true;
    }

    @Override
    public VehicalDetails find(Double lat, Double lon, Double maxDistance) {
        TreeMap<Double, VehicalDetails> distanceVehicleMap = new TreeMap<>();
        for(String vehicleId : this.vehicleStorage.keySet()){
            VehicalDetails vehicle = this.vehicleStorage.get(vehicleId);
            Double distance = Math.sqrt((lon)*(vehicle.getLon()) +(lat)*(vehicle.getLat()));
            if(distance < maxDistance) {
                distanceVehicleMap.put(distance, vehicle);
            }
        }
        return distanceVehicleMap.pollFirstEntry().getValue();
    }

    @Override
    public List<Booking> rideHistory(String riderUserId) {
        Rider rider = this.riderStorage.get(riderUserId);
        //System.out.println(riderUserId);
        List<String> riderBookingIdsHistory = rider.getBookingHistory();
        List<Booking> bookingHistory = new ArrayList<>();
        for(String bookingId : riderBookingIdsHistory){
            Booking booking = this.bookingStorage.get(bookingId);
            bookingHistory.add(booking);
        }
        return bookingHistory;
    }

    @Override
    public Boolean endTrip(Long timeStamp, String bookingId) {
        Booking booking = this.bookingStorage.get(bookingId);
        if(booking == null){
            throw new RuntimeException("No trip by this Id");
        }
        if(booking.getStatus() != null){
            throw new RuntimeException("Booking already ended");
        }
        booking.setEndTime(timeStamp);
        booking.setStatus(COMPLETED);
        return true;
    }

    @Override
    public Rider getRiderWithRiderUserID(String riderUserId) {
        Rider rider = this.riderStorage.get(riderUserId);
        return rider;
    }
}
