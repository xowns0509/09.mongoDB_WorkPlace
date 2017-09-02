package second.mongodb.domain.entity;

public class Address {
	private String name;
	private String city;
	private String zip;
	
	// 생성자 함수
	public Address(){}
	
	public Address( String name, String city, String zip){
		this.name = name;
		this.city = city;
		this.zip = zip;
	}

	// setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
