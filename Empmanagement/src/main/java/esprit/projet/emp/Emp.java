package esprit.projet.emp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employes")
public class Emp implements Serializable {
	private static final long serialVersionUID = 6711457437559348053L;
@Id
@GeneratedValue
private Integer id;
private String name;
private Integer cin;
private Integer num;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getCin() {
	return cin;
}
public void setCin(Integer cin) {
	this.cin = cin;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}
@Override
public String toString() {
	return "Emp [id=" + id + ", name=" + name + ", cin=" + cin + ", num=" + num + "]";
}
public Emp(Integer id, String name, Integer cin, Integer num) {
	super();
	this.id = id;
	this.name = name;
	this.cin = cin;
	this.num = num;
}
public Emp() {
	super();
}
public Emp(Integer id) {
	super();
	this.id = id;
}
public Emp(String name) {
	super();
	this.name = name;
}



}
