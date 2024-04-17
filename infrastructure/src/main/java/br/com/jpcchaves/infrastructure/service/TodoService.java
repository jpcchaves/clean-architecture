package br.com.jpcchaves.infrastructure.service;

import br.com.jpcchaves.infrastructure.dto.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.TodoResponseDTO;

import java.util.List;

public interface TodoService {
    TodoResponseDTO create(TodoRequestDTO request);

    List<TodoResponseDTO> list();

    TodoResponseDTO getById(Long id);

    void delete(Long id);

    TodoResponseDTO update(Long id,
                           TodoRequestDTO request);
}
