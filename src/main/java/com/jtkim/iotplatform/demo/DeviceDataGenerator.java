package com.jtkim.iotplatform.demo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jtkim.iotplatform.domain.Data;
import com.jtkim.iotplatform.domain.Device;
import com.jtkim.iotplatform.domain.DeviceData;
import com.jtkim.iotplatform.repository.DeviceDataRepository;
import com.jtkim.iotplatform.repository.DeviceRepository;



@Component
public class DeviceDataGenerator implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(DeviceDataGenerator.class);

	@Autowired
	DeviceRepository deviceRepository;
	
	@Autowired
	DeviceDataRepository deviceDataRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("Get all devices...");
		List<Device> devices = this.deviceRepository.findAll();

		// Generate Device Sensing Data
		log.info("Preparing device sensing data...");

		ScheduledExecutorService dataGenerator = Executors.newScheduledThreadPool(5);
		dataGenerator.scheduleAtFixedRate(() -> {
				// The repetitive task to generate sensing data
				Random rand = new Random();
				
				DeviceData temperature = new DeviceData(devices.get(0), new Data("Temperature", String.valueOf(rand.nextInt(30) + 10)));
				DeviceData humidity = new DeviceData(devices.get(1), new Data("Humidity", String.valueOf(rand.nextInt(90) + 10)));
				DeviceData airquality = new DeviceData(devices.get(2), new Data("Air Quality", String.valueOf(rand.nextInt(90) + 10)));

				deviceDataRepository.save(temperature);
				deviceDataRepository.save(humidity);
				deviceDataRepository.save(airquality);
			}, 0, 5000L, TimeUnit.MILLISECONDS);
	}
}
