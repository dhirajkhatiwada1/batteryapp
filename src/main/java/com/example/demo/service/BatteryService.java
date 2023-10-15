package com.example.demo.service;

import com.example.demo.entity.Battery;
import com.example.demo.entity.BatteryResponse;

import java.util.List;

public interface BatteryService {

    public void saveBatteries(List<Battery> batteries);

    public BatteryResponse findBatteriesInRange(double startRange, double endRange);

}
