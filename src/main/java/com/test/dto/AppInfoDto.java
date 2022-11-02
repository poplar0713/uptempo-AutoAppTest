package com.test.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "up_appinfo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppInfoDto {
	
	@Id
	private String appName;
	private String appEnName;
	private String appPackage;
	private String appActivity;
	private String className;
}
