package manager.mappings;

public class LibUser {
	private int userpersonid ;
	private String uname;
	private String password; 
	private int personid;
	private boolean isactive;
	private String level;
	public int getUserpersonid() {
		return userpersonid;
	}
	public void setUserpersonid(int userpersonid) {
		this.userpersonid=userpersonid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname=uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setPersonid(int personid) {
		this.personid=personid;
	}
	public int getPersonid() {
		return personid;
	}
	public boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive=isactive;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level=level;
	}
}
