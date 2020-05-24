package Dto;

public class ExaminerDto {
	private String eid;
	private String ename;
	private String name;
	private String level;
	private String phonenumber;
	private String deletemark;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDeletemark() {
		return deletemark;
	}

	public void setDeletemark(String deletemark) {
		this.deletemark = deletemark;
	}

	public void setAll(String eid, String ename, String name,String level,String phonenumber, String deletemark) {
		this.eid = eid;
		this.ename = ename;
		this.name = name;
		this.level = level;
		this.phonenumber = phonenumber;
		this.deletemark = deletemark;
	}

}
