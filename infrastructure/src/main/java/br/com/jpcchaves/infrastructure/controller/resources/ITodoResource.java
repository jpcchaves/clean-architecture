package br.com.jpcchaves.infrastructure.controller.resources;

import br.com.jpcchaves.core.domain.PaginatedResponse;
import br.com.jpcchaves.core.domain.PaginationRequest;
import br.com.jpcchaves.infrastructure.controller.resources.base.CreateResource;
import br.com.jpcchaves.infrastructure.controller.resources.base.DeleteResource;
import br.com.jpcchaves.infrastructure.controller.resources.base.GetByIdResource;
import br.com.jpcchaves.infrastructure.controller.resources.base.ListResourcePaginated;
import br.com.jpcchaves.infrastructure.controller.resources.base.UpdateResource;
import br.com.jpcchaves.infrastructure.dto.TodoRequestDTO;
import br.com.jpcchaves.infrastructure.dto.TodoResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ITodoResource
    extends CreateResource<TodoRequestDTO, ResponseEntity<TodoResponseDTO>>,
        ListResourcePaginated<
            PaginationRequest, ResponseEntity<PaginatedResponse<TodoResponseDTO>>>,
        GetByIdResource<Long, ResponseEntity<TodoResponseDTO>>,
        UpdateResource<Long, TodoRequestDTO, ResponseEntity<TodoResponseDTO>>,
        DeleteResource<Long, ResponseEntity<Void>> {}
