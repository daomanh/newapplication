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
public class CourseAssignedDataAccess {

//    public static ArrayList<Course> getAllCourses() {
//        try {
//            ArrayList<Course> courseList = new ArrayList<>();
//            Connection connection = ConnectionUtil.getConnection();
//            PreparedStatement ps = connection.prepareCall("select * from Course order by cId");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
//            }
//            return courseList;
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    public static Course getCourseAssignedBycId(int cId) {
//        try {
//            ArrayList<Course> courseList = new ArrayList<>();
//            Connection connection = ConnectionUtil.getConnection();
//            PreparedStatement ps = connection.prepareCall("select * from Course where cId=?");
//            ps.setInt(1, cId);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
//            }
//            return courseList.get(0);
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
    public static ArrayList<CourseAssigned> getCourseAssignedBycId(int cId) {
        try {
            ArrayList<CourseAssigned> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from CourseAssigned where cId=?");
            ps.setInt(1, cId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CourseAssigned ca = new CourseAssigned(rs.getInt("caId"), rs.getInt("cId"), rs.getInt("aIdCL"), rs.getInt("aIdCM"), rs.getString("caAcademicYear"));
                courseList.add(ca);
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 public static CourseAssigned getCourseAssis(int cId) {
        try {
            ArrayList<CourseAssigned> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from CourseAssigned where cId=?");
            ps.setInt(1, cId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new CourseAssigned(rs.getInt("caId"), rs.getInt("cId"), rs.getInt("aIdCL"), rs.getInt("aIdCM"), rs.getString("caAcademicYear")));
            }
            return courseList.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    
//    public static ArrayList<Course> getCourseBycName(String cName) {
//        try {
//            ArrayList<Course> courseList = new ArrayList<>();
//            Connection connection = ConnectionUtil.getConnection();
//            PreparedStatement ps = connection.prepareCall("select * from Course where cName like ?");
//            ps.setString(1, "%" + cName + "%");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
//            }
//            return courseList;
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public static boolean addAssigned(int cId, int IdCL, int IdCM , String CaAcademicYear) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("insert into CourseAssigned values(?,?,?,?)");
            ps.setInt(1, cId);
            ps.setInt(2, IdCL);
            ps.setInt(3, IdCM);
            ps.setString(4, CaAcademicYear);
           
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean addACourseAssigned(CourseAssigned courseAssigned) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("insert into CourseAssigned values(?,?,?,?)");
            ps.setInt(1, courseAssigned.getcId());
            ps.setInt(2, courseAssigned.getaIdCL());
            ps.setInt(3, courseAssigned.getaIdCM());
            ps.setString(4, courseAssigned.getCaAcademicYear());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    public static boolean editCourseAssigned(int fId, String cCode, String cName, String cDescription, int cStart, int cEnd, int cId) {
//        try {
//            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("UPDATE Course SET fId = ?, cCode=?, cName=?,cDescription=?,cStart =? ,cEnd =? WHERE cId=?");
//            ps.setInt(1, fId);
//            ps.setString(2, cCode);
//            ps.setString(3, cName);
//            ps.setString(4, cDescription);
//            ps.setInt(5, cStart);
//            ps.setInt(6, cEnd);
//            ps.setInt(7, cId);
//
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
//    public static boolean deleteACourse(int cId) {
//        try {
//            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("delete from Course where cId = ?");
//            ps.setInt(1, cId);
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
//
//    public static ArrayList<Course> getCourseByfacultyID(int fId) {
//        try {
//            ArrayList<Course> courseList = new ArrayList<>();
//            Connection connection = ConnectionUtil.getConnection();
//            PreparedStatement ps = connection.prepareCall("select * from Course where fId=?");
//            ps.setInt(1, fId);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
//            }
//            return courseList;
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
}
