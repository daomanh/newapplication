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
import model.CourseAssigned;
import model.CourseAssignedDataAccess;
import model.CourseDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class AddCourse {

    /**
     * Creates a new instance of AddCourse
     */
    public AddCourse() {
    }
    private int fId;
    private String cCode;
    private String cName;
    private String cDescription;
    private int cStart;
    private int cEnd;
    private String m;

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

    public int getFId() {
        return fId;
    }

    public void setFId(int fId) {
        this.fId = fId;
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

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String index() {
        m = null;
        return "addCourse?faces-redirect=true";
    }

    @ManagedProperty(value = "#{listCourses}")
    private ListCourses listCourses;

    public ListCourses getListCourses() {
        return listCourses;
    }

    public void setListCourses(ListCourses listCourses) {
        this.listCourses = listCourses;
    }

    public String addCourse() throws IOException {
        m = null;
        //        cCode = null;
//        cName = null;
//        cDescription = null;
//        cStart = 0;
//        cEnd = 0;
//        if (cStart == 0) {
//            m = "Year start is error !";
//            return "addCourse?faces-redirect=true";
//        }
//        if (Integer.toString(cEnd).length() != 4) {
//            m = "Year end is error !";
//            return "addCourse?faces-redirect=true";
//        }
//        if (cStart < 2010 || cStart > 2050) {
//            m = "Year start must over 2010 to 2050";
//            return "addCourse?faces-redirect=true";
//        }
//        if (cEnd < 2010 || cEnd > 2050 || cEnd < cStart) {
//            m = "Year end must over 2010 to 2050 and bigger than year start";
//            return "addCourse?faces-redirect=true";
//        }
        if (null != cCode && !cCode.trim().isEmpty()
                && null != cName && !cName.trim().isEmpty()
                && null != cDescription && !cDescription.trim().isEmpty()) {
            if (cDescription.length() < 100 && cDescription.length() < 500) {
                if (CourseDataAccess.CheckAddCourse(cName) == null) {
                    if (CourseDataAccess.addACourse(new Course(fId, cCode, cName, cDescription, cStart, cEnd))) {
//                    CourseAssigned c=new CourseAssigned(CourseDataAccess.getAllCourses().size());
//                    CourseAssignedDataAccess.addACourseAssigned(c);
                        m = null;
                        cCode = null;
                        cName = null;
                        cDescription = null;
                        cStart = 0;
                        cEnd = 0;
                        listCourses.index();
                        return "listCourses?faces-redirect=true";
                    } else {
                        m = "Failed to add the course due to a system error !";
                        return "addCourse?faces-redirect=true";
                    }
                } else {
                    m = "Course name is already exsit";
                    return "addCourse?faces-redirect=true";
                }
            } else {
                m = "Input fields too long!";
                return "addCourse?faces-redirect=true";
            }
        }
        m = "Please fill all the blank!'";
        return "addCourse?faces-redirect=true";
    }
}
