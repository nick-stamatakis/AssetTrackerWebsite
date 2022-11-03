package com.dkadur.assettracker.deviceservice.repository;

import com.dkadur.assettracker.deviceservice.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Device findByDeviceId(Long deviceId);
}
