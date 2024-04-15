package br.com.jpcchaves.infrastructure.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import java.util.Optional;

public class JpaAuditingConfig implements AuditorAware<Long> {
    @Override
    @NonNull
    public Optional<Long> getCurrentAuditor() {
        return Optional.empty();
    }
}
