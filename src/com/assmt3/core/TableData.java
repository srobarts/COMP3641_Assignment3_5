package com.assmt3.core;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;
import javax.naming.NamingException;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

@ManagedBean // or @Named
@SessionScoped
public class TableData implements Serializable {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	public Connection getConnection(String user, String pass) throws SQLException{
		   Connection conn = null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://Beangrinder.bcit.ca", user, pass);
			}catch(ClassNotFoundException cnfe){
				System.out.println("FAILED TO CONNECT TO DATABASE");
			}
				
		   return conn;
	   }
	 
	   public Result getAll() throws SQLException, NamingException {
		      try {
		         conn = getConnection("javastudent", "compjava");
		         Statement stmt = conn.createStatement();        
		         ResultSet result = stmt.executeQuery("SELECT * FROM Customers");
		         return ResultSupport.toResult(result);
		      } finally {
		         //close();
		      }
		   }
	
	private ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(
		new Customer("Anna", "Keeney", "100 Lonsdale", "654-333-1212"),
	    new Customer("John", "Wilson", "123 Marine Drive", "604-555-1234"),
	    new Customer("Mariko", "Randor", "555 Howe Street", "555-232-9045"),
	    new Customer("William", "Dupont", "345 Granville Street", "345-453-1234")
	));
   
   public ArrayList<Customer> getCustomers() { return customers;}

   public String save() {
      for (Customer customer : customers) customer.setEditable(false);
      return null;
   }
   
   public String deleteRow(Customer nameToDelete) {
	      customers.remove(nameToDelete);
	      return null;
	   }
   
}
