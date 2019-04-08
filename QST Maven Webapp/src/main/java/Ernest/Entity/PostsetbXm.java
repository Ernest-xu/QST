package Ernest.Entity;


/**
 * PmProjectProjectInformationtablePostsetbXm entity. @author MyEclipse
 * Persistence Tools
 */


public class PostsetbXm implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String fid;//
	private String fmasterId;//
	private String fprojectName;//
	private String fprojectCode;//
	private String fxmbType;//
	private String fxmbName;//
	private String fmd5;//
	private String fwriteName;//
	private String fwriteId;//
	private String fwriteMd5;//
	private String fno;
	private String fpostName;
	private String fpostWriteName;
	private String fpostWriteId;
	private String fpostCode;
	private String fpostId;
	private String fpostState;
	private String fpostType;
	private String froleName;
	private String froleId;
	private String fpostXlb;
	
	// Constructors

	/** default constructor */
	public PostsetbXm() {
	}

	/** minimal constructor */
	public PostsetbXm(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public PostsetbXm(String fid, String fno, String fpostName, String fpostWriteName,
			String fpostWriteId, String fpostCode, String fpostId, String fpostState, String fpostType,
			String fmasterId, String fprojectName, String fprojectCode, String froleName, String fxmbType,
			String fxmbName, String froleId, String fmd5, String fpostXlb, String fwriteName, String fwriteId,
			String fwriteMd5) {
		this.fid = fid;
		this.fno = fno;
		this.fpostName = fpostName;
		this.fpostWriteName = fpostWriteName;
		this.fpostWriteId = fpostWriteId;
		this.fpostCode = fpostCode;
		this.fpostId = fpostId;
		this.fpostState = fpostState;
		this.fpostType = fpostType;
		this.fmasterId = fmasterId;
		this.fprojectName = fprojectName;
		this.fprojectCode = fprojectCode;
		this.froleName = froleName;
		this.fxmbType = fxmbType;
		this.fxmbName = fxmbName;
		this.froleId = froleId;
		this.fmd5 = fmd5;
		this.fpostXlb = fpostXlb;
		this.fwriteName = fwriteName;
		this.fwriteId = fwriteId;
		this.fwriteMd5 = fwriteMd5;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}


	public String getFno() {
		return this.fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}


	public String getFpostName() {
		return this.fpostName;
	}

	public void setFpostName(String fpostName) {
		this.fpostName = fpostName;
	}


	public String getFpostWriteName() {
		return this.fpostWriteName;
	}

	public void setFpostWriteName(String fpostWriteName) {
		this.fpostWriteName = fpostWriteName;
	}


	public String getFpostWriteId() {
		return this.fpostWriteId;
	}

	public void setFpostWriteId(String fpostWriteId) {
		this.fpostWriteId = fpostWriteId;
	}


	public String getFpostCode() {
		return this.fpostCode;
	}

	public void setFpostCode(String fpostCode) {
		this.fpostCode = fpostCode;
	}


	public String getFpostId() {
		return this.fpostId;
	}

	public void setFpostId(String fpostId) {
		this.fpostId = fpostId;
	}


	public String getFpostState() {
		return this.fpostState;
	}

	public void setFpostState(String fpostState) {
		this.fpostState = fpostState;
	}


	public String getFpostType() {
		return this.fpostType;
	}

	public void setFpostType(String fpostType) {
		this.fpostType = fpostType;
	}


	public String getFmasterId() {
		return this.fmasterId;
	}

	public void setFmasterId(String fmasterId) {
		this.fmasterId = fmasterId;
	}


	public String getFprojectName() {
		return this.fprojectName;
	}

	public void setFprojectName(String fprojectName) {
		this.fprojectName = fprojectName;
	}


	public String getFprojectCode() {
		return this.fprojectCode;
	}

	public void setFprojectCode(String fprojectCode) {
		this.fprojectCode = fprojectCode;
	}


	public String getFroleName() {
		return this.froleName;
	}

	public void setFroleName(String froleName) {
		this.froleName = froleName;
	}


	public String getFxmbType() {
		return this.fxmbType;
	}

	public void setFxmbType(String fxmbType) {
		this.fxmbType = fxmbType;
	}


	public String getFxmbName() {
		return this.fxmbName;
	}

	public void setFxmbName(String fxmbName) {
		this.fxmbName = fxmbName;
	}


	public String getFroleId() {
		return this.froleId;
	}

	public void setFroleId(String froleId) {
		this.froleId = froleId;
	}


	public String getFmd5() {
		return this.fmd5;
	}

	public void setFmd5(String fmd5) {
		this.fmd5 = fmd5;
	}


	public String getFpostXlb() {
		return this.fpostXlb;
	}

	public void setFpostXlb(String fpostXlb) {
		this.fpostXlb = fpostXlb;
	}


	public String getFwriteName() {
		return this.fwriteName;
	}

	public void setFwriteName(String fwriteName) {
		this.fwriteName = fwriteName;
	}


	public String getFwriteId() {
		return this.fwriteId;
	}

	public void setFwriteId(String fwriteId) {
		this.fwriteId = fwriteId;
	}


	public String getFwriteMd5() {
		return this.fwriteMd5;
	}

	public void setFwriteMd5(String fwriteMd5) {
		this.fwriteMd5 = fwriteMd5;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostsetbXm [fid=" + fid + ", fno=" + fno + ", fpostName=" + fpostName + ", fpostWriteName="
				+ fpostWriteName + ", fpostWriteId=" + fpostWriteId + ", fpostCode=" + fpostCode + ", fpostId="
				+ fpostId + ", fpostState=" + fpostState + ", fpostType=" + fpostType + ", fmasterId=" + fmasterId
				+ ", fprojectName=" + fprojectName + ", fprojectCode=" + fprojectCode + ", froleName=" + froleName
				+ ", fxmbType=" + fxmbType + ", fxmbName=" + fxmbName + ", froleId=" + froleId + ", fmd5=" + fmd5
				+ ", fpostXlb=" + fpostXlb + ", fwriteName=" + fwriteName + ", fwriteId=" + fwriteId + ", fwriteMd5="
				+ fwriteMd5 + "]";
	}
	
	
	

}