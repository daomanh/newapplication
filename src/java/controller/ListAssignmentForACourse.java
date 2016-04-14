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
import model.Account;
import model.AccountDataAccess;
import model.Course;
import model.CourseAssigned;
import model.CourseAssignedDataAccess;
import model.CourseDataAccess;
import model.FacultyDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class ListAssignmentForACourse {

    private ArrayList<CourseAssigned> courseList = new ArrayList<>();

    private int cId;

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

   

    public ArrayList<CourseAssigned> getCourseList() {
                System.out.println("aaaaaaaaaaaaaaaaaa" +cId);
        return CourseAssignedDataAccess.getCourseAssignedBycId(cId);

    }

    public String backToThisBean(int cId) {
        System.out.println("abcf" + cId);
        setCourseList(CourseAssignedDataAccess.getCourseAssignedBycId(1));
        return "listAssignementForACourse?faces-redirect=true";
    }

    public void setCourseList(ArrayList<CourseAssigned> courseList) {
        this.courseList = courseList;
    }

    public int getFId() {
        return CourseDataAccess.getCourseBycId(cId).getFId();
    }


    public String getCourseName(int cId) {
        return CourseDataAccess.getCourseBycId(cId).getCName();
    }


    public String getUserNameByAId(int aID) {
        return AccountDataAccess.getAnccountByaId(aID).getaUsername();
    }
}
