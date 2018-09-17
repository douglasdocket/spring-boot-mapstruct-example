package com.github.douglasdocket.mapstruct.domain;

import com.github.douglasdocket.mapstruct.hardcode.TipoEmail;
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

@Entity
@Table(name = "EMAIL")
public class Email {

	@Id
	@GenericGenerator(name = "emailSequenceGenerator", parameters = @Parameter(name = "sequence_name", value = "EMAIL_SEQUENCE"),  strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
	@GeneratedValue(generator = "emailSequenceGenerator")
	@Column(name = "ID")
	private Long id;

	@Column(name = "ENDERECO")
	private String endereco;

	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private TipoEmail tipo;

	@JoinColumn(name = "PESSOA_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_EMAIL_PESSOA"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Pessoa criador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public TipoEmail getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmail tipo) {
		this.tipo = tipo;
	}

	public Pessoa getCriador() {
		return criador;
	}

	public void setCriador(Pessoa criador) {
		this.criador = criador;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Email{");
		sb.append("id=").append(id);
		sb.append(", endereco='").append(endereco).append('\'');
		sb.append(", tipo=").append(tipo);
		sb.append('}');
		return sb.toString();
	}
}
