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
public class Cmr {

    private int id;
    private int cid;
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
    private double distributionexamtype2;
    private String status;
    private String comment;
    private String createDate;

    public Cmr(int id, int cid, int studentCount, double meancw1, double meancw2, double meanexam, double mediancw1, double mediancw2, double medianexam, double distributioncw1type1, double distributioncw2type1, double distributionexamtype1, double distributionexamtype2, String status, String comment, String createDate) {
        this.id = id;
        this.cid = cid;
        this.studentCount = studentCount;
        this.meancw1 = meancw1;
        this.meancw2 = meancw2;
        this.meanexam = meanexam;
        this.mediancw1 = mediancw1;
        this.mediancw2 = mediancw2;
        this.medianexam = medianexam;
        this.distributioncw1type1 = distributioncw1type1;
        this.distributioncw2type1 = distributioncw2type1;
        this.distributionexamtype1 = distributionexamtype1;
        this.distributionexamtype2 = distributionexamtype2;
        this.status = status;
        this.comment = comment;
        this.createDate = createDate;
    }

    public Cmr(int cid, int studentCount, double meancw1, double meancw2, double meanexam, double mediancw1, double mediancw2, double medianexam, double distributioncw1type1, double distributioncw2type1, double distributionexamtype1, double distributionexamtype2, String status, String comment) {
        this.cid = cid;
        this.studentCount = studentCount;
        this.meancw1 = meancw1;
        this.meancw2 = meancw2;
        this.meanexam = meanexam;
        this.mediancw1 = mediancw1;
        this.mediancw2 = mediancw2;
        this.medianexam = medianexam;
        this.distributioncw1type1 = distributioncw1type1;
        this.distributioncw2type1 = distributioncw2type1;
        this.distributionexamtype1 = distributionexamtype1;
        this.distributionexamtype2 = distributionexamtype2;
        this.status = status;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

   

}
