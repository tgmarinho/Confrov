package br.edu.pos.confrov.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-09-11T23:09:51.475-0400")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ {
	public static volatile SingularAttribute<Veiculo, Long> id;
	public static volatile SingularAttribute<Veiculo, String> placa;
	public static volatile SingularAttribute<Veiculo, String> cor;
	public static volatile SingularAttribute<Veiculo, Modelo> modelo;
	public static volatile SingularAttribute<Veiculo, Marca> marca;
	public static volatile SingularAttribute<Veiculo, Categoria> categoria;
	public static volatile SingularAttribute<Veiculo, Double> valorLocacao;
	public static volatile SingularAttribute<Veiculo, Integer> anoFabricacao;
	public static volatile SingularAttribute<Veiculo, Integer> anoModelo;
}
