package esprit.projet.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
	private static final long serialVersionUID = 6711457437559348053L;
@Id
@GeneratedValue
private Integer id;
private String name;
private String description;
private Integer price;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public Product(Integer id, String name, String description, Integer price) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
}
public Product(String name) {
	super();
	this.name = name;
}
public Product(Integer id) {
	super();
	this.id = id;
}
public Product() {
	super();
}



}
