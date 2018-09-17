package com.github.douglasdocket.mapstruct.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "EMPRESA")
public class Empresa {

	@Id
	@GenericGenerator(name = "empresaSequenceGenerator", parameters = @Parameter(name = "sequence_name", value = "EMPRESA_SEQUENCE"),  strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
	@GeneratedValue(generator = "empresaSequenceGenerator")
	@Column(name = "ID")
	private Long id;

	@Column(name = "UUID")
	private String uuid = UUID.randomUUID().toString();

	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;

	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;

	@Column(name = "DATA_FUNDACAO")
	private Date dataFundacao;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Pessoa> funcionarios = new HashSet<Pessoa>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

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

	public Set<Pessoa> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Empresa{");
		sb.append("id=").append(id);
		sb.append(", uuid='").append(uuid).append('\'');
		sb.append(", razaoSocial='").append(razaoSocial).append('\'');
		sb.append(", nomeFantasia='").append(nomeFantasia).append('\'');
		sb.append(", dataFundacao=").append(dataFundacao);
		sb.append('}');
		return sb.toString();
	}
}
