package br.edu.pos.confrov.controller;


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
import br.edu.pos.confrov.utils.AbstractEntity;


@ManagedBean(name="estadoMB")
public class EstadoMB extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private Estado estado;
	private List<Estado> listaEstado;

	IEstadoService estadoService = new EstadoServiceImpl();

	@PostConstruct
	public void init(){
		setListaEstado(new ArrayList<Estado>());
		buscaEstados();
		setEstado(new Estado());
	}

	private void buscaEstados() {
		setListaEstado(estadoService.findByAll());
	}

	public String salvar(){

		//Estado estadoPeristida = estadoService.findByDescricao(getEstado().getNome());
		//if(estadoPeristida == null){
			setEstado(estadoService.criaEstado(getEstado()));
			buscaEstados();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Estado Salva","" )); 
	//	else {
		//	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ops! Estado", "Já existe uma Estado com esse Nome: "+getEstado().getNome()));  
		//}

		return "";
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Estado Editedo", ((Estado) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		estadoService.editaEstado((Estado) event.getObject());
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
		return estado;
	}


	public void setEstado(Estado Estado) {
		this.estado = Estado;
	}

	public List<Estado> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<Estado> listaEstado) {
		this.listaEstado = listaEstado;
	}

}
