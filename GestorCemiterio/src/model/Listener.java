package model;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Listener implements PhaseListener {
	private static final long serialVersionUID = 3549101153061073955L;
	@Override
	public void afterPhase(PhaseEvent e) {
		System.out.println("After Phase sendo executado para a Fase : " + e.getPhaseId());	
		FacesContext fc = FacesContext.getCurrentInstance();
		String nomePagina = fc.getViewRoot().getViewId();
		System.out.println( "Pagina acessada : " + nomePagina);
		
		if (! "/Login.xhtml".equals( nomePagina )) {
			Application app = fc.getApplication();
			LoginMB login = app.evaluateExpressionGet(
					fc, "#{loginMB}", LoginMB.class);
			if (login.isLogado()) { 
				System.out.println("Usuario logado pode prosseguir");
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
