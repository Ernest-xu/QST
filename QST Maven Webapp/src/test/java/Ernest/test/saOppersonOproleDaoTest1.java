/**
 * 
 */
package Ernest.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Ernest.Dao.saOppersonOproleDaoI;
import Ernest.Entity.SaOppersonOprole;




/**第一种测试类方法
 * @author Ernest
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/applicationContext.xml", "classpath:conf/spring-servlet.xml" })
public class saOppersonOproleDaoTest1 {
	
	private static final Logger logger = Logger.getLogger(saOppersonOproleDaoTest1.class);
	
	@Autowired
	private saOppersonOproleDaoI saOppersonproleDao;
	
	@Test
	public void save(){
		SaOppersonOprole saOppersonOprole=new SaOppersonOprole();
		saOppersonOprole.setSid("aa");
		saOppersonOprole.setRoleId("aa");
		saOppersonOprole.setSmd5str("aa");
		saOppersonproleDao.save(saOppersonOprole);
		logger.info("成功");
	}
}
