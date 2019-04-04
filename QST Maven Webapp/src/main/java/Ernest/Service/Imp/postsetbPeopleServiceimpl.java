/**
 * 
 */
package Ernest.Service.Imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.postsetbPeopleDaoI;
import Ernest.Entity.PostsetbPeople;
import Ernest.Entity.SaOpperson;
import Ernest.Service.postsetbPeopleServiceI;
import Ernest.Service.postsetbXm3gwServiceI;
import Ernest.Service.saOproleServiceI;

/**
 * @author Ernest
 *
 */
@Service
public class postsetbPeopleServiceimpl implements postsetbPeopleServiceI {
	private static final Logger logger = Logger.getLogger(postsetbPeopleServiceimpl.class);
	@Autowired
	private postsetbPeopleDaoI postsetbPeopleDao;
	@Autowired
	private saOproleServiceI saOproleService;
	@Autowired
	private postsetbXm3gwServiceI postsetbXm3gwService;
	
	@Override
	public JSONObject findPeopleListByProjectId(String ProjectId) {
		JSONObject json  = new JSONObject();
		Map<String, String> orgMap= postsetbXm3gwService.findByProjectId(ProjectId); 
		List<PostsetbPeople> PPlist = postsetbPeopleDao.findPeopleListByProjectId(ProjectId);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(PostsetbPeople postsetbPeople : PPlist){
			Map<String,Object> map = new HashMap<String, Object>();
			SaOpperson saOpperson = new SaOpperson();
			saOpperson = postsetbPeople.getSaOpperson();
			map.put("sID", saOpperson.getSid());//人员ID
			map.put("sName", saOpperson.getSname());//真实姓名
			map.put("sMd5Str", saOpperson.getSmd5str());//md5
			map.put("sLoginName", saOpperson.getSloginName());//登录名
			map.put("sPassword", saOpperson.getSpassword());//密码
			map.put("fID", postsetbPeople.getFid());//岗位
			map.put("fPostName", postsetbPeople.getFpostName());//项目名称
			map.put("sFName", orgMap.get( saOpperson.getSid()));//部门
			map.put("fxmbName", postsetbPeople.getPostsetbXm().getFxmbName());//分包商
			List<Map<String, Object>> SOlist = saOproleService.selectJobName(postsetbPeople.getSaOpperson().getSid());
			map.put("roleIds", SOlist);
			list.add(map);
		}
		//分类排序
		Collections.sort(list, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
            	String n1="";
            	if(o1.get("sFName")!=null){
            		n1=(String)o1.get("sFName");
            	}
            	
            	String n2="";
            	if(o2.get("sFName")!=null){
            		n2=(String)o2.get("sFName");
            	}
//                我这里是从大到小的排序，如果从小到大，n1和n2换一下位置就可以了
                return n2.compareTo(n1);
            }
        });
		if(!list.isEmpty()){
			json.put("Data", list);
			json.put("success", true);
		}else{
			json.put("success",false);
		};
		return json;
	}

}
