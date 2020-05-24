package Tool;

import java.sql.*;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class DataAccess {
	// Mysql连接方法(S)
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static String xmlPath = "database.conf.xml";
	private static String xsdPath = "database.conf.xsd";
	
	public static Connection getConnection(){
		Connection conn = null;
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath =base +  "database.conf.xml";
		xsdPath =base +  "database.conf.xsd";
		try{
			HashMap<String,String> hm = XmlParser.parser(xmlPath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
		
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("获取connection时找不到文件");
		} catch (SQLException e) {
			System.out.println("获取connection时SQL异常");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
