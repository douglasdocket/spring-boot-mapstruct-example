package com.github.douglasdocket.mapstruct.hardcode;

public enum TipoPessoa {

	PESSOA_FISICA("Pessoa física"),
	PESSOA_JURIDICA("Pessoa jurídica");

	private final String nome;

	TipoPessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
