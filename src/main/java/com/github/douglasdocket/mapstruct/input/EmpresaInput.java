package com.github.douglasdocket.mapstruct.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class EmpresaInput {

	@NotBlank
	private final String razaoSocial;

	private final String nomeFantasia;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="America/Sao_Paulo")
	private final Date dataFundacao;

	private final List<FuncionarioInput> funcionarios;

	@JsonCreator
	public EmpresaInput(@JsonProperty("razaoSocial") String razaoSocial,
						@JsonProperty("nomeFantasia") String nomeFantasia,
						@JsonProperty(value = "dataFundacao") Date dataFundacao,
						@JsonProperty(value = "funcionarios") List<FuncionarioInput> funcionarios) {
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataFundacao = dataFundacao;
		this.funcionarios = funcionarios;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public List<FuncionarioInput> getFuncionarios() {
		return funcionarios;
	}
}
