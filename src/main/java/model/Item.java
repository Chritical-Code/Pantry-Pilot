package model;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import db.*;

public class Item {
    public int id;
    public int productID;
    public Date expiry;

    //functions
    public static ArrayList<Item> getItems(){
        //send the SELECT statement
        DBManager dbm = new DBManager();
        String statement = "SELECT * FROM item";
        dbm.executeQuery(statement);

        //make object list from ResultSet
        ArrayList<Item> items = new ArrayList<>();
        try{
            while(dbm.r.next()){
                Item tempItem = new Item();
                tempItem.id = dbm.r.getInt("id");
                tempItem.productID = dbm.r.getInt("productID");
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
