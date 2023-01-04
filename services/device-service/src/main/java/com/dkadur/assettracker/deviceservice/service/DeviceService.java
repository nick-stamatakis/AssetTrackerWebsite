package com.dkadur.assettracker.deviceservice.service;

import com.dkadur.assettracker.deviceservice.entity.Device;
import com.dkadur.assettracker.deviceservice.repository.DeviceRepository;
import com.dkadur.assettracker.deviceservice.template.DeviceList;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<List<Object>> getDeviceCounts() {
        List<List<Object>> deviceCountsAndTypes = new ArrayList<List<Object>>();
        List<String> deviceCountTypes =  deviceRepository.getDeviceCountTypes();
        List<Integer> deviceCounts =  deviceRepository.getDeviceCounts();

        for (int i = 0; i < deviceCountTypes.size(); i++) {
            deviceCountsAndTypes.add(i, new ArrayList<Object>(
                    List.of(deviceCountTypes.get(i), deviceCounts.get(i))));
        }

        return deviceCountsAndTypes;
    }

    public List<Device> getDeviceList() {
        return deviceRepository.getDeviceList();
    }

    public String removeDeviceById(Long deviceId) {
        deviceRepository.deleteById(deviceId);
        return "Device successfully deleted";
    }
}
