package kmitl.sci.cs.entp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kmitl.sci.cs.entp.model.Vehicle;
import kmitl.sci.cs.entp.service.VehicleService;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping("/vehicles/{vehicleId}")
    public Vehicle getVehicle(@PathVariable long vehicleId) {
        return vehicleService.getVehicle(vehicleId);
    }

    @PostMapping("/vehicles/add")
    public void create() {
        vehicleService.create();
    }

    @PostMapping("/{vehicleId}/user/{userId}")
    public void associate(@PathVariable long vehicleId, @PathVariable long userId) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        if (vehicle != null) {
            vehicleService.associate(vehicleId, userId);
        }
    }

    @DeleteMapping("/{vehicleId}/user/{userId}")
    public void delete(@PathVariable long vehicleId, @PathVariable long userId) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        if (vehicle != null) {
            vehicleService.delete(vehicleId);
        }
    }
}
