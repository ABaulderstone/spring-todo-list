package nology.io.testereclipse.todo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class UpdateTodoDTO {
	@Pattern(regexp = "^(?=\\S).*$", message = "Title cannot be empty")
	private String title;

	@Pattern(regexp = "^(?=\\S).*$", message = "Title cannot be empty")
	private String description;

	@Min(1)
	private Long categoryId;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
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

}
