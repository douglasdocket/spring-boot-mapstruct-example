package com.github.douglasdocket.mapstruct.domain;

import com.github.douglasdocket.mapstruct.hardcode.Sexo;
import com.github.douglasdocket.mapstruct.hardcode.TipoPessoa;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PESSOA")
public class Pessoa {

	@Id
	@GenericGenerator(name = "pessoaSequenceGenerator", parameters = @Parameter(name = "sequence_name", value = "PESSOA_SEQUENCE"),  strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
	@GeneratedValue(generator = "pessoaSequenceGenerator")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "APELIDO")
	private String apelido;

	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;

	@Column(name = "SEXO")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipo;

	@JoinColumn(name = "EMPRESA_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_PESSOA_EMPRESA"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Empresa empresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Pessoa{");
		sb.append("id=").append(id);
		sb.append(", nome='").append(nome).append('\'');
		sb.append(", apelido='").append(apelido).append('\'');
		sb.append(", dataNascimento=").append(dataNascimento);
		sb.append(", sexo=").append(sexo);
		sb.append(", tipo=").append(tipo);
		sb.append('}');
		return sb.toString();
	}
}
