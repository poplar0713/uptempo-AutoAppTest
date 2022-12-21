package com.test.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.test.dto.AppInfoDto;
import com.test.dto.DeviceDto;

@Service
public class CreateXml {

	public static void createXml(List<DeviceDto> deviceList, List<AppInfoDto> appList, String depName, String name) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder(); // xml file ==>> DOM file

			Document doc = docBuilder.newDocument();
			doc.setXmlStandalone(true); // standalone="no" 를 없애준다.

			Element suite = doc.createElement("suite");
			doc.appendChild(suite);

			suite.setAttribute("name", "Paralleltest");
			suite.setAttribute("parallel", "tests");
			suite.setAttribute("thread-count", Integer.toString(deviceList.size()));

			for (AppInfoDto element : appList) {
				for (DeviceDto element2 : deviceList) {
					Element test = doc.createElement("test");
					suite.appendChild(test);

					test.setAttribute("name", element2.getDeviceName() + "+" + element.getAppEnName());

					Element parameter1 = doc.createElement("parameter");
					test.appendChild(parameter1);
					parameter1.setAttribute("name", "deviceName");

					parameter1.setAttribute("value", element2.getDeviceName());

					Element parameter2 = doc.createElement("parameter");
					test.appendChild(parameter2);
					parameter2.setAttribute("name", "udid");
					parameter2.setAttribute("value", element2.getUdid());

					Element parameter3 = doc.createElement("parameter");
					test.appendChild(parameter3);
					parameter3.setAttribute("name", "systemPort");
					parameter3.setAttribute("value", element2.getSystemPort());

					Element parameter4 = doc.createElement("parameter");
					test.appendChild(parameter4);
					parameter4.setAttribute("name", "appPackage");
					parameter4.setAttribute("value", element.getAppPackage());

					Element parameter5 = doc.createElement("parameter");
					test.appendChild(parameter5);
					parameter5.setAttribute("name", "appActivity");
					parameter5.setAttribute("value", element.getAppActivity());

					Element classes = doc.createElement("classes");
					test.appendChild(classes);

					Element runClass = doc.createElement("class");
					classes.appendChild(runClass);
					runClass.setAttribute("name", element.getClassName());
				}
			}

			// XML 파일로 쓰기
			TransformerFactory transformerFactory = TransformerFactory.newInstance();

			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // 정렬 스페이스4칸
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // 들여쓰기
			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes"); // doc.setXmlStandalone(true); 했을때 붙어서
																				// 출력되는부분 개행
			DOMSource source = new DOMSource(doc);

			String path = "/home/uptemto/Desktop/appiumtest/" + depName + "/" + name;
			File Folder = new File(path);

			if (!Folder.exists()) {
				try {
					if (Folder.mkdir() == true)
						System.out.println("make new folder");
					else
						System.out.println("folder mkdirs() fail");
				} catch (Exception e) {
					throw e;
				}
			}
//			
//			String filePath = "/home/uptemto/Desktop/appiumtest/" + depName + "/" + name + "/testng.xml";
//			
//			FileOutputStream ofp = new FileOutputStream(filePath);
//			StreamResult result = new StreamResult(ofp);
//			transformer.transform(source, result);

			System.out.println("=========END=========");

			System.out.println(Folder.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}