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

import Ernest.Dao.basicMainGongDaoI;
import Ernest.Entity.BasicDetailGong;
import Ernest.Entity.BasicMainGong;
import Ernest.Service.basicDetailGongServiceI;
import Ernest.Service.basicMainGongServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class basicMainGongServiceimpl implements basicMainGongServiceI {

	@Autowired
	private basicMainGongDaoI basicMainGongDao;
	@Autowired
	private basicDetailGongServiceI basicDetailGongService;
	
	@Override
	public List<BasicMainGong> findByfMasterId(String fMasterID) {
		return basicMainGongDao.findByfMasterId(fMasterID);
	}

	
	@Override
	public JSONObject SelectProcess(String fProjectID) {
		
		JSONObject json = new JSONObject();
		 List<BasicMainGong> BMGlist = basicMainGongDao.findByfMasterId(fProjectID);
		 List<Map<String ,Object>> list = new ArrayList<Map<String,Object>>();
		 int number=0;
		 for(BasicMainGong basicMainGong : BMGlist){
			 Map<String,Object> map = new HashMap<String, Object>();
			 List<BasicDetailGong> BDGlist = new ArrayList<BasicDetailGong>();
			 BDGlist = basicDetailGongService.basicDetailGongMap(fProjectID, basicMainGong.getFbz());
			 List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
			 for(BasicDetailGong basicDetailGong:BDGlist){
				 Map<String,Object> map2 = new HashMap<String, Object>();
				 map2.put("fID", basicDetailGong.getFid());
				 map2.put("lable", basicDetailGong.getFbasicName());
				 list2.add(map2);
			 }
			 map.put("fID", basicMainGong.getFid());
			 map.put("lable", basicMainGong.getFbasicType());
			 map.put("children", list2);
			 list.add(map);
		 }
		json.put("list", list);
		if(number>0){
			json.put("success", true);
			json.put("message", "成功");
		}else{
			json.put("success", false);
			json.put("message", "失败");
		}
		 
		return json;
	}


	@Override
	public int batchSaves(List<BasicMainGong> list) {
		return basicMainGongDao.batchSaves(list);
	}

}
