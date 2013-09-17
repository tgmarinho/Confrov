package br.edu.pos.confrov.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="menu")
public class Menu {

	
	public String categoriaList(){
		System.out.println("categoriaList");
		return "categoriaList";
	}
	
	public String marcaMB(){
		System.out.println("marcaMB");
		return "marca";
	}
	
	public String modeloMB(){
		System.out.println("modeloMB");
		return "modelo";
	}
	
	public String veiculoMB(){
		System.out.println("veiculoMB");
		return "veiculo";
	}
	
	public String locacaoMB(){
		System.out.println("locacaoMB");
		return "locacao";
	}
	
	public String estadoMB(){
		System.out.println("estadoMB");
		return "estado";
	}
	public String cidadeMB(){
		System.out.println("cidadeMB");
		return "cidade";
	}
	
	public String clienteMB(){
		System.out.println("clienteMB");
		return "cliente";
	}
}
