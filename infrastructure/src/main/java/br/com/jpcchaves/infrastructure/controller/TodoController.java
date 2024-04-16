package br.com.jpcchaves.infrastructure.controller;

import br.com.jpcchaves.core.domain.Todo;
import br.com.jpcchaves.infrastructure.persistence.entity.TodoEntity;
import br.com.jpcchaves.infrastructure.service.TodoService;
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
    public ResponseEntity<TodoEntity> create(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.create(todo));
    }

    @GetMapping
    public ResponseEntity<List<TodoEntity>> list() {
        return ResponseEntity.ok(todoService.list());
    }
}
