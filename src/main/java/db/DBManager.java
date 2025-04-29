package db;

import java.sql.*;

public class DBManager {
    //variables
    public Connection c = null;
    public Statement s = null;
    public ResultSet r = null;
    public PreparedStatement ps = null;

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

    //read
    public void executeQuery(String statement){
        try{
            s = c.createStatement();
            r = s.executeQuery(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //update
    public void executeUpdate(String statement){
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
