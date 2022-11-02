package com.test.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "up_deviceinfo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceDto {

	@Id
	//private String _id;//mongodb의 Document(레코드에 해당)식별자
	private String name;
	private String deviceName;
	private String udid;
	private String systemPort;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getUdid() {
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
	}
	public String getSystemPort() {
		return systemPort;
	}
	public void setSystemPort(String systemPort) {
		this.systemPort = systemPort;
	}
	

	
}
