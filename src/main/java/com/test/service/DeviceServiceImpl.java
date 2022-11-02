package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.dto.AppInfoDto;
import com.test.dto.DeviceDto;
import com.test.dto.ReserveInfoDto;
import com.test.mapper.DeviceDAO;

@Component
public class DeviceServiceImpl implements DeviceService {

	  @Autowired  //의존성 주입
	  private DeviceDAO deviceDao;
	  
	    
	  @Override
	  public DeviceDto deviceCheck(String name) {
	      return deviceDao.deviceCheck(name);
	  }
	  
	  @Override
	  public AppInfoDto appInfoCheck(String appName) {
	      return deviceDao.appInfoCheck(appName);
	  }
	  
	  @Override
	  public ReserveInfoDto checkTheTime(String reservedTime) {
	      return deviceDao.checkTheTime(reservedTime);
	  }
	  
	  @Override
	  public ReserveInfoDto deleteTheTime(String reservedTime) {
	      return deviceDao.deleteTheTime(reservedTime);
	  }
	  
	  @Override
	  public String insert(String reservedTime, String depName, String name) {
		  return deviceDao.insert(reservedTime,depName,name);
	     
	  }
}