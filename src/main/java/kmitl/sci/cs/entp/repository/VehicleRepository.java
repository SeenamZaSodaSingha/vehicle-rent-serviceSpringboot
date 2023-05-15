package kmitl.sci.cs.entp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kmitl.sci.cs.entp.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByVehicleId(long id);
    // void associate(long vehicleId, long userId);
    void deleteByVehicleId(long id);
}
