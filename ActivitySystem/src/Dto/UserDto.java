package Dto;

public class UserDto {
	private String uid;
	private String uname;
	private String password;
	private int deletemark;
	private int sSuper;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDeletemark() {
		return deletemark;
	}
	public void setDeletemark(int deletemark) {
		this.deletemark = deletemark;
	}
	public int getsSuper() {
		return sSuper;
	}
	public void setsSuper(int sSuper) {
		this.sSuper = sSuper;
	}
	public void setAll(String uid,String uname,String password,int sSuper,int deletemark){
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.sSuper = sSuper;
		this.deletemark = deletemark;
		
	}
}
