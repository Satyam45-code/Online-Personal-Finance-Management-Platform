package com.finance.dao;

import com.finance.interfaces.GenericDAO;
import com.finance.model.Budget;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetDAO implements GenericDAO<Budget> {
    public void save(Budget b)throws SQLException{
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement("INSERT INTO budgets(user_id,category,amount,duration) VALUES(?,?,?,?)")){
            p.setInt(1,b.getUserId());p.setString(2,b.getCategory());p.setDouble(3,b.getAmount());p.setString(4,b.getDuration());p.executeUpdate();
        }
    }
    public void delete(int id)throws SQLException{
        try(Connection c=DatabaseConnection.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM budgets WHERE id=?")){
            p.setInt(1,id);p.executeUpdate();
        }
    }
    public List<Budget> findAll(int userId)throws SQLException{
        List<Budget> list=new ArrayList<>();
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement("SELECT * FROM budgets WHERE user_id=? ORDER BY id DESC")){
            p.setInt(1,userId);ResultSet r=p.executeQuery();
            while(r.next())list.add(new Budget(r.getInt("id"),r.getInt("user_id"),r.getString("category"),r.getDouble("amount"),r.getString("duration")));
        }
        return list;
    }
}
