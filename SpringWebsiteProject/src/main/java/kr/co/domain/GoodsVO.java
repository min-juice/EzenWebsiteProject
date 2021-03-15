package kr.co.domain;

import java.sql.Date;

public class GoodsVO {
	private int fNum;
	private String fName;
	private String fCode;
	private int fPrice;
	private int fStock;
	private String fDes;
	private String fImg;
	private Date fDate;
	
	
	
	public GoodsVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GoodsVO(int fNum, String fName, String fCode, int fPrice, int fStock, String fDes, String fImg, Date fDate) {
		super();
		this.fNum = fNum;
		this.fName = fName;
		this.fCode = fCode;
		this.fPrice = fPrice;
		this.fStock = fStock;
		this.fDes = fDes;
		this.fImg = fImg;
		this.fDate = fDate;
	}

	public int getfNum() {
		return fNum;
	}

	public void setfNum(int fNum) {
		this.fNum = fNum;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public int getfPrice() {
		return fPrice;
	}

	public void setfPrice(int fPrice) {
		this.fPrice = fPrice;
	}

	public int getfStock() {
		return fStock;
	}

	public void setfStock(int fStock) {
		this.fStock = fStock;
	}

	public String getfDes() {
		return fDes;
	}

	public void setfDes(String fDes) {
		this.fDes = fDes;
	}

	public String getfImg() {
		return fImg;
	}

	public void setfImg(String fImg) {
		this.fImg = fImg;
	}

	public Date getfDate() {
		return fDate;
	}

	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fCode == null) ? 0 : fCode.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + fNum;
		result = prime * result + fPrice;
		result = prime * result + fStock;
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
		GoodsVO other = (GoodsVO) obj;
		if (fCode == null) {
			if (other.fCode != null)
				return false;
		} else if (!fCode.equals(other.fCode))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (fNum != other.fNum)
			return false;
		if (fPrice != other.fPrice)
			return false;
		if (fStock != other.fStock)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsVO [fNum=" + fNum + ", fName=" + fName + ", fCode=" + fCode + "]";
	}
	
	
}
