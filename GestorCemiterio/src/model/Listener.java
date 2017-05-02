package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Listener implements PhaseListener {
	private static final long serialVersionUID = 3549101153061073955L;

	@Override
	public void afterPhase(PhaseEvent e) {

		List<String> lstPaginas = new ArrayList<String>();
		lstPaginas.add("/index.xhtml");
		lstPaginas.add("/Login.xhtml");
		lstPaginas.add("/menuAdmin.xhtml");
		lstPaginas.add("/menuCola.xhtml");
		lstPaginas.add("/menuDecla.xhtml");
		lstPaginas.add("/menuFal.xhtml");
		lstPaginas.add("/menuJaz.xhtml");
		lstPaginas.add("/menuRela.xhtml");
		lstPaginas.add("/menuVelo.xhtml");
		lstPaginas.add("/pesquisarColaborador.xhtml");
		lstPaginas.add("/pesquisarDeclarante.xhtml");
		lstPaginas.add("/pesquisarDono.xhtml");
		lstPaginas.add("pesquisarFalecido.xhtml");
		lstPaginas.add("/pesquisarJazigo.xhtml");
		lstPaginas.add("pesquisarUsuario.xhtml");
		lstPaginas.add("/acessoNegado.xhtml");

		FacesContext fc = FacesContext.getCurrentInstance();
		String nomePagina = fc.getViewRoot().getViewId();

		if (!"/Login.xhtml".equals(nomePagina)) {
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(fc, "#{loginMB}", LoginMB.class);
			if (login.isLogado()) {
				System.out.println("oioioi" + login.isAdministrador());
				if (!login.isAdministrador()) {
					if (!lstPaginas.contains(nomePagina)) {
						fc.addMessage("formBody", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Acesso negado!",
								"Área restrita para administradores!"));
						NavigationHandler nav = app.getNavigationHandler();
						nav.handleNavigation(fc, "", "acessoNegado?faces-redirect=true");
						fc.renderResponse();
					}
				}
				// System.out.println("Usuario logado pode prosseguir");
			} else {
				System.out.println("Usuario não logado direcionando para a pagina ./login.xhtml");
				NavigationHandler nav = app.getNavigationHandler();
				nav.handleNavigation(fc, "", "Login?faces-redirect=true");
				fc.renderResponse();
			}

		}
	}

	@Override
	public void beforePhase(PhaseEvent e) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
