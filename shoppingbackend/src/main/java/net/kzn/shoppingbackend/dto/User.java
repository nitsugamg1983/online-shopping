package net.kzn.shoppingbackend.dto;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="USER_DETAIL")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4659703039571229430L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="FIRST_NAME")
	@NotBlank(message="Please enter first name")
	private String firstName;
	
	@Column(name="LAST_NAME")
	@NotBlank(message="Please enter last name")
	private String lastName;
	
	private String role;
	private boolean enabled = true;
	
	@NotBlank(message="Please enter password")
	private String password;
	
	@NotBlank(message="Please enter email")
	private String email;
	
	@Column(name="CONTACT_NUMBER")
	@NotBlank(message="Please enter contact number")
	private String contactNumber;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private List<Address> addresses;
	
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Cart cart;
	
	
	//confirm password transient field
	@Transient
	private String confirmPassword;
	
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", enabled=" + enabled + ", password=" + password + ", email=" + email + ", contactNumber="
				+ contactNumber + "]";
	}

	
}
