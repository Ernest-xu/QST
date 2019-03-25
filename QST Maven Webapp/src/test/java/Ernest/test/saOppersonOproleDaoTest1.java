/**
 * 
 */
package Ernest.test;

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
	
	
	@Autowired
	private saOppersonOproleDaoI saOppersonproleDao;
	
	@Test
	public void save(){
		SaOppersonOprole saOppersonOprole=new SaOppersonOprole();
		saOppersonOprole.setSid("aa");
		saOppersonOprole.setRoleId("aa");
		saOppersonOprole.setSmd5str("aa");
		saOppersonproleDao.save(saOppersonOprole);
		System.out.println("成功");
	}
}
