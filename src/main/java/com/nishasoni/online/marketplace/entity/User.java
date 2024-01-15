package com.nishasoni.online.marketplace.entity;


import java.util.Objects;


import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User{

@Basic
@Column(name="email", nullable = false , length = 50)
private String email;

@Basic
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Column(name="entry_date", nullable = true)
private Date entryDate;

@Basic
@Column(name="first_name", nullable = false , length = 45)
private String firstName;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="last_name", nullable = false , length = 45)
private String lastName;

@Basic
@Column(name="password", nullable = false , length = 20)
private String password;

@Basic
@Column(name="role", nullable = false , length = 10)
private String role;

@Basic
@Column(name="status", nullable = false )
private Integer status;

public String getEmail() { 
	return email; 
} 

public void setEmail(String email) {
	this.email = email;
}
public Date getEntryDate() { 
	return entryDate; 
} 

public void setEntryDate(Date entryDate) {
	this.entryDate = entryDate;
}
public String getFirstName() { 
	return firstName; 
} 

public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public Integer getId() { 
	return id; 
} 

public void setId(Integer id) {
	this.id = id;
}
public String getLastName() { 
	return lastName; 
} 

public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPassword() { 
	return password; 
} 

public void setPassword(String password) {
	this.password = password;
}
public String getRole() { 
	return role; 
} 

public void setRole(String role) {
	this.role = role;
}
public Integer getStatus() { 
	return status; 
} 

public void setStatus(Integer status) {
	this.status = status;
}
  @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
        User other = (User) obj;
         return   Objects.equals(email, other.email)   &&   Objects.equals(entryDate, other.entryDate)   &&   Objects.equals(firstName, other.firstName)   &&   Objects.equals(id, other.id)   &&   Objects.equals(lastName, other.lastName)   &&   Objects.equals(password, other.password)   &&   Objects.equals(role, other.role)   &&   Objects.equals(status, other.status)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(email, entryDate, firstName, id, lastName, password, role, status);
     }
public User() { 
super();
 }
public User(String email, Date entryDate, String firstName, String lastName, String password, String role, Integer status ){
 super();
 this.email = email; 
this.entryDate = entryDate; 
this.firstName = firstName; 
this.lastName = lastName; 
this.password = password; 
this.role = role; 
this.status = status; 
}
@Override 
public String toString() {
return "User [email=" + email + ", entryDate=" + entryDate + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", password=" + password + ", role=" + role + ", status=" + status + "]" ; 
 } 
}
