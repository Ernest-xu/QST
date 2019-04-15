/**
 * 
 */
package Ernest.Service.Imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.postinformationtabQuduanDaoI;
import Ernest.Entity.Postinformationtab;
import Ernest.Entity.PostinformationtabQuduan;
import Ernest.Service.postinformationtabQuduanServiceI;
import Ernest.Service.postinformationtabServiceI;
import Ernest.until.RecursiveHierarchy;

/**
 * @author Ernest
 *
 */
@Service
public class postinformationtabQuduanServiceimpl implements postinformationtabQuduanServiceI {
	private static final Logger logger = Logger.getLogger(postinformationtabQuduanServiceimpl.class);
	@Autowired
	private postinformationtabQuduanDaoI postinformationtabQuduanDao;
	@Autowired
	private postinformationtabServiceI postinformationtabService;
	
	
	@Override
	public List<PostinformationtabQuduan> findListByfMsterID(String fMsterID) {
		return postinformationtabQuduanDao.findListByfMsterID(fMsterID);
	}

	
	@Override
	public JSONObject SelectZoneList(String fProjectID) {
		JSONObject json= new JSONObject();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<String> idlist = new ArrayList<String>();
		List<PostinformationtabQuduan> PQlist = postinformationtabQuduanDao.findListByfMsterID(fProjectID);
		for(PostinformationtabQuduan postinformationtabQuduan :PQlist){
			Map<String, Object> map = new HashMap<String, Object>();
			String fID =postinformationtabQuduan.getFid() ;
			idlist.add(fID);
			map.put("fID", fID);
			map.put("fMsterID", postinformationtabQuduan.getFmsterId());
			map.put("sName", postinformationtabQuduan.getFpostName());
			map.put("fPostName", postinformationtabQuduan.getFpostName());
			map.put("fPostNameState", postinformationtabQuduan.getFpostNameState());
			map.put("fPostNameEnd", postinformationtabQuduan.getFpostNameEnd());
			map.put("fPostID", postinformationtabQuduan.getFpostId());
			map.put("fSpanSum", postinformationtabQuduan.getFspanSum());
			map.put("fPointCut", postinformationtabQuduan.getFpointCut());
			list.add(map);
		}
		List<Postinformationtab> Plist = new ArrayList<Postinformationtab>();
		if(!idlist.isEmpty()){
			 Plist =postinformationtabService.findListByListMasterIds(idlist);
		}
		for(Postinformationtab postinformationtab:Plist){
			Map<String, Object> strMap = new HashMap<String, Object>();
			strMap.put("fID", postinformationtab.getFid());
			strMap.put("fProjectCode", postinformationtab.getFprojectCode());
			strMap.put("fMsterID", postinformationtab.getFmsterId());
			strMap.put("sName" , postinformationtab.getFpostName());
			strMap.put("fPostName", postinformationtab.getFpostName());
			strMap.put("fPostID", postinformationtab.getFpostId());
			strMap.put("fCubeSum", postinformationtab.getFcubeSum());
			strMap.put("fTonnageSum", postinformationtab.getFtonnageSum());
			strMap.put("fSpanSum", postinformationtab.getFspanSum());
			strMap.put("fPointCut", postinformationtab.getFpointCut());
			list.add(strMap);
		}
		Map<String,String> imap = new HashMap<String, String>();
		imap.put("fID","fID");
		imap.put("fMsterID","fMsterID");
		imap.put("fPostName","fPostName");
		imap.put("sName","sName");
		imap.put("fPostName","fPostName");
		imap.put("fPostNameState","fPostNameState");
		imap.put("fPostNameEnd","fPostNameEnd");
		imap.put("fPostID","fPostID");
		imap.put("fSpanSum","fSpanSum");
		imap.put("fPointCut","fPointCut");
		imap.put("fProjectCode","fProjectCode");
		imap.put("fCubeSum","fCubeSum");
		imap.put("fTonnageSum","fTonnageSum");
		Map<String,String> Parentmap = new HashMap<String, String>();
		Parentmap.put("fMsterID","fID");
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		list2 = RecursiveHierarchy.getChildren(list, imap, Parentmap, 2, 3, fProjectID);
		
		json.put("list", list2);
		if(!list2.isEmpty()){
			json.put("success", true);
			json.put("message", "成功");
		}else{
			json.put("success", false);
			json.put("message", "失败");
		}
		return json;
	}

}
