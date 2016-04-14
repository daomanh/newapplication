/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.mail.MessagingException;
import model.Account;
import model.AccountDataAccess;
import model.Cmr;
import model.CmrDataAccess;
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
public class AddCmr {

    private String m;
    public int cId;

    public int studentCount;
public int count;
    public double meancw1;
    public double meancw2;
    public double meanexam;
    public double mediancw1;
    public double mediancw2;
    public double medianexam;
    public double distributioncw1type1;
    public double distributioncw2type1;
    public double distributionexamtype1;
    public double distributionexamtype2;
    public String status;
    Pattern p = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?", Pattern.CASE_INSENSITIVE);

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

  
    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getMeancw1() {
        return meancw1;
    }

    public void setMeancw1(double meancw1) {
        this.meancw1 = meancw1;
    }

    public double getMeancw2() {
        return meancw2;
    }

    public void setMeancw2(double meancw2) {
        this.meancw2 = meancw2;
    }

    public double getMeanexam() {
        return meanexam;
    }

    public void setMeanexam(double meanexam) {
        this.meanexam = meanexam;
    }

    public double getMediancw1() {
        return mediancw1;
    }

    public void setMediancw1(double mediancw1) {
        this.mediancw1 = mediancw1;
    }

    public double getMediancw2() {
        return mediancw2;
    }

    public void setMediancw2(double mediancw2) {
        this.mediancw2 = mediancw2;
    }

    public double getMedianexam() {
        return medianexam;
    }

    public void setMedianexam(double medianexam) {
        this.medianexam = medianexam;
    }

    public double getDistributioncw1type1() {
        return distributioncw1type1;
    }

    public void setDistributioncw1type1(double distributioncw1type1) {
        this.distributioncw1type1 = distributioncw1type1;
    }

    public double getDistributioncw2type1() {
        return distributioncw2type1;
    }

    public void setDistributioncw2type1(double distributioncw2type1) {
        this.distributioncw2type1 = distributioncw2type1;
    }

    public double getDistributionexamtype1() {
        return distributionexamtype1;
    }

    public void setDistributionexamtype1(double distributionexamtype1) {
        this.distributionexamtype1 = distributionexamtype1;
    }

    public double getDistributionexamtype2() {
        return distributionexamtype2;
    }

    public void setDistributionexamtype2(double distributionexamtype2) {
        this.distributionexamtype2 = distributionexamtype2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pattern getP() {
        return p;
    }

    public void setP(Pattern p) {
        this.p = p;
    }
  

    public Course getCourse() {
        return CourseDataAccess.getCourseBycId(cId);
    }
//    @ManagedProperty(value = "#{listCourses}")
//    private ListCourses lc;

    public String addCmr() throws IOException, MessagingException {
        m = null;
        Matcher mt = p.matcher(Double.toString(meancw1));
        if (!mt.find()) {
            m = "mean cw 1 double error";
            return "addCmrCL?faces-redirect=true";
        }
        Matcher m2 = p.matcher(Double.toString(meancw2));
        if (!m2.find()) {
            m = "mean cw 2 double error ";
            return "addCmrCL?faces-redirect=true";
        }
          if (studentCount == 0) {
            m = "Please fill the blank  ";
            return "addCmrCL?faces-redirect=true";
        }
             if ( distributioncw1type1 == 0) {
           m = "Please fill the blank  ";
               return "addCmrCL?faces-redirect=true";
        }
        if ( distributioncw2type1 == 0) {
           m = "Please fill the blank  ";
               return "addCmrCL?faces-redirect=true";
        }
          if ( distributionexamtype1 == 0) {
           m = "Please fill the blank  ";
               return "addCmrCL?faces-redirect=true";
        }
           if ( distributionexamtype2 == 0) {
           m = "Please fill the blank  ";
               return "addCmrCL?faces-redirect=true";
        }
        if (true) {
            if (studentCount < 100) {
                Cmr cmr = new Cmr(cId, studentCount, meancw1, meancw2, meanexam, mediancw1, mediancw2, medianexam, distributioncw1type1, distributioncw2type1, distributionexamtype1, distributionexamtype2, "processing", "not yet");
                if (CmrDataAccess.addCmr(cmr)) {
                    Course c = CourseDataAccess.getCourseBycId(cId);
                    CourseAssigned ca = CourseAssignedDataAccess.getCourseAssis(cId);
                    int idcl = ca.aIdCL;
                    int idcm = ca.aIdCM;
                    Account cmid = AccountDataAccess.getAccountByCMID(idcm);
                    Account clid = AccountDataAccess.getAccountByCLID(idcl);
                    AccountDataAccess.addCMRsendMail(c, cmid, clid);
                    m = null;
                    count = 0;
                    meancw1 = 0.0;
                    meancw2 = 0.0;
                    meanexam = 0.0;
                    mediancw1 = 0.0;
                    mediancw2 = 0.0;
                    medianexam = 0.0;
                    distributioncw1type1 = 0.0;
                    distributioncw2type1 = 0.0;
                    distributionexamtype1 = 0.0;
                    distributionexamtype2 = 0.0;
                    return "listCoursesCL?faces-redirect=true";
                } else {
                    m = "Failed to add the cmr due to a system error !";
                    return "addCmrCL?faces-redirect=true";
                }
            } else {
                m = "Input fields too long!";
                return "addCmrCL?faces-redirect=true";
            }
        } else {
            m = "Please enter student count!'";
            return "addCmrCL?faces-redirect=true";
        }
    }

  

}
