package kmitl.sci.cs.entp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kmitl.sci.cs.entp.model.Vehicle;
import kmitl.sci.cs.entp.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicle(long vehicleId) {
        return vehicleRepository.findByVehicleId(vehicleId);
    }

    @Override
    public void create() {
        vehicleRepository.save(new Vehicle());
    }

    @Override
    public void delete(long vehicleId) {
        Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId);
        // vehicleRepository.delete(vehicle);
        vehicle.resetOwner();
        vehicle.setStatus("AVAILABLE");
        vehicle.resetAssociateDate();
        vehicleRepository.save(vehicle);
    }

    @Override
    public void associate(long vehicleId, long ownerId) {
        Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId);
        vehicle.setOwner(ownerId);
        vehicle.setStatus("ASSOCIATED");
        vehicle.setAssociateDate();
        vehicleRepository.save(vehicle);
    }
}
