package com.example.demo.service;


import com.example.demo.entity.Battery;
import com.example.demo.entity.BatteryResponse;
import com.example.demo.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {


    @Autowired
    BatteryRepository batteryRepository;

    @Override
    public void saveBatteries(List<Battery> batteries) {
        batteryRepository.saveAll(batteries);
    }

    @Override
    public BatteryResponse findBatteriesInRange(double startRange, double endRange) {
        List<Battery> batteriesInRange = batteryRepository.findByCapacityBetween(startRange, endRange);

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
