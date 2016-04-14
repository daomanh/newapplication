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
import javax.mail.MessagingException;
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
public class AssignCourse {

    private String m;
    private int cId;
    private int cm;
    private int cl;
    private String year;

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public int getCm() {
        return cm;
    }

    public void setCm(int cm) {
        this.cm = cm;
    }

    public int getCl() {
        return cl;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Course getCourse() {
        return CourseDataAccess.getCourseBycId(cId);
    }

    @ManagedProperty(value = "#{listCourses}")
    private ListCourses lc;

    public ListCourses getLc() {
        return lc;
    }

    public void setLc(ListCourses lc) {
        this.lc = lc;
    }

    public String addCourseAssigned() throws IOException, MessagingException {
        m = null;
        if (cl == 0) {
            System.out.println("asdasdsa" +cl);
            m = "Please select course leader";
              return "assignCourse?faces-redirect=true";
//            return "assignCourse?faces-redirect=true";
        }
        if (cm == 0) {
            m = "Please select course morderiter";
            return "assignCourse?faces-redirect=true";
        }
        if (null != year && !year.trim().isEmpty()) {
            if (year.length() < 100) {
                if (CourseAssignedDataAccess.addAssigned(cId, cl, cm, year)) {
                    Account cmid = AccountDataAccess.getAccountByCMID(cm);
                    Account clid = AccountDataAccess.getAccountByCLID(cl);
                    Course c = CourseDataAccess.getCourseBycId(cId);
                    AccountDataAccess.generateAndSendEmail(cmid, clid, c);
                    m = null;
                    cl = 0;
                    cm = 0;
                    year = null;
                    return "listAssignementForACourse?faces-redirect=truecId=" + cId + "";
                } else {
                    m = "Failed to add the course assigned due to a system error !";
                    return "assignCourse?faces-redirect=true";
                }
            } else {
                m = "Input fields too long!";
                return "assignCourse?faces-redirect=true";
            }
        }
        m = "Please fill all the blank!'";
        return "assignCourse?faces-redirect=true";
    }

}
