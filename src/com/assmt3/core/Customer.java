package com.assmt3.core;

import java.io.Serializable;
import javax.faces.bean.ManagedBean; 
// or import javax.inject.Named;
import javax.faces.bean.SessionScoped;

@ManagedBean // or @Named
@SessionScoped
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String first;
	private String last;
	private String address;
	private String phone;
	private String city;
	private String prov;
	private boolean editable;

   public Customer(int id, String first, String last, String address, String city, String prov, String phone) {
	  this.id = id;
      this.first = first;
      this.last = last;
      this.address = address;
      this.city = city;
      this.prov = prov;
      this.phone = phone;
   }
   
   public void setId(int newValue) { id = newValue; }
   public int getId() { return id; }

   public void setFirst(String newValue) { first = newValue; }
   public String getFirst() { return first; }

   public void setLast(String newValue) { last = newValue; }     
   public String getLast() { return last; }
   
   public void setAddress(String newValue) { address = newValue; }     
   public String getAddress() { return address; }
   
   public void setPhone(String newValue) { phone = newValue; }     
   public String getPhone() { return phone; }
   
   public void setCity(String newValue) { city = newValue; }     
   public String getCity() { return city; }
   
   public void setProv(String newValue) { prov = newValue; }     
   public String getProv() { return prov; }
   
   public boolean isEditable() { return editable; }
   public void setEditable(boolean newValue) { editable = newValue; }
   
}
