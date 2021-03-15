package kr.co.domain;

import java.sql.Date;

public class GoodsViewVO {
	
	private int fNum;
	private String fName;
	private String fCode;
	private int fPrice;
	private int fStock;
	private String fDes;
	private String fImg;
	private Date fDate;
	
	private String fCodeRef;
	private String fcName;
	
	public GoodsViewVO() {
		// TODO Auto-generated constructor stub
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

	public String getfCodeRef() {
		return fCodeRef;
	}

	public void setfCodeRef(String fCodeRef) {
		this.fCodeRef = fCodeRef;
	}

	public String getFcName() {
		return fcName;
	}

	public void setFcName(String fcName) {
		this.fcName = fcName;
	}
	
	

}
