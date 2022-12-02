package com.test.mapper;

import com.test.dto.AppInfoDto;
import com.test.dto.DeviceDto;
import com.test.dto.ReserveInfoDto;

public interface DeviceDAO {
	DeviceDto deviceCheck(String deviceName);  //device 체크 메소드

	AppInfoDto appInfoCheck(String appName);

    String insert(String reservedTime, String depName, String name);

	ReserveInfoDto checkTheTime(String reservedTime);

	ReserveInfoDto deleteTheTime(String reservedTime);
}