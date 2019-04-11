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
		
		/**
		 * 删除
		 * @param list
		 * @return
		 */
		int deletByIds(List<String> list);
		
		/**
		 * 删除
		 * @param ProjectId
		 * @param fWriteID
		 * @return
		 */
		int deleteByProjectAndUser(String ProjectId ,String fWriteID );
}
