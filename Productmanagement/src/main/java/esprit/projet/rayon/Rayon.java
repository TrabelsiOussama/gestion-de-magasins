package esprit.projet.rayon;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rayons")
public class Rayon implements Serializable {
	private static final long serialVersionUID = 6711457437559348053L;
@Id
@GeneratedValue
private Integer id;
private String type;
private Integer capacite;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Integer getCapacite() {
	return capacite;
}
public void setCapacite(Integer capacite) {
	this.capacite = capacite;
}
@Override
public String toString() {
	return "Rayon [id=" + id + ", type=" + type + ", capacite=" + capacite + "]";
}
public Rayon(Integer id, String type, Integer capacite) {
	super();
	this.id = id;
	this.type = type;
	this.capacite = capacite;
}

public Rayon(Integer id) {
	super();
	this.id = id;
}
public Rayon(String type) {
	super();
	this.type = type;
}
public Rayon() {
	super();
}


}
