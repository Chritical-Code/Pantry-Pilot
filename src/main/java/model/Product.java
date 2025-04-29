package model;

import db.DBManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class Product {
    public int id;
    public String brand;
    public String name;
    public String category;

    //functions
    //return full product list
    public static ArrayList<Product> readProducts(){
        //send the SELECT statement
        DBManager dbm = new DBManager();
        String statement = "SELECT * FROM Product";
        dbm.executeQuery(statement);

        //make object list from ResultSet
        ArrayList<Product> products = new ArrayList<>();
        try{
            while(dbm.r.next()){
                Product product = new Product();
                product.id = dbm.r.getInt("id");
                product.brand = dbm.r.getString("brand");
                product.name = dbm.r.getString("name");
                product.category = dbm.r.getString("category");
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //close and return
        dbm.close();
        return products;
    }

    //insert a product into the database
    public static void createProduct(Product product){
        //create the sql
        DBManager dbm = new DBManager();
        String sql = "INSERT INTO Product (brand, name, category) VALUES (?, ?, ?)";

        //prepare and execute
        try{
            dbm.ps = dbm.c.prepareStatement(sql);
            dbm.ps.setString(1, product.brand);
            dbm.ps.setString(2, product.name);
            dbm.ps.setString(3, product.category);
            dbm.ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //close
        dbm.close();
    }

    //update a product in the database
    public static void updateProduct(Product product){
        //create the sql
        DBManager dbm = new DBManager();
        String sql = "UPDATE Product SET brand = ?, name = ?, category = ? WHERE id = ?";

        //prepare and execute
        try{
            dbm.ps = dbm.c.prepareStatement(sql);
            dbm.ps.setString(1, product.brand);
            dbm.ps.setString(2, product.name);
            dbm.ps.setString(3, product.category);
            dbm.ps.setInt(4, product.id);
            dbm.ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //close
        dbm.close();
    }

    //delete a product from the database
    public static void deleteProduct(int inID){
        //create the sql
        DBManager dbm = new DBManager();
        String sql = "DELETE FROM Product WHERE id = ?";

        //prepare and execute
        try{
            dbm.ps = dbm.c.prepareStatement(sql);
            dbm.ps.setInt(1, inID);
            dbm.ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //close
        dbm.close();
    }
}
