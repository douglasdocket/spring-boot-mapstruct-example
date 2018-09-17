package com.github.douglasdocket.mapstruct.vo;

import com.github.douglasdocket.mapstruct.hardcode.Sexo;
import com.github.douglasdocket.mapstruct.hardcode.TipoPessoa;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class NovoFuncionarioVO {

	@NotBlank
	private String nome;

	private String apelido;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	@NotNull
	private Sexo sexo;

	@NotNull
	private TipoPessoa tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
}
