package com.dkadur.assettracker.deviceservice.repository;

import com.dkadur.assettracker.deviceservice.entity.Device;
import com.dkadur.assettracker.deviceservice.template.DeviceList;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface DeviceRepository extends SpannerRepository<Device, Long> {
    List<Device> findAll();

    @Query(value = "SELECT type, COUNT(*) AS count FROM devices WHERE tenantId = @tenantId GROUP BY type")
    List<String> getDeviceCountTypesByTenantId(
            @Param("tenantId") int tenantId
    );

    @Query(value = "SELECT COUNT(*) AS count FROM devices GROUP BY type")
    List<Integer> getDeviceCounts();

    @Query(value = "SELECT name, uuid, * EXCEPT(uuid, name) FROM devices")
    List<Device> getDeviceList();

    @Query(value = "SELECT * FROM devices WHERE tenantId = @tenantId")
    List<Device> getDeviceListByTenantId(
            @Param("tenantId") int tenantId
    );
}
