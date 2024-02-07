package nology.io.testereclipse.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import nology.io.testereclipse.common.exceptions.NotFoundException;
import nology.io.testereclipse.common.exceptions.ServiceValidationException;
import nology.io.testereclipse.todo.dto.CreateTodoDTO;
import nology.io.testereclipse.todo.dto.UpdateTodoDTO;

@RestController
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping
	public ResponseEntity<List<Todo>> getAll() {
		List<Todo> todos = this.todoService.getAll();
		return new ResponseEntity<>(todos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Todo> createTodo(@Valid @RequestBody CreateTodoDTO data) throws ServiceValidationException {
		Todo newTodo = this.todoService.createTodo(data);
		return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Todo> getById(@PathVariable Long id) throws NotFoundException {
		Optional<Todo> maybeFound = this.todoService.findById(id);
		Todo found = maybeFound.orElseThrow(() -> new NotFoundException(Todo.class, id));
		return new ResponseEntity<>(found, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Todo> updateById(@PathVariable Long id, @Valid @RequestBody UpdateTodoDTO data)
			throws NotFoundException {
		Optional<Todo> maybeUpdated = this.todoService.updateById(id, data);
		Todo updated = maybeUpdated.orElseThrow(() -> new NotFoundException(Todo.class, id));
		return new ResponseEntity<>(updated, HttpStatus.OK);

	}

}
