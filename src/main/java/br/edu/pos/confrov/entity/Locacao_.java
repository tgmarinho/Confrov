package br.edu.pos.confrov.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-09-14T15:18:16.045-0400")
@StaticMetamodel(Locacao.class)
public class Locacao_ {
	public static volatile SingularAttribute<Locacao, Long> id;
	public static volatile SingularAttribute<Locacao, String> dataRetirada;
	public static volatile SingularAttribute<Locacao, Integer> dataDevolucao;
	public static volatile SingularAttribute<Locacao, BigDecimal> valorDario;
	public static volatile SingularAttribute<Locacao, BigDecimal> valorTotalLocacao;
	public static volatile SingularAttribute<Locacao, Veiculo> veiculo;
}
