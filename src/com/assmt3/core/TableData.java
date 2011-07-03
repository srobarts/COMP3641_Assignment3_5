package com.assmt3.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

import com.assmt3.core.SortFilterModel;
import com.assmt3.core.Customer;

@ManagedBean // or @Named
@SessionScoped
public class TableData implements Serializable {
	private static final long serialVersionUID = 1L;
	private SortFilterModel<Customer> filterModel;
	
	private ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(
		new Customer(1, "Anna", "Keeney", "100 Lonsdale", "North Vancouver", "BC", "654-333-1212"),
	    new Customer(2, "John", "Wilson", "123 Marine Drive", "North Vancouver", "BC", "604-555-1234"),
	    new Customer(3, "Mariko", "Randor", "555 Howe Street", "Vancouver", "BC", "555-232-9045"),
	    new Customer(5, "William", "Dupont", "345 Granville Street", "Vancouver", "BC", "345-453-1234"),
		new Customer(6, "Bill", "Dupont", "500 Granville Street", "Vancouver", "BC", "345-453-1234"),
		new Customer(7, "Sue", "Williams", "820 Hornby Street", "Vancouver", "BC", "345-453-1234"),
		new Customer(8, "Joseph", "Johns", "120 Deercrest Ave", "North Vancouver", "BC", "345-453-1234"),
		new Customer(9, "Phil", "Hartman", "45 Georgia Street", "Vancouver", "BC", "345-453-1234"),
		new Customer(10, "Jane", "Smith", "90 Davie Street", "Vancouver", "BC", "345-453-1234")
	));
   
   //public ArrayList<Customer> getCustomers() { return customers;}
   
   public TableData() {
	   final Customer[] customerArray = customers.toArray(new Customer[customers.size()]);
	   filterModel = new SortFilterModel<Customer>(new ArrayDataModel<Customer>(customerArray));
   }
   
   public DataModel<Customer> getCustomers() {
	   final Customer[] customerArray = customers.toArray(new Customer[customers.size()]);
	   filterModel = new SortFilterModel<Customer>(new ArrayDataModel<Customer>(customerArray));
	   return filterModel;
   }
   
   public String sortByFirst() {
      filterModel.sortBy(new Comparator<Customer>() {
         public int compare(Customer n1, Customer n2) {
            return n1.getFirst().compareTo(n2.getFirst());
         }  
      });
      return null;
   }
   
   public String sortByLast() {
      filterModel.sortBy(new Comparator<Customer>() {
         public int compare(Customer n1, Customer n2) {
            return n1.getLast().compareTo(n2.getLast());
         }  
      });
      return null;
   }
   
   public String sortByAddress() {
	      filterModel.sortBy(new Comparator<Customer>() {
	         public int compare(Customer n1, Customer n2) {
	            return n1.getAddress().compareTo(n2.getAddress());
	         }  
	      });
	      return null;
	   }
   
   public String sortByCity() {
	      filterModel.sortBy(new Comparator<Customer>() {
	         public int compare(Customer n1, Customer n2) {
	            return n1.getCity().compareTo(n2.getCity());
	         }  
	      });
	      return null;
	   }
   
   public String sortByProv() {//
	      filterModel.sortBy(new Comparator<Customer>() {
	         public int compare(Customer n1, Customer n2) {
	            return n1.getProv().compareTo(n2.getProv());
	         }  
	      });
	      return null;
	   }
   
   public String sortByPhone() {
	      filterModel.sortBy(new Comparator<Customer>() {
	         public int compare(Customer n1, Customer n2) {
	            return n1.getPhone().compareTo(n2.getPhone());
	         }  
	      });
	      return null;
	   }

   public String save() {
      for (Customer customer : customers) customer.setEditable(false);
      return null;
   }
   
   public String deleteRow(Customer nameToDelete) {
	      customers.remove(nameToDelete);
	      return null;
	   }
   
   public void add(Temp temp) {
	   //parse out values of temp and add to customer
	   int id = 1;
	   Customer cust = new Customer(id, temp.getFirst(), temp.getLast(), 
			   							temp.getAddress(), temp.getCity(), temp.getProv(), temp.getPhone());
	   customers.add(cust);
	   
   }
   
}
