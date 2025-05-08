package model;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import db.*;

public class Item {
    //Variables
    public int id;
    public int productID;
    public Date expiry;
    public String productName; //special case - not part of the DB, just used to store the retrieved name

    //Functions
    //read items
    public static ArrayList<Item> readItems(){
        //send the SELECT statement
        DBManager dbm = new DBManager();
        String statement =  "SELECT Item.id, Product.name, item.expiry" +
                            " FROM Item" +
                            " JOIN Product ON Item.productID = Product.id";
        dbm.executeQuery(statement);

        //make object list from ResultSet
        ArrayList<Item> items = new ArrayList<>();
        try{
            while(dbm.r.next()){
                Item tempItem = new Item();
                tempItem.id = dbm.r.getInt("id");
                tempItem.productName = dbm.r.getString("name");
                tempItem.expiry = dbm.r.getDate("expiry");
                items.add(tempItem);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        dbm.close();
        return items;
    }

    //insert item
    public static void createItem(Item item){
        //create the sql
        DBManager dbm = new DBManager();
        String sql = "INSERT INTO Item (productID, expiry) VALUES (?, ?)";

        //prepare and execute
        try{
            dbm.ps = dbm.c.prepareStatement(sql);
            dbm.ps.setInt(1, item.productID);

            //in case of null date
            if(Objects.equals(item.expiry, null)){
                dbm.ps.setDate(2, null);
            }
            else{
                dbm.ps.setDate(2, new java.sql.Date(item.expiry.getTime()));
            }

            dbm.ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //close
        dbm.close();
    }
}
