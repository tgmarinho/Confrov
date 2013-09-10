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
@SequenceGenerator(name="seq_modelo", sequenceName="seq_modelo", initialValue=1, allocationSize=1)
@Table(name="tb_modelo", uniqueConstraints=@UniqueConstraint(columnNames="mo_descricao"))
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m"),
    @NamedQuery(name = "Modelo.findByDescricao", query = "SELECT m FROM Modelo m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Modelo.findById", query = "SELECT m FROM Modelo m WHERE m.id = :id")})
public class Modelo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="seq_modelo", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="mo_descricao")
	private String descricao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Marca marca;

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
	
}
