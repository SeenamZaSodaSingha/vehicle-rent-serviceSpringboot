package kmitl.sci.cs.entp.service;

import java.util.List;

import kmitl.sci.cs.entp.model.Vehicle;

public interface VehicleService {
    public List<Vehicle> getVehicles();
    public Vehicle getVehicle(long vehicleId);
    public void create(Vehicle vehicle);
    public void associate(long vehicleId, long ownerId);   
    public void delete(long vehicleId);
}