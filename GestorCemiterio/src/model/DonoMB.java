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
import entidades.Jazigo;

@ManagedBean
@SessionScoped
public class DonoMB {

	private DonoDAO donoDao = new DonoDAOImpl();
	private Dono dono = new Dono();
	private Jazigo jazigo = new Jazigo();
	private DonoJazigo dj = new DonoJazigo();
	private List<Dono> lista = new ArrayList<Dono>();
	private List<DonoJazigo> list = new ArrayList<DonoJazigo>();
    private String nome;
    private int num;
  

	public String adicionar() throws DAOException {;
		donoDao.adicionar(dono);
		dono = new Dono();
		return "";
	}
	
	public String pesquisarCPF() throws DAOException {
		//declarante = new Declarante();
		String cpf = dono.getCpf();
		
		dono = donoDao.pesquisar1(cpf);
		//declarante = new Declarante();
		return "";
	}
	
	public String pesquisarDono() throws DAOException {
		setLista(donoDao.pesquisar(dono.getNome()));
		
		System.out.println(dj.getNome());
		//dono = new Dono();
		return "";
	}

	public String pesquisar() throws DAOException {
		setList(donoDao.pesquisarJazigo(num));
		System.out.println(dono.getNome());
		dj.setNome(dono.getNome());
		dj.setCodigo(jazigo.getCodigo());
		System.out.println(dj.getNome());
		//dono = new Dono();
		return "";
	}
	
	public String pesquisarCpf() throws DAOException {
		setLista(donoDao.pesquisarDonoCpf(dono.getCpf()));
		System.out.println(dono.getNome());
		dono = new Dono();
		return "";
	}

	public String atualizar() throws DAOException {
		donoDao.atualizar(dono);
		dono = new Dono();
		return "";
	}

	public String deletar(Dono d) throws DAOException {
		dono = d;
		donoDao.deletar(d.getCpf());
		dono = new Dono();
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

	public DonoDAO getDonoDao() {
		return donoDao;
	}

	public void setDonoDao(DonoDAO donoDao) {
		this.donoDao = donoDao;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Jazigo getJazigo() {
		return jazigo;
	}

	public void setJazigo(Jazigo jazigo) {
		this.jazigo = jazigo;
	}
	
}
