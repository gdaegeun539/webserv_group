package org.agora.webserv_group.dao;

import org.agora.webserv_group.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserDAO {
    private ConnectionMaker connectionMaker;
    PreparedStatement pstmt;
    Connection conn;

    public UserDAO() {
        connectionMaker = new ConnectionMaker();
    }
    public void close(){
        try {
            pstmt.close();
            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean idCheck(String id) { //id를 입력하지 않았거나 DB내에 존재하지 않는 id를 입력한 경우 false를 반환
        String sql = "select EXISTS (select * from usertable where ID= ? limit 1) as success";
        try {
            if(id != null){ //id 입력을한 경우 실행
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                boolean check = pstmt.execute(); //존재하면 true 없으면 false 저장
                if(check) {return true;} //DB내에 존재시 true를 반환
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public void addUser(User user){
        String sql = "insert into user(uid,password,name,interest,admin) values(?,?,?,?,?)";
        String sqlEmail = "insert into usertable(email) values(?)";
        conn = connectionMaker.makeNewConnection();
        String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUid());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getName());
            pstmt.setString(4,user.getInterest());
            pstmt.setBoolean(5,user.getAdmin());
            pstmt.executeUpdate();

            if(Pattern.matches(emailPattern,user.getEmail())) {
                pstmt = conn.prepareStatement(sqlEmail);
                pstmt.setString(1,user.getEmail());
                pstmt.executeUpdate();
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
           close();
        }
    }

    public User getUser(String uid){
        conn = connectionMaker.makeNewConnection();
        User u = new User();
        try{
            pstmt = conn.prepareStatement("select * from usertable where uid = ?");
            pstmt.setString(1,uid);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            u.setUid(rs.getString("uid"));
            u.setPassword(rs.getString("password"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            u.setInterest(rs.getString("interest"));
            u.setAdmin(rs.getBoolean("admin"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            close();
        }
        return u;
    }

    public void interestUpdate(String i, String uid){
        conn = connectionMaker.makeNewConnection();
        try{
            pstmt = conn.prepareStatement("update usertable set interest = ? where uid = ?");
            pstmt.setString(1,i);
            pstmt.setString(2,uid);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close();
        }
    }

    public String findId(String name, String email){
        conn = connectionMaker.makeNewConnection();
        String uid = "";
        try{
            pstmt = conn.prepareStatement("select * from usertable where name = ? and email = ?");
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            uid = rs.getString("uid");
        }catch (SQLException e) {
            e.printStackTrace();
        } finally{
            close();
        }
        return uid;
    }

    public String findPassword(String uid){
        conn = connectionMaker.makeNewConnection();
        String password = "";
        try{
            pstmt = conn.prepareStatement("select * from usertable where uid = ?");
            pstmt.setString(1,uid);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            password = rs.getString("password");
        }catch (SQLException e) {
            e.printStackTrace();
        } finally{
            close();
        }
        return password;
    }
}
