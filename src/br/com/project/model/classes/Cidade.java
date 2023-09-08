package br.com.project.model.classes;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name = "cidade")
@SequenceGenerator(name = "cidade_seq", sequenceName = "cidade_seq", initialValue = 1, allocationSize = 1)
public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_seq")
	@IdentificaCampoPesquisa(descricaoCampo = "Código",campoConsulta = "cidade_id")
	private Long cidade_id;
	
	@Column( nullable = false, length = 100)
	@IdentificaCampoPesquisa(descricaoCampo = "Nome cidade", campoConsulta = "cidade_nome", principal = 1)
	private String cidade_nome;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Estado da cidade", campoConsulta = "estado.estado_nome")
	@Basic
	@ManyToOne
	@JoinColumn(name = "estado", nullable = false)
	@ForeignKey(name = "estado_fk")
	private Estado estado = new Estado();
	
	@Version
	@Column(name = "versionNumber")
	private int versionNumber;

	public Long getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(Long cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getCidade_nome() {
		return cidade_nome;
	}

	public void setCidade_nome(String cidade_nome) {
		this.cidade_nome = cidade_nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(cidade_id, other.cidade_id);
	}

	@Override
	public String toString() {
		return "Cidade [cidade_id=" + cidade_id + ", cidade_nome=" + cidade_nome + "]";
	}
	
	
}
