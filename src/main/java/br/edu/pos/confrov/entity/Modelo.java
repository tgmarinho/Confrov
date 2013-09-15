package br.edu.pos.confrov.entity;

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

import br.edu.pos.confrov.utils.AbstractEntity;

@Entity
@SequenceGenerator(name="seq_modelo", sequenceName="seq_modelo", initialValue=1, allocationSize=1)
@Table(name="tb_modelo", uniqueConstraints=@UniqueConstraint(columnNames="mo_descricao"))
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m order by m.descricao desc"),
    @NamedQuery(name = "Modelo.findByDescricao", query = "SELECT m FROM Modelo m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Modelo.findById", query = "SELECT m FROM Modelo m WHERE m.id = :id")})
public class Modelo extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="seq_modelo", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="mo_descricao")
	private String descricao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Marca marca;

	@ManyToOne(fetch=FetchType.EAGER)
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
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
		Modelo other = (Modelo) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
