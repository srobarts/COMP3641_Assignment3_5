package com.assmt3.core;

import java.io.Serializable;
import javax.faces.bean.ManagedBean; 
// or import javax.inject.Named;
import javax.faces.bean.SessionScoped;

@ManagedBean // or @Named
@SessionScoped
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String first;
	private String last;
	private String address;
	private String phone;
	private boolean editable;

   public Customer(String first, String last, String address, String phone) {
      this.first = first;
      this.last = last;
      this.address = address;
      this.phone = phone;
   }

   public void setFirst(String newValue) { first = newValue; }
   public String getFirst() { return first; }

   public void setLast(String newValue) { last = newValue; }     
   public String getLast() { return last; }
   
   public void setAddress(String newValue) { address = newValue; }     
   public String getAddress() { return address; }
   
   public void setPhone(String newValue) { phone = newValue; }     
   public String getPhone() { return phone; }
   
   public boolean isEditable() { return editable; }
   public void setEditable(boolean newValue) { editable = newValue; }
   
}
