package com.jtkim.iotplatform.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DeviceData extends BaseAuditableEntity implements Serializable {
	
	private static final long serialVersionUID = 6037176088726379540L;

	public DeviceData() {
		super();
	}
	
	public DeviceData(Device device) {
		super();
		this.device = device;
	}
	
	public DeviceData(Device device, Data data) {
		super();
		this.device = device;
		this.data = data;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @ManyToOne
    @JoinColumn
    private Device device;
    
    private Data data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
    
    @Override
    public String toString() {
        return String.format(
                "DeviceData[id=%d, device_name='%s', data='%s']",
                id, device.getName(), data);
    }
}
