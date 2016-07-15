package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.DAOException;
import dao.DonoDAO;
import dao.DonoDAOImpl;
import entidades.Dono;
import entidades.DonoJazigo;

@ManagedBean
@SessionScoped
public class DonoMB {

	private DonoDAO donoDao = new DonoDAOImpl();
	private Dono dono = new Dono();
	private DonoJazigo dj = new DonoJazigo();
	private List<Dono> lista = new ArrayList<Dono>();
	private List<DonoJazigo> list = new ArrayList<DonoJazigo>();
    private String nome;
  

	public String adicionar() throws DAOException {;
		donoDao.adicionar(dono);
		dono = new Dono();
		return "";
	}
	
	public String pesquisarDono() throws DAOException {
		setLista(donoDao.pesquisar(dono.getNome()));
		System.out.println(dono.getNome());
		return "";
	}

	public String pesquisar() throws DAOException {
		setList(donoDao.pesquisarJazigo(dono.getNome()));
		System.out.println(dono.getNome());
		return "";
	}
	
	public String pesquisarCpf() throws DAOException {
		setLista(donoDao.pesquisarDonoCpf(dono.getCpf()));
		System.out.println(dono.getNome());
		return "";
	}

	public String atualizar() throws DAOException {
		donoDao.atualizar(dono);
		return "";
	}

	public String deletar(Dono d) throws DAOException {
		dono = d;
		donoDao.deletar(d.getCpf());
		return "";

	}
	public String deletarJazigo(Dono d) throws DAOException {
		dono = d;
		donoDao.deletarJazigo(d.getCodJazigo());
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

	public List<DonoJazigo> getList() {
		return list;
	}

	public void setList(List<DonoJazigo> list) {
		this.list = list;
	}

	public DonoJazigo getDj() {
		return dj;
	}

	public void setDj(DonoJazigo dj) {
		this.dj = dj;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
