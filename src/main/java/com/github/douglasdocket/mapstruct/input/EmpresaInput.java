package com.github.douglasdocket.mapstruct.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class EmpresaInput {

	@NotBlank
	private final String razaoSocial;

	private final String nomeFantasia;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="America/Sao_Paulo")
	@NotNull
	private final Date dataFundacao;

	@JsonCreator
	public EmpresaInput(@JsonProperty("razaoSocial") String razaoSocial, @JsonProperty("nomeFantasia") String nomeFantasia, @JsonProperty(value = "dataFundacao") Date dataFundacao) {
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataFundacao = dataFundacao;
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
}
