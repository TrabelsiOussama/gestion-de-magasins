package esprit.projet.client;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
	private static final long serialVersionUID = 6711457437559348053L;
@Id
@GeneratedValue
private Integer id;
private String name;

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
public Client(Integer id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
}
public Client(Integer id) {
	super();
	this.id = id;
}
public Client(String name) {
	super();
	this.name = name;
}


}
