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
public class AccountRole {

    private int arId;
    private String arName;

    public AccountRole() {
    }

    public AccountRole(int arId, String arName) {
        this.arId = arId;
        this.arName = arName;
    }

    public AccountRole(String arName) {
        this.arName = arName;
    }

    public int getArId() {
        return arId;
    }

    public void setArId(int arId) {
        this.arId = arId;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }
    
}
