/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.CourseDataAccess;
import model.FacultyDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class DeleteFaculty {

    private int fId; 
    private String m;

    public int getFId() {
        return fId;
    }

    public void setFId(int fId) {
        this.fId = fId;
    }
    
    @ManagedProperty(value = "#{listFaculty}")
    private ListFaculty listFaculty;

    public ListFaculty getListFaculty() {
        return listFaculty;
    }

    public void setListFaculty(ListFaculty listFaculty) {
        this.listFaculty = listFaculty;
    }

   

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    
    
    public void deleteFaculty() {
        m="";
        if(FacultyDataAccess.deleteAFaculty(fId)){
            listFaculty.index();
        }
        m="Fail to delete";
        listFaculty.index();
    }
    
}
