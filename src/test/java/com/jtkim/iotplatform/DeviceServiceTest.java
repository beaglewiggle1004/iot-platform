package com.jtkim.iotplatform;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jtkim.iotplatform.domain.Device;
import com.jtkim.iotplatform.service.DeviceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceTest {
	
	@Autowired
	private DeviceService deviceService;
	
	@Test
	public void whenApplicationStarts_thenHibernateCreateIninialRecords() {
		List<Device> devices = deviceService.list();
		
		Assert.assertEquals(devices.size(), 3);
	}
}