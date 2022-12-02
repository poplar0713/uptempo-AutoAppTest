package com.test.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.dto.AppInfoDto;
import com.test.dto.DeviceDto;
import com.test.service.CreateXml;
import com.test.service.DeviceService;

@Controller
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	private CreateXml createXmlService;

	// 메인 페이지
	@RequestMapping("/")
	public String index() {
		System.out.println("index()");
		return "/deviceList";
	}

	@RequestMapping(value = "/deviceList", method = { RequestMethod.POST })
	public String deviceInfo(String[] checkedValue, String[] checkedApplication, String year, String month, String day,
			String hour, String depName, String name) throws Exception {

		List<DeviceDto> deviceList = new ArrayList<>();
		List<AppInfoDto> appInfoeList = new ArrayList<>();
		System.out.println(year);
		for (String n : checkedValue) {
			System.out.println(n);
			DeviceDto dto = new DeviceDto();
			dto = deviceService.deviceCheck(n);
			if (dto == null) {
				System.out.println("데이터가 존재하지 않습니다");
			} else {
				deviceList.add(dto);
				System.out.println(dto.getSystemPort());
			}
		}

		for (String n : checkedApplication) {
			System.out.println(n);
			AppInfoDto appDto = new AppInfoDto();
			appDto = deviceService.appInfoCheck(n);
			if (appDto == null) {
				System.out.println("데이터가 존재하지 않습니다");
			} else {
				appInfoeList.add(appDto);
				System.out.println(appDto);
			}
		}

		System.out.println(deviceList.size());

		String date = year + "-" + month + "-" + day + " " + hour + ":00:00";
		System.out.println("depName = "+depName);
		if (depName == "" && name == "") {
			System.out.println("부서가 없어요");
			depName = "right";
			name = "now";
			date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00"));
		}

		String response = deviceService.insert(date, depName, name);
		System.out.println(response);
		CreateXml.createXml(deviceList, appInfoeList, depName, name);

		return "/deviceList";
	}

}