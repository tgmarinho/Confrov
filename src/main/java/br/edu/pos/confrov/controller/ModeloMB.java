package br.edu.pos.confrov.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.service.IMarcaService;
import br.edu.pos.confrov.service.IModeloService;
import br.edu.pos.confrov.service.impl.MarcaServiceImpl;
import br.edu.pos.confrov.service.impl.ModeloServiceImpl;
import br.edu.pos.confrov.utils.AbstractEntity;

@ManagedBean(name="modeloMB")
public class ModeloMB extends AbstractEntity {

	//	private static final Logger log = Logger.getLogger(ModeloMB.class);


	private static final long serialVersionUID = 1L;

	private Modelo modelo;
	private List<Modelo> listaModelos;
	private List<Marca> listaMarcas;

	IModeloService modeloService = new ModeloServiceImpl();
	IMarcaService marcaService = new MarcaServiceImpl();
	

	@PostConstruct
	public void init(){
		setListaModelos(new ArrayList<Modelo>());
		setListaMarcas((new ArrayList<Marca>()));
		buscaModelos();
		setModelo(new Modelo());
	}

	private void buscaMarcas() {
		setListaMarcas(marcaService.findByAll());
		
	}

	private void buscaModelos() {
		setListaModelos(modeloService.findByAll());
	}

	public String salvar(){

		Modelo ModeloPeristida = modeloService.findByDescricao(getModelo().getDescricao());
		if(ModeloPeristida == null){
			setModelo(modeloService.criaModelo(getModelo()));
			buscaModelos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Modelo Salva","" )); 
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ops! Modelo", "Já existe uma Modelo com essa Descricão: "+getModelo().getDescricao()));  
		}

		return "";
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modelo Editada", ((Modelo) event.getObject()).getDescricao());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		modeloService.editaModelo((Modelo) event.getObject());
		buscaModelos();
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modelo cancelada", ((Modelo) event.getObject()).getDescricao());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onExcluir(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modelo excluída", ((Modelo) event.getObject()).getDescricao());
		System.out.println("teste excluir");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Modelo> getListaModelos() {
		return listaModelos;
	}

	public void setListaModelos(List<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}

	public List<Marca> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}


	


}
