package com.example.demo.repository;

import com.example.demo.entity.Battery;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BatteryRepository extends CrudRepository<Battery, Long> {

    List<Battery> findByCapacityBetween(double start, double end);


}
