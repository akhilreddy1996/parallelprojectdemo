package org.capg.model;

import java.time.LocalDate;

public class Transaction {

  private LocalDate	Transdate;
  
  private  String amount;
  
  private String description;
  
  private String transtype;

public Transaction(LocalDate transdate, String amount, String description, String transtype) {
	super();
	Transdate = transdate;
	this.amount = amount;
	this.description = description;
	this.transtype = transtype;
}

public LocalDate getTransdate() {
	return Transdate;
}

public void setTransdate(LocalDate transdate) {
	Transdate = transdate;
}

public String getAmount() {
	return amount;
}

public void setAmount(String amount) {
	this.amount = amount;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getTranstype() {
	return transtype;
}

public void setTranstype(String transtype) {
	this.transtype = transtype;
}

public Transaction() {
	super();
}

@Override
public String toString() {
	return "Transaction [Transdate=" + Transdate + ", amount=" + amount + ", description=" + description
			+ ", transtype=" + transtype + "]";
}
  
  
	
	
}
