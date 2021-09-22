package com.spring.work.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "x_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address1;

    private String area;
    private String city;
    private String state;
    private Integer pin;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getAddress1() {
	return address1;
    }

    public void setAddress1(String address1) {
	this.address1 = address1;
    }

    public String getArea() {
	return area;
    }

    public void setArea(String area) {
	this.area = area;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public Integer getPin() {
	return pin;
    }

    public void setPin(Integer pin) {
	this.pin = pin;
    }

}
