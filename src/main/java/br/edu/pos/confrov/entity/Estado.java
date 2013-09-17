package br.edu.pos.confrov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.edu.pos.confrov.utils.AbstractEntity;

@Entity
@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado", initialValue = 1, allocationSize = 1)
@Table(name = "tb_estado", uniqueConstraints=@UniqueConstraint(columnNames="es_nome"))
@NamedQueries({
		@NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
		@NamedQuery(name = "Estado.findByDescricao", query = "SELECT e FROM Estado e WHERE e.nome = :nome"),
		@NamedQuery(name = "Estado.findById", query = "SELECT m FROM Estado m WHERE m.id = :id") })
public class Estado extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_estado", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "es_nome")
	private String nome;
	
	@Column(name = "es_sigla")
	private String sigla;
	
	public String getSigla(){
		return sigla;
	}
	public void setSigla(String sigla){
		 this.sigla=sigla;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
