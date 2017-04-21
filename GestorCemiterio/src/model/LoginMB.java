package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.DAOException;
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
	private boolean logado = false;

	public String adicionar() throws DAOExceptionLG {;
	    try{
		usuarioDao.adicionar(user);
		user = new Usuario();
	    FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso!", " "));
   		}catch(DAOExceptionLG e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar ", null));
	    	
	}
		return "";
	}

	public String pesquisar() throws DAOExceptionLG {
		try{
		String codigo = user.getId();
		user = new Usuario();
		user = usuarioDao.pesquisar(codigo);
		if(user.getId()== null){
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro, usuário não cadastrado ", " "));
		}
		}catch(DAOExceptionLG e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar ", null));
	    	
	}
		return "";
	}

	public String atualizar() throws DAOExceptionLG {
		try{
		usuarioDao.atualizar(user);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", " "));
   		
		}catch(DAOExceptionLG e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar ", null));
	    	
	}
		return "";
	}

	public String deletar() throws DAOExceptionLG {
		try{
		usuarioDao.excluir(user.getId());
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso", " "));
   		
		}catch(DAOExceptionLG e){
			e.printStackTrace();
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao deletar ", null));
	    	
	}
		return "";

	}
	
	public String logar() throws DAOExceptionLG{
		String pagina = "login";
		//user = usuarioDao.pesquisar(id);
		//try{
			if(usuarioDao.password(id) == null){
				logado = false;
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage msg =  new FacesMessage("Usuáio inválido","Usuário  "
						+ "inválido, tente novamentte");
				fc.addMessage("formBody:txtUsuario", msg);
			}
		  							 		
		//}
		//catch(DAOExceptionLG e){
			else if(usuarioDao.verificar(id)== true && 
					usuarioDao.password(id).equals(senha)){
					//if(usuarioDao.verNivel(user.getId()).equals("Administrador")){
			pagina = "index?faces-redirect=true";
			logado = true;
			}
													
				else if(usuarioDao.verificar(id)== true && usuarioDao.password(id)!= senha){
				logado = false;
				FacesContext fc = FacesContext.getCurrentInstance();
				FacesMessage msg = new FacesMessage("Senha inválida","Senha  "
						+ "inválida, tente novamentte");
				fc.addMessage("formBody:txtSenha", msg);
				}
			//}
		
			
		
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
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	

}
