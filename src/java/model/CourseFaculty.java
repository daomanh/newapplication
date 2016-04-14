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
public class CourseFaculty {

    private int cfId;
    private int cId;
    private int fId;

    public CourseFaculty() {
    }

    public CourseFaculty(int cfId, int cId, int fId) {
        this.cfId = cfId;
        this.cId = cId;
        this.fId = fId;
    }

    public int getCfId() {
        return cfId;
    }

    public void setCfId(int cfId) {
        this.cfId = cfId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }
    
}
