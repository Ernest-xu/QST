/**
 * 
 */
package Ernest.Service.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import Ernest.Dao.postsetbXmDaoI;
import Ernest.Entity.PostsetbXm;
import Ernest.Service.postsetbXmServiceI;

/**
 * @author Ernest
 *
 */
public class postsetbXmServiceimpl implements postsetbXmServiceI {

	private static final Logger logger = Logger.getLogger(postsetbXmServiceimpl.class);
	
	@Autowired
	private postsetbXmDaoI postsetbXmDao;
	@Override
	public List<PostsetbXm> findByProjectIdAndUser(String ProjectId, String UserId) {
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("fMasterID", ProjectId);
		map.put("fWriteID", UserId);
		List<PostsetbXm> list = postsetbXmDao.findList(map);
		return list;
	}
	

	@Override
	public Map<String, String> findByProjectId(String ProjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
