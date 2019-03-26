package Ernest.until;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;

import Ernest.Entity.Company;
import Ernest.Entity.Function;

public class ReadXml {
	private static String getPath() throws IOException{
		
		Properties properties = new Properties();
	    // 使用InPutStream流读取properties文件
	    BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/myeclipse/Git/QST Maven Webapp/src/main/resources/conf/jdbc.properties"));
	    properties.load(bufferedReader);
	    // 获取key对应的value值
	    String a= properties.getProperty("allfunction");
	    return a;
		
	}
	
	public static List<Company> parseXml() throws DocumentException, IOException {
		ArrayList<Company> companyList = new ArrayList<Company>();
		/*
		 * java.io.FileNotFoundException: F:/company/WeX5_V3.6Check/studio/resources/allFunction.xml (系统找不到指定的路径。)
		 */
		//String file=System.getProperty("user.dir")+File.separator+"resources"+File.separator+"function.xml";
		File f = new File(getPath());
        InputStream inputStream = new FileInputStream(f);
//		InputStream inputStream = ReadXml.class.getResourceAsStream("main/resources/conf/allFunction.xml");
		
		SAXReader saxReader = new SAXReader();
		
		//Document document = saxReader.read(new File(file));
		Document document = saxReader.read(inputStream);
		// 获取根元素
		Element root = document.getRootElement();
		List<Element> elements = root.elements();
		for(Element organization:elements){
			Company company=new Company();
			List<Attribute> companyAttrs = organization.attributes();
			//获取属性
			for(Attribute attr:companyAttrs){
				if(attr.getName().equals("id")){
					company.setId(attr.getValue());
				}
			}
			List<Element> organizations = organization.elements();
			for(Element oc:organizations){
				String name=oc.getName();
				String value=oc.getStringValue();
				if(name.equals("name")){
					company.setName(value);
				}else if(name.equals("system")){
					company.setSystem(value);
				}else if(name.equals("password")){
					company.setPassword(value);
				}else if(name.equals("phone")){
					company.setPhone(value);
				}else if(name.equals("functions")){
					List<Function> functionList = new ArrayList<Function>();
					List<Element> functions = oc.elements();
					for(Element function:functions){
						List<Element> e = function.elements();
						Function fun=new Function();
						List<Attribute> funAttrs=function.attributes();
						//获取属性
						for(Attribute attr:funAttrs){
							if(attr.getName().equals("id")){
								fun.setId(Integer.valueOf(attr.getValue()));
							}
						}
						for(Element el:e){
							
							String ename=el.getName();
							String evalue=el.getStringValue();
							if(ename.equals("url")){
								fun.setUrl(evalue.trim());
							}else if(ename.equals("name")){
								fun.setName(evalue.trim());
							}else if(ename.equals("icon")){
								fun.setIcon(evalue.trim());
							}else if(ename.equals("type")){
								fun.setType(evalue.trim());
							}
						
						}
						functionList.add(fun);
						function=null;
					}
					company.setFunctions(functionList);
				}
			}
			companyList.add(company);
			company=null;
		}
		
		
		return companyList;

	}
	public static List<Function> parseXmlAllFunction() throws DocumentException, IOException {
		ArrayList<Function> functionList = new ArrayList<Function>();
		/*
		 * java.io.FileNotFoundException: F:/company/WeX5_V3.6Check/studio/resources/allFunction.xml (系统找不到指定的路径。)
		 */
		//String file=System.getProperty("user.dir")+File.separator+"resources"+File.separator+"allFunction.xml";
		File f = new File(getPath());
        InputStream inputStream = new FileInputStream(f);
//		InputStream inputStream = ReadXml.class.getResourceAsStream(path);
		
		SAXReader saxReader = new SAXReader();
		//Document document = saxReader.read(new File(file));
		Document document = saxReader.read(inputStream);
		// 获取根元素
		Element root = document.getRootElement();
		List<Element> elements = root.elements();
		for(Element functions:elements){
			Function function=new Function();
			List<Attribute> functionAttrs = functions.attributes();
			//获取属性
			for(Attribute attr:functionAttrs){
				if(attr.getName().equals("id")){
					function.setId(Integer.valueOf(attr.getValue()));
				}
			}
			List<Element> funs = functions.elements();
			for(Element oc:funs){
				String name=oc.getName();
				String value=oc.getStringValue();
				if(name.equals("name")){
					function.setName(value.trim());
				}else if(name.equals("url")){
					function.setUrl(value.trim());
				}else if(name.equals("icon")){
					function.setIcon(value.trim());
				}
			}
			functionList.add(function);
			function=null;
		}
		
		
		return functionList;

	}

}
