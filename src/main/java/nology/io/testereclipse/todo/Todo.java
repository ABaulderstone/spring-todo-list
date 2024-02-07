package nology.io.testereclipse.todo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import nology.io.testereclipse.category.Category;
import nology.io.testereclipse.common.BaseEntity;

@Entity
@Table(name = "todos")
public class Todo extends BaseEntity {

	@Column
	String title;

	@Column
	String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	public Todo(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Todo() {
	}

	public String getTitle() {
		return title;
	}

	public Category getCategory() {
		return category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Todo [title=" + title + ", description=" + description + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
