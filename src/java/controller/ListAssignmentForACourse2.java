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

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class ListAssignmentForACourse2 {

    private int cId;


    public int getFId() {
        return CourseDataAccess.getCourseBycId(cId).getFId();
    }

    public int countAssigned(int cId) {
        System.out.println("course id" + cId);
       return CourseAssignedDataAccess.getCourseAssignedBycId(cId).size() ;
    }   
     public int countAssignemen(int cId){
         return CourseAssignedDataAccess.getCourseAssignedBycId(cId).size();
    }

  

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

}
