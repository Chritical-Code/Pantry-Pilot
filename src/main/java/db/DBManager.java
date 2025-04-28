package db;

import java.sql.*;

public class DBManager {
    //variables
    public Connection c = null;
    public Statement s = null;
    public ResultSet r = null;

    //constructor
    public DBManager(){
        try{
            c = DriverManager.getConnection("jdbc:sqlite:pantry.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    //functions
    //select
    public void select(String statement){
        try{
            s = c.createStatement();
            r = s.executeQuery(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //update
    public void update(String statement){
        try{
            s = c.createStatement();
            s.executeUpdate(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //insert
    public void insert(String statement){
        try{
            s = c.createStatement();
            s.executeUpdate(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //delete
    public void delete(String statement){
        try{
            s = c.createStatement();
            s.executeUpdate(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //close
    public void close(){
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
