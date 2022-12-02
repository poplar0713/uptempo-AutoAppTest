package com.test.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reserveinfo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReserveInfoDto {

	@Id
	private String id;

	private String reservedTime;
	private String depName;
	private String name;
	private String path;
	private Date createdDate;


}
