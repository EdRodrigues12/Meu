package model;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.DAOExceptionLG;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;

@ManagedBean
@SessionScoped
public class LoginMB {

	private String id;
	private String senha;
	private boolean logado = false;
	private boolean administrador = false;

	public String logar() throws DAOExceptionLG {
		String pagina = "login";
		UsuarioDAO dao = new UsuarioDAOImpl();

		if (dao.autenticarLogin(id, senha)) {
			pagina = "index?faces-redirect=true";
			logado = true;

			if (dao.verNivel(id).equals("Administrador")) {
				administrador = true;
			}

		} else {
			logado = false;

			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("formBody", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha de autenticação!",
					"Usuário ou senha incorretos!"));
			// fc.addMessage("formBody:txtSenha", new
			// FacesMessage(FacesMessage.SEVERITY_WARN,"",""));

		}

		id = "";
		senha = "";

		return pagina;
	}

	public String doLogout() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		sessao.invalidate();

		return "login?faces-redirect=true";

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public boolean isAdmin() {
		return administrador;
	}

	public void setAdmin(boolean admin) {
		this.administrador = admin;
	}

}
