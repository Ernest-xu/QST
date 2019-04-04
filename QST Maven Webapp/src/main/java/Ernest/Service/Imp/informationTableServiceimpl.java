/**
 * 
 */
package Ernest.Service.Imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.informationTableDaoI;
import Ernest.Entity.InformationTable;
import Ernest.Service.informationTableServiceI;
import Ernest.until.RecursiveHierarchy;

/**
 * @author Ernest
 *
 */
@Service
public class informationTableServiceimpl implements informationTableServiceI {

	@Autowired
	private informationTableDaoI informationTableDao;
	
	@Override
	public JSONObject findMainList(String writeId) {
		JSONObject json = new JSONObject();
		List<InformationTable> listTable = informationTableDao.findList(writeId);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		String newID = UUID.randomUUID().toString();
		newID = newID.replace("-", "");
		Map<String, Object> parentMap = new HashMap<String, Object>();
		parentMap.put("sID", newID);
		parentMap.put("sName", "项目组织");
		parentMap.put("sParentID",null);
		parentMap.put("sMd5Str", "");
		list2.add(parentMap);
		for(InformationTable Information : listTable){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sID", Information.getFid());
			map.put("sName", Information.getFprjoectName());
			map.put("fProjectQuanName", Information.getFprojectQuanName());
			map.put("sParentID", newID);
			map.put("sMd5Str", Information.getFmd5());
			list2.add(map);
		}
		Map<String, String> map1= new HashMap<String, String>();
		map1.put("id", "sID");
		map1.put("label", "sName");
		map1.put("fProjectQuanName", "fProjectQuanName");
		map1.put("sParentID", "sParentID");
		map1.put("sMd5Str", "sMd5Str");
		Map<String, String> Parentmap= new HashMap<String, String>();
		Parentmap.put("sParentID", "id");
		list = RecursiveHierarchy.getChildren(list2, map1, Parentmap, 1, 2, null);
		
		if(list2!=null ){
			json.put("list", list);
			json.put("success", true);
		}else{
			json.put("success", false);
		}
		
		return json;
	}

}