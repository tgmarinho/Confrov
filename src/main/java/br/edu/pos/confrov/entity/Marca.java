package br.edu.pos.confrov.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@SequenceGenerator(name="seq_marca", sequenceName="seq_marca", initialValue=1, allocationSize=1)
@Table(name="tb_marca", uniqueConstraints=@UniqueConstraint(columnNames="ma_descricao"))
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findByDescricao", query = "SELECT m FROM Marca m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Marca.findById", query = "SELECT m FROM Marca m WHERE m.descricao = :id")})
public class Marca implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="seq_marca", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="ma_descricao",unique=true, nullable=false) 
	private String descricao;
	
	@OneToMany(mappedBy="marca", fetch=FetchType.LAZY)
	private Set<Modelo> modelo;

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
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
		Marca other = (Marca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<Modelo> getModelo() {
		return modelo;
	}

}
