package kr.co.domain;

import java.util.Date;

public class FMemberVO {

	private String memId;
	private String memPw;
	private String memName;
	private String memMail;
	private String memAd1;
	private String memAd2;
	private String memAd3;
	private int adminCK;
	private Date regDate;
	private Date updatedate;
	private int money;
	private int point;
	
	private int verify;
	
	public FMemberVO() {
		// TODO Auto-generated constructor stub
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemAd1() {
		return memAd1;
	}

	public void setMemAd1(String memAd1) {
		this.memAd1 = memAd1;
	}

	public String getMemAd2() {
		return memAd2;
	}

	public void setMemAd2(String memAd2) {
		this.memAd2 = memAd2;
	}

	public String getMemAd3() {
		return memAd3;
	}

	public void setMemAd3(String memAd3) {
		this.memAd3 = memAd3;
	}

	public int getAdminCK() {
		return adminCK;
	}

	public void setAdminCK(int adminCK) {
		this.adminCK = adminCK;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public FMemberVO(String memId, String memPw, String memName, String memMail, String memAd1, String memAd2,
			String memAd3, int adminCK, int money, int point) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memMail = memMail;
		this.memAd1 = memAd1;
		this.memAd2 = memAd2;
		this.memAd3 = memAd3;
		this.adminCK = adminCK;
		this.money = money;
		this.point = point;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + ((memName == null) ? 0 : memName.hashCode());
		result = prime * result + ((memPw == null) ? 0 : memPw.hashCode());
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
		FMemberVO other = (FMemberVO) obj;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (memName == null) {
			if (other.memName != null)
				return false;
		} else if (!memName.equals(other.memName))
			return false;
		if (memPw == null) {
			if (other.memPw != null)
				return false;
		} else if (!memPw.equals(other.memPw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "F_MemberVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + "]";
	}

	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	
	
}
