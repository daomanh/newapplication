/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import model.AccountDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class Login {

    public Login() {
    }
    private int aId;
    private String username;
    private String password;
    private String firstName;
    private String arId;
    private String arName;
    private int aIdSession;
    private String message;

    public int getAId() {
        return aId;
    }

    public void setAId(int aId) {
        this.aId = aId;
    }

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

    public String getAFirstName() {
        return firstName;
    }

    public void setAFirstName(String aFirstName) {
        this.firstName = aFirstName;
    }

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }

    public int getAIdSession() {
        return aIdSession;
    }

    public void setAIdSession(int aIdSession) {
        this.aIdSession = aIdSession;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String index() {
        this.message = null;
        return "login?faces-redirect=true";
    }

    public String login() {
//        aIdSession = AccountDataAccess.getAccountByaUsername(username).getArId();
//        if (aIdSession == 3 && "TrongAn".equals(username)) {
//            return "main?faces-redirect=true";
//        }
        if (username != null && !username.trim().isEmpty() && password != null && !password.trim().isEmpty()) {
            if (AccountDataAccess.CheckAccountExistence(username, password)) {
                aIdSession = AccountDataAccess.getAccountByaUsername(username).getArId();
                System.out.println("asdasdasdasdada"+ aIdSession);
                aId = AccountDataAccess.getAccountByaUsername(username).getaId();
                if (aIdSession == 3) {
                    return "AsCL/mainCL?faces-redirect=true";
                } else if (aIdSession == 4) {
                    return "AsCM/mainCM?faces-redirect=true";
                }else if(aIdSession == 2){
                    return "AsDLT/mainDLT?faces-redirect=true";
                }else if(aIdSession == 1){
                    return "AsPVC/mainPVC?faces-redirect=true";
                }else {
                    return "main?faces-redirect=true";
                }
            } else {
                message = "This account doesn't exitst !";
                return "login?faces-redirect=true";
            }
        }
        message = "Please fill all the blank!";
        return "login?faces-redirect=true";
    }
    private String pathInfo;

    public String getPathInfo() {
        return pathInfo;
    }

    public void setPathInfo(String pathInfo) {
        this.pathInfo = pathInfo;
    }

    public String getAutoLogin() {
        if (aIdSession == 0) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();

                pathInfo = context.getExternalContext().getRequestPathInfo();
                String contextPath = context.getExternalContext().getRequestContextPath();
                ((HttpServletResponse) context.getExternalContext().getResponse()).sendRedirect(contextPath + "/faces/index.xhtml?faces-redirect=true");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    public String logout() {
        username = null;
        message = null;
        password = null;
        arId = null;
        aIdSession = 0;
        return "main?faces-redirect=true";
    }
}
