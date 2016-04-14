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

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class DeleteCourse {

    private int cId; 
    private String m;

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }
    
    @ManagedProperty(value = "#{listCourses}")
    private ListCourses listCourses;

    public ListCourses getListCourses() {
        return listCourses;
    }

    public void setListCourses(ListCourses listCourses) {
        this.listCourses = listCourses;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    
    
    public void deleteCourse() {
        m="";
        if(CourseDataAccess.deleteACourse(cId)){
            listCourses.index();
        }
        m="Fail to delete";
        listCourses.index();
    }
    
}
