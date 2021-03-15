package kr.co.domain;

public class CategoryVO {
	
	private String fcName;
	private String fcCode;
	private String fcCodeRef;
	private int level;
	
	public CategoryVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public CategoryVO(String fName, String fCode, String fCodeRef) {
		super();
		this.fcName = fName;
		this.fcCode = fCode;
		this.fcCodeRef = fCodeRef;
	}

	public String getfName() {
		return fcName;
	}

	public void setfName(String fName) {
		this.fcName = fName;
	}

	public String getfCode() {
		return fcCode;
	}

	public void setfCode(String fCode) {
		this.fcCode = fCode;
	}

	public String getfCodeRef() {
		return fcCodeRef;
	}

	public void setfCodeRef(String fCodeRef) {
		this.fcCodeRef = fCodeRef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fcCode == null) ? 0 : fcCode.hashCode());
		result = prime * result + ((fcCodeRef == null) ? 0 : fcCodeRef.hashCode());
		result = prime * result + ((fcName == null) ? 0 : fcName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryVO other = (CategoryVO) obj;
		if (fcCode == null) {
			if (other.fcCode != null)
				return false;
		} else if (!fcCode.equals(other.fcCode))
			return false;
		if (fcCodeRef == null) {
			if (other.fcCodeRef != null)
				return false;
		} else if (!fcCodeRef.equals(other.fcCodeRef))
			return false;
		if (fcName == null) {
			if (other.fcName != null)
				return false;
		} else if (!fcName.equals(other.fcName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryVO [fName=" + fcName + ", fCode=" + fcCode + ", fCodeRef=" + fcCodeRef + "]";
	}
	
	

}
