package com.test.service;

import com.test.dto.AppInfoDto;
import com.test.dto.DeviceDto;
import com.test.dto.ReserveInfoDto;

public interface DeviceService {

	DeviceDto deviceCheck(String name);

	AppInfoDto appInfoCheck(String appName);

	String insert(String reservedTime, String depName, String name);

	ReserveInfoDto checkTheTime(String reservedTime);

	ReserveInfoDto deleteTheTime(String reservedTime);



}