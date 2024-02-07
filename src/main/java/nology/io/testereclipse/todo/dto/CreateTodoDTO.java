package nology.io.testereclipse.todo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTodoDTO {

	@NotBlank(message = "Title cannot be blank")
	private String title;

	@NotBlank(message = "Description cannot be blank")
	private String description;

	@Min(1)
	@NotNull
	private Long categoryId;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public CreateTodoDTO(@NotBlank(message = "Title cannot be blank") String title,
			@NotBlank(message = "Description cannot be blank") String description) {
		super();
		this.title = title;
		this.description = description;
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
