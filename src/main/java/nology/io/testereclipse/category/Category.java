package nology.io.testereclipse.category;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import nology.io.testereclipse.common.BaseEntity;
import nology.io.testereclipse.todo.Todo;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

	@Column
	private String name;

	@OneToMany(mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<Todo> todos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category() {

	}

	public List<Todo> getTodos() {
		return todos;
	}

}
