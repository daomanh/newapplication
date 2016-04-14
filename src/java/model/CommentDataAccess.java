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
public class CommentDataAccess {

    public static ArrayList<Account> getAccountByaId(int aId) {
        try {
            ArrayList<Account> accountList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Account where aId=?");
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountList.add(new Account(rs.getInt("aId"), rs.getInt("arId"), rs.getString("aFirstName"), rs.getString("aLastName"), rs.getString("aUserName"), rs.getString("aPassword"), rs.getString("aEmail"), rs.getString("aAddress")));
            }
            return accountList;
        } catch (SQLException ex) {
            Logger.getLogger(CommentDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean CheckAccountExistence(String aUserName, String aPassword) {
        try {
            ArrayList<Account> accountList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Account where aUserName = ? and aPassword  = ?");
            ps.setString(1, aUserName);
            ps.setString(2, aPassword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Account getAccountByaUsername(String aUsername) {
        try {
            ArrayList<Account> accountList = new ArrayList<>();
            PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement("select * from Account where aUsername = ?");
            ps.setString(1, aUsername);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountList.add(new Account(rs.getInt("aId"), rs.getInt("arId"), rs.getString("aFirstName"), rs.getString("aLastName"), rs.getString("aUserName"), rs.getString("aPassword"), rs.getString("aEmail"), rs.getString("aAddress")));
            }
            return accountList.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(CommentDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList getAccountByaRole(int arId) {
        try {
            ArrayList<Account> accountList = new ArrayList<>();
            PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement("select * from Account where arId =?");
            ps.setInt(1, arId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountList.add(new Account(rs.getInt("aId"), rs.getInt("arId"),  rs.getString("aFirstName"), rs.getString("aLastName"), rs.getString("aUserName"), rs.getString("aPassword"), rs.getString("aEmail"), rs.getString("aAddress")));
            }
            return accountList;
        } catch (SQLException ex) {
            Logger.getLogger(CommentDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public static boolean addAccount(Account account) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("insert into Account values(?,?,?,?,?,?,?)");
            ps.setInt(1, account.getArId());
            ps.setString(3, account.getaFirstName());
            ps.setString(4, account.getaLastName());
            ps.setString(5, account.getaUsername());
            ps.setString(6, account.getaPassword());
            ps.setString(7, account.getaEmail());
            ps.setString(8, account.getaAddress());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteAccount(int aId) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("delete from Account where aId = ?");
            ps.setInt(1, aId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
