/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class Account {

    public int aId;
    public int arId;  
    public String aFirstName;
    public String aLastName;
    public String aUsername;
    public String aPassword;
    public String aEmail;
    public String aAddress;

    public Account() {
    }

    public Account(int arId,  String aFirstName, String aLastName, String aUsername, String aPassword, String aEmail, String aAddress) {
        this.arId = arId;
        this.aFirstName = aFirstName;
        this.aLastName = aLastName;
        this.aUsername = aUsername;
        this.aPassword = aPassword;
        this.aEmail = aEmail;
        this.aAddress = aAddress;
    }

    public Account(int aId, int arId, String aFirstName, String aLastName, String aUsername, String aPassword, String aEmail, String aAddress) {
        this.aId = aId;
        this.arId = arId;
        this.aFirstName = aFirstName;
        this.aLastName = aLastName;
        this.aUsername = aUsername;
        this.aPassword = aPassword;
        this.aEmail = aEmail;
        this.aAddress = aAddress;
    }

    
    

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getArId() {
        return arId;
    }

    public void setArId(int arId) {
        this.arId = arId;
    }

    public String getaFirstName() {
        return aFirstName;
    }

    public void setaFirstName(String aFirstName) {
        this.aFirstName = aFirstName;
    }

    public String getaLastName() {
        return aLastName;
    }

    public void setaLastName(String aLastName) {
        this.aLastName = aLastName;
    }

    public String getaEmail() {
        return aEmail;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public String getaUsername() {
        return aUsername;
    }

    public void setaUsername(String aUsername) {
        this.aUsername = aUsername;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }
    
    
    
}
