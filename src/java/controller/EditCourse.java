/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Course;
import model.CourseDataAccess;
import model.Faculty;
import model.FacultyDataAccess;

/**
 *
 * @author thanh
 */
@ManagedBean
@SessionScoped
public class EditCourse {

    private Course course;
    private Faculty faculty;
    private int cId;
    private int fId;
    private String cCode;
    private String cName;
    private String cDescription;
    private String fName;
    private int cStart;
    private int cEnd;
    private String m;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public int getFId() {
        return fId;
    }

    public void setFId(int fId) {
        this.fId = fId;
    }

    public String getCCode() {
        return cCode;
    }

    public void setCCode(String cCode) {
        this.cCode = cCode;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCDescription() {
        return cDescription;
    }

    public void setCDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public int getCStart() {
        return cStart;
    }

    public void setCStart(int cStart) {
        this.cStart = cStart;
    }

    public int getCEnd() {
        return cEnd;
    }

    public void setCEnd(int cEnd) {
        this.cEnd = cEnd;
    }

    public String editIndex() throws SQLException {
        course = CourseDataAccess.getCourseBycId(cId);
        faculty = FacultyDataAccess.getFacultyByfId(fId).get(0);
        fName = faculty.getFName();
        cCode = course.getCCode();
        cName = course.getCName();
        cDescription = course.getCDescription();
        cStart = course.getCStart();
        cEnd = course.getCEnd();
        return "editCourse?faces-redirect=true";
    }
    @ManagedProperty(value = "#{listCourses}")
    private ListCourses listCourses;

    public ListCourses getListCourses() {
        return listCourses;
    }

    public void setListCourses(ListCourses listCourses) {
        this.listCourses = listCourses;
    }

    public String editCourse() throws SQLException {
        m = null;
//        if (Integer.toString(cStart).length() != 4) {
//            m = "Year start is error !";
//            return "editCourse?faces-redirect=true";
//        }
//        if (Integer.toString(cEnd).length()!= 4) {
//            m="Year end is error !";
//            return "editCourse?faces-redirect=true";
//        }
//        if (cStart <2010 || cStart >2050 ) {
//            m="Year start must over 2010 to 2050";
//             return "editCourse?faces-redirect=true";
//        }
//        if (cEnd <2010 || cEnd >2050 || cEnd < cStart) {
//            m = "Year end must over 2010 to 2050 and bigger than year start";
//             return "editCourse?faces-redirect=true";
//        }
        if (null != cCode && !cCode.trim().isEmpty()
                && null != cName && !cName.trim().isEmpty()
                && null != cDescription && !cDescription.trim().isEmpty()) {

            if (cDescription.length() < 100 && cDescription.length() < 500) {
                course.setFId(fId);
                course.setcCode(cCode);
                course.setcName(cName);
                course.setcDescription(cDescription);
                course.setcStart(0);
                course.setcEnd(0);
                if (CourseDataAccess.editCourse(fId, cCode, cName, cDescription, cStart, cEnd, cId)) {
                    m = "";
                    listCourses.listcourseByFacultyID();
                    return "listCoursesInAFaculty?faces-redirect=true";

                } else {
                    m = "Failed to add the course due to a system error !";

                    return "editCourse?faces-redirect=true";
                }
            } else {
                m = "Input fields too long!";
                return "editCourse?faces-redirect=true";
            }
        } else {
            m = "Please fill all the blank!'";
            return "editCourse?faces-redirect=true";
        }

    }

}
