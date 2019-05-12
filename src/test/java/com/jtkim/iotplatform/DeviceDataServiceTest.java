package com.jtkim.iotplatform;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jtkim.iotplatform.service.DeviceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceDataServiceTest {
	
	@Autowired
	private DeviceService deviceDataService;
	
}