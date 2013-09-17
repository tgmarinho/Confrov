package br.edu.pos.confrov.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.pos.confrov.entity.Cliente;
import br.edu.pos.confrov.entity.Locacao;
import br.edu.pos.confrov.entity.Veiculo;
import br.edu.pos.confrov.service.IClienteService;
import br.edu.pos.confrov.service.ILocacaoService;
import br.edu.pos.confrov.service.IVeiculoService;
import br.edu.pos.confrov.service.impl.ClienteServiceImpl;
import br.edu.pos.confrov.service.impl.LocacaoServiceImpl;
import br.edu.pos.confrov.service.impl.VeiculoServiceImpl;
import br.edu.pos.confrov.utils.AbstractEntity;

@ManagedBean(name="locacaoMB")
public class LocacaoMB extends AbstractEntity {

	private static final long serialVersionUID = 1L;


	private Locacao locacao;

	private List<Veiculo> listaVeiculos;
	private List<Cliente> listaClientes;
	private List<Locacao> listaLocacoes;
	
	ILocacaoService locacaoService = new LocacaoServiceImpl();
	IVeiculoService veiculoService = new VeiculoServiceImpl();
	IClienteService clienteService = new ClienteServiceImpl();

	@PostConstruct
	public void init(){
		setListaVeiculos(new ArrayList<Veiculo>());
		setListaClientes((new ArrayList<Cliente>()));
		buscaLocacoes();
		setLocacao(new Locacao());
	}


	private void buscaLocacoes() {
		setListaLocacoes(locacaoService.findByAll());
		
	}

	public String salvar(){

		try {
			
			if(regrasNegocios()){
			setLocacao(locacaoService.criaLocacao(locacao));
			System.out.println("teste locacao salvar");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Locacção Salvo","" )); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Locação não salvo","" )); 
		}

		buscaLocacoes();
		
		return "";
	}

	/**
	 * Não deu para colocar na service por questões de tempo.... regra de negocio implementada aq no MB mesmo =/
	 * @return
	 */
	private boolean regrasNegocios() {
		
		if(validaDatasLocacao()) {
			
		}
		
		return true;
		
		
	}


	private boolean validaDatasLocacao() {
//		locacaoService.buscaVeiculoLocadoNaData();
		return false;
	}


	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Locação Editado", ((Locacao) event.getObject()).getId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);

		locacaoService.editaLocacao((Locacao) event.getObject());
		buscaLocacoes();
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Locação cancelada", ((Locacao) event.getObject()).getId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onExcluir(RowEditEvent event) {
		System.out.println("teste excluir");

	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}


	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}


	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	public Locacao getLocacao() {
		return locacao;
	}


	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}


	public List<Locacao> getListaLocacoes() {
		return listaLocacoes;
	}


	public void setListaLocacoes(List<Locacao> listaLocacoes) {
		this.listaLocacoes = listaLocacoes;
	}
	
	

}
