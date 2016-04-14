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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.websocket.Session;

/**
 *
 * @author Dell
 */
public class AccountDataAccess {

    static Properties mailServerProperties;
    static javax.mail.Session getMailSession;
    static MimeMessage generateMailMessage;

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
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Account getAnccountByaId(int aId) {
        try {
            ArrayList<Account> accountList = new ArrayList<>();
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareCall("select * from Account where aId=?");
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accountList.add(new Account(rs.getInt("aId"), rs.getInt("arId"), rs.getString("aFirstName"), rs.getString("aLastName"), rs.getString("aUserName"), rs.getString("aPassword"), rs.getString("aEmail"), rs.getString("aAddress")));
            }
            return accountList.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
                accountList.add(new Account(rs.getInt("aId"), rs.getInt("arId"), rs.getString("aFirstName"), rs.getString("aLastName"), rs.getString("aUserName"), rs.getString("aPassword"), rs.getString("aEmail"), rs.getString("aAddress")));
            }
            return accountList;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean addAccount(Account account) {
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareCall("insert into Account values(?,?,?,?,?,?,?)");
            ps.setInt(1, account.getArId());
            ps.setString(2, account.getaFirstName());
            ps.setString(3, account.getaLastName());
            ps.setString(4, account.getaUsername());
            ps.setString(5, account.getaPassword());
            ps.setString(6, account.getaEmail());
            ps.setString(7, account.getaAddress());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Account getAccountByCMID(int cm) {
        try {
            Account account = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account WHERE aId=?");
            ps.setInt(1, cm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt("aId"), rs.getInt("arId"), rs.getString("aFirstName"), rs.getString("aLastName"), rs.getString("aUserName"), rs.getString("aPassword"), rs.getString("aEmail"), rs.getString("aAddress"));
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Account getAccountByCLID(int cl) {
        try {
            Account account = null;
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from Account WHERE aId=?");
            ps.setInt(1, cl);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt("aId"), rs.getInt("arId"), rs.getString("aFirstName"), rs.getString("aLastName"), rs.getString("aUserName"), rs.getString("aPassword"), rs.getString("aEmail"), rs.getString("aAddress"));
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void generateAndSendEmail(Account cmid, Account clid, Course c) throws AddressException, MessagingException {

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = javax.mail.Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(clid.aEmail));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cmid.aEmail));
        generateMailMessage.setSubject("BAN GIAM HIEU TRA TRUONG THONG BAO");
        String emailBody = "A course :" + c.cName + " have been assign to <br> Teacher :" + clid.aFirstName + " as course leader <br> Teacher :" + cmid.aFirstName + " as course monitor<br><br> Best regards, <br>Admin";
        generateMailMessage.setContent(emailBody, "text/html");

        // Step3
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "thanhntgc00493@fpt.edu.vn", "vanminh1989");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

    }

    public static void addCMRsendMail(Course c, Account cmid,Account clid) throws AddressException, MessagingException {

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = javax.mail.Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(clid.aEmail));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cmid.aEmail));
        generateMailMessage.setSubject("ADD CMR REPORT");
        String emailBody = "Dear MR/MRS " + cmid.aUsername + " <br><br> My name is : " + clid.aUsername +".Course leader of course's name :" +c.cName+"<br>I have send you this course CMR in our system.Please check it.<br><br> Best regards, <br>"+clid.aUsername+"";
        generateMailMessage.setContent(emailBody, "text/html");

        // Step3
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "thanhntgc00493@fpt.edu.vn", "vanminh1989");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

    }

  
}
