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
}
