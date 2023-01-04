package com.dkadur.assettracker.deviceservice.template;

import com.google.cloud.spring.data.spanner.core.mapping.Column;

public interface DeviceList {

    String getName();
    String getUuid();
    String getModel();
    String getLocation();
    String getStatus();
    String getType();
}
