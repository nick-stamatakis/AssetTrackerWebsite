package com.dkadur.assettracker.deviceservice.service;

import com.dkadur.assettracker.deviceservice.entity.Device;
import com.dkadur.assettracker.deviceservice.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device findDeviceById(Long deviceId) {
        //return deviceRepository.findByDeviceId(deviceId);
        return new Device();
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
}
