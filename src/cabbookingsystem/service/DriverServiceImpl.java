package cabbookingsystem.service;


import cabbookingsystem.entity.Driver;
import cabbookingsystem.storage.StorageService;


public class DriverServiceImpl implements DriverService {
    private StorageService storageService;

    public DriverServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    public Boolean register(Driver driver) {
        this.storageService.saveDriver(driver);
        return true;
    }
}
