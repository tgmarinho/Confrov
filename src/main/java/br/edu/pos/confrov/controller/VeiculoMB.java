package br.edu.pos.confrov.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.entity.Veiculo;
import br.edu.pos.confrov.service.IModeloService;
import br.edu.pos.confrov.service.IVeiculoService;
import br.edu.pos.confrov.service.impl.ModeloServiceImpl;
import br.edu.pos.confrov.service.impl.VeiculoServiceImpl;
import br.edu.pos.confrov.utils.AbstractEntity;

@ManagedBean(name="veiculoMB")
public class VeiculoMB extends AbstractEntity {

	//	private static final Logger log = Logger.getLogger(ModeloMB.class);


	private static final long serialVersionUID = 1L;

	private Veiculo veiculo;

	private List<Veiculo> listaVeiculos;
	private List<Modelo> listaModelos;

	IVeiculoService veiculoService = new VeiculoServiceImpl();
	IModeloService modeloService = new ModeloServiceImpl();


	@PostConstruct
	public void init(){
		setListaVeiculos(new ArrayList<Veiculo>());
		setListaModelos((new ArrayList<Modelo>()));
		buscaVeiculos();
		setVeiculo(new Veiculo());
	}


	private void buscaVeiculos() {
//		veiculoService.findByAll();
		
	}


	private void buscaModelos() {
		setListaModelos(modeloService.findByAll());
	}

	public String salvar(){

		try {
			setVeiculo(veiculoService.criaVeiculo(veiculo));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Veiculo Salvo","" )); 
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veiculo não salvo","" )); 
		}

		buscaVeiculos();
		return "";
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Veiculo Editado", ((Veiculo) event.getObject()).getModelo().getDescricao());
		FacesContext.getCurrentInstance().addMessage(null, msg);

		modeloService.editaModelo((Modelo) event.getObject());
		buscaModelos();
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Veiculo cancelado", ((Veiculo) event.getObject()).getModelo().getDescricao());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onExcluir(RowEditEvent event) {
		System.out.println("teste excluir");

	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}


	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}


	public List<Modelo> getListaModelos() {
		return listaModelos;
	}


	public void setListaModelos(List<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}




}
