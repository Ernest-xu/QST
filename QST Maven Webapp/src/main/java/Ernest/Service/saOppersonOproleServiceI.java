/**
 * 
 */
package Ernest.Service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import Ernest.Entity.SaOppersonOprole;

/**
 * @author Ernest
 *
 */
public interface saOppersonOproleServiceI {
	/**
	 * 添加中间表
	 * @param json
	 * @return
	 */
	String addSaOpersonOprole(JSONObject json);
	/**
	 * 修改中间表
	 * @param json
	 * @return
	 */
	String updateSaOpersonOprole(JSONObject json);
	/**
	 * 根据id删除中间表
	 * @param id
	 * @return
	 */
	String DeleteSaOpersonOprole(String id);
	/**
	 * 根据id查找中间表
	 * @param id
	 * @return
	 */
	String findSaOpersonOprole(String id);
	/**
	 * 根据人员id删除
	 * @param id
	 * @return
	 */
	JSONObject deletByUserId(String id);
	/**
	 * 根据人员Id列表删除
	 * @param list
	 * @return 返回影响数据的条数
	 */
	int deleteByUserIds(List<String> list);
	/**
	 * 批量保存
	 * @param list
	 * @return 返回影响数据的条数
	 */
	int batchSaves(List<SaOppersonOprole> list);
	/**
	 * 根据主键id批量删除
	 * @param list
	 * @return 返回影响数据的条数
	 */
	int deleteById(List<String> list);
}
