package com.test.mapper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.test.dto.AppInfoDto;
import com.test.dto.DeviceDto;
import com.test.dto.ReserveInfoDto;

@Repository
public class DeviceDAOImpl implements DeviceDAO{
	
	//mongodb에 접속하여 명령어를 실행하는 객체
    //Autowired 대신에 inject를 써도 된다.
    //Inject를 사용하려면 pom.xml에 라이브러리를 추가해 주어야 한다.
    //Inject 어노테이션을 쓰고 우클릭 후 fix Project Setup을 누르고 jar파일에대고
    //ok를 누르면 Inject를 사용할 수 있다.
    //의존성 주입
    //@Inject
    @Autowired
    private MongoTemplate mongoTemplate;
    
    
    //bean에 MongoTemplate을 리턴하는 메소드가 있었는데 이 메소드가 실행되어야
    //Mongo DB를 사용할 수 있기 때문에 의존관계를 주입시키는 것이다.
    //템플릿을 사용하기 위한 의존성 주입	
    
    //mongodb의 컬렉션(테이블에 해당)
    //그리고 레코드 대신 도큐먼트(document)라고 부르고 사용한다.
   // String COLLECTION_NAME="deviceinfo";

	@Override
	public DeviceDto deviceCheck(String deviceName) {
		System.out.println("deviceName은 무엇입니다?");
		System.out.println(deviceName);
		//Query query= new Query(new Criteria("deviceName").is(deviceName));
		//System.out.println(query);
		DeviceDto device = mongoTemplate.findOne(
				Query.query(Criteria.where("deviceName").is(deviceName)),DeviceDto.class);
		System.out.println(device.getSystemPort());
	
		return device;
	}
	
	@Override
	public AppInfoDto appInfoCheck(String appEnName) {
		System.out.println("appName은 무엇입니다?");
		System.out.println(appEnName);
		//Query query= new Query(new Criteria("deviceName").is(deviceName));
		//System.out.println(query);
		AppInfoDto app = mongoTemplate.findOne(
				Query.query(Criteria.where("appEnName").is(appEnName)),AppInfoDto.class);
		System.out.println(app.getClassName());
	
		return app;
	}
	
	@Override
	public ReserveInfoDto checkTheTime(String reservedTime) {
		
		System.out.println(reservedTime);

		ReserveInfoDto work = mongoTemplate.findOne(
				Query.query(Criteria.where("reservedTime").is(reservedTime)),ReserveInfoDto.class);
		
		if(work!=null) {
			System.out.println("null이 아닙니다");
		}else {
			System.out.println("null입니다.");
		}
	
		return work;
	}
	
	@Override
	public ReserveInfoDto deleteTheTime(String time) {
		System.out.println("데이터삭제하러 왔습니다.");
		Criteria criteria = new Criteria("reservedTime");
		criteria.is(time);
		
		Query query = new Query(criteria);
		
		mongoTemplate.remove(query, "reserveinfo");
		
		return null;
		
	}
	@Override
	public String insert(String reservedTime, String depName, String name)
	{
		ReserveInfoDto  entity = new ReserveInfoDto();
		entity.setReservedTime(reservedTime);
		entity.setDepName(depName);
		entity.setName(name);
		entity.setCreatedDate(new Date());
	        
	    //mongoTemplate 버전
	    mongoTemplate.insert(entity);
	  
		return "OK";
		
	}

}