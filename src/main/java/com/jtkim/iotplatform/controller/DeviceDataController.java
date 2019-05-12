package com.jtkim.iotplatform.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.jtkim.iotplatform.domain.DeviceData;
import com.jtkim.iotplatform.service.DeviceDataService;

@RestController
@RequestMapping(value = "/device/{deviceId}/data")
public class DeviceDataController extends BaseController {
    
	@Autowired
	TaskExecutor taskExecutor;
	
	@Autowired
	DeviceDataService deviceDataService;
	
	@ApiOperation(value = "디바이스 데이터 조회")
    @GetMapping(value = "/{id}")
    public Optional<DeviceData> getDeviceData(@PathVariable Long deviceId, @PathVariable Long id) {
        return deviceDataService.getByDeviceIdAndId(deviceId, id);
    }
    
	@ApiOperation(value = "디바이스 데이터 조회")
    @GetMapping(value = "")
    public DeferredResult<List<DeviceData>> getAllDeviceData(@PathVariable Long deviceId) {
        final DeferredResult<List<DeviceData>> result = new DeferredResult<>();
    	
        taskExecutor.execute(() -> {
        	List<DeviceData> deviceData = deviceDataService.getByDeviceId(deviceId);
        	
        	result.setResult(deviceData);
        });
        
    	return result;
    }
}
