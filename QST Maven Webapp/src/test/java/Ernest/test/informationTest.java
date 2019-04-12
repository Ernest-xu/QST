/**
 * 
 */
package Ernest.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.informationTableDaoI;
import Ernest.Entity.InformationTable;

/**
 * @author Ernest
 *
 */
public class informationTest extends TestBase {
	private static final Logger logger = Logger.getLogger(informationTest.class);
	@Autowired
	private informationTableDaoI informationTableDao;
	
//	@Before
	public void init(){
		informationTableDao = super.getContext().getBean("informationTableDaoI",informationTableDaoI.class);
	}
	
//	@Test
	public void select(){
		List<InformationTable> list = informationTableDao.findList("3fd612fa7fc042869f8ec3e30a7117e9");
		for(InformationTable information:list){
			logger.info(information.toString());
		}
	}
//	@Test
	public void update(){
		InformationTable informationTable = new InformationTable();
		String fID = "C82BF43AEBB0000123221B4159871D1F";
		String fPrjoectName = "鸡哈线";
		String fProjectQuanName = "鸡西至哈尔滨线";
		String fProjectAddress = "黑龙江";
		String fProjectMessage = "架设鸡西至哈尔滨的高架线路";
		String fStateTime = "2018-10-09";
		String fEndTime = "2020-10-09";
		Map<String, Object> upm = new HashMap<String, Object>();
		upm.put("fID", fID);
		upm.put("fPrjoectName", "鸡哈线");
		upm.put("fProjectQuanName", "鸡西至哈尔滨线");
		upm.put("fProjectAddress", "黑龙江");
		upm.put("fProjectMessage", "架设鸡西至哈尔滨的高架线路");
		upm.put("fStateTime", "2018-10-09");
		upm.put("fEndTime", "2020-10-09");
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		
		informationTable.setFid(fID);
		informationTable.setFprjoectName(fPrjoectName);
		informationTable.setFprojectAddress(fProjectAddress);
		informationTable.setFprojectQuanName(fProjectQuanName);
		informationTable.setFprojectMessage(fProjectMessage);
		try {
			informationTable.setFstateTime(sdf.parse(fStateTime));
			informationTable.setFendTime(sdf.parse(fEndTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int a = informationTableDao.updateByMapId(informationTable);
		logger.info("修改成功:"+a);
	}
	
	
}
