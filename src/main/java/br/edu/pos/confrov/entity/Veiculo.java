package br.edu.pos.confrov.entity;

import java.math.BigDecimal;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.pos.confrov.utils.AbstractEntity;

@Entity
@SequenceGenerator(name="seq_veiculo", sequenceName="seq_veiculo", initialValue=1, allocationSize=1)
@Table(name="tb_veiculo")
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.findById", query = "SELECT v FROM Veiculo v WHERE v.id = :id")})
public class Veiculo extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="seq_veiculo", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="ve_placa")
	private String placa;
	
	@Column(name="ve_ano_fabricacao")
	private Integer anoFabricacao;
	
	@Column(name="ve_ano_modelo")
	private Integer anoModelo;
	
	@Column(name="ve_cor")
	private String cor;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="modelo_fk")
	private Modelo modelo;
	
	@Column(name="ve_valor_locacao")
	private BigDecimal valorLocacao;
	
	@OneToMany(mappedBy="veiculo")
	private List<Locacao> locacoes;
	
	public BigDecimal getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(BigDecimal valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public Long getId() {
		return id;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return id + " " + modelo.getDescricao();
	}

	
}
