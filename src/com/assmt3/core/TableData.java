package com.assmt3.core;

import java.io.Serializable;
import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;

@ManagedBean // or @Named
@SessionScoped
public class TableData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final Customer[] customers = new Customer[] {
		new Customer("Anna", "Keeney", "100 Lonsdale", "654-333-1212"),
	    new Customer("John", "Wilson", "123 Marine Drive", "604-555-1234"),
	    new Customer("Mariko", "Randor", "555 Howe Street", "555-232-9045"),
	    new Customer("William", "Dupont", "345 Granville Street", "345-453-1234")
	};
   
   public Customer[] getCustomers() { return customers;}

   public String save() {
      for (Customer customer : customers) customer.setEditable(false);
      return null;
   }
   
}