package com.jtkim.iotplatform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jtkim.iotplatform.domain.DeviceData;

@Repository
public interface DeviceDataRepository extends JpaRepository<DeviceData, Long> {
	
    Optional<DeviceData> findById(Long id);
    
    Optional<DeviceData> findByDeviceIdAndId(Long deviceId, Long id);
    
    List<DeviceData> findByDeviceId(Long deviceId);
}
