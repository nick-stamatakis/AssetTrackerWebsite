package com.dkadur.assettracker.deviceservice.entity;

import com.google.cloud.spring.data.spanner.core.mapping.*;
import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name="devices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    @Id
    @PrimaryKey(keyOrder = 1)
    @Column(name="deviceId")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long deviceId;

    @Column(name="deviceName")
    private String deviceName;
}
