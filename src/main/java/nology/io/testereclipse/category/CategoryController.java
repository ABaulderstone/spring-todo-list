package nology.io.testereclipse.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import nology.io.testereclipse.category.dto.CreateCategoryDTO;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		List<Category> allCategories = this.categoryService.getAll();
		return new ResponseEntity<>(allCategories, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Category> createCategory(@Valid @RequestBody CreateCategoryDTO data) {
		Category created = this.categoryService.create(data);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
}
