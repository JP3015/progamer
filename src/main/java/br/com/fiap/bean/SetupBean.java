package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

@Named
@RequestScoped
public class SetupBean {

	private Setup setup = new Setup();
	
	// CDI
	@Inject //injeção de dependência
	private SetupDao dao;
	
	public String save() {
		System.out.println(this.setup);
		dao.create(setup);
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Setup cadastrado com sucesso"));
		
		return "setups";
	}
	
	public List<Setup> getAll(){
		return dao.listAll();
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

}
