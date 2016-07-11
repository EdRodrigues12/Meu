package dao;

import java.util.List;

import entidades.Dono;

public interface DonoDAO {
	
	public void adicionar(Dono d) throws DAOException;

	public void atualizar(Dono d) throws DAOException;

	public boolean deletar(String cpf) throws DAOException;

	public List<Dono> pesquisar(String dono) throws DAOException;
	
	public Dono pesquisarDonoCpf(String cpf) throws DAOException;
	
	public boolean deletarJazigo(int codigo) throws DAOException;

	

}
