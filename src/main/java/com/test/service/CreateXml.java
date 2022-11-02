package com.test.service;

import java.io.File;
import java.io.FileOutputStream;
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
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			doc.setXmlStandalone(true); // standalone="no" 를 없애준다.

			Element suite = doc.createElement("suite");
			doc.appendChild(suite);

			suite.setAttribute("name", "Paralleltest");
			suite.setAttribute("parallel", "tests");
			suite.setAttribute("thread-count", Integer.toString(deviceList.size()));

			for (int i = 0; i < appList.size(); i++) {
				for (int j = 0; j < deviceList.size(); j++) {
					Element test = doc.createElement("test");
					suite.appendChild(test);

					test.setAttribute("name", deviceList.get(j).getDeviceName() + "+" + appList.get(i).getAppEnName());

					Element parameter1 = doc.createElement("parameter");
					test.appendChild(parameter1);
					parameter1.setAttribute("name", "deviceName");

					parameter1.setAttribute("value", deviceList.get(j).getDeviceName());

					Element parameter2 = doc.createElement("parameter");
					test.appendChild(parameter2);
					parameter2.setAttribute("name", "udid");
					parameter2.setAttribute("value", deviceList.get(j).getUdid());

					Element parameter3 = doc.createElement("parameter");
					test.appendChild(parameter3);
					parameter3.setAttribute("name", "systemPort");
					parameter3.setAttribute("value", deviceList.get(j).getSystemPort());

					Element parameter4 = doc.createElement("parameter");
					test.appendChild(parameter4);
					parameter4.setAttribute("name", "appPackage");
					parameter4.setAttribute("value", appList.get(i).getAppPackage());

					Element parameter5 = doc.createElement("parameter");
					test.appendChild(parameter5);
					parameter5.setAttribute("name", "appActivity");
					parameter5.setAttribute("value", appList.get(i).getAppActivity());

					Element classes = doc.createElement("classes");
					test.appendChild(classes);

					Element runClass = doc.createElement("class");
					classes.appendChild(runClass);
					runClass.setAttribute("name", appList.get(i).getClassName());
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

			String path = "/home/uptemto/Desktop/appiumtest/" + depName + name;
			System.out.println(path);
			File Folder = new File(path);

			if (!Folder.exists()) {
				boolean result = Folder.mkdirs(); // 폴더 생성합니다.
				if (result) {
					System.out.println("폴더가 생성되었습니다.");
				} else {
					System.out.println("폴더가 생성안됨.");
				}

			}

			String filePath = "/home/uptemto/Desktop/appiumtest/" + depName + name + "/testng.xml";
			StreamResult result = new StreamResult(new FileOutputStream(new File(filePath)));

			transformer.transform(source, result);

			System.out.println("=========END=========");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}