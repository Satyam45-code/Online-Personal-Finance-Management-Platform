package com.finance.dao;

import com.finance.interfaces.GenericDAO;
import com.finance.model.Goal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoalDAO implements GenericDAO<Goal> {
    public void save(Goal g)throws SQLException{
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement("INSERT INTO goals(user_id,description,target_amount,saved_amount,deadline) VALUES(?,?,?,?,?)")){
            p.setInt(1,g.getUserId());p.setString(2,g.getDescription());p.setDouble(3,g.getTargetAmount());
            p.setDouble(4,g.getSavedAmount());p.setDate(5,Date.valueOf(g.getDeadline()));p.executeUpdate();
        }
    }
    public void delete(int id)throws SQLException{
        try(Connection c=DatabaseConnection.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM goals WHERE id=?")){
            p.setInt(1,id);p.executeUpdate();
        }
    }
    public List<Goal> findAll(int userId)throws SQLException{
        List<Goal> list=new ArrayList<>();
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement("SELECT * FROM goals WHERE user_id=? ORDER BY id DESC")){
            p.setInt(1,userId);ResultSet r=p.executeQuery();
            while(r.next())list.add(new Goal(r.getInt("id"),r.getInt("user_id"),r.getString("description"),
                    r.getDouble("target_amount"),r.getDouble("saved_amount"),r.getDate("deadline").toLocalDate()));
        }
        return list;
    }
}
