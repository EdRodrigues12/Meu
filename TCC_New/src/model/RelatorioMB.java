package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;



import dao.DAOException;
import dao.DBResourceManager;
import dao.JazigoDAO;
import dao.JazigoDAOImpl;
import entidades.Jazigo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;


@ManagedBean
@SessionScoped
public class RelatorioMB {
	
	private JazigoDAO jazigoDao = new JazigoDAOImpl();
	private Jazigo jazigo = new Jazigo();
	private List<Jazigo> lista = new ArrayList<Jazigo>();
	String rua;
	public String pesquisar() throws DAOException {
		setLista(jazigoDao.pesquisarRua(jazigo.getRua()));
		return "";
	}
	
	public void geraJazigo() throws IOException, ClassNotFoundException, SQLException{
		 FacesContext facesContext = FacesContext.getCurrentInstance();
	        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		String erro = "";
		
		String jasper = "WEB-INF/reports/DataExumacao.jasper";
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("rua",this.rua);
		byte[]bytes = null;
		ServletContext contexto = (ServletContext)facesContext.getExternalContext().getContext();;
		
		try {
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile
			(contexto.getRealPath(jasper));
			bytes = JasperRunManager.runReportToPdf(relatorio, param, new DBResourceManager().getCon());
		} catch (JRException e) {
		
			e.printStackTrace();
		}finally{
			if(bytes != null){
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream sos = response.getOutputStream();
				sos.write(bytes);
				sos.flush();
				sos.close();
			}else{
				
				
			}
		}
		
	}
		

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Jazigo getJazigo() {
		return jazigo;
	}
	public void setJazigo(Jazigo jazigo) {
		this.jazigo = jazigo;
	}
	public List<Jazigo> getLista() {
		return lista;
	}
	public void setLista(List<Jazigo> lista) {
		this.lista = lista;
	}
	
	
	
}
