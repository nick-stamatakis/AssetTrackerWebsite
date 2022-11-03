package com.dkadur.assettracker.deviceservice.service;

import com.dkadur.assettracker.deviceservice.entity.Device;
import com.dkadur.assettracker.deviceservice.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    private String adminPassword = "asset-tracker";

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device findDeviceById(Long deviceId) {
        return deviceRepository.findByDeviceId(deviceId);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
}
