package br.edu.pos.confrov.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.service.ICategoriaService;
import br.edu.pos.confrov.service.impl.CategoriaServiceImpl;

@ViewScoped
@ManagedBean(name="categoria")
public class CategoriaList implements Serializable {

//	private static final Logger log = Logger.getLogger(CategoriaList.class);
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Categoria categoria;
	private List<Categoria> categorias;
	
	ICategoriaService categoriaService = new CategoriaServiceImpl();
	
	@PostConstruct
	public void init(){
//		categorias = categoriaService.findByAll();
	}
	
	public String salvar(){
		
		Categoria categoriaPeristida = categoriaService.findByDescricao(categoria.getDescricao());
		if(categoriaPeristida !=null){
			categoriaService.criaCategoria(categoria);
		}
		
		return "categoriaList";
		
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}





}
