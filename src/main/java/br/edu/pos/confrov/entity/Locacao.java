package br.edu.pos.confrov.entity;

import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.pos.confrov.utils.AbstractEntity;

@Entity
@SequenceGenerator(name = "seq_locacao", sequenceName = "seq_locacao", initialValue = 1, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l"),
	@NamedQuery(name = "Locacao.findByPeriodo", query = "SELECT l FROM Locacao l WHERE l.dataDevolucao >= :dataInicial and l.dataDevolucao <= :dataFinal"),
	@NamedQuery(name = "Locacao.findByCliente", query = "SELECT l FROM Locacao l JOIN FETCH l.cliente WHERE l.cliente = :idCliente"),
	@NamedQuery(name = "Locacao.findByVeiculo", query = "SELECT l FROM Locacao l JOIN FETCH l.veiculo WHERE l.veiculo = :idVeiculo"),
	@NamedQuery(name = "Locacao.findById", query = "SELECT l FROM Locacao l WHERE l.id = :id") })
public class Locacao extends AbstractEntity {

	//SELECT x FROM Magazine x join fetch x.articles WHERE x.title = 'JDJ'
	
	private static final long serialVersionUID = 1L;

	/*
	 * possui o atributo data da retirada, data da devolução, 
	 * cliente, valor da diária e valor da locação;
	 * 
	 */
	@Id
	@GeneratedValue(generator="seq_locacao", strategy=GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_retirada")
	private Date dataRetirada;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_devolucao")
	private Date dataDevolucao;

	@Column(name="vlr_diaria")
	private BigDecimal valorDario;

	@Column(name="vlr_total_locacao")
	private BigDecimal valorTotalLocacao;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="veiculo_fk")
	private Veiculo veiculo;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="cliente_fk")
	private Cliente cliente;

	// Getters and Setters
	
	public BigDecimal getValorDario() {
		return valorDario;
	}

	public void setValorDario(BigDecimal valorDario) {
		this.valorDario = valorDario;
	}

	public BigDecimal getValorTotalLocacao() {
		return valorTotalLocacao;
	}

	public void setValorTotalLocacao(BigDecimal valorTotalLocacao) {
		this.valorTotalLocacao = valorTotalLocacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	// HashCode and Equals
	
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
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
}
