package Ernest.Entity;




/**
 * 项目基础从表
 * @author Ernest
 *
 */
public class BasicDetailGong implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String fid;
	private String fno;
	private String fbasicName;
	private String fbasicType;
	private String fbasicCode;
	private String fbasicState;
	private String fbz;
	private String fmasterId;
	private String fonlyOne;
	private String fgxid;

	// Constructors

	/** default constructor */
	public BasicDetailGong() {
	}

	/** minimal constructor */
	public BasicDetailGong(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public BasicDetailGong(String fid, String fno, String fbasicName, String fbasicType, String fbasicCode,
			String fbasicState, String fbz, String fmasterId, String fonlyOne, String fgxid) {
		this.fid = fid;
		this.fno = fno;
		this.fbasicName = fbasicName;
		this.fbasicType = fbasicType;
		this.fbasicCode = fbasicCode;
		this.fbasicState = fbasicState;
		this.fbz = fbz;
		this.fmasterId = fmasterId;
		this.fonlyOne = fonlyOne;
		this.fgxid = fgxid;
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


	public String getFbasicName() {
		return this.fbasicName;
	}

	public void setFbasicName(String fbasicName) {
		this.fbasicName = fbasicName;
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


	public String getFmasterId() {
		return this.fmasterId;
	}

	public void setFmasterId(String fmasterId) {
		this.fmasterId = fmasterId;
	}


	public String getFonlyOne() {
		return this.fonlyOne;
	}

	public void setFonlyOne(String fonlyOne) {
		this.fonlyOne = fonlyOne;
	}


	public String getFgxid() {
		return this.fgxid;
	}

	public void setFgxid(String fgxid) {
		this.fgxid = fgxid;
	}

	@Override
	public String toString() {
		return "BasicDetailGong [fid=" + fid + ", fno=" + fno + ", fbasicName=" + fbasicName + ", fbasicType="
				+ fbasicType + ", fbasicCode=" + fbasicCode + ", fbasicState=" + fbasicState + ", fbz=" + fbz
				+ ", fmasterId=" + fmasterId + ", fonlyOne=" + fonlyOne + ", fgxid=" + fgxid + "]";
	}

	
	
}