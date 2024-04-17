package br.com.jpcchaves.infrastructure.controller;

import br.com.jpcchaves.infrastructure.dto.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoResponseDTO> create(@RequestBody @Valid TodoRequestDTO todo) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.create(todo));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDTO>> list() {
        return ResponseEntity.ok(todoService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> update(@PathVariable(name = "id") Long id,
                                                  @RequestBody @Valid TodoRequestDTO todoEntity) {
        return ResponseEntity.ok(todoService.update(id, todoEntity));
    }
}
