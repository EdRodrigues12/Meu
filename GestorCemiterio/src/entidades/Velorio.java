package entidades;

import java.util.Date;

public class Velorio {
	
	private String cpfFalecido;
	private String nomeFalecido;
	private String cpfDeclarante;
	private String nomeDeclarante;
	private int sala;
	private Date dia;
	private Date hora;
	
	public String getCpfFalecido() {
		return cpfFalecido;
	}
	public void setCpfFalecido(String cpfFalecido) {
		this.cpfFalecido = cpfFalecido;
	}
	public String getNomeFalecido() {
		return nomeFalecido;
	}
	public void setNomeFalecido(String nomeFalecido) {
		this.nomeFalecido = nomeFalecido;
	}
	public String getCpfDeclarante() {
		return cpfDeclarante;
	}
	public void setCpfDeclarante(String cpfDeclarante) {
		this.cpfDeclarante = cpfDeclarante;
	}
	public String getNomeDeclarante() {
		return nomeDeclarante;
	}
	public void setNomeDeclarante(String nomeDeclarante) {
		this.nomeDeclarante = nomeDeclarante;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	

}
