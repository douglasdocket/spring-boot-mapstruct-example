package com.github.douglasdocket.mapstruct.api;

import com.github.douglasdocket.mapstruct.domain.Empresa;
import com.github.douglasdocket.mapstruct.factory.EmpresaFactory;
import com.github.douglasdocket.mapstruct.input.EmpresaInput;
import com.github.douglasdocket.mapstruct.mapper.EmpresaMapper;
import com.github.douglasdocket.mapstruct.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaAPI {

	private EmpresaRepository empresaRepository;

	private EmpresaFactory empresaFactory;

	@Autowired
	public EmpresaAPI(EmpresaMapper empresaMapper, EmpresaRepository empresaRepository, EmpresaFactory empresaFactory) {
		this.empresaRepository = empresaRepository;
		this.empresaFactory = empresaFactory;
	}

	@PostMapping
	public ResponseEntity registrarEmpresa(@RequestBody @Validated EmpresaInput empresaInput) {
		Empresa empresa = empresaFactory.fabricateFromInputObject(empresaInput);

		empresaRepository.save(empresa);

		return ResponseEntity.ok().build();
	}

}
