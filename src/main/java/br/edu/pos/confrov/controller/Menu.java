package br.edu.pos.confrov.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="menu")
public class Menu {

	
	public String categoriaList(){
		System.out.println("teste");
		return "categoriaList";
	}
	
}
