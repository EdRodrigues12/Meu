package entidades;

public class Dono {
	private int id;
	private String cpf;
	private String nome;
	private int codJazigo;
	private Jazigo jazigo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Jazigo getJazigo() {
		return jazigo;
	}
	public void setJazigo(Jazigo jazigo) {
		this.jazigo = jazigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodJazigo() {
		return codJazigo;
	}
	public void setCodJazigo(int codJazigo) {
		this.codJazigo = codJazigo;
	}
	
	

}
