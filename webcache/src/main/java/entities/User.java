package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User extends AbstractEntity{

	public User(){
		
	}
	@Column(name="Name")
	private String name;
	
	@Column(name="Phone")
	private String phone; 
	
	@Column(name="Company")
	private String company;
	
	@Column(name="IBAN")
	private String iban;
	
	public User(String name, String phone, String company, String iban) {
		super();
		this.name = name;
		this.phone = phone;
		this.company = company;
		this.iban = iban;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phone=" + phone + ", company=" + company + ", iban=" + iban + "]";
	}
}
