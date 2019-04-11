/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ernest.Dao.pkrenyuanDaoI;
import Ernest.Entity.Pkrenyuan;
import Ernest.Service.pkrenyuanServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class pkrenyuanServiceimpl implements pkrenyuanServiceI {

	@Autowired
	private pkrenyuanDaoI pkrenyuanDao;
	
	@Override
	public int save(Pkrenyuan pkrenyuan) {
		int a = pkrenyuanDao.save(pkrenyuan);
		return a;
	}

	
	@Override
	public int batchSave(List<Pkrenyuan> list) {
		int b = pkrenyuanDao.batchSaves(list);
		return b;
	}


	
	@Override
	public int deletByIds(List<String> list) {
		return pkrenyuanDao.deletByIds(list);
	}


	
	@Override
	public int deleteByProjectAndUser(String ProjectId, String fWriteID) {
		return pkrenyuanDao.deleteByProjectAndUser(ProjectId, fWriteID);
	}

}
