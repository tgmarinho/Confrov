package br.edu.pos.confrov.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-09-16T19:56:16.870-0400")
@StaticMetamodel(Locacao.class)
public class Locacao_ {
	public static volatile SingularAttribute<Locacao, Long> id;
	public static volatile SingularAttribute<Locacao, Date> dataRetirada;
	public static volatile SingularAttribute<Locacao, Date> dataDevolucao;
	public static volatile SingularAttribute<Locacao, BigDecimal> valorDario;
	public static volatile SingularAttribute<Locacao, BigDecimal> valorTotalLocacao;
	public static volatile SingularAttribute<Locacao, Veiculo> veiculo;
	public static volatile SingularAttribute<Locacao, Cliente> cliente;
}
