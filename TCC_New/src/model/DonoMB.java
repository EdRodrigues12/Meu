package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.DAOException;
import dao.DonoDAO;
import dao.DonoDAOImpl;
import entidades.Dono;

@ManagedBean
@SessionScoped
public class DonoMB {

	private DonoDAO donoDao = new DonoDAOImpl();
	private Dono dono = new Dono();
	private List<Dono> lista = new ArrayList<Dono>();

	public String adicionar() throws DAOException {;
		donoDao.adicionar(dono);
		dono = new Dono();
		return "";
	}

	public String pesquisar() throws DAOException {
		setLista(donoDao.pesquisar(dono.getNome()));
		return "";
	}

	public String atualizar() throws DAOException {
		donoDao.atualizar(dono);
		return "";
	}

	public String deletar() throws DAOException {
		donoDao.deletar(dono.getCpf());
		return "";

	}
	public String deletarJazigo() throws DAOException {
		donoDao.deletarJazigo(dono.getCodJazigo());
		return "";

	}

	public Dono getDono() {
		return dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}

	public List<Dono> getLista() {
		return lista;
	}

	public void setLista(List<Dono> lista) {
		this.lista = lista;
	}
	
	
}
