package com.test.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.test.dto.ReserveInfoDto;
import com.test.service.DeviceService;

@Component
public class ScheduledConfig {

	@Autowired
	private DeviceService deviceService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	// 10초마다 실행 >> 확인 후 정각 단위로 배치 프로그램 실
	@Scheduled(cron = "0/10 * * * * *")
	public void checkTimeSchedule() throws IOException {

		logger.info("[MYTEST] test batch {}", LocalDateTime.now());

		// 현재 시간과 DB를 조회해서 같은 시간이 있는지 체크한다.
		String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00"));

		logger.info("[MYTEST] change type {}", formatDate);

		ReserveInfoDto work = deviceService.checkTheTime(formatDate);

		if (work != null) {
			File oldFile = new File("/home/uptemto/Desktop/appiumtest/" + work.getDepName() + work.getName() + "/testng.xml");
			File newFile = new File("/home/uptemto/Desktop/appiumtest/appium_workspace/test/testng.xml");
		
			if(oldFile.exists()) {
				logger.info("OLD파일이 존재합니다.");
			}


		//	Files.deleteIfExists(Paths.get("D:\\appium_workspace\\test\\testng.xml"));
			oldFile.renameTo(newFile);	
			
		
			
			if(newFile.exists()) {
				logger.info("파일이 존재합니다.");
			}

			logger.info("파일이름변경완료");

			try {
				logger.info("shell고고");
				ShellCmd.cmdRun();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			deviceService.deleteTheTime(formatDate);

		}
	}

}