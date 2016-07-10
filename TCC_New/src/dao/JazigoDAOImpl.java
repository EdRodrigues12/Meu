package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Jazigo;

public class JazigoDAOImpl implements JazigoDAO {

	
	public void adicionar(Jazigo j) throws DAOException {
		String sql = "INSERT INTO jazigo (rua, quadra, gaveta, numero) VALUES ( ?, ?, ?, ?)";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, j.getRua());
			stmt.setString(2, j.getQuadra());
			stmt.setInt(3, j.getGaveta());
			stmt.setInt(4, j.getNumero());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	
	public void atualizar(Jazigo j) throws DAOException {
		String sql = "UPDATE jazigo SET rua = ?,"
				+ " quadra = ?,  gaveta = ?,  numero = ? WHERE codigo = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, j.getRua());
			stmt.setString(2, j.getQuadra());
			stmt.setInt(3, j.getGaveta());
			stmt.setInt(4, j.getNumero());
			stmt.setInt(5, j.getCodigo());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	
	public boolean deletar(int codigo) throws DAOException {
		boolean deletado = false;
		String sql = "DELETE FROM jazigo WHERE codigo = ?";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, codigo);
			stmt.execute();
			stmt.executeUpdate();
			// stmt.close();
			deletado = true;

		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return deletado;
	}

	
	public List<Jazigo> pesquisar(int numeroJazigo) throws DAOException {
		String sql = "SELECT * FROM jazigo WHERE numero like ? ";
		List<Jazigo> jazigos = new ArrayList<Jazigo>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + numeroJazigo + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Jazigo j = new Jazigo();
				j.setCodigo(rs.getInt("codigo"));
				j.setRua(rs.getString("rua"));
				j.setQuadra(rs.getString("quadra"));
				j.setGaveta(rs.getInt("gaveta"));
				j.setNumero(rs.getInt("numero"));
				j.setDono(rs.getString("dono"));
				jazigos.add(j);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return jazigos;

	}

	
	public Jazigo pesquisarUmJazigo(int numeroJazigo) throws DAOException {
		Jazigo j = new Jazigo();
		String sql = "SELECT * FROM jazigo WHERE numero like ? ";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + numeroJazigo + "%");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				j.setRua(rs.getString("rua"));
				j.setQuadra(rs.getString("quadra"));
				j.setGaveta(rs.getInt("gaveta"));
				j.setNumero(rs.getInt("numero"));
				j.setDono(rs.getString("dono"));
				j.setCodigo(rs.getInt("codigo"));
				

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return j;

	}


	@Override
	public List<Jazigo> pesquisarRua(String rua) throws DAOException {
		String sql = "SELECT * FROM jazigo WHERE numero rua ? ";
		List<Jazigo> jazigos = new ArrayList<Jazigo>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + rua + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Jazigo j = new Jazigo();
				j.setCodigo(rs.getInt("codigo"));
				j.setRua(rs.getString("rua"));
				j.setQuadra(rs.getString("quadra"));
				j.setGaveta(rs.getInt("gaveta"));
				j.setNumero(rs.getInt("numero"));
				j.setDono(rs.getString("dono"));
				jazigos.add(j);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return jazigos;
	}


	@Override
	public void atualizarDono(Jazigo j) throws DAOException {
		String sql = "UPDATE jazigo SET dono = ? WHERE codigo = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			//stmt.setString(1, j.getRua());
			//stmt.setString(2, j.getQuadra());
			//stmt.setInt(3, j.getGaveta());
			//stmt.setInt(4, j.getNumero());
			stmt.setString(1, j.getDono());
			stmt.setInt(2, j.getCodigo());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		
	}


	@Override
	public List<Jazigo> pesquisarDono(String dono) throws DAOException {
		String sql = "SELECT * FROM jazigo WHERE numero dono ? ";
		List<Jazigo> jazigos = new ArrayList<Jazigo>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + dono + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Jazigo j = new Jazigo();
				j.setCodigo(rs.getInt("codigo"));
				j.setRua(rs.getString("rua"));
				j.setQuadra(rs.getString("quadra"));
				j.setGaveta(rs.getInt("gaveta"));
				j.setNumero(rs.getInt("numero"));
				j.setDono(rs.getString("dono"));
				jazigos.add(j);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return jazigos;
	}
}
