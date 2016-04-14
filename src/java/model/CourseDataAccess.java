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
public class CourseDataAccess {

    public static ArrayList<Course> getAllCourses() {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course order by cId");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> getAllCourseshaveAssigned() {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course where cId not in (select cId from CourseAssigned)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> getAllCourseshaveNoAssigned() {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course where cId  in (select cId from CourseAssigned)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Course getCourseBycId(int cId) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course where cId=?");
            ps.setInt(1, cId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 

    public static ArrayList<Course> getCourseByfId(int fId) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course where fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean editCourse(int fId, String cCode, String cName, String cDescription, int cStart, int cEnd, int cId) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("UPDATE Course SET fId = ?, cCode=?, cName=?,cDescription=?,cStart =? ,cEnd =? WHERE cId=?");
            ps.setInt(1, fId);
            ps.setString(2, cCode);
            ps.setString(3, cName);
            ps.setString(4, cDescription);
            ps.setInt(5, cStart);
            ps.setInt(6, cEnd);
            ps.setInt(7, cId);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<Course> getCourseBycName(String cName) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course where cName like ?");
            ps.setString(1, "%" + cName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean addACourse(Course course) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("insert into Course values(?,?,?,?,default,?,?)");
            ps.setInt(1, course.getFId());
            ps.setString(2, course.getCCode());
            ps.setString(3, course.getCName());
            ps.setString(4, course.getCDescription());
            ps.setInt(5, course.getCStart());
            ps.setInt(6, course.getCEnd());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteACourse(int cId) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("delete from Course where cId = ?");
            ps.setInt(1, cId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<Course> getCourseByfacultyID(int fId) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course where fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Course getCourseNameByfacultyID(int fId) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course where fId=?");
            ps.setInt(1, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> SearchCourse(String key, int fId) {
        try {
            ArrayList<Course> list = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Course where cName like ? and fId = ? or cCode like ? and fId = ?");
            ps.setString(1, "%" + key + "%");
            ps.setInt(2, fId);
            ps.setString(3, "%" + key + "%");
            ps.setInt(4, fId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int getCourseAssignedByaId(int aId) {
        int cId = 0;
        try {
            ArrayList<CourseAssigned> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select cId from CourseAssigned where aIdCL=?");
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cId = rs.getInt("cId");
            }
            return cId;
        } catch (SQLException ex) {
            Logger.getLogger(CourseAssignedDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cId;
    }

    public static ArrayList<Course> getCourseByIDCM(int aId) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("SELECT * FROM Course \n"
                    + "WHERE cId  IN \n"
                    + "  (SELECT cId FROM CourseAssigned \n"
                    + "   WHERE aIdCM= ?)");
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> getCourseByIDCL(int aId) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("SELECT * FROM Course \n"
                    + "WHERE cId  IN \n"
                    + "  (SELECT cId FROM CourseAssigned \n"
                    + "   WHERE aIdCL= ?)");
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> getCourseByIDDLT(int aId) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("SELECT * FROM Course \n"
                    + "WHERE fId  IN \n"
                    + "  (SELECT fId FROM Faculty \n"
                    + "   WHERE aIdDLT= ?)");
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> getCourseByIDPVC(int aId) {
        try {
            ArrayList<Course> courseList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("SELECT * FROM Course \n"
                    + "WHERE fId  IN \n"
                    + "  (SELECT fId FROM Faculty \n"
                    + "   WHERE aIdPVC= ?)");
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courseList.add(new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd")));
            }
            return courseList;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Course CheckAddCourse(String cName) {
        try {
            Course course = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Course where cName = ?");
            ps.setString(1, cName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course(rs.getInt("cId"), rs.getInt("fId"), rs.getString("cCode"), rs.getString("cName"), rs.getString("cDescription"), rs.getString("cPostOn"), rs.getInt("cStart"), rs.getInt("cEnd"));

            }
            return course;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
