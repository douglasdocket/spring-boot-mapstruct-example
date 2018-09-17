package com.github.douglasdocket.mapstruct.hardcode;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");

	private final String nome;

	Sexo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
