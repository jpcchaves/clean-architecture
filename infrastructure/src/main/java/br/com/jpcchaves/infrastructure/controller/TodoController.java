package br.com.jpcchaves.infrastructure.controller;

import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.infrastructure.controller.resources.ITodoResource;
import br.com.jpcchaves.infrastructure.dto.todo.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.todo.TodoResponseDTO;
import br.com.jpcchaves.infrastructure.dto.todo.UpdateTodoStatusDTO;
import br.com.jpcchaves.infrastructure.service.todo.TodoService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController implements ITodoResource {
  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @PostMapping
  @Override
  public ResponseEntity<TodoResponseDTO> create(@RequestBody @Valid TodoRequestDTO request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(request));
  }

  @GetMapping
  @Override
  public ResponseEntity<PaginatedResponse<TodoResponseDTO>> list(
      PaginationRequest paginationRequest) {
    return ResponseEntity.ok(todoService.list(paginationRequest));
  }

  @GetMapping("/{id}")
  @Override
  public ResponseEntity<TodoResponseDTO> getById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(todoService.getById(id));
  }

  @PutMapping("/{id}")
  @Override
  public ResponseEntity<TodoResponseDTO> update(
      @PathVariable(name = "id") Long id, @RequestBody @Valid TodoRequestDTO todoEntity) {
    return ResponseEntity.ok(todoService.update(id, todoEntity));
  }

  @Override
  public ResponseEntity<Void> deleteById(Long id) {
    todoService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<?> updateStatus(
      @PathVariable(name = "id") Long id, @RequestBody @Valid UpdateTodoStatusDTO requestDTO) {
    todoService.updateStatus(id, requestDTO.getStatus());
    return ResponseEntity.ok(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/by-category")
  public ResponseEntity<List<TodoResponseDTO>> listByCategory(
      @PathParam("category") Long categoryId) {
    return ResponseEntity.ok(todoService.listByCategory(categoryId));
  }
}
