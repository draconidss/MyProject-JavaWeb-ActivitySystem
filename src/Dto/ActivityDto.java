package Dto;

public class ActivityDto {
	private String aid;
	private String aname;
	private String level;
	private String place;
	private String duration;
	private String pname;
	private String email;
	private String inf;
	private String con;
	private String deletemark;

	


	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}


	public String getAname() {
		return aname;
	}


	public void setAname(String aname) {
		this.aname = aname;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getInf() {
		return inf;
	}


	public void setInf(String inf) {
		this.inf = inf;
	}

	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getDeletemark() {
		return deletemark;
	}


	public void setDeletemark(String deletemark) {
		this.deletemark = deletemark;
	}
	
	public void setAll(String aid, String aname, String level, String place,String duration, String pname,String email,String inf,String con,String deletemark) {
		this.aid = aid;
		this.aname = aname;
		this.level = level;
		this.place = place;
		this.duration = duration;
		this.pname = pname;
		this.email = email;
		this.inf = inf;
		this.con = con;
		this.deletemark = deletemark;
	}

}
