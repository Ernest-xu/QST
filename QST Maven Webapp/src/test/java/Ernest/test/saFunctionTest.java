/**
 * 
 */
package Ernest.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.saFunctionDaoI;
import Ernest.Entity.Company;
import Ernest.Entity.Function;
import Ernest.Entity.SaFunction;
import Ernest.until.ReadXml;

/**
 * @author Ernest
 *
 */
public class saFunctionTest extends TestBase {
	private static final Logger logger = Logger.getLogger(saFunctionTest.class);
	private saFunctionDaoI saFunctionDao;
	@Before
	public void init(){
		saFunctionDao = super.getContext().getBean("saFunctionDaoI",saFunctionDaoI.class);
	}
	
//	@Test
	public void allfunction(){
	}
//	@Test
	public void AllfunctionDao(){
		String companyId = "xu";
		String roleId = "xu";
		JSONObject json = new JSONObject();
		List<SaFunction> list = new ArrayList<SaFunction>();
		List<Company> companyList = null;// 不初始化，下面616行会报2错
		try {
			companyList = ReadXml.parseXml();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int aa=0;
		for (Company company : companyList) {
			aa++;
			List<Function> functions = company.getFunctions();
			
			for (Function function : functions) {
				SaFunction saFunction = new SaFunction();
				String fName = function.getName();
				String fUrl = function.getUrl();
				String fIcon = function.getIcon();
				Integer id = function.getId();
				String fType = function.getType();
				saFunction.setSid(UUID.randomUUID().toString());
				saFunction.setSname(fName);
				saFunction.setSurl(fUrl);
				saFunction.setCompanyId(companyId);
				saFunction.setIsShow((short) 1);
				saFunction.setRoleId(roleId);
				saFunction.setSicon(fIcon);
				saFunction.setSorder(id);
				saFunction.setStype(fType);
				logger.info(saFunction.toString());
				list.add(saFunction);
			}
		}
		logger.info(aa);
		for(SaFunction function:list){
			logger.info(function.toString());
		}
		saFunctionDao.batchSaves(list);
		logger.info("成功");
//		json.put("success",true);
//		json.put("message","成功");
	}
	
}
