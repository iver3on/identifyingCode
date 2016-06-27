package bean;

public class user {
	private int id;
	private String username;
	private String psd;
	private String age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public user(int id, String username, String psd, String age) {
		super();
		this.id = id;
		this.username = username;
		this.psd = psd;
		this.age = age;
	}

	public user(String username, String psd, String age) {
		super();
		this.username = username;
		this.psd = psd;
		this.age = age;
	}

}
