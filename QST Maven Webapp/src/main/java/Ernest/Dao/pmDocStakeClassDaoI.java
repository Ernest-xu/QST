/**
 * 
 */
package Ernest.Dao;

import org.springframework.stereotype.Repository;

import Ernest.Entity.PmDocStakeClass;

/**
 * @author Ernest
 *
 */
@Repository
public interface pmDocStakeClassDaoI {

	/**
	 * 保存
	 * @param pmDocStakeClass 实体类
	 * @return
	 */
	int saveById(PmDocStakeClass pmDocStakeClass) ;
}
