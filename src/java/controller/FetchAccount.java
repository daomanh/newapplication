/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Account;
import model.AccountDataAccess;


/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class FetchAccount {
    public ArrayList<Account> getCL() {
        return AccountDataAccess.getAccountByaRole(3);
    }
    public ArrayList<Account> getCMR() {
        return AccountDataAccess.getAccountByaRole(4);
    }
    public ArrayList<Account> getDLT() {
        return AccountDataAccess.getAccountByaRole(2);
    }
       public ArrayList<Account> getPVC() {
        return AccountDataAccess.getAccountByaRole(1);
    }
}
