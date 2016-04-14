/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author nguyen
 */
@ManagedBean
@SessionScoped
public class SearchFaculty {
private ArrayList<Faculty> listFaculty = new ArrayList<>();
    private String key;
    /**
     * Creates a new instance of SearchMusic
     */
    public SearchFaculty() {
        
    }

    public ArrayList<Faculty> getListFaculty() {
        return listFaculty;
    }

    public void setListFaculty(ArrayList<Faculty> listFaculty) {
        this.listFaculty = listFaculty;
    }

    

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String searchFaculty() {
        listFaculty = FacultyDataAccess.SearchFaculty(key);
       key = null;
        return "SearchFaculty?faces-redirect=true";
        
    }
}
