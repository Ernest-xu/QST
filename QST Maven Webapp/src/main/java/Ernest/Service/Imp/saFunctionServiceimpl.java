/**
 * 
 */
package Ernest.Service.Imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;

import Ernest.Dao.saFunctionDaoI;
import Ernest.Entity.Company;
import Ernest.Entity.Function;
import Ernest.Entity.SaFunction;
import Ernest.Service.saFunctionServiceI;
import Ernest.until.ReadXml;
import Ernest.until.RecursiveHierarchy;



/**
 * 功能表实现类
 * @author Ernest
 *
 */
@Service
public class saFunctionServiceimpl implements saFunctionServiceI {
	@Autowired
	private  saFunctionDaoI saFunctionDao;
	private static final Logger logger = Logger.getLogger(saFunctionServiceimpl.class);
	
	@Override
	public JSONObject saveAllFunction(String roleId, String companyId) {
		JSONObject json = new JSONObject();
		List<SaFunction> list = new ArrayList<SaFunction>();
		List<Company> companyList = null;// 不初始化，下面616行会报2错
		try {
			companyList = ReadXml.parseXml();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int aa=0;
		for (Company company : companyList) {
			aa++;
			List<Function> functions = company.getFunctions();
			
			for (Function function : functions) {
				SaFunction saFunction = new SaFunction();
				String fName = function.getName();
				String fUrl = function.getUrl();
				String fIcon = function.getIcon();
				Integer id = function.getId();
				String fType = function.getType();
				saFunction.setSid(UUID.randomUUID().toString());
				saFunction.setSname(fName);
				saFunction.setSurl(fUrl);
				saFunction.setCompanyId(companyId);
				saFunction.setIsShow((short) 1);
				saFunction.setRoleId(roleId);
				saFunction.setSicon(fIcon);
				saFunction.setSorder(id);
				saFunction.setStype(fType);
//				logger.info(saFunction.toString());
				list.add(saFunction);
			}
		}
//		logger.info(aa);
		saFunctionDao.batchSaves(list);
		json.put("success",true);
		json.put("message","成功");
		return json;
	}

	
	@Override
	public JSONObject deleteFunctionByRole(String id) {
		JSONObject json = new JSONObject();
		int a = saFunctionDao.deleteByRoleId(id);
//		logger.info(a);
		json.put("success", true);
		json.put("message", "成功");
		return json;
	}

	@Override
	public JSONObject SelectFunctionTier(String sID, String sMainOrgID) {
		JSONObject json = new JSONObject();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
		list3 = getType();
		if(list3!=null){
			for(int i=0;i<list3.size();i++){
				Map<String,Object> map = list3.get(i);
				list2.add(map);
			}
		}
		Map<String,Object> paramsmap = new HashMap<String, Object>();
		paramsmap.put("roleId", sID);
		paramsmap.put("companyId", sMainOrgID);
//		logger.info(paramsmap.toString());
		List<SaFunction> SFlist = findByroleandcompany(paramsmap);
		for(SaFunction saFunction:SFlist){
//			logger.info(saFunction.toString());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sID", saFunction.getSid());
			map.put("sName", saFunction.getSname());
			map.put("sUrl", saFunction.getSurl());
			map.put("isShow",saFunction.getIsShow()+"");
			map.put("sIcon", saFunction.getSicon());
			map.put("companyId", saFunction.getCompanyId());
			map.put("roleId", saFunction.getRoleId());
			map.put("sOrder", saFunction.getSorder());
			map.put("sType", saFunction.getStype());
			list2.add(map);
		}
		Map<String,String > fieldmap = new HashMap<String, String>();
		fieldmap.put("sID", "sID");
		fieldmap.put("sName", "sName");
		fieldmap.put("sParentID","sParentID");
		fieldmap.put("sType", "sType");
		fieldmap.put("isShow", "isShow");
		Map<String,String > Parentmap = new HashMap<String, String>();
		Parentmap.put("sType", "sParentID");
		list = RecursiveHierarchy.getChildren(list2, fieldmap,Parentmap,1,2,null);
		if(list.isEmpty()){
			
			json.put("success", false);
			json.put("message", "没有数据");
		}else{
			json.put("list", list);
			json.put("success", true);
			json.put("message", "查找成功");
		}
		return json;
	}

	/**
	 * 权限类别
	 * @return
	 */
	public static List<Map<String, Object>> getType(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("sName", "工程管理");
		map1.put("sParentID", "engineeringManager");
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("sName", "日志统计");
		map2.put("sParentID", "logStatistics");
		Map<String,Object> map3 = new HashMap<String, Object>();
		map3.put("sName", "汇报模块");
		map3.put("sParentID", "reportFunctions");
		Map<String,Object> map4 = new HashMap<String, Object>();
		map4.put("sName", "系统管理");
		map4.put("sParentID", "systemManager");
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		return list;
	};

	@Override
	public List<SaFunction> findByroleandcompany(Map<String, Object> map) {
		
		return saFunctionDao.findByroleandcompany(map);
	}



	@Override
	public JSONObject UpdateFunction(String sID, int isShow) {
		JSONObject json = new JSONObject();
		int number = 0;
		SaFunction saFunction = new SaFunction();
		saFunction.setSid(sID);
		saFunction.setIsShow((short)isShow);
		number = saFunctionDao.updateById(saFunction);
		if(number>0){
			json.put("success", true);
			json.put("message", "修改成功");
		}else{
			json.put("success", false);
			json.put("message", "修改失败");
		}
		return json;
	}
	
	

	
	

}
