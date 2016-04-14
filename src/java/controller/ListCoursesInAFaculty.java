/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.CmrDataAccess;
import model.Course;
import model.CourseDataAccess;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@RequestScoped
public class ListCoursesInAFaculty {

    private ArrayList<Course> courseList = new ArrayList<>();
    private int fId;

    public ArrayList<Course> getCourseList() {
        return CourseDataAccess.getCourseByfId(fId);
    }
    private ArrayList<Faculty> facultyList = new ArrayList<>();

    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(ArrayList<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public String index() throws SQLException {
        courseList = CourseDataAccess.getCourseByfId(fId);
        facultyList = FacultyDataAccess.getFacultyByfId(fId);
        return "listCoursesInAFaculty?faces-redirect=true";
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public String listcourseByFacultyID() {
        courseList = CourseDataAccess.getCourseByfacultyID(fId);
        facultyList = FacultyDataAccess.getFacultyByfId(fId);
        return "listCoursesInAFaculty?faces-redirect=true";
    }

    public int getFId() {
        return fId;
    }

    public void setFId(int fId) {
        this.fId = fId;
    }
    public float numberOfCmrInAFaculty(int fId){
        float correct = CourseDataAccess.getCourseByfId(fId).size();
        float questionNum = CmrDataAccess.getCmrsInAFaculty(fId).size();
        return ( questionNum * 100f) / correct;
    }
    public float numberOfCompletedCmrInAFacultyByYear(int fId) {
        System.out.println("asdada"+ fId);
        float correct = CmrDataAccess.getCmrsCompletedInAFaculty(fId).size();
        System.out.println("correct" + correct);
        float questionNum = CmrDataAccess.getCmrsInAFaculty(fId).size();
        System.out.println("asdasdasdsadasdasd"+questionNum);
        return (correct * 100) / questionNum;
    }
    
//    public float
}
