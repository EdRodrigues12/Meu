package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

	public String adicionar() throws DAOException {;
		declaranteDao.adicionar(declarante);
		declarante = new Declarante();
		return "";
	}

	public String pesquisar() throws DAOException {
		String codigo = declarante.getCpf();
		declarante = new Declarante();
		declarante = declaranteDao.pesquisar1(codigo);
		return "";
	}

	public String atualizar() throws DAOException {
		declaranteDao.atualizar(declarante);
		return "";
	}

	public String deletar() throws DAOException {
		declaranteDao.deletar(declarante.getCpf());
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
