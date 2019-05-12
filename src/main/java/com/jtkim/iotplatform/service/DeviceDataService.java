package com.jtkim.iotplatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtkim.iotplatform.domain.DeviceData;
import com.jtkim.iotplatform.repository.DeviceDataRepository;

@Service
public class DeviceDataService {
	
	@Autowired
	private DeviceDataRepository deviceDataRepository;
	
	public Optional<DeviceData> getById(Long id) {
		return deviceDataRepository.findById(id);
	}
	
	public Optional<DeviceData> getByDeviceIdAndId(Long deviceId, Long id) {
		return deviceDataRepository.findByDeviceIdAndId(deviceId, id);
	}
	
	public List<DeviceData> getByDeviceId(Long deviceId) {
		return deviceDataRepository.findByDeviceId(deviceId);
	}
	
	public List<DeviceData> list() {
		return deviceDataRepository.findAll();
	}

}
