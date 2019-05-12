package com.jtkim.iotplatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtkim.iotplatform.domain.Device;
import com.jtkim.iotplatform.repository.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	public Optional<Device> get(Long id) {
		return deviceRepository.findById(id);
	}
	
	public Optional<Device> getByName(String name) {
		return deviceRepository.findByName(name);
	}
	
	public List<Device> getByType(String type) {
		return deviceRepository.findByType(type);
	}
	
	public List<Device> list() {
		return deviceRepository.findAll();
	}
}

