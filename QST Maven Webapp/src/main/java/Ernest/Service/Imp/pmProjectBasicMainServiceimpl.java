/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ernest.Entity.PmProjectBasicMain;
import Ernest.Service.pmProjectBasicMainServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class pmProjectBasicMainServiceimpl implements pmProjectBasicMainServiceI {

	@Autowired
	private pmProjectBasicMainServiceI pmProjectBasicMainService;
	
	@Override
	public List<PmProjectBasicMain> findAll() {
		return pmProjectBasicMainService.findAll();
	}

}
