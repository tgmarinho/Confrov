package br.edu.pos.confrov.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade", initialValue = 1, allocationSize = 1)
@Table(name = "tb_cidade", uniqueConstraints = @UniqueConstraint(columnNames = "ci_nome"))
@NamedQueries({
		@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
		@NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome"),
		@NamedQuery(name = "Cidade.findbyEstado", query = "SELECT c FROM Cidade c WHERE c.estado = :estado"),
		@NamedQuery(name = "Cidade.findById", query = "SELECT c FROM Cidade c WHERE c.id = :id") })
public class Cidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "seq_cidade", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ci_nome", unique = true, nullable = false)
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Estado estado;
	
	public Estado getEstado(){
		return estado;
	}
	public void setEstado(Estado estado){
		 this.estado=estado;
	}

	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
