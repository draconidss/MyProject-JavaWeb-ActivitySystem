package Tool;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlParser {
	public static HashMap<String,String> parser(String xmlPath) throws ParserConfigurationException, SAXException{
		HashMap<String, String> hm = new HashMap<String,String>();
		try{
			SAXParserFactory spf = SAXParserFactory.newInstance();//1
			SAXParser sp = spf.newSAXParser();//2
			File f = new File(xmlPath);
			XmlHandler xh = new XmlHandler();
			sp.parse(f,xh);//3
			hm = xh.getHashMap();
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();
		}
		
		return hm;
	}

	public Properties getProps() {
		// TODO Auto-generated method stub
		return null;
	}
}
