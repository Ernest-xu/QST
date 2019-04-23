/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ernest.Dao.basicDetailGongDaoI;
import Ernest.Entity.BasicDetailGong;
import Ernest.Service.basicDetailGongServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class basicDetailGongServiceimpl implements basicDetailGongServiceI {

	@Autowired
	private basicDetailGongDaoI basicDetailGongDao;
	
	@Override
	public List<BasicDetailGong> basicDetailGongMap(String fMasterID, String fBz) {
		return basicDetailGongDao.findbyfMasterIdAndfBz(fMasterID, fBz);
	}

	
	@Override
	public int batchSaves(List<BasicDetailGong> list) {
		return basicDetailGongDao.batchSaves(list);
	}

}
