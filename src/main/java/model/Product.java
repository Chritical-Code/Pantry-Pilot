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
    public static ArrayList<Product> getProducts(){
        //send the SELECT statement
        DBManager dbm = new DBManager();
        String statement = "SELECT * FROM Product";
        dbm.select(statement);

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
    public static void insertProduct(Product product){
        //create the statement
        DBManager dbm = new DBManager();
        String statement = String.format("INSERT INTO Product (brand, name, category) VALUES ('%s', '%s', '%s')", product.brand, product.name, product.category);

        //send the statement and close
        dbm.insert(statement);
        dbm.close();
    }

    //delete a product from the database
    public static void deleteProduct(int inID){
        //create the statement
        DBManager dbm = new DBManager();
        String statement = String.format("DELETE FROM Product WHERE id = %d", inID);

        //send the statement and close
        dbm.delete(statement);
    }
}
