package com.dkadur.assettracker.deviceservice.entity;

import com.google.cloud.spring.data.spanner.core.mapping.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="devices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    @PrimaryKey(keyOrder = 1)
    @Column(name="uuid")
    private String uuid;

    @Column(name="name")
    private String name;

    @Column(name="model")
    private String model;

    @Column(name="location")
    private String location;

    @Column(name="type")
    private String type;

    @Column(name="connectionStatus")
    private String connectionStatus;

    @Column(name="batteryStatus")
    private String batteryStatus;

    @Column(name="tenantId")
    private int tenantId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }
}
