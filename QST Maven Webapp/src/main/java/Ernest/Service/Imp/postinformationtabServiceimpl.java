/**
 * 
 */
package Ernest.Service.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Ernest.Dao.postinformationtabDaoI;
import Ernest.Entity.InformationTable;
import Ernest.Entity.PmDocStakeClass;
import Ernest.Entity.Postinformationtab;
import Ernest.Entity.PostinformationtabQuduan;
import Ernest.Service.informationTableServiceI;
import Ernest.Service.pmDocStakeClassServiceI;
import Ernest.Service.postinformationtabQuduanServiceI;
import Ernest.Service.postinformationtabServiceI;

/**
 * 桩号表实现类
 * @author Ernest
 *
 */
@Service
public class postinformationtabServiceimpl implements postinformationtabServiceI {
	private static final Logger logger = Logger.getLogger(postinformationtabServiceimpl.class);
	@Autowired
	private postinformationtabDaoI postinformationtabDao;
	@Autowired
	private postinformationtabQuduanServiceI postinformationtabQuduanService;
	@Autowired
	private informationTableServiceI informationTableService;
	@Autowired
	private pmDocStakeClassServiceI pmDocStakeClassService;
	
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
			HashMap<String, Object> map = postinformationtabDao.findMapByMasterId(fMsterID);
			PostinformationtabQuduan postinformationtabQuduan = new PostinformationtabQuduan();
			postinformationtabQuduan.setFid(fMsterID);
			
			postinformationtabQuduan.setFspanSum((float)((double)map.get("num")));
			//修改区段数量
			postinformationtabQuduanService.UpdateByfID(postinformationtabQuduan);
			//修改桩号数量
			HashMap<String, Object> upmap = postinformationtabDao.findMapByProjectId(fProjectCode);
			InformationTable informationTable = new InformationTable();
			informationTable.setFsvgqd(""+upmap.get("zdsum"));
			informationTable.setFsvgzs(""+upmap.get("num"));
			informationTable.setFzhuangshu(""+upmap.get("num"));
			informationTableService.updateByMapId(informationTable);
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


	
	@Override
	public HashMap<String, Object> findMapByProjectId(String ProjectId) {
		return postinformationtabDao.findMapByProjectId(ProjectId);
	}



	@Override
	public HashMap<String, Object> findMapByMasterId(String MasterId) {
		return postinformationtabDao.findMapByMasterId(MasterId);
	}


	
	@Override
	public int batchSave(List<Postinformationtab> list) {
		return postinformationtabDao.batchSave(list);
	}


	
	@Override
	public int saveById(Postinformationtab postinformationtab) {
		return postinformationtabDao.saveById(postinformationtab);
	}


	
	@Override
	public JSONObject insertZhuang(String fMsterID, String fProjectCode, String fPostName, Float fCubeSum,
			Float fTonnageSum, Float fSpanSum) {
		JSONObject json = new JSONObject();
		Postinformationtab postinformationtab = new Postinformationtab ();
		String fID = UUID.randomUUID().toString();
		postinformationtab.setFid(fID);
		postinformationtab.setFmsterId(fMsterID);
		postinformationtab.setFprojectCode(fProjectCode);
		postinformationtab.setFpostName(fPostName);
		postinformationtab.setFcubeSum(fCubeSum);
		postinformationtab.setFtonnageSum(fTonnageSum);
		postinformationtab.setFspanSum(fSpanSum);
		int a = postinformationtabDao.saveById(postinformationtab);
		
		if(a>0){
			//在照片文件夹中添加文件夹
//			PcPhotoManager.addProjectFolder(fID, fProjectCode, fPostName, fMsterID, context);
			PmDocStakeClass pmDocStakeClass = new PmDocStakeClass();
			pmDocStakeClass.setFid(fID);
			pmDocStakeClass.setFmsterId(fMsterID);
			pmDocStakeClass.setFprojectCode(fProjectCode);
			pmDocStakeClass.setFpostName(fPostName);
			pmDocStakeClassService.saveById(pmDocStakeClass);
			HashMap<String, Object> map = postinformationtabDao.findMapByMasterId(fMsterID);
			PostinformationtabQuduan postinformationtabQuduan = new PostinformationtabQuduan();
			postinformationtabQuduan.setFid(fMsterID);
			postinformationtabQuduan.setFspanSum((float)((double)map.get("num")));
			//修改区段数量
			postinformationtabQuduanService.UpdateByfID(postinformationtabQuduan);
			//修改桩号数量
			HashMap<String, Object> upmap = postinformationtabDao.findMapByProjectId(fProjectCode);
			InformationTable informationTable = new InformationTable();
			informationTable.setFsvgqd(""+upmap.get("zdsum"));
			informationTable.setFsvgzs(""+upmap.get("num"));
			informationTable.setFzhuangshu(""+upmap.get("num"));
			informationTableService.updateByMapId(informationTable);
			json.put("success", true);
			json.put("message", "新增成功");
		}else{
			json.put("success", true);
			json.put("message", "新增失败");
		}
		return json;
	}


	
	@Override
	public JSONObject deleteZhuang(String fID, String fMsterID, String fProjectCode) {
		JSONObject json = new JSONObject();
		int a = postinformationtabDao.deleteById(fID);
		if(a>0){
			logger.info(fMsterID);
			HashMap<String, Object> map = postinformationtabDao.findMapByMasterId(fMsterID);
			logger.info(map.toString());
			PostinformationtabQuduan postinformationtabQuduan = new PostinformationtabQuduan();
			postinformationtabQuduan.setFid(fMsterID);
			postinformationtabQuduan.setFspanSum((float)((double)map.get("num")));
			//修改区段数量
			postinformationtabQuduanService.UpdateByfID(postinformationtabQuduan);
			//修改桩号数量
			HashMap<String, Object> upmap = postinformationtabDao.findMapByProjectId(fProjectCode);
			InformationTable informationTable = new InformationTable();
			informationTable.setFsvgqd(""+upmap.get("zdsum"));
			informationTable.setFsvgzs(""+upmap.get("num"));
			informationTable.setFzhuangshu(""+upmap.get("num"));
			informationTableService.updateByMapId(informationTable);
			json.put("success", true);
			json.put("message", "删除成功");
		}else{
			json.put("success", false);
			json.put("message", "删除失败");
		}
		return json;
	}


	@Override
	public int deleteById(String fID) {
		return postinformationtabDao.deleteById(fID);
	}


	@Override
	public int batchDelete(List<String> list) {
		return postinformationtabDao.batchDelete(list);
	}


	@Override
	public int deleteByfMasterId(String fMasterId) {
		return postinformationtabDao.deleteByfMasterId(fMasterId);
	}


	@Override
	public int deleteByfProjectCode(String fProjectCode) {
		return postinformationtabDao.deleteByfProjectCode(fProjectCode);
	}

}
