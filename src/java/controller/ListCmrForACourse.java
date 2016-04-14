/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Cmr;
import model.CmrDataAccess;
import model.CourseAssignedDataAccess;
import model.CourseDataAccess;

/**
 *
 * @author Dell
 */
@ManagedBean
@SessionScoped
public class ListCmrForACourse {

    private ArrayList<Cmr> cmrList = new ArrayList<>();
    private int cId;
    private ArrayList<Cmr> cmrprocessing = new ArrayList<>();

    public ArrayList<Cmr> getCmrprocessing() {
        return CmrDataAccess.getCmrprocessingByCourseId(cId);
    }

    public void setCmrprocessing(ArrayList<Cmr> cmrprocessing) {
        this.cmrprocessing = cmrprocessing;
    }

    public ArrayList<Cmr> getCmrList() {
        return CmrDataAccess.getCmrByCourseId(cId);
    }

    public String backToThisBean(int cId) {
        setCmrList(CmrDataAccess.getCmrByCourseId(cId));
        return "listAssignementForACourse?faces-redirect=true";
    }

    public void setCmrList(ArrayList<Cmr> cmrList) {
        this.cmrList = cmrList;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public int getFId() {
        return CourseDataAccess.getCourseBycId(cId).getFId();
    }

    public String getCourseName() {
        return CourseDataAccess.getCourseBycId(cId).getCName();
    }

    public int countCMR(int cId) {
        return CmrDataAccess.getCMRBycId(cId).size();
    }

    public boolean checkCMR(int cId) {
        if (CmrDataAccess.getCMRBycId(cId).get(0).getStatus().equals("up accecpt able")) {
            return true;
        }
        return false;
    }

    public String checkCMRStatus(int cId) {

        return CmrDataAccess.getCMRBycId(cId).get(0).getStatus();
    }

}
