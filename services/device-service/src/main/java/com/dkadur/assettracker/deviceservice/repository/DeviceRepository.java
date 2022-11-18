package com.dkadur.assettracker.deviceservice.repository;

import com.dkadur.assettracker.deviceservice.entity.Device;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends SpannerRepository<Device, Long> {
}
