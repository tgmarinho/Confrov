package br.edu.pos.confrov.entity;



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
import javax.persistence.Table;
import br.edu.pos.confrov.utils.AbstractEntity;

@Entity
@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", initialValue = 1, allocationSize = 1)
@Table(name = "tb_cliente")
@NamedQueries({
		@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
		@NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
		@NamedQuery(name = "Cliente.findByCPF", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
		@NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id") })
public class Cliente extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "seq_cliente", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "cli_nome", unique = true, nullable = false)
	private String nome;
	
	@Column(name = "cli_cpf")
	private Long cpf;
	
	@Column(name = "cli_cep")
	private Long cep;
	
	@Column(name = "cli_endereco")
	private String endereco;
	
	@Column(name = "cli_bairro")
	private String bairro;
	
	@Column(name = "cli_dtnascimento")
	private String dtnascimento;
	
	@Column(name = "cli_fone")
	private Long fone;
	
	@Column(name = "cli_email")
	private String email;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="cidade_fk")
	private Cidade cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(String dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	public Long getFone() {
		return fone;
	}

	public void setFone(Long fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	

}
