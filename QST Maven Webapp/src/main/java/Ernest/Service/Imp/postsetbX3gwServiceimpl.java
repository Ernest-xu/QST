/**
 * 
 */
package Ernest.Service.Imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.postsetbXm3gwDaoI;
import Ernest.Entity.PostsetbXm3gw;
import Ernest.Service.postsetbXm3gwServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class postsetbX3gwServiceimpl implements postsetbXm3gwServiceI {
	
	@Autowired
	private postsetbXm3gwDaoI postsetbXm3gwDao;
	@Override
	public JSONObject findByProjectIdAndUser(String ProjectId, String UserId) {
		JSONObject json = new JSONObject();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<PostsetbXm3gw> list1 = postsetbXm3gwDao.findByProjectIdAndUser(ProjectId, UserId);
		for(int i=0;i<list1.size();i++){
			PostsetbXm3gw postsetXm3gw = new PostsetbXm3gw();
			Map<String, Object> map = new HashMap<String, Object>();
			postsetXm3gw = list1.get(i);
			map.put("fID", postsetXm3gw.getFid());
			map.put("fPostName",postsetXm3gw.getFpostName());
			if(postsetXm3gw.getFpostxmid2()==null){
				map.put("Class", "班组");
			}else{
				map.put("Class", "岗位");
			}
			list.add(map);
		}
		
		if(list.isEmpty()){
			json.put("success", false);
			json.put("message", "失败");
			json.put("data", "[]");
		}else{
			json.put("success", true);
			json.put("message", "成功");
			json.put("data", list);
			
		}
		
		return json;
	}
	
	@Override
	public Map<String, String> findByProjectId(String ProjectId) {
		List<PostsetbXm3gw> PX3list = postsetbXm3gwDao.findByProjectId(ProjectId);
		Map<String, String > map = new HashMap<String, String>();
		for(PostsetbXm3gw px:PX3list){
			String sName = null;
			sName =px.getPostsetbXm3gw().getFpostName();
			String fPostWriteID = null;
			fPostWriteID=px.getFpostWriteId();
			if(fPostWriteID==null||"".equals(fPostWriteID)||"null".equals(fPostWriteID)){
				
			}else{
				
				int index = fPostWriteID.indexOf(",");
				String[] attrID = fPostWriteID.split(",");
				for(int i=0;i<attrID.length;i++){
					map.put(attrID[i], sName);
				}
			}
		}
		return map;
	}

}
