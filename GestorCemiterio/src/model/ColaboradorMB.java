package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ColaboradorDAO;
import dao.ColaboradorDAOImpl;
import entidades.Colaborador;

@ManagedBean
@SessionScoped
public class ColaboradorMB {

	private Colaborador colaborador = new Colaborador();
	private List<Colaborador> colaboradores = new ArrayList<Colaborador>();
	private ColaboradorDAO dao = new ColaboradorDAOImpl();
	
	
	public String adicionar(){
		dao.adicionar(colaborador);
		colaborador = new Colaborador();
		return "";
	}
	public String atualizar(){
		dao.atualizar(colaborador);
		colaborador = new Colaborador();
		return "";
	}
	public String pesquisarPorNome(){
		setColaboradores(dao.pesquisarPorNome(colaborador.getNome()));
		colaborador = new Colaborador();
		//colaborador = colaboradores.get(0);
		return "";
	}
	public String pesquisarPorServico(){
		setColaboradores(dao.pesquisarPorServico(colaborador.getServico()));
		colaborador = new Colaborador();
		//colaborador = colaboradores.get(0);
		return "";
	}
	public String remover(Colaborador c){
		colaborador = c;
		dao.remover(c.getId());
		colaborador = new Colaborador();
		return "";
	}
	
	public String editar(Colaborador c) { 
		colaborador = c;
		System.out.println("Botao Editar do Col " + c.getNome() + " foi pressionado");
		//colaborador = new Colaborador();
		return "";
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
}
