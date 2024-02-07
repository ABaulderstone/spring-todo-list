package nology.io.testereclipse.todo;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import nology.io.testereclipse.category.Category;
import nology.io.testereclipse.category.CategoryService;
import nology.io.testereclipse.common.exceptions.ServiceValidationException;
import nology.io.testereclipse.common.exceptions.ValidationError;
import nology.io.testereclipse.todo.dto.CreateTodoDTO;
import nology.io.testereclipse.todo.dto.UpdateTodoDTO;

@Service
@Transactional
public class TodoService {

	@Autowired
	private TodoRepository todoRepo;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ModelMapper modelMapper;

	public List<Todo> getAll() {
		return this.todoRepo.findAll();
	}

	public Todo createTodo(CreateTodoDTO data) throws ServiceValidationException {
		ValidationError errors = new ValidationError();
		Long categoryId = data.getCategoryId();
		Todo newTodo = modelMapper.map(data, Todo.class);
		Optional<Category> maybeCategory = this.categoryService.findById(categoryId);

		if (maybeCategory.isEmpty()) {
			errors.addError("category", "Could not find category with id " + categoryId);
		} else {
			newTodo.setCategory(maybeCategory.get());
		}

		if (!errors.isEmpty()) {
			throw new ServiceValidationException(errors);
		}

		return this.todoRepo.save(newTodo);
	}

	public Optional<Todo> findById(Long id) {
		return this.todoRepo.findById(id);
	}

	public Optional<Todo> updateById(Long id, UpdateTodoDTO data) {
		Optional<Todo> maybeFound = this.findById(id);
		if (maybeFound.isEmpty()) {
			return maybeFound;
		}
		Todo toUpdate = maybeFound.get();
		modelMapper.map(data, toUpdate);
		Todo updated = this.todoRepo.save(toUpdate);
		return Optional.of(updated);
	}

}
