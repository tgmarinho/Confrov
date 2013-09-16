package br.edu.pos.confrov.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.service.IEstadoService;
import br.edu.pos.confrov.service.impl.EstadoServiceImpl;


@ManagedBean(name="estadoMB")
public class EstadoMB implements Serializable{
	private static final long serialVersionUID = 1L;

	private Estado Estado;
	private List<Estado> listaEstado;

	IEstadoService EstadoService = new EstadoServiceImpl();

	@PostConstruct
	public void init(){
		setListaEstado(new ArrayList<Estado>());
		buscaEstados();
		Estado = new Estado();
	}

	private void buscaEstados() {
		setListaEstado(EstadoService.findByAll());
	}

	public String salvar(){

		Estado EstadoPeristida = EstadoService.findByDescricao(Estado.getNome());
		if(EstadoPeristida == null){
			Estado = EstadoService.criaEstado(Estado);
			buscaEstados();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Estado Salva","" )); 
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ops! Estado", "Já existe uma Estado com esse Nome: "+Estado.getNome()));  
		}

		return "";
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Estado Edited", ((Estado) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		EstadoService.editaEstado((Estado) event.getObject());
		buscaEstados();
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Estado cancelada", ((Estado) event.getObject()).getNome());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onExcluir(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Estado excluída", ((Estado) event.getObject()).getNome());
		System.out.println("teste excluir");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	public Estado getEstado() {
		return Estado;
	}


	public void setEstado(Estado Estado) {
		this.Estado = Estado;
	}

	public List<Estado> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<Estado> listaEstado) {
		this.listaEstado = listaEstado;
	}

}
