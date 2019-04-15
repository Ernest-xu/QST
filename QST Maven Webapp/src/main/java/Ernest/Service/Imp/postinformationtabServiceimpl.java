/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ernest.Dao.postinformationtabDaoI;
import Ernest.Entity.Postinformationtab;
import Ernest.Service.postinformationtabServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class postinformationtabServiceimpl implements postinformationtabServiceI {

	@Autowired
	private postinformationtabDaoI postinformationtabDao;
	@Override
	public List<Postinformationtab> findListByListMasterIds(List<String> list) {
		return postinformationtabDao.findListByListMasterIds(list);
	}

}
