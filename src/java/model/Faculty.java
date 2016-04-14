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
public class Faculty {
    private int fId;
    private String fName;
    private int aIdDLT;
    private int aIdPVC;

    public Faculty(int fId, String fName, int aIdDLT, int aIdPVC) {
        this.fId = fId;
        this.fName = fName;
        this.aIdDLT = aIdDLT;
        this.aIdPVC = aIdPVC;
    }

    public Faculty(String fName, int aIdDLT, int aIdPVC) {
        this.fName = fName;
        this.aIdDLT = aIdDLT;
        this.aIdPVC = aIdPVC;
    }
    
    
    public Faculty() {
    }

    public int getaIdDLT() {
        return aIdDLT;
    }

    public void setaIdDLT(int aIdDLT) {
        this.aIdDLT = aIdDLT;
    }

    public int getaIdPVC() {
        return aIdPVC;
    }

    public void setaIdPVC(int aIdPVC) {
        this.aIdPVC = aIdPVC;
    }

    public Faculty(String fName) {
        this.fName = fName;
    }

    public Faculty(int fId, String fName) {
        this.fId = fId;
        this.fName = fName;
    }

    public int getFId() {
        return fId;
    }

    public void setFId(int fId) {
        this.fId = fId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }
    
}
