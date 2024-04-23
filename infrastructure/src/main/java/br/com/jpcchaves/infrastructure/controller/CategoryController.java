package br.com.jpcchaves.infrastructure.controller;

import br.com.jpcchaves.infrastructure.dto.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.CategoryResponseDTO;
import br.com.jpcchaves.infrastructure.service.category.CategoryService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping
  public ResponseEntity<CategoryResponseDTO> create(@RequestBody CategoryRequestDTO requestDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(requestDTO));
  }

  @GetMapping
  public ResponseEntity<List<CategoryResponseDTO>> list() {
    return ResponseEntity.ok(categoryService.list());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryResponseDTO> getById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(categoryService.getById(id));
  }
}
