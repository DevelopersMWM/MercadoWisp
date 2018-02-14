package mx.com.mwisp.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.PrimeFacesContext;
import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Controller;
//import org.primefaces.PrimeFaces;

import mx.com.mwisp.util.SessionUtils;


//import org.primefaces.component.ajaxstatus.*;

@ManagedBean
@RequestScoped
public class UserLoginView {

	private String username;
    
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) throws IOException{
        FacesMessage message = null;
        boolean loggedIn = false;
        String url="faces/admin/index.xhtml";
         
        if(username != null && username.equals("Miguel") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenidos", username);
            
            FacesContext fc=FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect(url);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de logueo", "Credenciales Invalidas");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext requestContext=RequestContext.getCurrentInstance();
        requestContext.addCallbackParam("loggedIn", loggedIn);
        
        
 //redirecciona la página
        //PrimeFacesContext.getCurrentInstance().addMessage("", loggedIn);
        //PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }
    public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}
