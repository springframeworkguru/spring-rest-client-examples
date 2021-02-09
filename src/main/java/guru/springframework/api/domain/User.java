package guru.springframework.api.domain;

public class User {
	private String nat;
	private String gender;
	private String phone;
	private Dob dob;
	private Name name;
	private Registered registered;
	private Location location;
	private Id id;
	private Login login;
	private String cell;
	private String email;
	private Picture picture;

	public void setNat(String nat){
		this.nat = nat;
	}

	public String getNat(){
		return nat;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setDob(Dob dob){
		this.dob = dob;
	}

	public Dob getDob(){
		return dob;
	}

	public void setName(Name name){
		this.name = name;
	}

	public Name getName(){
		return name;
	}

	public void setRegistered(Registered registered){
		this.registered = registered;
	}

	public Registered getRegistered(){
		return registered;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(Id id){
		this.id = id;
	}

	public Id getId(){
		return id;
	}

	public void setLogin(Login login){
		this.login = login;
	}

	public Login getLogin(){
		return login;
	}

	public void setCell(String cell){
		this.cell = cell;
	}

	public String getCell(){
		return cell;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPicture(Picture picture){
		this.picture = picture;
	}

	public Picture getPicture(){
		return picture;
	}
}
