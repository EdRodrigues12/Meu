package dao;

import java.util.List;

import entidades.Jazigo;

public interface JazigoDAO {
	public void adicionar(Jazigo j) throws DAOException;

	public void atualizar(Jazigo j) throws DAOException;

	public boolean deletar(int codigojazigo) throws DAOException;

	public List<Jazigo> pesquisar(int numerojazigo) throws DAOException;
	
	public List<Jazigo> pesquisarRua(String rua) throws DAOException;

	public Jazigo pesquisarUmJazigo(int numerojazigo) throws DAOException;
	
	public void atualizarDono(Jazigo j) throws DAOException;
	
	public List<Jazigo> pesquisarDono(String dono) throws DAOException;
	

}
