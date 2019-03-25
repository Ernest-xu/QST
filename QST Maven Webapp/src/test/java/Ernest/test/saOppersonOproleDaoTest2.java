/**
 * 
 */
package Ernest.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.saOppersonOproleDaoI;
import Ernest.Entity.SaOppersonOprole;


/**第二种测试类方法
 * @author Ernest
 *
 */

public class saOppersonOproleDaoTest2 extends TestBase{
	private static final Logger logger = Logger.getLogger(saOppersonOproleDaoTest2.class);
	@Autowired
	private saOppersonOproleDaoI saOppersonOproleDao;
	@Before
	public void init(){
		saOppersonOproleDao = super.getContext().getBean("saOppersonOproleDaoI",saOppersonOproleDaoI.class);
	}
	@Test
	public void Testsave(){
		
		SaOppersonOprole saOppersonOprole=new SaOppersonOprole();
		saOppersonOprole.setSid("aabb");
		saOppersonOprole.setRoleId("aabb");
		saOppersonOprole.setSmd5str("aabb");
		saOppersonOproleDao.save(saOppersonOprole);
		logger.info("成功");
	}
}
