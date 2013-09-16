package br.edu.pos.confrov.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.service.IEstadoService;
import br.edu.pos.confrov.service.ICidadeService;
import br.edu.pos.confrov.service.impl.CidadeServiceImpl;
import br.edu.pos.confrov.service.impl.EstadoServiceImpl;
import br.edu.pos.confrov.utils.AbstractEntity;

@ManagedBean(name="cidadeMB")
public class CidadeMB extends AbstractEntity  {
	private static final long serialVersionUID = 1L;

	private Cidade cidade;
	private List<Cidade> listaCidades;
	private List<Estado> listaEstados;

	ICidadeService cidadeService = new CidadeServiceImpl();
	IEstadoService estadoService = new EstadoServiceImpl();
	

	@PostConstruct
	public void init(){
		setListaCidades(new ArrayList<Cidade>());
		setListaEstados((new ArrayList<Estado>()));
		buscaCidades();
		setCidade(new Cidade());
	}


	private void buscaCidades() {
		setListaCidades(cidadeService.findByAll());
	}

	public String salvar(){

		Cidade CidadePeristida = cidadeService.findByNome(getCidade().getNome());
		if(CidadePeristida == null){
			setCidade(cidadeService.criaCidade(getCidade()));
			buscaCidades();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade Salva","" )); 
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ops! Cidade", "Já existe uma Cidade com essa Descricão: "+getCidade().getNome()));  
		}

		return "";
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cidade Editada", ((Cidade) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		cidadeService.editaCidade((Cidade) event.getObject());
		buscaCidades();
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cidade cancelada", ((Cidade) event.getObject()).getNome());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onExcluir(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cidade excluída", ((Cidade) event.getObject()).getNome());
		System.out.println("teste excluir");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade Cidade) {
		this.cidade = Cidade;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}



}
