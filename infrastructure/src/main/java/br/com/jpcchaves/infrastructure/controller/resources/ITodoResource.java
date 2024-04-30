package br.com.jpcchaves.infrastructure.controller.resources;

import br.com.jpcchaves.application.resources.CreateResource;
import br.com.jpcchaves.application.resources.DeleteResource;
import br.com.jpcchaves.application.resources.GetByIdResource;
import br.com.jpcchaves.application.resources.ListResourcePaginated;
import br.com.jpcchaves.application.resources.UpdateResource;
import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.infrastructure.dto.todo.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.todo.TodoResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ITodoResource
    extends CreateResource<TodoRequestDTO, ResponseEntity<TodoResponseDTO>>,
        ListResourcePaginated<
            PaginationRequest, ResponseEntity<PaginatedResponse<TodoResponseDTO>>>,
        GetByIdResource<Long, ResponseEntity<TodoResponseDTO>>,
        UpdateResource<Long, TodoRequestDTO, ResponseEntity<TodoResponseDTO>>,
        DeleteResource<Long, ResponseEntity<Void>> {}
