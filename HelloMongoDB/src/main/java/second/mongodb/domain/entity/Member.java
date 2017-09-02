package second.mongodb.domain.entity;

public class Member {

	private String id;
	private String name;
	private int age;
	
	private String [] favorites;
	private Address address;
	
	// 생성자 함수
	public Member(){}
	public Member( String name, int age){

		this.name = name;
		this.age = age;
	}
	
	public Member( String id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Member( String id, String name, int age, String[] favorites){
		this.id = id;
		this.name = name;
		this.age = age;
		this.favorites = favorites;
	}
	
	public Member( String id, String name, int age, String[] favorites, Address address){
		this.id = id;
		this.name = name;
		this.age = age;
		this.favorites = favorites;
		this.address = address;
	}


	// setters and getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getFavorites() {
		return favorites;
	}

	public void setFavorites(String[] favorites) {
		this.favorites = favorites;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
