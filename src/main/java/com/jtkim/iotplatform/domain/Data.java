package com.jtkim.iotplatform.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Data {

    @Size(max = 256)
    String label;
    String value;

    public Data() {

    }

    public Data(String label, String value) {
        super();
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
