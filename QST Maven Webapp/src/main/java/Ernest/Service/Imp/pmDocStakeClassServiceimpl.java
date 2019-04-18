/**
 * 
 */
package Ernest.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ernest.Dao.pmDocStakeClassDaoI;
import Ernest.Entity.PmDocStakeClass;
import Ernest.Service.pmDocStakeClassServiceI;



/**
 * @author Ernest
 *
 */
@Service class pmDocStakeClassServiceimpl implements pmDocStakeClassServiceI {

	@Autowired
	private pmDocStakeClassDaoI pmDocStakeClassDao;
	
	@Override
	public int saveById(PmDocStakeClass pmDocStakeClass) {
		return pmDocStakeClassDao.saveById(pmDocStakeClass);
	}

}
