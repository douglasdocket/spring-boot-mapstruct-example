package com.github.douglasdocket.mapstruct.factory;

import com.github.douglasdocket.mapstruct.domain.Empresa;
import com.github.douglasdocket.mapstruct.domain.Pessoa;
import com.github.douglasdocket.mapstruct.input.EmpresaInput;
import com.github.douglasdocket.mapstruct.mapper.EmpresaMapper;
import com.github.douglasdocket.mapstruct.vo.NovaEmpresaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpresaFactory implements Factory<EmpresaInput, NovaEmpresaVO, Empresa> {

	private EmpresaMapper empresaMapper;

	@Autowired
	public EmpresaFactory(EmpresaMapper empresaMapper) {
		this.empresaMapper = empresaMapper;
	}

	@Override
	public Empresa fabricateFromInputObject(EmpresaInput empresaInput) {
		Empresa empresa = empresaMapper.empresaInputToEmpresa(empresaInput);

		if (empresa.getFuncionarios() == null) {
			return empresa;
		}

		for (Pessoa funcionario : empresa.getFuncionarios()) {
			funcionario.setEmpresa(empresa);
		}

		return empresa;
	}

	@Override
	public Empresa fabricateFromViewObject(NovaEmpresaVO novaEmpresaVO) {
		Empresa empresa = empresaMapper.empresaVOToEmpresa(novaEmpresaVO);

		if (empresa.getFuncionarios() == null) {
			return empresa;
		}

		for (Pessoa funcionario : empresa.getFuncionarios()) {
			funcionario.setEmpresa(empresa);
		}

		return empresa;
	}
}
