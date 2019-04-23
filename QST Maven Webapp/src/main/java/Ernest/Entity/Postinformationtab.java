package Ernest.Entity;

import java.util.Date;

/**
 * 桩号表实体类
 * @author Ernest
 *
 */

public class Postinformationtab implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String fid;//
	private String fprojectCode;//
	private String fmsterId;//
	private String fpostName;//
	private String fpostId;//
	private Float fcubeSum;//
	private Float ftonnageSum;//
	private Float fspanSum;//
	private String fpointCut;//
	private Float fzhuangJdjichu;//
	private Float fzhuangJdzuta;//
	
	private String fcreateOrgId;
	private String fcreateOrgname;
	private String fcreateOrgCode;
	private String fcreateDepId;
	private String fcreateDepName;
	private String fcreateDepCode;
	private String fcreatePosId;
	private String fcreatePosName;
	private String fcreatePosCode;
	private String fcreatePsmId;
	private String fcreatePsmname;
	private String fcreatePsmCode;
	private String fcreateDateTime;
	private String fupdateDateTime;
	private String fupdatePsmName;
	private String fprjoectName;
	private String fno;
	private String fwrtieName;
	private String fwriteCode;
	private Date fwrtietime;
	private String fstate;
	private String ftype;
	private String fzhuangState;
	private String basicsSubPageName;
	private String basicsSubPageState;
	private String towerSubPageName;
	private String towerSubPageState;
	private String stringingSubPageName;
	private String stringingSubPageState;
	private String basicsSubPageId;
	private String towerSubPageId;
	private String stringingSubPageId;
	private Integer fbasicsSubPlanSum;
	private Integer ftowerSubPlanSum;
	private Integer fstringingSubPlanSum;
	private String fmd5;
	private Float fzhuangJdjiaxian;

	// Constructors

	/** default constructor */
	public Postinformationtab() {
	}

	/** minimal constructor */
	public Postinformationtab(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public Postinformationtab(String fid, String fcreateOrgId, String fcreateOrgname,
			String fcreateOrgCode, String fcreateDepId, String fcreateDepName, String fcreateDepCode,
			String fcreatePosId, String fcreatePosName, String fcreatePosCode, String fcreatePsmId,
			String fcreatePsmname, String fcreatePsmCode, String fcreateDateTime, String fupdateDateTime,
			String fupdatePsmName, String fprjoectName, String fprojectCode, String fno, String fwrtieName,
			String fwriteCode, Date fwrtietime, String fstate, String ftype, String fmsterId, String fpostName,
			String fpostId, Float fcubeSum, Float ftonnageSum, Float fspanSum, String fzhuangState, String fpointCut,
			String basicsSubPageName, String basicsSubPageState, String towerSubPageName, String towerSubPageState,
			String stringingSubPageName, String stringingSubPageState, String basicsSubPageId, String towerSubPageId,
			String stringingSubPageId, Integer fbasicsSubPlanSum, Integer ftowerSubPlanSum,
			Integer fstringingSubPlanSum, String fmd5, Float fzhuangJdjichu, Float fzhuangJdzuta,
			Float fzhuangJdjiaxian) {
		this.fid = fid;
		this.fcreateOrgId = fcreateOrgId;
		this.fcreateOrgname = fcreateOrgname;
		this.fcreateOrgCode = fcreateOrgCode;
		this.fcreateDepId = fcreateDepId;
		this.fcreateDepName = fcreateDepName;
		this.fcreateDepCode = fcreateDepCode;
		this.fcreatePosId = fcreatePosId;
		this.fcreatePosName = fcreatePosName;
		this.fcreatePosCode = fcreatePosCode;
		this.fcreatePsmId = fcreatePsmId;
		this.fcreatePsmname = fcreatePsmname;
		this.fcreatePsmCode = fcreatePsmCode;
		this.fcreateDateTime = fcreateDateTime;
		this.fupdateDateTime = fupdateDateTime;
		this.fupdatePsmName = fupdatePsmName;
		this.fprjoectName = fprjoectName;
		this.fprojectCode = fprojectCode;
		this.fno = fno;
		this.fwrtieName = fwrtieName;
		this.fwriteCode = fwriteCode;
		this.fwrtietime = fwrtietime;
		this.fstate = fstate;
		this.ftype = ftype;
		this.fmsterId = fmsterId;
		this.fpostName = fpostName;
		this.fpostId = fpostId;
		this.fcubeSum = fcubeSum;
		this.ftonnageSum = ftonnageSum;
		this.fspanSum = fspanSum;
		this.fzhuangState = fzhuangState;
		this.fpointCut = fpointCut;
		this.basicsSubPageName = basicsSubPageName;
		this.basicsSubPageState = basicsSubPageState;
		this.towerSubPageName = towerSubPageName;
		this.towerSubPageState = towerSubPageState;
		this.stringingSubPageName = stringingSubPageName;
		this.stringingSubPageState = stringingSubPageState;
		this.basicsSubPageId = basicsSubPageId;
		this.towerSubPageId = towerSubPageId;
		this.stringingSubPageId = stringingSubPageId;
		this.fbasicsSubPlanSum = fbasicsSubPlanSum;
		this.ftowerSubPlanSum = ftowerSubPlanSum;
		this.fstringingSubPlanSum = fstringingSubPlanSum;
		this.fmd5 = fmd5;
		this.fzhuangJdjichu = fzhuangJdjichu;
		this.fzhuangJdzuta = fzhuangJdzuta;
		this.fzhuangJdjiaxian = fzhuangJdjiaxian;
	}

	// Property accessors


	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}


	public String getFcreateOrgId() {
		return this.fcreateOrgId;
	}

	public void setFcreateOrgId(String fcreateOrgId) {
		this.fcreateOrgId = fcreateOrgId;
	}


	public String getFcreateOrgname() {
		return this.fcreateOrgname;
	}

	public void setFcreateOrgname(String fcreateOrgname) {
		this.fcreateOrgname = fcreateOrgname;
	}


	public String getFcreateOrgCode() {
		return this.fcreateOrgCode;
	}

	public void setFcreateOrgCode(String fcreateOrgCode) {
		this.fcreateOrgCode = fcreateOrgCode;
	}


	public String getFcreateDepId() {
		return this.fcreateDepId;
	}

	public void setFcreateDepId(String fcreateDepId) {
		this.fcreateDepId = fcreateDepId;
	}


	public String getFcreateDepName() {
		return this.fcreateDepName;
	}

	public void setFcreateDepName(String fcreateDepName) {
		this.fcreateDepName = fcreateDepName;
	}


	public String getFcreateDepCode() {
		return this.fcreateDepCode;
	}

	public void setFcreateDepCode(String fcreateDepCode) {
		this.fcreateDepCode = fcreateDepCode;
	}


	public String getFcreatePosId() {
		return this.fcreatePosId;
	}

	public void setFcreatePosId(String fcreatePosId) {
		this.fcreatePosId = fcreatePosId;
	}


	public String getFcreatePosName() {
		return this.fcreatePosName;
	}

	public void setFcreatePosName(String fcreatePosName) {
		this.fcreatePosName = fcreatePosName;
	}


	public String getFcreatePosCode() {
		return this.fcreatePosCode;
	}

	public void setFcreatePosCode(String fcreatePosCode) {
		this.fcreatePosCode = fcreatePosCode;
	}


	public String getFcreatePsmId() {
		return this.fcreatePsmId;
	}

	public void setFcreatePsmId(String fcreatePsmId) {
		this.fcreatePsmId = fcreatePsmId;
	}


	public String getFcreatePsmname() {
		return this.fcreatePsmname;
	}

	public void setFcreatePsmname(String fcreatePsmname) {
		this.fcreatePsmname = fcreatePsmname;
	}


	public String getFcreatePsmCode() {
		return this.fcreatePsmCode;
	}

	public void setFcreatePsmCode(String fcreatePsmCode) {
		this.fcreatePsmCode = fcreatePsmCode;
	}


	public String getFcreateDateTime() {
		return this.fcreateDateTime;
	}

	public void setFcreateDateTime(String fcreateDateTime) {
		this.fcreateDateTime = fcreateDateTime;
	}


	public String getFupdateDateTime() {
		return this.fupdateDateTime;
	}

	public void setFupdateDateTime(String fupdateDateTime) {
		this.fupdateDateTime = fupdateDateTime;
	}


	public String getFupdatePsmName() {
		return this.fupdatePsmName;
	}

	public void setFupdatePsmName(String fupdatePsmName) {
		this.fupdatePsmName = fupdatePsmName;
	}


	public String getFprjoectName() {
		return this.fprjoectName;
	}

	public void setFprjoectName(String fprjoectName) {
		this.fprjoectName = fprjoectName;
	}


	public String getFprojectCode() {
		return this.fprojectCode;
	}

	public void setFprojectCode(String fprojectCode) {
		this.fprojectCode = fprojectCode;
	}


	public String getFno() {
		return this.fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}


	public String getFwrtieName() {
		return this.fwrtieName;
	}

	public void setFwrtieName(String fwrtieName) {
		this.fwrtieName = fwrtieName;
	}


	public String getFwriteCode() {
		return this.fwriteCode;
	}

	public void setFwriteCode(String fwriteCode) {
		this.fwriteCode = fwriteCode;
	}


	public Date getFwrtietime() {
		return this.fwrtietime;
	}

	public void setFwrtietime(Date fwrtietime) {
		this.fwrtietime = fwrtietime;
	}


	public String getFstate() {
		return this.fstate;
	}

	public void setFstate(String fstate) {
		this.fstate = fstate;
	}


	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}


	public String getFmsterId() {
		return this.fmsterId;
	}

	public void setFmsterId(String fmsterId) {
		this.fmsterId = fmsterId;
	}


	public String getFpostName() {
		return this.fpostName;
	}

	public void setFpostName(String fpostName) {
		this.fpostName = fpostName;
	}


	public String getFpostId() {
		return this.fpostId;
	}

	public void setFpostId(String fpostId) {
		this.fpostId = fpostId;
	}


	public Float getFcubeSum() {
		return this.fcubeSum;
	}

	public void setFcubeSum(Float fcubeSum) {
		this.fcubeSum = fcubeSum;
	}


	public Float getFtonnageSum() {
		return this.ftonnageSum;
	}

	public void setFtonnageSum(Float ftonnageSum) {
		this.ftonnageSum = ftonnageSum;
	}


	public Float getFspanSum() {
		return this.fspanSum;
	}

	public void setFspanSum(Float fspanSum) {
		this.fspanSum = fspanSum;
	}


	public String getFzhuangState() {
		return this.fzhuangState;
	}

	public void setFzhuangState(String fzhuangState) {
		this.fzhuangState = fzhuangState;
	}


	public String getFpointCut() {
		return this.fpointCut;
	}

	public void setFpointCut(String fpointCut) {
		this.fpointCut = fpointCut;
	}


	public String getBasicsSubPageName() {
		return this.basicsSubPageName;
	}

	public void setBasicsSubPageName(String basicsSubPageName) {
		this.basicsSubPageName = basicsSubPageName;
	}


	public String getBasicsSubPageState() {
		return this.basicsSubPageState;
	}

	public void setBasicsSubPageState(String basicsSubPageState) {
		this.basicsSubPageState = basicsSubPageState;
	}


	public String getTowerSubPageName() {
		return this.towerSubPageName;
	}

	public void setTowerSubPageName(String towerSubPageName) {
		this.towerSubPageName = towerSubPageName;
	}


	public String getTowerSubPageState() {
		return this.towerSubPageState;
	}

	public void setTowerSubPageState(String towerSubPageState) {
		this.towerSubPageState = towerSubPageState;
	}


	public String getStringingSubPageName() {
		return this.stringingSubPageName;
	}

	public void setStringingSubPageName(String stringingSubPageName) {
		this.stringingSubPageName = stringingSubPageName;
	}


	public String getStringingSubPageState() {
		return this.stringingSubPageState;
	}

	public void setStringingSubPageState(String stringingSubPageState) {
		this.stringingSubPageState = stringingSubPageState;
	}


	public String getBasicsSubPageId() {
		return this.basicsSubPageId;
	}

	public void setBasicsSubPageId(String basicsSubPageId) {
		this.basicsSubPageId = basicsSubPageId;
	}


	public String getTowerSubPageId() {
		return this.towerSubPageId;
	}

	public void setTowerSubPageId(String towerSubPageId) {
		this.towerSubPageId = towerSubPageId;
	}


	public String getStringingSubPageId() {
		return this.stringingSubPageId;
	}

	public void setStringingSubPageId(String stringingSubPageId) {
		this.stringingSubPageId = stringingSubPageId;
	}


	public Integer getFbasicsSubPlanSum() {
		return this.fbasicsSubPlanSum;
	}

	public void setFbasicsSubPlanSum(Integer fbasicsSubPlanSum) {
		this.fbasicsSubPlanSum = fbasicsSubPlanSum;
	}


	public Integer getFtowerSubPlanSum() {
		return this.ftowerSubPlanSum;
	}

	public void setFtowerSubPlanSum(Integer ftowerSubPlanSum) {
		this.ftowerSubPlanSum = ftowerSubPlanSum;
	}


	public Integer getFstringingSubPlanSum() {
		return this.fstringingSubPlanSum;
	}

	public void setFstringingSubPlanSum(Integer fstringingSubPlanSum) {
		this.fstringingSubPlanSum = fstringingSubPlanSum;
	}


	public String getFmd5() {
		return this.fmd5;
	}

	public void setFmd5(String fmd5) {
		this.fmd5 = fmd5;
	}


	public Float getFzhuangJdjichu() {
		return this.fzhuangJdjichu;
	}

	public void setFzhuangJdjichu(Float fzhuangJdjichu) {
		this.fzhuangJdjichu = fzhuangJdjichu;
	}


	public Float getFzhuangJdzuta() {
		return this.fzhuangJdzuta;
	}

	public void setFzhuangJdzuta(Float fzhuangJdzuta) {
		this.fzhuangJdzuta = fzhuangJdzuta;
	}


	public Float getFzhuangJdjiaxian() {
		return this.fzhuangJdjiaxian;
	}

	public void setFzhuangJdjiaxian(Float fzhuangJdjiaxian) {
		this.fzhuangJdjiaxian = fzhuangJdjiaxian;
	}

	@Override
	public String toString() {
		return "Postinformationtab [fid=" + fid + ", fprojectCode=" + fprojectCode + ", fmsterId=" + fmsterId
				+ ", fpostName=" + fpostName + ", fpostId=" + fpostId + ", fcubeSum=" + fcubeSum + ", ftonnageSum="
				+ ftonnageSum + ", fspanSum=" + fspanSum + ", fpointCut=" + fpointCut + ", fzhuangJdjichu="
				+ fzhuangJdjichu + ", fzhuangJdzuta=" + fzhuangJdzuta + "]";
	}

	
	
	
	
}