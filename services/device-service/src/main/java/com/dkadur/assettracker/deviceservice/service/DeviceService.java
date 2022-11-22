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

    public Optional<Device> findDeviceById(Long deviceId) {
        return deviceRepository.findById(deviceId);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public String removeDeviceById(Long deviceId) {
        deviceRepository.deleteById(deviceId);
        return "Device successfully deleted";
    }
}
