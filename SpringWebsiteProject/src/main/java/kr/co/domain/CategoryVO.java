package kr.co.domain;

public class CategoryVO {
	
	/*
			cateName VARCHAR2(20) not null,
			cateCode VARCHAR2(30) not null,
			cateCodeRef VARCHAR2(30) null,
			primary key(cateCode),
			foreign key(cateCodeRef) references goods_category(cateCode)
			*/
			
	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private int level;
	
	public CategoryVO() {
		// TODO Auto-generated constructor stub
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateCodeRef() {
		return cateCodeRef;
	}

	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	

}
