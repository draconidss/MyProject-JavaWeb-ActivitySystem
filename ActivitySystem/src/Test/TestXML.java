package Test;

import java.util.HashMap;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Tool.XmlParser;
import Tool.XmlValidator;

public class TestXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xmlPath = "database.conf.xml";
		String xsdPath = "database.conf.xsd";
		System.out.println(XmlValidator.validate(xmlPath, xsdPath));
		HashMap<String, String> hm;
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath =base + "database.conf.xml";
		xsdPath =base + "database.conf.xsd";
		try {
			hm = XmlParser.parser(xmlPath);
			System.out.println(hm.get("driver"));
			System.out.println(hm.get("url"));
			System.out.println(hm.get("user"));
			System.out.println(hm.get("password"));
			System.out.println("true");
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
