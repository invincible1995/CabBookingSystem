package cabbookingsystem;

import java.util.List;
import cabbookingsystem.storage.*;
import cabbookingsystem.service.*;
import cabbookingsystem.entity.*;

public class CabBookingSytem {

	
	    private static StorageService storageService = new StorageServiceImpl();
	    private static RiderService riderService = new RiderServiceImpl(storageService);
	    private static DriverService driverService = new DriverServiceImpl(storageService);
	    private static VehicleService vehicleService = new VehicleServiceImpl(storageService);
	    private static BookingService bookingService = new BookingServiceImpl(vehicleService, storageService);

	    public static void main(String args[]){
	        Rider rider = new Rider();
	        rider.setName("Anupam");
	        rider.setMobile_no("8159973762");
	        riderService.register(rider);

	        Driver driver = new Driver();
	        driver.setName("OLA");
	        driver.setMobile_no("7980371418");
	        driverService.register(driver);

	        VehicalDetails vehicle = new VehicalDetails();
	        vehicle.setCarNumber("KA05KJ6244");
	        vehicle.setLat(5D);
	        vehicle.setLon(6D);
	        vehicle.setType("Car");
	        vehicle.setIsAvailable(true);
	        vehicleService.registerVehicle(vehicle);

	        vehicle.setLat(3D);
	        vehicle.setLon(4D);
	        vehicleService.updateLocation(vehicle);

	        bookingService.book("8159973762", 1D, 2D);

	        List<Booking> bookingHistory = bookingService.history("8159973762");
	        System.out.println("bookingHistory"+bookingHistory);

	    }

}
