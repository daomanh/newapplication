/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import model.Course;
import model.CourseAssigned;
import model.CourseDataAccess;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class ListCourses {

    /**
     * Creates a new instance of CourseList
     */
    public ListCourses() {
      
    }
  


    private ArrayList<Course> courseList = new ArrayList<>();
    private ArrayList<Faculty> facultyList = new ArrayList<>();
    private String cName;
    private int fId;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public int getFId() {
        return fId;
    }

    public void setFId(int fId) {
        this.fId = fId;
    }

    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(ArrayList<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public String index() {
        courseList = CourseDataAccess.getAllCourses();
        return "listCourses?faces-redirect=true";
    }

    public String searchPostByTitle() {
        courseList = CourseDataAccess.getCourseBycName(cName);
        cName = null;
        return "courseList?faces-redirect=true";
    }

    public String listcourseByFacultyID() {
        courseList = CourseDataAccess.getCourseByfacultyID(fId);
        facultyList = FacultyDataAccess.getFacultyByfId(fId);
        return "listCoursesInAFaculty?faces-redirect=true";
    }
    private ArrayList<CourseAssigned> CourseAssignedList = new ArrayList<>();
    private int cId;
    private int aId;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getAId() {
        return aId;
    }

    public void setAId(int aId) {
        this.aId = aId;
    }

    public String listcourseOfCL() {
        courseList = CourseDataAccess.getCourseByIDCL(aId);
        System.out.println("sadasd"+aId);
        return "listCoursesCL?faces-redirect=true";
    }

    public String listcourseOfCM() {
        courseList = CourseDataAccess.getCourseByIDCM(aId);
        return "listCoursesCM?faces-redirect=true";
    }
    public String listcourseOfDLT(){
         courseList = CourseDataAccess.getCourseByIDDLT(aId);
        return "listCoursesDLT?faces-redirect=true";
    }
    public String listcourseOfPVC(){
         courseList = CourseDataAccess.getCourseByIDPVC(aId);
        return "listCoursesPVC?faces-redirect=true";
    }

    public String listcourseFaculty() {
        return CourseDataAccess.getCourseNameByfacultyID(fId).getCName();
    }
}
