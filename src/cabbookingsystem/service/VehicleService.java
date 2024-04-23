package cabbookingsystem.service;

import cabbookingsystem.entity.VehicalDetails;

public interface VehicleService {
    Boolean registerVehicle(VehicalDetails cab);
    Boolean updateLocation(VehicalDetails cab);
    VehicalDetails find(Double lat, Double lon);
}
