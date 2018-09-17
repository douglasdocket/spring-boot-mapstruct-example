package com.github.douglasdocket.mapstruct.repository;

import com.github.douglasdocket.mapstruct.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
