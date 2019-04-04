/**
 * 
 */
package Ernest.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.postsetbXm3gwDaoI;
import Ernest.Entity.PostsetbXm3gw;

/**
 * @author Ernest
 *
 */
public class postsetbXm3gw extends TestBase {
		private static final Logger logger = Logger.getLogger(postsetbXm3gw.class);
		@Autowired
		private postsetbXm3gwDaoI postsetbXm3gwDao;
//		@Before
		public void init(){
			postsetbXm3gwDao = super.getContext().getBean("postsetbXm3gwDaoI",postsetbXm3gwDaoI.class);
		}
		
//		@Test
		public void select(){
			String ProjectId = "C82BF43AEBB0000123221B4159871D1F";
			String UserId = "3fd612fa7fc042869f8ec3e30a7117e9";
			List<PostsetbXm3gw> list = postsetbXm3gwDao.findByProjectIdAndUser(ProjectId, UserId);
			for(PostsetbXm3gw px:list){
				logger.info(px.toString());
			}
		}
//		@Test
		public void select2(){
			String ProjectId = "C82BF43AEBB0000123221B4159871D1F";
			List<PostsetbXm3gw> list = postsetbXm3gwDao.findByProjectId(ProjectId);
			for(PostsetbXm3gw px:list){
				logger.info(px.getFpostWriteId());
				logger.info(px.getPostsetbXm3gw().getFpostName());
			}
		}
		
}
