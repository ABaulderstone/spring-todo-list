package nology.io.testereclipse.category.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateCategoryDTO {
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
