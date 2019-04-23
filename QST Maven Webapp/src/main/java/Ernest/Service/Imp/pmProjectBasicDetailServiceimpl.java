/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ernest.Dao.pmProjectBasicDetailDaoI;
import Ernest.Entity.PmProjectBasicDetail;
import Ernest.Service.pmProjectBasicDetailServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class pmProjectBasicDetailServiceimpl implements pmProjectBasicDetailServiceI {

	@Autowired
	private pmProjectBasicDetailDaoI pmProjectBasicDetailDao;
	
	@Override
	public List<PmProjectBasicDetail> findAll() {
		return pmProjectBasicDetailDao.findAll();
	}

}
