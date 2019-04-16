/**
 * 
 */
package Ernest.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.postinformationtabDaoI;
import Ernest.Entity.Postinformationtab;
import Ernest.Service.postinformationtabServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class postinformationtabServiceimpl implements postinformationtabServiceI {

	@Autowired
	private postinformationtabDaoI postinformationtabDao;
	@Override
	public List<Postinformationtab> findListByListMasterIds(List<String> list) {
		return postinformationtabDao.findListByListMasterIds(list);
	}
	
	
	@Override
	public JSONObject updateZhuang(String fID, String fMsterID, String fProjectCode, String fPostName, Float fCubeSum,
			Float fTonnageSum, Float fSpanSum) {
		JSONObject json = new JSONObject();
		Postinformationtab postinformationtab = new Postinformationtab();
		postinformationtab.setFid(fID);
		postinformationtab.setFmsterId(fMsterID);
		postinformationtab.setFprojectCode(fProjectCode);
		postinformationtab.setFpostName(fPostName);
		postinformationtab.setFcubeSum(fCubeSum);
		postinformationtab.setFtonnageSum(fTonnageSum);
		postinformationtab.setFspanSum(fSpanSum);
		int number = 0;
		number = postinformationtabDao.UpdateById(postinformationtab);
		if(number>0){
			//修改区段数量
			
			//修改桩号数量
			
			json.put("success", true);
			json.put("message", "成功");
		}else{
			json.put("success", false);
			json.put("message", "失败");
			
		}
		
		
		return json;
	}


	
	@Override
	public int UpdateById(Postinformationtab postinformationtab) {
		
		return postinformationtabDao.UpdateById(postinformationtab);
	}

}
