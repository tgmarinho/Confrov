package br.edu.pos.confrov.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.service.IMarcaService;
import br.edu.pos.confrov.service.impl.MarcaServiceImpl;
import br.edu.pos.confrov.utils.AbstractEntity;

@ManagedBean(name="marcaMB")
public class MarcaMB extends AbstractEntity {

	//	private static final Logger log = Logger.getLogger(MarcaMB.class);

	private static final long serialVersionUID = 1L;

	private Marca marca;
	private List<Marca> listaMarcas;

	IMarcaService marcaService = new MarcaServiceImpl();

	@PostConstruct
	public void init(){
		setListaMarcas(new ArrayList<Marca>());
		buscaMarcas();
		setMarca(new Marca());
	}

	private void buscaMarcas() {
		setListaMarcas(marcaService.findByAll());
	}

	public String salvar(){

		Marca marcaPeristida = marcaService.findByDescricao(getMarca().getDescricao());
		if(marcaPeristida == null){
			setMarca(marcaService.criaMarca(getMarca()));
			buscaMarcas();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Marca Salva","" )); 
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ops! Marca", "Já existe uma marca com essa Descricão: "+getMarca().getDescricao()));  
		}

		return "";
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Marca Editada", ((Marca) event.getObject()).getDescricao());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		marcaService.editaMarca((Marca) event.getObject());
		buscaMarcas();
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Marca cancelada", ((Marca) event.getObject()).getDescricao());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onExcluir(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Marca excluída", ((Marca) event.getObject()).getDescricao());
		System.out.println("teste excluir");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}


}
