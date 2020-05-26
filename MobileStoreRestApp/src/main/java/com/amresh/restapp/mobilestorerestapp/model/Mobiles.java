package com.amresh.restapp.mobilestorerestapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Mobiles")
public class Mobiles {
	@Id
	private int id;
	private String brandName;
	private String modelName;
	private int ramInGB;
	private int memoryInGB;
	private String processor;
	private float displayInInches;
	private String os;
	private long batteryCapacity;
	private String colour;
	
	public Mobiles(int id,String brandName, String modelName, int ramInGB, int memoryInGB, String processor,
			float displayInInches, String os, long batteryCapacity, String colour) {
		this.id=id;
		this.brandName = brandName;
		this.modelName = modelName;
		this.ramInGB = ramInGB;
		this.memoryInGB = memoryInGB;
		this.processor = processor;
		this.displayInInches = displayInInches;
		this.os = os;
		this.batteryCapacity = batteryCapacity;
		this.colour = colour;
	}
	public Mobiles() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getRamInGB() {
		return ramInGB;
	}
	public void setRamInGB(int ramInGB) {
		this.ramInGB = ramInGB;
	}
	public int getMemoryInGB() {
		return memoryInGB;
	}
	public void setMemoryInGB(int memoryInGB) {
		this.memoryInGB = memoryInGB;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public float getDisplayInInches() {
		return displayInInches;
	}
	public void setDisplayInInches(float displayInInches) {
		this.displayInInches = displayInInches;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public long getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(long batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	@Override
	public String toString() {
		return "Mobiles [id=" + id + ", brandName=" + brandName + ", modelName=" + modelName + ", ramInGB=" + ramInGB
				+ ", memoryInGB=" + memoryInGB + ", processor=" + processor + ", displayInInches=" + displayInInches
				+ ", os=" + os + ", batteryCapacity=" + batteryCapacity + ", colour=" + colour + "]";
	}
	
	
	
	
	
	
	
}
