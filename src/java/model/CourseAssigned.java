/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class CourseAssigned {
    public int caId;
    public int cId;
    public int aIdCL;
    public int aIdCM;
   public String caAcademicYear;

    
    
    public CourseAssigned(int cId, int aIdCL, int aIdCM, String caAcademicYear) {
        this.cId = cId;
        this.aIdCL = aIdCL;
        this.aIdCM = aIdCM;
        this.caAcademicYear = caAcademicYear;
    }

    public CourseAssigned(int caId, int cId, int aIdCL, int aIdCM, String caAcademicYear) {
        this.caId = caId;
        this.cId = cId;
        this.aIdCL = aIdCL;
        this.aIdCM = aIdCM;
        this.caAcademicYear = caAcademicYear;
    }


    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getaIdCL() {
        return aIdCL;
    }

    public void setaIdCL(int aIdCL) {
        this.aIdCL = aIdCL;
    }

    public int getaIdCM() {
        return aIdCM;
    }

    public void setaIdCM(int aIdCM) {
        this.aIdCM = aIdCM;
    }

    public String getCaAcademicYear() {
        return caAcademicYear;
    }

    public void setCaAcademicYear(String caAcademicYear) {
        this.caAcademicYear = caAcademicYear;
    }

    
    
    
}
