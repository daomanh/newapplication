/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import model.Course;
import model.CourseDataAccess;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class AddFaculty {

    /**
     * Creates a new instance of AddCourse
     */
    public AddFaculty() {
    }

    public int fId;
    public String fName;
    public int dlt;
    public int pvc;

    private String m;

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

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public int getDlt() {
        return dlt;
    }

    public void setDlt(int dlt) {
        this.dlt = dlt;
    }

    public int getPvc() {
        return pvc;
    }

    public void setPvc(int pvc) {
        this.pvc = pvc;
    }

    public String index() {
        m = null;
        return "addFaculty?faces-redirect=true";
    }
    @ManagedProperty(value = "#{listFaculty}")
    private ListFaculty listFaculty;

    public ListFaculty getListFaculty() {
        return listFaculty;
    }

    public void setListFaculty(ListFaculty listFaculty) {
        this.listFaculty = listFaculty;
    }

    public String addFaculty() throws IOException {
        m = null;
           if (dlt == 0) { 
            m = "Please select Director of Learning and Quality";
              return "addFaculty?faces-redirect=true";
//            return "assignCourse?faces-redirect=true";
        }
        if (pvc == 0) {
            m = "Please select Pro-Vice Chancellor";
             return "addFaculty?faces-redirect=true";
        }
        if (null != fName && !fName.trim().isEmpty()) {
            if (fName.length() < 100) {
                if (FacultyDataAccess.addAFaculty(fName, dlt, pvc)) {
                    return "listFaculty?faces-redirect=true";
                } else {
                    m = "Failed to add the course due to a system error !";
                    listFaculty.index();
                    return "addFaculty?faces-redirect=true";
                }
            } else {
                m = "Input fields too long!";
                return "addFaculty?faces-redirect=true";
            }
        }
        m = "Please fill all the blank!'";
        return "addFaculty?faces-redirect=true";
    }
}
