package com.example.demo.controller;


import com.example.demo.entity.Battery;
import com.example.demo.entity.BatteryResponse;
import com.example.demo.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batteries")
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @PostMapping
    public ResponseEntity<String> createBattery(@RequestBody List<Battery> batteries) {
         batteryService.saveBatteries(batteries);
         return ResponseEntity.ok("Batteries saved successfully..");
    }

    @GetMapping("/range")
    public BatteryResponse getBatteriesInCapacityRange(
            @RequestParam double start,
            @RequestParam double end) {
        return batteryService.findBatteriesInRange(start, end);
    }

}
