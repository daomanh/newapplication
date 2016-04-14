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
import model.Course;
import model.CourseAssignedDataAccess;
import model.CourseDataAccess;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author nguyen
 */
@ManagedBean
@SessionScoped
public class SearchCourse {
private ArrayList<Course> listCourse = new ArrayList<>();

    private String key;
    private int fId;
    /**
     * Creates a new instance of SearchMusic
     */
    public SearchCourse() {
        
    }

    public ArrayList<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(ArrayList<Course> listCourse) {
        this.listCourse = listCourse;
    }

    public int getFId() {
        return fId;
    }

    public void setFId(int fId) {
        this.fId = fId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String searchCourse() {
        listCourse = CourseDataAccess.SearchCourse(key, fId);
       key = null;
        return "SearchCourse?faces-redirect=true";
        
    }
}
