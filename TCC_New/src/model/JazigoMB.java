package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.DAOException;
import dao.JazigoDAO;
import dao.JazigoDAOImpl;
import entidades.Jazigo;


@ManagedBean
@SessionScoped
public class JazigoMB {
	
		private JazigoDAO jazigoDao = new JazigoDAOImpl();
		private Jazigo jazigo = new Jazigo();
		private List<Jazigo> lista = new ArrayList<Jazigo>();
	
		public String adicionar() throws DAOException {;
			jazigoDao.adicionar(jazigo);
			jazigo = new Jazigo();
			return "";
		}

		public String pesquisar() throws DAOException {
			int codigo = jazigo.getNumero();
			jazigo = new Jazigo();
			jazigo = jazigoDao.pesquisarUmJazigo(codigo);
			return "";
		}

		public String atualizar() throws DAOException {
			jazigoDao.atualizar(jazigo);
			return "";
		}
		
		public String atualizarDono() throws DAOException {
			jazigoDao.atualizarDono(jazigo);;
			return "";
		}

		public String deletar() throws DAOException {
			jazigoDao.deletar(jazigo.getCodigo());
			return "";

		}

		
		public Jazigo getJazigo() {
			return jazigo;
		}

		public void setJazigo(Jazigo jazigo) {
			this.jazigo = jazigo;
		}

		public List<Jazigo> getLista() {
			return lista;
		}

		public void setLista(List<Jazigo> lista) {
			this.lista = lista;
		}
		
		

}
