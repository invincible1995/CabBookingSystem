package cabbookingsystem.entity;

public abstract class User {
	
	private Long id = null;
	private String name = null;
	private String mobile_no = null;
 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User(String name, String mobile_no , Long id) {
		super();
		this.id = id;
		this.name = name;
		this.mobile_no = mobile_no;
	}

	public User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	
	
	 @Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobile_no=" + mobile_no + "]";
	}

	public abstract boolean ckeckNull();

	
	
	
		
	
	
	
}
