package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Dono;


public class DonoDAOImpl implements DonoDAO {

	@Override
	public void adicionar(Dono d) throws DAOException {
		String sql = "INSERT INTO dono (cpf, nome) VALUES (?, ?)";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, d.getCpf());
			stmt.setString(2, d.getNome());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void atualizar(Dono d) throws DAOException {
		String sql = "UPDATE dono SET cpf = ?,"
				+ " nome = ? WHERE cpf = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, d.getCpf());
			stmt.setString(2, d.getNome());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public boolean deletar(String cpf) throws DAOException {
		boolean deletado = false;
		String sql = "DELETE FROM dono WHERE cpf = ?";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);
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

	@Override
	public List<Dono> pesquisar(String dono) throws DAOException {
		String sql = "SELECT * FROM dono WHERE cpf like ? ";
		List<Dono> donos = new ArrayList<Dono>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + dono + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Dono d = new Dono();
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				donos.add(d);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return donos;
	}

	@Override
	public Dono pesquisarDonoCpf(String cpf) throws DAOException {
		Dono d = new Dono();
		String sql = "SELECT * FROM dono WHERE cpf like ? ";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpf + "%");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return d;
	}

	@Override
	public boolean deletarJazigo(int codigo) throws DAOException {
		boolean deletado = false;
		String sql = "DELETE FROM dono WHERE codJazigo = ?";

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
	
	
}
