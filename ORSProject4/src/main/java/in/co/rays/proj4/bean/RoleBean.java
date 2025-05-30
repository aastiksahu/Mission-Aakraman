package in.co.rays.proj4.bean;

public class RoleBean extends BaseBean{
	
	public static final int ADMIN = 11111;
	public static final int FACULTY = 22222;
	public static final int STUDENT = 33333;
	public static final int KIOSK = 44444;
	public static final int COLLEGE = 55555;
	
	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return name;
	}

}
