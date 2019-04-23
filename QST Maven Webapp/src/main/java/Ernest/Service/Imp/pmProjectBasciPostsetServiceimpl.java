/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ernest.Dao.pmProjectBasciPostsetDaoI;
import Ernest.Entity.PmProjectBasciPostset;
import Ernest.Service.pmProjectBasciPostsetServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class pmProjectBasciPostsetServiceimpl implements pmProjectBasciPostsetServiceI{

	@Autowired
	private pmProjectBasciPostsetDaoI pmProjectBasciPostsetDao;

	
	@Override
	public List<PmProjectBasciPostset> findAll() {
		return pmProjectBasciPostsetDao.findAll();
	}
	
	
}
