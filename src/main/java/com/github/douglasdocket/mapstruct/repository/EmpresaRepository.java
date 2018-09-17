package com.github.douglasdocket.mapstruct.repository;

import com.github.douglasdocket.mapstruct.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Optional<Empresa> findOneByUuid(String empresaUUID);

}
