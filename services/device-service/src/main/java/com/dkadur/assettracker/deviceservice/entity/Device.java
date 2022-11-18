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
    @Column(name="deviceId")
    private Long deviceId;

    @Column(name="deviceName")
    private String deviceName;
}
