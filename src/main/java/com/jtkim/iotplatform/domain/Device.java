package com.jtkim.iotplatform.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = 2688799350337496378L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    
    private String type;

    protected Device() {
    	super();
    }

    public Device(String name, String type) {
    	super();
        this.name = name;
        this.type = type;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public String toString() {
        return String.format(
                "Device[id=%d, name='%s', type='%s']",
                id, name, type);
    }
}