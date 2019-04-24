/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ernest.Dao.postsetbXm1DaoI;
import Ernest.Entity.PostsetbXm1;
import Ernest.Service.postsetbXm1ServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class postsetbXm1Serviceimpl implements postsetbXm1ServiceI {

	@Autowired
	private postsetbXm1DaoI postsetbXm1DaoI;
	
	@Override
	public int batchSave(List<PostsetbXm1> list) {
		return postsetbXm1DaoI.batchSave(list);
	}

}
