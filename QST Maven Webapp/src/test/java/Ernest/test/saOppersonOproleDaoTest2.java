/**
 * 
 */
package Ernest.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.saOppersonOproleDaoI;
import Ernest.Entity.SaOppersonOprole;


/**
 * @author Ernest
 *
 */

public class saOppersonOproleDaoTest2 extends TestBase{
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
		System.out.println("成功");
		
	}
}
