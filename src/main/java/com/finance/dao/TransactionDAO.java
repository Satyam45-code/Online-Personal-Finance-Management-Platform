package com.finance.dao;

import com.finance.interfaces.GenericDAO;
import com.finance.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements GenericDAO<Transaction> {
    public void save(Transaction t) throws SQLException {
        String sql="INSERT INTO transactions(user_id,category,amount,transaction_date,description) VALUES(?,?,?,?,?)";
        try(Connection c=DatabaseConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,t.getUserId());p.setString(2,t.getCategory());p.setDouble(3,t.getAmount());
            p.setDate(4,Date.valueOf(t.getDate()));p.setString(5,t.getDescription());p.executeUpdate();
        }
    }
    public void delete(int id)throws SQLException{
        try(Connection c=DatabaseConnection.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM transactions WHERE id=?")){
            p.setInt(1,id);p.executeUpdate();
        }
    }
    public List<Transaction> findAll(int userId)throws SQLException{
        List<Transaction> list=new ArrayList<>();
        String sql="SELECT * FROM transactions WHERE user_id=? ORDER BY transaction_date DESC,id DESC";
        try(Connection c=DatabaseConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,userId);ResultSet r=p.executeQuery();
            while(r.next()) list.add(new Transaction(r.getInt("id"),r.getInt("user_id"),r.getString("category"),
                    r.getDouble("amount"),r.getDate("transaction_date").toLocalDate(),r.getString("description")));
        }
        return list;
    }
}
