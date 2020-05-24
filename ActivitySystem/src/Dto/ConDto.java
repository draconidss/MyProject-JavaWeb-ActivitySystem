package Dto;

public class ConDto {
	private String aid;
	private String aname;
	private String name;
	private String level;
	private String con;
	private String nreason;
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

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public String getNreason() {
		return nreason;
	}

	public void setNreason(String nreason) {
		this.nreason = nreason;
	}

	public String getDeletemark() {
		return deletemark;
	}

	public void setDeletemark(String deletemark) {
		this.deletemark = deletemark;
	}

	public void setAll(String aid, String aname,  String name,String level, String con, String nreason, String deletemark) {
		this.aid = aid;
		this.aname = aname;
		this.name = name;
		this.level = level;
		this.con = con;
		this.nreason = nreason;
		this.deletemark = deletemark;
	}

}