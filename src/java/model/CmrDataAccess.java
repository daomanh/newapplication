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
public class CmrDataAccess {

    public static ArrayList<Cmr> getCMRBycId(int cId) {
        try {
            ArrayList<Cmr> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from CMR where cId=?");
            ps.setInt(1, cId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cmr ca = new Cmr(rs.getInt("id"), rs.getInt("cid"), rs.getInt("studentCount"), rs.getDouble("meancw1"), rs.getDouble("meancw2"), rs.getDouble("meanexam"), rs.getDouble("mediancw1"), rs.getDouble("mediancw2"), rs.getDouble("medianexam"), rs.getDouble("distributioncw1type1"), rs.getDouble("distributioncw2type1"), rs.getDouble("distributionexamtype1"), rs.getDouble("distributionexamtype2"), rs.getString("status"), rs.getString("comment"), rs.getString("createDate"));
                courseList.add(ca);
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CmrDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Cmr> getCmrByCourseId(int courseId) {
        try {
            ArrayList<Cmr> CmrList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Cmr where cId=?");
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cmr cmr = new Cmr(rs.getInt("id"), rs.getInt("cId"), rs.getInt("studentCount"), rs.getDouble("meancw1"), rs.getDouble("meancw2"), rs.getDouble("meanexam"), rs.getDouble("mediancw1"), rs.getDouble("mediancw2"), rs.getDouble("medianexam"), rs.getDouble("distributioncw1type1"), rs.getDouble("distributioncw2type1"), rs.getDouble("distributionexamtype1"), rs.getDouble("distributionexamtype2"), rs.getString("status"), rs.getString("comment"), rs.getString("createDate"));
                CmrList.add(cmr);
            }
            return CmrList;
        } catch (SQLException ex) {
            Logger.getLogger(CmrDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Cmr> CheckCMRByCid(int courseId) {
        try {
            ArrayList<Cmr> CmrList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Cmr where cId=?");
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int cId = rs.getInt("cId");
                int studentCount = rs.getInt("studentCount");
                double meancw1 = rs.getDouble("meancw1");
                double meancw2 = rs.getDouble("meancw2");
                double meanexam = rs.getDouble("meanexam");
                double mediancw1 = rs.getDouble("mediancw1");
                double mediancw2 = rs.getDouble("mediancw2");
                double medianexam = rs.getDouble("medianexam");
                double distributioncw1type1 = rs.getDouble("distributioncw1type1");
                double distributioncw2type1 = rs.getDouble("distributioncw2type1");
                double distributionexamtype2 = rs.getDouble("distributionexamtype2");
                String status = rs.getString("status");
                String comment = rs.getString("comment");
                String createDate = rs.getString("createDate");
                Cmr cmr = new Cmr(id, cId, studentCount, meancw1, meancw2, meanexam, mediancw1, mediancw2, medianexam, distributioncw1type1, distributioncw2type1, distributionexamtype2, distributionexamtype2, status, comment, createDate);
                CmrList.add(cmr);
            }
            return CmrList;
        } catch (SQLException ex) {
            Logger.getLogger(CmrDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Cmr> getCmrprocessingByCourseId(int courseId) {
        try {
            ArrayList<Cmr> CmrList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Cmr where cId=?");
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int cId = rs.getInt("cId");
                int studentCount = rs.getInt("studentCount");
                double meancw1 = rs.getDouble("meancw1");
                double meancw2 = rs.getDouble("meancw2");
                double meanexam = rs.getDouble("meanexam");
                double mediancw1 = rs.getDouble("mediancw1");
                double mediancw2 = rs.getDouble("mediancw2");
                double medianexam = rs.getDouble("medianexam");
                double distributioncw1type1 = rs.getDouble("distributioncw1type1");
                double distributioncw2type1 = rs.getDouble("distributioncw2type1");
                double distributionexamtype2 = rs.getDouble("distributionexamtype2");
                String status = rs.getString("status");
                String comment = rs.getString("comment");
                String createDate = rs.getString("createDate");
                Cmr cmr = new Cmr(id, cId, studentCount, meancw1, meancw2, meanexam, mediancw1, mediancw2, medianexam, distributioncw1type1, distributioncw2type1, distributionexamtype2, distributionexamtype2, status, comment, createDate);
                CmrList.add(cmr);
            }
            return CmrList;
        } catch (SQLException ex) {
            Logger.getLogger(CmrDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean editCMR(int StudentCount, double meancw1, double meancw2, double meanexam, double mediancw1, double mediancw2, double medianexam, double distributioncw1type1, double distributioncw2type1, double distributionexamtype1, int id) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("UPDATE CMR SET StudentCount =? ,meancw1 =?,meancw2 = ?,meanexam = ?,mediancw1 =?,mediancw2=?,medianexam =?,distributioncw1type1 =? ,distributioncw2type1 =?,distributionexamtype1 =?,status = 'processing' WHERE id=?");
            ps.setInt(1, StudentCount);
            ps.setDouble(2, meancw1);
            ps.setDouble(3, meancw2);
            ps.setDouble(4, meanexam);
            ps.setDouble(5, mediancw1);
            ps.setDouble(6, mediancw2);
            ps.setDouble(7, medianexam);
            ps.setDouble(8, distributioncw1type1);
            ps.setDouble(9, distributioncw2type1);
            ps.setDouble(10, distributionexamtype1);
            ps.setInt(11, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
// public static boolean addnewCMR(int cId, int studentCount, double meancw1 ,double meancw2, double meanexam, double mediancw1,double mediancw2,double medianexam,double distributioncw1type1,double distributioncw2type1,double distributionexamtype1, double distributionexamtype2) {
//        try {
//            Connection connection = ConnectionUtil.getConnection();
//            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("insert into CourseAssigned values(?,?,?,?)");
//            ps.setInt(1, cId);
//            ps.setInt(2, IdCL);
//            ps.setInt(3, IdCM);
//            ps.setString(4, CaAcademicYear);
//           
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
    public static boolean addCmr(Cmr cmr) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("insert into  CMR values(?,?,?,?,?, ?,?,?,?,?, ?,?,'processing','not yet',default)");
            ps.setInt(1, cmr.getCid());
            ps.setInt(2, cmr.getStudentCount());
            ps.setDouble(3, cmr.getMeancw1());
            ps.setDouble(4, cmr.getMeancw2());
            ps.setDouble(5, cmr.getMeanexam());
            ps.setDouble(6, cmr.getMediancw1());
            ps.setDouble(7, cmr.getMeancw2());
            ps.setDouble(8, cmr.getMedianexam());
            ps.setDouble(9, cmr.getDistributioncw1type1());
            ps.setDouble(10, cmr.getDistributioncw2type1());
            ps.setDouble(11, cmr.getDistributionexamtype1());
            ps.setDouble(12, cmr.getDistributionexamtype2());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CmrDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean editCMRtoDone(int id) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("UPDATE CMR SET status ='done', CMR.createDate = default WHERE id=?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean editCMRNOTDone(int id) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("UPDATE CMR SET status ='up accecpt able' WHERE id=?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    public static boolean deleteCmr(int aId) {
//        try {
//            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("delete from Cmr where aId = ?");
//            ps.setInt(1, aId);
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CmrDataAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
    public static ArrayList<Cmr> getCmrsCompletedInAFaculty(int fId) {
        try {
            ArrayList<Cmr> CmrList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from cmr \n"
                    + "inner join Course on cmr.cId = Course.cid\n"
                    + "inner join Faculty on Course.fId=Faculty.fId\n"
                    + "where cmr.status like 'done' and Faculty.fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int cId = rs.getInt("cId");
                int studentCount = rs.getInt("studentCount");
                double meancw1 = rs.getDouble("meancw1");
                double meancw2 = rs.getDouble("meancw2");
                double meanexam = rs.getDouble("meanexam");
                double mediancw1 = rs.getDouble("mediancw1");
                double mediancw2 = rs.getDouble("mediancw2");
                double medianexam = rs.getDouble("medianexam");
                double distributioncw1type1 = rs.getDouble("distributioncw1type1");
                double distributioncw2type1 = rs.getDouble("distributioncw2type1");
                double distributionexamtype2 = rs.getDouble("distributionexamtype2");
                String status = rs.getString("status");
                String comment = rs.getString("comment");
                String createDate = rs.getString("createDate");
                Cmr cmr = new Cmr(id, cId, studentCount, meancw1, meancw2, meanexam, mediancw1, mediancw2, medianexam, distributioncw1type1, distributioncw2type1, distributionexamtype2, distributionexamtype2, status, comment, createDate);
                CmrList.add(cmr);
            }
            return CmrList;
        } catch (SQLException ex) {
            Logger.getLogger(CmrDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Cmr> getCmrsInAFaculty(int fId) {
        try {
            ArrayList<Cmr> CmrList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from cmr \n"
                    + "inner join Course on cmr.cId = Course.cid\n"
                    + "inner join Faculty on Course.fId=Faculty.fId\n"
                    + "where Faculty.fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int cId = rs.getInt("cId");
                int studentCount = rs.getInt("studentCount");
                double meancw1 = rs.getDouble("meancw1");
                double meancw2 = rs.getDouble("meancw2");
                double meanexam = rs.getDouble("meanexam");
                double mediancw1 = rs.getDouble("mediancw1");
                double mediancw2 = rs.getDouble("mediancw2");
                double medianexam = rs.getDouble("medianexam");
                double distributioncw1type1 = rs.getDouble("distributioncw1type1");
                double distributioncw2type1 = rs.getDouble("distributioncw2type1");
                double distributionexamtype2 = rs.getDouble("distributionexamtype2");
                String status = rs.getString("status");
                String comment = rs.getString("comment");
                String createDate = rs.getString("createDate");
                Cmr cmr = new Cmr(id, cId, studentCount, meancw1, meancw2, meanexam, mediancw1, mediancw2, medianexam, distributioncw1type1, distributioncw2type1, distributionexamtype2, distributionexamtype2, status, comment, createDate);
                CmrList.add(cmr);
            }
            return CmrList;
        } catch (SQLException ex) {
            Logger.getLogger(CmrDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean addCommentToCMR(int id,String comment) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("UPDATE CMR SET comment = ? WHERE id=?");
            ps.setString(1,comment);
            ps.setInt(2, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
