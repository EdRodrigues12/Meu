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
	private Date dtExumacao;
	private String dono;
	private String cep = null;
	 
    private String tipoendereco;
    private String endereco;
    private String uf;
    private String cidade;
    private String bairro;
	
	

	public String buscaCEP(){
		System.out.println(cep);
		WebServiceCep webServiceCep = WebServiceCep.searchCep(getCep());
      
        if (webServiceCep.wasSuccessful()) {
        	//setTipoendereco(webServiceCep.getTipoendereco());
            setEndereco(webServiceCep.getLogradouroFull());
            setUf(webServiceCep.getUf());
            setCidade(webServiceCep.getCidade());
            setBairro(webServiceCep.getBairro());
        	
//        	falecido.setEndereco(webServiceCep.getLogradouroFull());
//        	falecido.setUf(webServiceCep.getUf());
//        	falecido.setCidade(webServiceCep.getCidade());
//        	falecido.setBairro(webServiceCep.getBairro());
            //falecido.setCep(cep);
           // System.out.println(cep);
            System.out.println(falecido.getEndereco());
            

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cep Encontrado!", " "));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cep Não Encontrado ", null));
        }
		return "";
		
		
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String adicionar() throws DAOException {
		
		//falecido = new Falecido();
		falecidoDao.adicionar(falecido);
		
		imagem = new DefaultStreamedContent();
		falecido = new Falecido();
		return "";
	}

	public String pesquisar() throws DAOException {
		//falecido = new Falecido();
		String codigo = falecido.getCpf();
		int num = falecido.getCodJazigo();
		jazigo = new Jazigo();
	    jazigo = jazigoDao.pesquisarUmJazigo(num);
		falecido = new Falecido();
		imagem = new DefaultStreamedContent();
		falecido = falecidoDao.pesquisar1(codigo);
		falecido.setFoto(falecido.getFoto());
	    imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
	   // falecido = new Falecido();
		return "";
	}
	public String pesquisarPorNome() throws DAOException{
		//falecido = new Falecido();
		imagem = new DefaultStreamedContent();
		setLista(falecidoDao.pesquisar(falecido.getNome()));
		falecido = new Falecido();
//		falecido.setFoto(falecido.getFoto());
//	    imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
		//falecido = new Falecido();
		return "";
	}
	
	public String ver(Falecido f) { 
		//falecido = new Falecido();
		falecido = f;
		imagem = new DefaultStreamedContent();
		falecido.setFoto(falecido.getFoto());
	    imagem = new DefaultStreamedContent(new ByteArrayInputStream(falecido.getFoto()));
	   // falecido = new Falecido();
		System.out.println("Botao Editar do taxista " + f.getNome() + " foi pressionado");
		return "";
	}

	public String atualizar() throws DAOException {
		System.out.println(" teste");
		//falecido = new Falecido();
		falecidoDao.atualizar(falecido);
		System.out.println(falecido.getNome());
		falecido = new Falecido();
		imagem = new DefaultStreamedContent();
		return "";
	}

	public String deletar() throws DAOException {
		//falecido = new Falecido();
		System.out.println(" teste");
		falecidoDao.deletar(falecido.getCpf());
		falecido = new Falecido();
		return "";

	}
	
	public String carregaJazigos() throws DAOException{
		System.out.println(" teste");
		//int codigo = falecido.getCodJazigo();
		//int txtNumero = (int) nomeText.getValue();
		//setList(jazigoDao.pesquisarDono(dono));
		return "";
		
	}
	
	public void calcularExumacao(/*int idade*/)throws DAOException{
		System.out.println(" teste");
		
		int idade = falecido.getIdade();
		  
		 if(idade > 6){
			int dias = 62;
	        Date date = new Date();
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        System.out.println(c.getTime());
	        c.add(Calendar.DAY_OF_YEAR, dias);
	        System.out.println(" teste"+c.getTime());
			//falecido.setDtExumacao(c) ;
			
		}else{
			System.out.println(" teste");
		}
		
		//return "";
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

	public Date getDtExumacao() {
		return dtExumacao;
	}

	public void setDtExumacao(Date dtExumacao) {
		this.dtExumacao = dtExumacao;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}
	public String getTipoendereco() {
		return tipoendereco;
	}

	public void setTipoendereco(String tipoendereco) {
		this.tipoendereco = tipoendereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


}
