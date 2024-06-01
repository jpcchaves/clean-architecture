package br.com.jpcchaves.infrastructure.controller;

import br.com.jpcchaves.infrastructure.dto.category.CategoryRequestDTO;
import br.com.jpcchaves.infrastructure.dto.category.CategoryResponseDTO;
import br.com.jpcchaves.infrastructure.service.category.CategoryService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public ResponseEntity<CategoryResponseDTO> create(
      @RequestBody @Valid CategoryRequestDTO requestDTO) {
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

  @PutMapping("/{id}")
  public ResponseEntity<CategoryResponseDTO> update(
      @PathVariable(name = "id") Long id, @RequestBody CategoryRequestDTO requestDTO) {
    return ResponseEntity.ok(categoryService.update(id, requestDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
    categoryService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
