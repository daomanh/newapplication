/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class FacultyDataAccess {

    public static ArrayList<Faculty> getAllFacultys() {
        try {
            ArrayList<Faculty> FacultyList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Faculty order by fId");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FacultyList.add(new Faculty(rs.getInt("fId"), rs.getString("fName")));
            }
            return FacultyList;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Faculty> getFacultyByfId(int fId) {
        try {
            ArrayList<Faculty> facultyList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Faculty where fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                facultyList.add(new Faculty(rs.getInt("fId"), rs.getString("fName"),rs.getInt("aIdDLT"),rs.getInt("aIdPVC")));
            }
            return facultyList;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Faculty> getFacultyByfName(String cName) {
        try {
            ArrayList<Faculty> facultyList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Faculty where cName like ?");
            ps.setString(1, "%" + cName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                facultyList.add(new Faculty(rs.getInt("fId"), rs.getString("fName")));
            }
            return facultyList;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean addAFaculty(String fName, int dlt, int pvc) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("insert into Faculty values(?,?,?)");
            ps.setString(1, fName);
            ps.setInt(2, dlt);
            ps.setInt(3, pvc);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean editFaculty(String fName, int aIdDLT,int aIdPVC,int fId) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("UPDATE Faculty SET fName =?,aIdDLT =? ,aIdPVC =? WHERE fId=?");
            ps.setString(1, fName);
            ps.setInt(2, aIdDLT);
            ps.setInt(3,aIdPVC);
            ps.setInt(4, fId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteAFaculty(int fId) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("delete from Faculty where fId = ?");
            ps.setInt(1, fId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<Faculty> SearchFaculty(String key) {
        try {
            ArrayList<Faculty> list = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Faculty where fName like ?");
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Faculty(rs.getInt("fId"), rs.getString("fName")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
public static Faculty getFname(int fId) {
        try {
            ArrayList<Faculty> facultyList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Faculty where fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                facultyList.add(new Faculty(rs.getInt("fId"), rs.getString("fName"),rs.getInt("aIdDLT"),rs.getInt("aIdPVC")));
            }
            return facultyList.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
