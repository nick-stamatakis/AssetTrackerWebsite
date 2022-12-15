package com.dkadur.assettracker.deviceservice.controller;

import com.dkadur.assettracker.deviceservice.entity.Device;
import com.dkadur.assettracker.deviceservice.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/add/")
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @GetMapping("/get/{deviceId}")
    public Optional<Device> getDeviceById(@PathVariable Long deviceId) {
        return deviceService.findDeviceById(deviceId);
    }

    @GetMapping("/get/all/")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/test-string/")
    public String getTestString() {
        return "test6";
    }

    @DeleteMapping("/delete/{deviceId}")
    public void removeDeviceById(@PathVariable Long deviceId) {
        deviceService.removeDeviceById(deviceId);
    }
}
