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
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void atualizar(Dono d) throws DAOException {
		String sql = "UPDATE dono SET cpf = ?,"
				+ " nome = ?,codigoJazigo = ? WHERE id = ?";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, d.getCpf());
			stmt.setString(2, d.getNome());
			stmt.setInt(3, d.getCodJazigo());
			stmt.setInt(4, d.getId());
			stmt.executeUpdate();
			stmt.close();
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
			stmt.close(); 
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
				d.setId( rs.getInt("id") );
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				d.setCodJazigo(rs.getInt("codigoJazigo"));
				donos.add(d);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return donos;
	}

	@Override
	public List<Dono> pesquisarDonoCpf(String cpf) throws DAOException {
		String sql = "SELECT * FROM dono WHERE cpf like ? ";
		List<Dono> donos = new ArrayList<Dono>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpf + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Dono d = new Dono();
				d.setId( rs.getInt("id") );
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				d.setCodJazigo(rs.getInt("codigoJazigo"));
				donos.add(d);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return donos;
	}

	@Override
	public boolean deletarJazigo(int codigo) throws DAOException {
		boolean deletado = false;
		String sql = "DELETE FROM dono WHERE codigoJazigo = ?";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, codigo);
			stmt.execute();
			stmt.executeUpdate();
			// stmt.close();
			deletado = true;
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return deletado;
	}

	@Override
	public List<DonoJazigo> pesquisarJazigo(String dono) throws DAOException {
		System.out.println(""+dono);
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
				
				d.setCpf(rs.getString(1));
				d.setNome(rs.getString(2));
				d.setCodigo(rs.getInt(3));
				d.setRua(rs.getString(4));
				d.setQuadra(rs.getString(5));
				d.setGaveta(rs.getInt(6));
				d.setNumero(rs.getInt(7));
				donos.add(d);
				System.out.println(""+donos);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return donos;
		
	}

	@Override
	public Dono pesquisar1(String cpf) throws DAOException {
		String sql = "SELECT * FROM dono WHERE cpf like ? ";
		Dono d = new Dono();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpf + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				d.setId( rs.getInt("id") );
				d.setCpf(rs.getString("cpf"));
				d.setNome(rs.getString("nome"));
				d.setCodJazigo(rs.getInt("codigoJazigo"));
				
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return d;
	
	}
	
	
}
