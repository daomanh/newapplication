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
import model.Cmr;
import model.CmrDataAccess;
import model.Course;
import model.CourseDataAccess;
import model.Faculty;
import model.FacultyDataAccess;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author thanh
 */
@ManagedBean
@SessionScoped
public class EditCmr {

    private Cmr cmr;
    private String status;
    private int id;
    private String m;
    private int studentCount;
    private double meancw1;
    private double meancw2;
    private double meanexam;
    private double mediancw1;
    private double mediancw2;
    private double medianexam;
    private double distributioncw1type1;
    private double distributioncw2type1;
    private double distributionexamtype1;

    private String comment;

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cmr getCmr() {
        return cmr;
    }

    public void setCmr(Cmr cmr) {
        this.cmr = cmr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String editIndex() throws SQLException {
        cmr = CmrDataAccess.getCMRBycId(id).get(0);
        studentCount = cmr.getStudentCount();
        meancw1 = cmr.getMeancw1();
        meancw2 = cmr.getMeancw2();
        meanexam = cmr.getMeanexam();
        mediancw1 = cmr.getMediancw1();
        mediancw2 = cmr.getMediancw2();
        medianexam = cmr.getMedianexam();
        distributioncw1type1 = cmr.getDistributioncw1type1();
        distributioncw2type1 = cmr.getDistributioncw2type1();
        distributionexamtype1 = cmr.getDistributionexamtype1();
        return "editCMR?faces-redirect=true";
    }

    public String editCMRR() throws SQLException {
        m = null;
        cmr.setStudentCount(studentCount);
        cmr.setMeancw1(meancw1);
        cmr.setMeancw2(meancw2);
        cmr.setMeanexam(meanexam);
        cmr.setMediancw1(mediancw1);
        cmr.setMediancw2(mediancw2);
        cmr.setMedianexam(medianexam);
        cmr.setDistributioncw1type1(distributioncw1type1);
        cmr.setDistributioncw2type1(distributioncw2type1);
        cmr.setDistributionexamtype1(distributionexamtype1);

        if (CmrDataAccess.editCMR(studentCount, meancw1, meancw2, meanexam, mediancw1, mediancw2, medianexam, distributioncw1type1, distributioncw2type1, distributionexamtype1, id)) {
            m = "";

            return "listCoursesCL?faces-redirect=true";

        } else {
            m = "Failed to add the course due to a system error !";
            System.out.println(" sai cmnr");
            return "editCMR?faces-redirect=true";
        }
    }

    public String editCMRtoDone() throws SQLException {
        m = null;
        if (CmrDataAccess.editCMRtoDone(id)) {
            m = "";

            return "listCmrForACourseCM?faces-redirect=true";

        } else {
            m = "Failed to add the course due to a system error !";

            return "listCmrForACourseCM?faces-redirect=true";
        }

    }

    public String editCMRNotdone() throws SQLException {
        m = null;
        if (CmrDataAccess.editCMRNOTDone(id)) {
            m = "";

            return "listCmrForACourseCM?faces-redirect=true";

        } else {
            m = "Failed to add the course due to a system error !";

            return "listCmrForACourseCM?faces-redirect=true";
        }

    }

    public int countDate(String inputDate) throws ParseException {
        ArrayList<Date> listOfDate = new ArrayList<>();
        if (!inputDate.equals("")) {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = (Date) formatter.parse(inputDate);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Date endDate = (Date) formatter.parse(dateFormat.format(date));
            Calendar start = Calendar.getInstance();
            start.setTime(startDate);
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            end.add(Calendar.DAY_OF_YEAR, 1);
            while (start.before(end)) {
                listOfDate.add(start.getTime());
                start.add(Calendar.DAY_OF_YEAR, 1);
            }
        }
        return listOfDate.size();
    }

    public boolean countDateDifference(String inputDate) throws ParseException {
        ArrayList<Date> listOfDate = new ArrayList<>();
        if (!inputDate.equals("")) {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = (Date) formatter.parse(inputDate);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Date endDate = (Date) formatter.parse(dateFormat.format(date));
            Calendar start = Calendar.getInstance();
            start.setTime(startDate);
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            end.add(Calendar.DAY_OF_YEAR, 1);
            while (start.before(end)) {
                listOfDate.add(start.getTime());
                start.add(Calendar.DAY_OF_YEAR, 1);
            }
        }
        return (listOfDate.size() < 14);
    }

    public String addCommentToCmr() throws SQLException {
        m = null;
        if (comment == null) { 
            m = "Enter comment";
             return "listCmrForACourseDLT?faces-redirect=true";
//            return "assignCourse?faces-redirect=true";
        }
        if (CmrDataAccess.addCommentToCMR(id, comment)) {
            m = "";
            return "listCmrForACourseDLT?faces-redirect=true";
        } else {
            m = "Failed to add the course due to a system error !";

            return "listCmrForACourseDLT?faces-redirect=true";
        }

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
