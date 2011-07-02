package com.assmt3.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped;

@ManagedBean // or @Named
@SessionScoped
public class TableData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(
		new Customer(1, "Anna", "Keeney", "100 Lonsdale", "654-333-1212"),
	    new Customer(2, "John", "Wilson", "123 Marine Drive", "604-555-1234"),
	    new Customer(3, "Mariko", "Randor", "555 Howe Street", "555-232-9045"),
	    new Customer(4, "William", "Dupont", "345 Granville Street", "345-453-1234")
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
