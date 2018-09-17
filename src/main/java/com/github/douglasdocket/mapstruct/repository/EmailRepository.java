package com.github.douglasdocket.mapstruct.repository;

import com.github.douglasdocket.mapstruct.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
