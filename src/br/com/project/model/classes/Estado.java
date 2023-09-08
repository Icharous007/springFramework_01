package br.com.project.model.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Entity
@Audited
@Table(name = "estado")
@SequenceGenerator(sequenceName = "estado_seq", name = "estado_seq", initialValue = 1, allocationSize = 1)
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@IdentificaCampoPesquisa(descricaoCampo = "Código Estado", campoConsulta = "estado_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_seq")
	private Long estado_id;
	
	@Column(length = 100, nullable = false)
	@IdentificaCampoPesquisa(descricaoCampo = "Nome do estado.", campoConsulta = "estado_nome", principal = 1)
	private String estado_nome;
	
	@Column(length = 10, nullable = true)
	private String estado_uf;
	
	@NotAudited
	@OneToMany(mappedBy = "estado", orphanRemoval = false)
	@Cascade(value = {CascadeType.SAVE_UPDATE, CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Cidade> cidades =  new ArrayList<Cidade>();
	
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pais")
	//@NotNull
	@ForeignKey(name = "pais_fk")
	private Pais pais = new Pais();
	
	@Version
	@Column(name = "versionNumber")
	private int versionNumber;

	public Long getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Long estado_id) {
		this.estado_id = estado_id;
	}

	public String getEstado_nome() {
		return estado_nome;
	}

	public void setEstado_nome(String estado_nome) {
		this.estado_nome = estado_nome;
	}

	public String getEstado_uf() {
		return estado_uf;
	}

	public void setEstado_uf(String estado_uf) {
		this.estado_uf = estado_uf;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(estado_id, other.estado_id);
	}
}
