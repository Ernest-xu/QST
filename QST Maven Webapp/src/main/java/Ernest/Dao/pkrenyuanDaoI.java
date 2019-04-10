/**
 * 
 */
package Ernest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ernest.Entity.Pkrenyuan;

/**
 * @author Ernest
 *
 */
@Repository
public interface pkrenyuanDaoI {

		/**
		 * 批量插入
		 * @param list
		 * @return
		 */
		int batchSaves(List<Pkrenyuan> list);
		
		/**
		 * 新增
		 * @param pkrenyuan
		 * @return
		 */
		int save(Pkrenyuan pkrenyuan);
		
}
