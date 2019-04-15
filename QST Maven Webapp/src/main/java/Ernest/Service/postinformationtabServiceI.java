/**
 * 
 */
package Ernest.Service;

import java.util.List;

import Ernest.Entity.Postinformationtab;

/**
 * @author Ernest
 *
 */
public interface postinformationtabServiceI {

	
	/**
	 * 根据list中区段id获取下面桩号
	 * @param list
	 * @return
	 */
	List<Postinformationtab> findListByListMasterIds(List<String> list);
}
