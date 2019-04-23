/**
 * 
 */
package Ernest.Service;

import java.util.List;

import Ernest.Entity.BasicDetailGong;

/**
 * @author Ernest
 *
 */
public interface basicDetailGongServiceI {

	
	List<BasicDetailGong> basicDetailGongMap(String fMasterID,String fBz);
	
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchSaves (List<BasicDetailGong> list);
	
}
