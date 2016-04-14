/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class ListFaculty {

    /**
     * Creates a new instance of CourseList
     */
    public ListFaculty() {
    }

    private ArrayList<Faculty> facultyList = new ArrayList<>();
    private String fName;

    public ArrayList<Faculty> getFacultyList() {
       facultyList = FacultyDataAccess.getAllFacultys();
        return facultyList;
    }

    public void setFacultyList(ArrayList<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String index() {
        facultyList = FacultyDataAccess.getAllFacultys();
        return "listFaculty?faces-redirect=true";
    }


}
