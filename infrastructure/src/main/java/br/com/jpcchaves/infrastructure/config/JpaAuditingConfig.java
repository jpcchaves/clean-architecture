package br.com.jpcchaves.infrastructure.config;

import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.lang.NonNull;

@EnableJpaAuditing
@Configuration
public class JpaAuditingConfig implements AuditorAware<Long> {
  @Override
  @NonNull
  public Optional<Long> getCurrentAuditor() {
    return Optional.of(1L);
  }
}
