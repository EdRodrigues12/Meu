package dao;

import java.util.List;

import entidades.Colaborador;

public interface ColaboradorDAO {
	public void adicionar(Colaborador c);
	public void atualizar(Colaborador c);
	public List<Colaborador> pesquisarPorNome(String nome);
	public List<Colaborador> pesquisarPorServico(String servico);
	public void remover(int id);
}
