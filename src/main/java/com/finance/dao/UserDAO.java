package com.finance.dao;

import com.finance.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public User login(String email, String password) throws SQLException {
        String sql="SELECT * FROM users WHERE email=? AND password=? AND status='ACTIVE'";
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,email); p.setString(2,password);
            ResultSet r=p.executeQuery();
            if(r.next()) return map(r);
        }
        return null;
    }

    public List<User> findAll() throws SQLException {
        List<User> list=new ArrayList<>();
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement("SELECT * FROM users ORDER BY id DESC");
            ResultSet r=p.executeQuery()){
            while(r.next()) list.add(map(r));
        }
        return list;
    }

    public void save(User u) throws SQLException {
        String sql="INSERT INTO users(name,email,password,role,status) VALUES(?,?,?,?,?)";
        try(Connection c=DatabaseConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,u.getName());p.setString(2,u.getEmail());p.setString(3,u.getPassword());
            p.setString(4,u.getRole());p.setString(5,u.getStatus());p.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        try(Connection c=DatabaseConnection.getConnection(); PreparedStatement p=c.prepareStatement("DELETE FROM users WHERE id=?")){
            p.setInt(1,id);p.executeUpdate();
        }
    }

    private User map(ResultSet r)throws SQLException{
        return new User(r.getInt("id"),r.getString("name"),r.getString("email"),
                r.getString("password"),r.getString("role"),r.getString("status"));
    }
}
