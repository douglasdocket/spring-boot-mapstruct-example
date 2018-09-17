package com.github.douglasdocket.mapstruct.api;

import com.github.douglasdocket.mapstruct.input.EmpresaInput;
import com.github.douglasdocket.mapstruct.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@Autowired
	public EmpresaAPI(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	@PostMapping
	public ResponseEntity registrarEmpresa(@RequestBody @Validated EmpresaInput input) {



		return ResponseEntity.ok().build();
	}

}
