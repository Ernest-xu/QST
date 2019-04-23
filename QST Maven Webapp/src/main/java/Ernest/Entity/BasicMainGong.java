package Ernest.Entity;


/**
 * 项目基础主表实体类
 * @author Ernest
 *
 */
public class BasicMainGong implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fid;
	private String fno;
	private String fbasicType;
	private String fbasicCode;
	private String fbasicState;
	private String fbz;
	private String fprojectId;
	private String fgxfId;
	private String fmasterId;
	private String fprojectName;
	private String fprojectCode;

	// Constructors

	/** default constructor */
	public BasicMainGong() {
	}

	/** minimal constructor */
	public BasicMainGong(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public BasicMainGong(String fid, String fno, String fbasicType, String fbasicCode, String fbasicState,
			String fbz, String fprojectId, String fgxfId, String fmasterId, String fprojectName, String fprojectCode) {
		this.fid = fid;
		this.fno = fno;
		this.fbasicType = fbasicType;
		this.fbasicCode = fbasicCode;
		this.fbasicState = fbasicState;
		this.fbz = fbz;
		this.fprojectId = fprojectId;
		this.fgxfId = fgxfId;
		this.fmasterId = fmasterId;
		this.fprojectName = fprojectName;
		this.fprojectCode = fprojectCode;
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


	public String getFbasicType() {
		return this.fbasicType;
	}

	public void setFbasicType(String fbasicType) {
		this.fbasicType = fbasicType;
	}


	public String getFbasicCode() {
		return this.fbasicCode;
	}

	public void setFbasicCode(String fbasicCode) {
		this.fbasicCode = fbasicCode;
	}


	public String getFbasicState() {
		return this.fbasicState;
	}

	public void setFbasicState(String fbasicState) {
		this.fbasicState = fbasicState;
	}


	public String getFbz() {
		return this.fbz;
	}

	public void setFbz(String fbz) {
		this.fbz = fbz;
	}


	public String getFprojectId() {
		return this.fprojectId;
	}

	public void setFprojectId(String fprojectId) {
		this.fprojectId = fprojectId;
	}


	public String getFgxfId() {
		return this.fgxfId;
	}

	public void setFgxfId(String fgxfId) {
		this.fgxfId = fgxfId;
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

	@Override
	public String toString() {
		return "BasicMainGong [fid=" + fid + ", fno=" + fno + ", fbasicType=" + fbasicType + ", fbasicCode="
				+ fbasicCode + ", fbasicState=" + fbasicState + ", fbz=" + fbz + ", fprojectId=" + fprojectId
				+ ", fgxfId=" + fgxfId + ", fmasterId=" + fmasterId + ", fprojectName=" + fprojectName
				+ ", fprojectCode=" + fprojectCode + "]";
	}

	
	
	
}