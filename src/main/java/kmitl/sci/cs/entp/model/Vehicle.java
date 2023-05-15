package kmitl.sci.cs.entp.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// @JsonInclude(Include.NON_NULL)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vehicleId;
    @Column(length = 30)
    private String status;
    @Column(length = 30)
    private String owner;

    @CreationTimestamp
    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date associateDate;

    public Vehicle() {
        super();
        this.status = "AVAILABLE";
        this.owner = null;
        this.associateDate = null;
    }

    public long getVehicleId() {
        return this.vehicleId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void resetOwner() {
        this.owner = null;
    }

    public void setOwner(long ownerId) {
        this.owner = Long.toString(ownerId);
    }

    public void resetAssociateDate() {
        this.associateDate = null;
    }

    public void setAssociateDate() {
        this.associateDate = new Date();
    }

    public String getStatus() {
        return this.status;
    }

    public String getOwner() {
        return this.owner;
    }

    public Date getAssociateDate() {
        return this.associateDate;
    }
}
