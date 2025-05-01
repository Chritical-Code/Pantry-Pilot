package model;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import db.*;

public class Item {
    //Variables
    public int id;
    public int productID;
    public Date expiry;
    public String productName; //special case - not part of the DB, just used to store the retrieved name

    //Functions
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
}
