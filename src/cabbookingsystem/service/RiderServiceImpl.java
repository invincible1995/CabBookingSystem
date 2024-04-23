package cabbookingsystem.service;

import cabbookingsystem.entity.Rider;
import cabbookingsystem.storage.StorageService;

public class RiderServiceImpl implements  RiderService{
    private StorageService storageService;

    public RiderServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    public Boolean register(Rider rider) {
        return this.storageService.saveRider(rider);
    }
}
