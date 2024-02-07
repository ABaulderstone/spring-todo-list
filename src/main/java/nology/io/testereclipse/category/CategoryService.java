package nology.io.testereclipse.category;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import nology.io.testereclipse.category.dto.CreateCategoryDTO;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<Category> getAll() {
		return this.categoryRepository.findAll();
	}

	public Category create(CreateCategoryDTO data) {
		Category created = modelMapper.map(data, Category.class);
		return this.categoryRepository.save(created);
	}

	public Optional<Category> findById(Long categoryId) {
		return this.categoryRepository.findById(categoryId);
	}

}
