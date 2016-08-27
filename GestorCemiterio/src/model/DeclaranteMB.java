package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.DAOException;
import dao.DeclaranteDAO;
import dao.DeclaranteDAOImpl;
import entidades.Declarante;
@ManagedBean
@SessionScoped
public class DeclaranteMB {
	
	private DeclaranteDAO declaranteDao = new DeclaranteDAOImpl();
	private Declarante declarante = new Declarante();
	private List<Declarante> lista = new ArrayList<Declarante>();

	public String adicionar() throws DAOException {
		try{
		declarante = new Declarante();
		declaranteDao.adicionar(declarante);
		declarante = new Declarante();
	}catch(DAOException e){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO","Erro ao salvar no banco"));
	}
		return "";
	}

	public String pesquisar() throws DAOException {
		String codigo = declarante.getCpf();
		declarante = new Declarante();
		declarante = declaranteDao.pesquisar1(codigo);
		declarante = new Declarante();
		return "";
	}

	public String atualizar() throws DAOException {
		declarante = new Declarante();
		declaranteDao.atualizar(declarante);
		declarante = new Declarante();
		return "";
	}

	public String deletar() throws DAOException {
		declaranteDao.deletar(declarante.getCpf());
		declarante = new Declarante();
		return "";

	}

	public Declarante getDeclarante() {
		return declarante;
	}

	public void setDeclarante(Declarante declarante) {
		this.declarante = declarante;
	}

	public List<Declarante> getLista() {
		return lista;
	}

	public void setLista(List<Declarante> lista) {
		this.lista = lista;
	}

	
	
}
