/**
 * 
 */
package Ernest.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.dom4j.DocumentException;
import org.junit.Test;

import Ernest.Entity.Company;
import Ernest.Entity.Function;
import Ernest.until.ReadXml;

/**
 * @author Ernest
 *
 */

public class RoleTest {
	
	
//	@Test
	public void readallFunction() throws DocumentException, IOException{
		List<Company> list=ReadXml.parseXml();
		//List<Function> list=ReadXml.parseXmlAllFunction();
		for(Company com:list){
			System.out.println(com);
			List<Function> functions = com.getFunctions();
			System.out.println(functions.size());
		}
		
//		for(Function fun:list){
//			System.out.println(fun);
//		}
		System.out.println(list.size());
		
//		Properties properties = new Properties();
//		     // 使用InPutStream流读取properties文件
//		     BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/conf/jdbc.properties"));
//		     properties.load(bufferedReader);
//		     // 获取key对应的value值
//		     String a= properties.getProperty("jdbc.url");
//		System.out.println(a);
		
	}
}
