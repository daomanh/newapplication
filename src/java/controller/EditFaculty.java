/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.CourseDataAccess;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author thanh
 */
@ManagedBean
@SessionScoped
public class EditFaculty {
    public int fId;
    public String fName;
    public Faculty faculty;
    public int aIdDLT;
    public int aIdPVC;
    public String m;

    public int getAIdDLT() {
        return aIdDLT;
    }

    public void setAIdDLT(int aIdDLT) {
        this.aIdDLT = aIdDLT;
    }

    public int getAIdPVC() {
        return aIdPVC;
    }

    public void setAIdPVC(int aIdPVC) {
        this.aIdPVC = aIdPVC;
    }

    public int getFId() {
        return fId;
    }

    public void setFId(int fId) {
        this.fId = fId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
   public String editIndex() throws SQLException {
//        course = CourseDataAccess.getCourseBycId(cId);
        faculty = FacultyDataAccess.getFacultyByfId(fId).get(0);
        fName = faculty.getFName();
        aIdDLT = faculty.getaIdDLT();
        aIdPVC = faculty.getaIdPVC();
        
        return "editFaculty?faces-redirect=true";
    } 
   @ManagedProperty(value = "#{listFaculty}")
    private ListFaculty listFaculty;

    public ListFaculty getListFaculty() {
        return listFaculty;
    }

    public void setListFaculty(ListFaculty listFaculty) {
        this.listFaculty = listFaculty;
    }
   
    
    public String editFaculty() throws SQLException {
        m = null;

            if (null != fName && !fName.trim().isEmpty()) {
                faculty.setFName(fName);
                if (FacultyDataAccess.editFaculty(fName,aIdDLT,aIdPVC,fId)) {
                    m = "";
//                    listFaculty.index();
                    return "listFaculty?faces-redirect=true";
                    
                } else {
                    m = "Failed to add the faculty due to a system error !";
                    
                    return "editFaculty?faces-redirect=true";
                }
            } 
        m = "Please fill all the blank!'";
        return "editFaculty?faces-redirect=true";

    }
    
}
