package kmitl.sci.cs.entp.model;

public class PatchVehicleRequest {
	private long vehicleId;
	private String owner;
	private String status;

    public long getVehicleId() {
        return vehicleId;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
