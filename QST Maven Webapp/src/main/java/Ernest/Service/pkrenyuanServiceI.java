/**
 * 
 */
package Ernest.Service;

import java.util.List;

import Ernest.Entity.Pkrenyuan;

/**
 * @author Ernest
 *
 */
public interface pkrenyuanServiceI {
	
	/**
	 * 新增
	 * @param pkrenyuan
	 * @return
	 */
	int save(Pkrenyuan pkrenyuan);
	
	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchSave(List<Pkrenyuan> list);
	
}
