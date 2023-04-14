package com.dkadur.assettracker.deviceservice.controller;

import com.dkadur.assettracker.deviceservice.entity.Device;
import com.dkadur.assettracker.deviceservice.service.DeviceService;
import com.dkadur.assettracker.deviceservice.template.DeviceList;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/add/")
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @PostMapping("/get/device/{deviceId}")
    public Optional<Device> getDeviceById(@PathVariable Long deviceId) {
        return deviceService.findDeviceById(deviceId);
    }
    @GetMapping("/get/all/")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/get/device-counts/{tenantId}")
    public List<List<Object>> getDeviceCounts(@PathVariable int tenantId) {
        return deviceService.getDeviceCounts(tenantId);
    }

    @GetMapping("/get/device-list/{tenantId}")
    public List<JsonObject> getDeviceList(@PathVariable int tenantId) {
        return deviceService.getDeviceList(tenantId);
    }

    @GetMapping("/test-string/")
    public String getTestString() {
        return "test7";
    }

    @DeleteMapping("/delete/{deviceId}")
    public void removeDeviceById(@PathVariable Long deviceId) {
        deviceService.removeDeviceById(deviceId);
    }
}
