package br.edu.pos.confrov.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_locacao", sequenceName = "seq_locacao", initialValue = 1, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l"),
	@NamedQuery(name = "Locacao.findById", query = "SELECT l FROM Locacao l WHERE l.id = :id") })
public class Locacao implements Serializable{

	private static final long serialVersionUID = 1L;

	/*
	 * possui o atributo data da retirada, data da devolução, 
	 * cliente, valor da diária e valor da locação;
	 * 
	 */
	@Id
	@GeneratedValue(generator="seq_locacao", strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="dt_retirada")
	private String dataRetirada;

	@Column(name="dt_devolucao")
	private Integer dataDevolucao;

	@Column(name="vlr_diaria")
	private BigDecimal valorDario;

	@Column(name="vlr_total_locacao")
	private BigDecimal valorTotalLocacao;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="veiculo_fk")
	private Veiculo veiculo;
	
	

}
