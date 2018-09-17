package com.github.douglasdocket.mapstruct.mapper;

import com.github.douglasdocket.mapstruct.domain.Empresa;
import com.github.douglasdocket.mapstruct.hardcode.MapperConstansts;
import com.github.douglasdocket.mapstruct.input.EmpresaInput;
import com.github.douglasdocket.mapstruct.vo.NovaEmpresaVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = MapperConstansts.SPRING, uses = {FuncionarioMapper.class})
public interface EmpresaMapper {

	@Mapping(source = "razaoSocial", target = "razaoSocial")
	@Mapping(source = "nomeFantasia", target = "nomeFantasia")
	@Mapping(source = "dataFundacao", target = "dataFundacao")
	@Mapping(source = "funcionarios", target = "funcionarios")
	Empresa empresaInputToEmpresa(EmpresaInput empresaInput);

	@Mapping(source = "razaoSocial", target = "razaoSocial")
	@Mapping(source = "nomeFantasia", target = "nomeFantasia")
	@Mapping(source = "dataFundacao", target = "dataFundacao")
	Empresa empresaVOToEmpresa(NovaEmpresaVO novaEmpresaVO);

}
