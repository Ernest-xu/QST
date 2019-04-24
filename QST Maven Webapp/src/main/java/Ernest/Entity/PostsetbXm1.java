package Ernest.Entity;




public class PostsetbXm1 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private String fid;//
	private String fno;//
	private String fpostName;//
	private String fmasterId;//
	private String fprojectName;//
	private String fprojectId;//
	private String fprojectCode;//
	private String fpostXlb;//
	private String fpostType;//
	
	private String fmd5;
	private String fpostCode;
	private String fpostId;
	private String fpostWriteName;
	private String fpostWriteId;
	private String fpostState;
	private String froleName;
	private String froleId;
	// Constructors

	/** default constructor */
	public PostsetbXm1() {
	}

	/** minimal constructor */
	public PostsetbXm1(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public PostsetbXm1(String fid, String fpostXlb, String fno, String fpostType,
			String fmd5, String fpostCode, String fpostName, String fpostId, String fpostWriteName, String fpostWriteId,
			String fpostState, String fmasterId, String fprojectName, String fprojectId, String fprojectCode,
			String froleName, String froleId) {
		this.fid = fid;
		this.fpostXlb = fpostXlb;
		this.fno = fno;
		this.fpostType = fpostType;
		this.fmd5 = fmd5;
		this.fpostCode = fpostCode;
		this.fpostName = fpostName;
		this.fpostId = fpostId;
		this.fpostWriteName = fpostWriteName;
		this.fpostWriteId = fpostWriteId;
		this.fpostState = fpostState;
		this.fmasterId = fmasterId;
		this.fprojectName = fprojectName;
		this.fprojectId = fprojectId;
		this.fprojectCode = fprojectCode;
		this.froleName = froleName;
		this.froleId = froleId;
	}

	// Property accessors


	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}


	public String getFpostXlb() {
		return this.fpostXlb;
	}

	public void setFpostXlb(String fpostXlb) {
		this.fpostXlb = fpostXlb;
	}


	public String getFno() {
		return this.fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}


	public String getFpostType() {
		return this.fpostType;
	}

	public void setFpostType(String fpostType) {
		this.fpostType = fpostType;
	}


	public String getFmd5() {
		return this.fmd5;
	}

	public void setFmd5(String fmd5) {
		this.fmd5 = fmd5;
	}


	public String getFpostCode() {
		return this.fpostCode;
	}

	public void setFpostCode(String fpostCode) {
		this.fpostCode = fpostCode;
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


	public String getFpostState() {
		return this.fpostState;
	}

	public void setFpostState(String fpostState) {
		this.fpostState = fpostState;
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


	public String getFprojectId() {
		return this.fprojectId;
	}

	public void setFprojectId(String fprojectId) {
		this.fprojectId = fprojectId;
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


	public String getFroleId() {
		return this.froleId;
	}

	public void setFroleId(String froleId) {
		this.froleId = froleId;
	}

	@Override
	public String toString() {
		return "PostsetbXm1 [fid=" + fid + ", fno=" + fno + ", fpostName=" + fpostName + ", fmasterId=" + fmasterId
				+ ", fprojectName=" + fprojectName + ", fprojectId=" + fprojectId + ", fprojectCode=" + fprojectCode
				+ ", fpostXlb=" + fpostXlb + ", fpostType=" + fpostType + ", fmd5=" + fmd5 + ", fpostCode=" + fpostCode
				+ ", fpostId=" + fpostId + ", fpostWriteName=" + fpostWriteName + ", fpostWriteId=" + fpostWriteId
				+ ", fpostState=" + fpostState + ", froleName=" + froleName + ", froleId=" + froleId + "]";
	}

	
	
}