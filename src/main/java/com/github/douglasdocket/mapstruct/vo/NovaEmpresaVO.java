package com.github.douglasdocket.mapstruct.vo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovaEmpresaVO {

	@NotBlank
	private String razaoSocial;

	private String nomeFantasia;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataFundacao;

	private List<NovoFuncionarioVO> funcionarios = new ArrayList<>();

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public List<NovoFuncionarioVO> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<NovoFuncionarioVO> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
