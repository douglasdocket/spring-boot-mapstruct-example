package com.github.douglasdocket.mapstruct.repository;

import com.github.douglasdocket.mapstruct.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
