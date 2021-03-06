package fr.kevin.lambda.entity;

import java.io.Serializable;

/**
 * @author anonymous
 *
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4030894698307391929L;
	private String lastname;
	private Integer age;
	private String firstname;

	public User() {

	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param age
	 */
	public User(String firstname, String lastname, Integer age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
