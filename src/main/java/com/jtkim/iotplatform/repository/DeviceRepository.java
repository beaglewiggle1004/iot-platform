package com.jtkim.iotplatform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jtkim.iotplatform.domain.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Optional<Device> findById(Long id);
    
    Optional<Device> findByName(String name);
    
    List<Device> findByType(String type);
}