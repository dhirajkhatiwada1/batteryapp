package com.example.demo.entity;

import java.util.List;

public class BatteryResponse {
    private List<String> batteryNames;
    private double totalWattCapacity;
    private double averageWattCapacity;

    public BatteryResponse() {
    }

    public BatteryResponse(List<String> batteryNames, double totalWattCapacity, double averageWattCapacity) {
        this.batteryNames = batteryNames;
        this.totalWattCapacity = totalWattCapacity;
        this.averageWattCapacity = averageWattCapacity;
    }

    public List<String> getBatteryNames() {
        return batteryNames;
    }

    public void setBatteryNames(List<String> batteryNames) {
        this.batteryNames = batteryNames;
    }

    public double getTotalWattCapacity() {
        return totalWattCapacity;
    }

    public void setTotalWattCapacity(double totalWattCapacity) {
        this.totalWattCapacity = totalWattCapacity;
    }

    public double getAverageWattCapacity() {
        return averageWattCapacity;
    }

    public void setAverageWattCapacity(double averageWattCapacity) {
        this.averageWattCapacity = averageWattCapacity;
    }
}
