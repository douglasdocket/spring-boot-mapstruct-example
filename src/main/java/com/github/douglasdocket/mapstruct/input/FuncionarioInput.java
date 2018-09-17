package com.github.douglasdocket.mapstruct.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.douglasdocket.mapstruct.hardcode.Sexo;
import com.github.douglasdocket.mapstruct.hardcode.TipoPessoa;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class FuncionarioInput {

	@NotBlank
	private final String nome;

	private final String apelido;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="America/Sao_Paulo")
	private final Date dataNascimento;

	@NotNull
	private final Sexo sexo;

	@NotNull
	private final TipoPessoa tipo;

	@JsonCreator
	public FuncionarioInput(@JsonProperty("nome") String nome,
							@JsonProperty("apelido") String apelido,
							@JsonProperty("dataNascimento") Date dataNascimento,
							@JsonProperty("sexo") Sexo sexo,
							@JsonProperty("tipo") TipoPessoa tipo) {
		this.nome = nome;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}
}
