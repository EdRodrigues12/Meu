package model;

import java.io.ByteArrayInputStream;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;


import dao.DAOException;
import dao.FalecidoDAO;
import dao.FalecidoDAOImpl;
import dao.JazigoDAO;
import dao.JazigoDAOImpl;

import entidades.Falecido;
import entidades.Jazigo;


@ManagedBean
@SessionScoped
public class FalecidoMB {
	private HtmlInputText nomeText = new HtmlInputText();
	private FalecidoDAO falecidoDao = new FalecidoDAOImpl();
	private Falecido falecido = new Falecido();
	private List<Falecido> lista = new ArrayList<Falecido>();
	private JazigoDAO jazigoDao = new JazigoDAOImpl();
	private Jazigo jazigo = new Jazigo();
	private List<Jazigo> list = new ArrayList<Jazigo>();
	private StreamedContent imagem;
	private String dono;
	
	public String adicionar() throws DAOException {;
		falecidoDao.adicionar(falecido);
		falecido = new Falecido();
		imagem = new DefaultStreamedContent();
		return "";
	}

	public String pesquisar() throws DAOException {
		String codigo = falecido.getCpf();
		int num = falecido.getCodJazigo();
		jazigo = new Jazigo();
	    jazigo = jazigoDao.pesquisarUmJazigo(num);
		falecido = new Falecido();
		imagem = new DefaultStreamedContent();
		falecido = falecidoDao.pesquisar1(codigo);
		falecido.setFoto(falecido.getFoto());
	    imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
	    
		return "";
	}

	public String atualizar() throws DAOException {
		falecidoDao.atualizar(falecido);
		imagem = new DefaultStreamedContent();
		return "";
	}

	public String deletar() throws DAOException {
		falecidoDao.deletar(falecido.getCpf());
		return "";

	}
	
	public String carregaJazigos() throws DAOException{
		//int codigo = falecido.getCodJazigo();
		//int txtNumero = (int) nomeText.getValue();
		//setList(jazigoDao.pesquisarDono(dono));
		return "";
		
	}
	
	public String calcularExumacao(int idade){
		System.out.println(" teste");
		// idade = falecido.getIdade();
		//if(idade > 6){
			int dias = 62;
	        Date date = new Date();
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        System.out.println(c.getTime());
	        c.add(Calendar.DAY_OF_YEAR, dias);
	        System.out.println(" teste"+c.getTime());
			//falecido.setDtExumacao(c) ;
			
		//}
		
		return "";
	}
	 
	
	public void handleFileUpload(FileUploadEvent event) {
		 try {
		 imagem = new DefaultStreamedContent(event.getFile().getInputstream());
		 byte[] foto = event.getFile().getContents();
		 this.falecido.setFoto(foto);
		 } catch (IOException ex) {
		 Logger.getLogger(FalecidoMB.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 UploadedFile uploadedFile = event.getFile();
		 String fileNameUploaded = uploadedFile.getFileName(); 
         long fileSizeUploaded = uploadedFile.getSize(); 
         String infoAboutFile = "<br/> Arquivo recebido: <b>" +fileNameUploaded              		+"</b><br/>"+
             "Tamanho do Arquivo: <b>"+fileSizeUploaded+"</b>";
         FacesContext facesContext = FacesContext.getCurrentInstance();
         facesContext.addMessage(null, new FacesMessage("Sucesso", 			                                                                       infoAboutFile));

		 }
	
	public void buscaFoto() {
		 
		 falecido.setFoto(falecido.getFoto());
		 imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
		 }
	
	public void limpaImagem() {
		 this.imagem = new DefaultStreamedContent();
		 }
	
	
	public Falecido getFalecido() {
		return falecido;
	}

	public void setFalecido(Falecido falecido) {
		this.falecido = falecido;
	}

	public List<Falecido> getLista() {
		return lista;
	}

	public void setLista(List<Falecido> lista) {
		this.lista = lista;
	}

	public Jazigo getJazigo() {
		return jazigo;
	}

	public void setJazigo(Jazigo jazigo) {
		this.jazigo = jazigo;
	}

	public List<Jazigo> getList() {
		return list;
	}

	public void setList(List<Jazigo> list) {
		this.list = list;
	}

	public StreamedContent getImagem() {
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

	public HtmlInputText getNomeText() {
		return nomeText;
	}

	public void setNomeText(HtmlInputText nomeText) {
		this.nomeText = nomeText;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	


	
	

}
