package com.example.demo.controller;


import com.example.demo.entity.Battery;
import com.example.demo.entity.BatteryResponse;
import com.example.demo.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/batteries")
public class BatteryController {

    @Autowired
    private BatteryRepository batteryRepository;

    @PostMapping
    public ResponseEntity<String> createBattery(@RequestBody List<Battery> batteries) {
         batteryRepository.saveAll(batteries);
         return ResponseEntity.ok("Batteries saved successfully..");
    }

    @GetMapping("/range")
    public BatteryResponse getBatteriesInPostcodeRange(
            @RequestParam double start,
            @RequestParam double end) {
        List<Battery> batteriesInRange = batteryRepository.findByCapacityBetween(start, end);

        double totalWattCapacity = batteriesInRange.stream()
                .mapToDouble(Battery::getCapacity)
                .sum();

        double averageWattCapacity = batteriesInRange.stream()
                .mapToDouble(Battery::getCapacity)
                .average()
                .orElse(0.0);

        List<String> batteryNames = batteriesInRange.stream()
                .map(Battery::getName)
                .sorted()
                .collect(Collectors.toList());

        return new BatteryResponse(batteryNames, totalWattCapacity, averageWattCapacity);
    }

}
