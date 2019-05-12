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

import com.jtkim.iotplatform.domain.Device;
import com.jtkim.iotplatform.service.DeviceService;

@RestController
@RequestMapping(value = "/device")
public class DeviceController extends BaseController {
    
	@Autowired
	TaskExecutor taskExecutor;
	
	@Autowired
	DeviceService deviceService;

	@ApiOperation(value = "디바이스 조회")
    @GetMapping(value = "/{id}")
    public Optional<Device> getDevice(@PathVariable Long id) {
        return deviceService.get(id);
    }

	@ApiOperation(value = "모든 디바이스 조회")
    @GetMapping(value = "")
    public DeferredResult<List<Device>> getAllDevice() {
        final DeferredResult<List<Device>> result = new DeferredResult<>();
    	
        taskExecutor.execute(() -> {
        	result.setResult(deviceService.list());
        });
        
    	return  result;
    }
}
