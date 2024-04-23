package cabbookingsystem.service;


import cabbookingsystem.entity.VehicalDetails;
import cabbookingsystem.storage.StorageService;


public class VehicleServiceImpl implements VehicleService {
    StorageService storageService;

    private static final double MAX_DISTANCE = 110D;

    public VehicleServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public Boolean registerVehicle(VehicalDetails cab) {
        this.storageService.saveVehicle(cab);
        return true;
    }

    @Override
    public Boolean updateLocation(VehicalDetails cab) {
        this.storageService.updateLocation(cab);
        return true;
    }

    @Override
    public VehicalDetails find(Double lat, Double lon) {
    	VehicalDetails cab = this.storageService.find(lat, lon, MAX_DISTANCE);
        if(cab == null){
            throw new RuntimeException("Vehicle not available");
        }
        return cab;
    }
}
