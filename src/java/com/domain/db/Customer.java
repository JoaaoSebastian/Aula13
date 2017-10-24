package com.domain.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class Customer {
        private int id;
        private String name;
        private String city;
        
        public static ArrayList<Customer> getList()throws Exception{
            ArrayList<Customer> list = new ArrayList<>();
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url= "jdbc:derby://localhost:1527/sample";
            String user= "app";
            String pass = "app";
            Connection c = DriverManager.getConnection(url, user, pass);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT CUSTOMER_ID, NAME, CITY FROM CUSTOMER " + "ORDER BY NAME");
            while(rs.next()){
                Customer customer = new Customer(
                  rs.getInt(1)
                , rs.getString(2)
                , rs.getString(3));
                list.add(customer);
            }
            return list;
        }

    public Customer(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
        
   
        
}
