package com.github.douglasdocket.mapstruct.mapper;

import com.github.douglasdocket.mapstruct.domain.Pessoa;
import com.github.douglasdocket.mapstruct.hardcode.MapperConstansts;
import com.github.douglasdocket.mapstruct.input.FuncionarioInput;
import com.github.douglasdocket.mapstruct.vo.NovoFuncionarioVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = MapperConstansts.SPRING)
public interface FuncionarioMapper {

	@Mapping(source = "nome", target = "nome")
	@Mapping(source = "apelido", target = "apelido")
	@Mapping(source = "dataNascimento", target = "dataNascimento")
	@Mapping(source = "sexo", target = "sexo")
	@Mapping(source = "tipo", target = "tipo")
	Pessoa funcionarioInputToPessoa(FuncionarioInput funcionarioInput);

	@Mapping(source = "nome", target = "nome")
	@Mapping(source = "apelido", target = "apelido")
	@Mapping(source = "dataNascimento", target = "dataNascimento")
	@Mapping(source = "sexo", target = "sexo")
	@Mapping(source = "tipo", target = "tipo")
	Pessoa novoFuncionarioVOToPessoa(NovoFuncionarioVO novoFuncionarioVO);

}
