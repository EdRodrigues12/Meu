package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Dono;
import entidades.DonoJazigo;



public class DonoDAOImpl implements DonoDAO {

	@Override
	public void adicionar(Dono d) throws DAOException {
		String sql = "INSERT INTO dono (cpf, nome,codigoJazigo) VALUES (?, ?, ?)";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, d.getCpf());
			stmt.setString(2, d.getNome());
			stmt.setInt(3, d.getCodJazigo());

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
				+ " nome = ?,codigoJazigo = ? WHERE cpf = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, d.getCpf());
			stmt.setString(2, d.getNome());
			stmt.setInt(3, d.getCodJazigo());
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
		String sql = "SELECT * FROM dono WHERE nome like ? ";
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
				d.setCodJazigo(rs.getInt("codigoJazigo"));
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
				d.setCodJazigo(rs.getInt("codigoJazigo"));

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

	@Override
	public List<DonoJazigo> pesquisarJazigo(String dono) throws DAOException {
		String sql = "SELECT cpf,nome,codigo, rua, quadra, gaveta,numero "
				+ "FROM dono INNER JOIN jazigo on codigoJazigo = codigo WHERE nome LIKE ?";
		List<DonoJazigo> donos = new ArrayList<DonoJazigo>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + dono + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				DonoJazigo d = new DonoJazigo();
				
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				d.setCodigo(rs.getInt("codigo"));
				d.setRua(rs.getString("rua"));
				d.setQuadra(rs.getString("quadra"));
				d.setGaveta(rs.getInt("gaveta"));
				d.setNumero(rs.getInt("numero"));
				donos.add(d);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return donos;
	}
	
	
}
