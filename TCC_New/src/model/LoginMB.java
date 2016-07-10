package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.DAOExceptionLG;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidades.Usuario;



@ManagedBean
@SessionScoped
public class LoginMB {
	
	private UsuarioDAO usuarioDao = new UsuarioDAOImpl();
	private Usuario user = new Usuario();
	private List<Usuario> lista = new ArrayList<Usuario>();
	private String id;
	private String senha;

	public String adicionar() throws DAOExceptionLG {;
		usuarioDao.adicionar(user);
		user = new Usuario();
		return "";
	}

	public String pesquisar() throws DAOExceptionLG {
		String codigo = user.getId();
		user = new Usuario();
		user = usuarioDao.pesquisar(codigo);
		return "";
	}

	public String atualizar() throws DAOExceptionLG {
		usuarioDao.atualizar(user);
		return "";
	}

	public String deletar() throws DAOExceptionLG {
		usuarioDao.excluir(user.getId());
		return "";

	}
	
	public String logar() throws DAOExceptionLG{
		String pagina = "login";
		
		if(usuarioDao.verificar(id)==true && 
				usuarioDao.password(id).equals(senha)){
				//if(usuarioDao.verNivel(user.getId()).equals("Administrador")){
		pagina = "Index?faces-redirect=true";
	
		}else{
			
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Usuario ou Senha inválidos","Usuário ou "
					+ "Senha inválidos, tente novamentte");
			         fc.addMessage("formBody", msg);
			if(! usuarioDao.password(id).equals(senha)){
				msg = new FacesMessage("Senha inválida","Senha  "
						+ "inválida, tente novamentte");
				fc.addMessage("formBody:txtSenha", msg);
			} else { 
				if(! usuarioDao.verificar(id)==true){
					msg = new FacesMessage("Senha inválida","Senha  "
							+ "inválida, tente novamentte");
					fc.addMessage("formBody:txtUsuario", msg);
				}
				
			}
		}
		return pagina;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
