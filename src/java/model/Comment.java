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
public class Comment {
    private int id;
    private int cmrId;
    private String comment;

    public Comment() {
    }

    public Comment(int id, int cmrId, String comment) {
        this.id = id;
        this.cmrId = cmrId;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCmrId() {
        return cmrId;
    }

    public void setCmrId(int cmrId) {
        this.cmrId = cmrId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
