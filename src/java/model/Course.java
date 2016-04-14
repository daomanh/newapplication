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
public class Course {
    public int cId;
    public int fId;
    public String cCode;
    public String cName;
    public String cDescription;
    public String cPostOn;
    public int cStart;
    public int cEnd;

    public Course(int cId,int fId, String cCode, String cName, String cDescription, String cPostOn ,int cStart ,int cEnd ) {
        this.cId = cId;
        this.fId = fId;
        this.cCode = cCode;
        this.cName = cName;
        this.cDescription = cDescription;
        this.cPostOn = cPostOn;
        this.cStart = cStart;
        this.cEnd = cEnd;
    }

    public Course(int fId,String cCode, String cName, String cDescription, String cPostOn,int cStart ,int cEnd ) {
        this.fId = fId;
        this.cCode = cCode;
        this.cName = cName;
        this.cDescription = cDescription;
        this.cPostOn = cPostOn;
        this.cStart = cStart;
        this.cEnd = cEnd;
    }

    public Course(int fId,String cCode, String cName, String cDescription,int cStart,int cEnd) {
        this.fId = fId;
        this.cCode = cCode;
        this.cName = cName;
        this.cDescription = cDescription;
        this.cStart = cStart;
        this.cEnd = cEnd;
    }

    
    
    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public String getCCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getCName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public String getCPostOn() {
        return cPostOn;
    }

    public void setcPostOn(String cPostOn) {
        this.cPostOn = cPostOn;
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

    public void setcStart(int cStart) {
        this.cStart = cStart;
    }

    public int getCEnd() {
        return cEnd;
    }

    public void setcEnd(int cEnd) {
        this.cEnd = cEnd;
    }
    
    
}
