package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Velorio;

public class VelorioDAOImpl implements VelorioDAO {

	@Override
	public void adicionar(Velorio v) throws DAOException {
		String sql = "INSERT INTO velorio (cpfFalecido,nomeFalecido, cpfDeclarante, nomeDeclarante, sala, dia, hora) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			
			stmt.setString(1, v.getCpfFalecido());
			stmt.setString(2, v.getNomeFalecido());
			stmt.setString(3, v.getCpfDeclarante());
			stmt.setString(4, v.getNomeDeclarante());
			stmt.setInt(5, v.getSala());				
			java.sql.Date dex = new java.sql.Date(v.getDia().getTime());
			stmt.setDate(6, dex);
			java.sql.Timestamp hf = new java.sql.Timestamp(v.getHora().getTime());
			stmt.setTimestamp(7, hf);
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void atualizar(Velorio v) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Velorio> pesquisarD(Date dia) throws DAOException {
		String sql = "SELECT * FROM velorio WHERE dia like ? ";
		List<Velorio> velorios = new ArrayList<Velorio>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + dia + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Velorio v = new Velorio();
				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setHora(rs.getDate("hora"));
				v.setSala(rs.getInt("sala"));
				velorios.add(v);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return velorios;
	}

	@Override
	public List<Velorio> pesquisarS(int sala) throws DAOException {
		String sql = "SELECT * FROM velorio WHERE sala like ? ";
		List<Velorio> velorios = new ArrayList<Velorio>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + sala + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Velorio v = new Velorio();
				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setHora(rs.getDate("hora"));
				v.setSala(rs.getInt("sala"));
				velorios.add(v);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return velorios;
	}

	@Override
	public List<Velorio> pesquisarH(Date hora) throws DAOException {
		String sql = "SELECT * FROM velorio WHERE hora like ? ";
		List<Velorio> velorios = new ArrayList<Velorio>();
		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + hora + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Velorio v = new Velorio();
				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setHora(rs.getDate("hora"));
				v.setSala(rs.getInt("sala"));
				velorios.add(v);
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return velorios;
	}

	@Override
	public Velorio pesquisar1(String cpfFalecido) throws DAOException {
		Velorio v = new Velorio();
		String sql = "SELECT * FROM velorio WHERE cpfFalecido like ? ";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpfFalecido + "%");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setHora(rs.getDate("hora"));
				v.setSala(rs.getInt("sala"));
				

			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return v;
	}

	@Override
	public Velorio pesquisarDec(String cpfDeclarante) throws DAOException {
		Velorio v = new Velorio();
		String sql = "SELECT * FROM velorio WHERE cpfDeclarante like ? ";

		try {
			Connection con = DBResourceManager.getInstance().getCon();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "%" + cpfDeclarante + "%");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				v.setCpfFalecido(rs.getString("cpfFalecido"));
				v.setCpfDeclarante(rs.getString("cpfDeclarante"));
				v.setNomeDeclarante(rs.getString("nomeDeclarante"));
				v.setNomeFalecido(rs.getString("nomeFalecido"));
				v.setDia(rs.getDate("dia"));
				v.setHora(rs.getDate("hora"));
				v.setSala(rs.getInt("sala"));
				

			}
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
		return v;
	}

}
