package org.capg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.model.LoginBean;
import org.capg.model.Transaction;



public class LoginDaoImpl implements ILoginDao{

	@Override
	public boolean isValidLogin(LoginBean loginBean) {
		
String sql="select * from customers";
		
		
		try(Connection conn=getDbConnection()) {
			//	Statement statement=conn.createStatement();
				
				PreparedStatement pst=conn.prepareStatement(sql);
				
				ResultSet res=pst.executeQuery();
				
				while(res.next())
				{
					if(res.getString(2).compareTo(loginBean.getUserName())==0 && res.getString(3).compareTo(loginBean.getUserPassword())==0) {
						{
							return true;
						}
					}
				}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	private Connection getMysqlDbConnection() {
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "India123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}


	@Override
	public boolean createCustomer(Customer customer) {
		int customerId=0;
		boolean flag=false;
	String sql="insert into customers(emailId,customerPwd)"+
						" values(?,?)";
		
	try(PreparedStatement pst=getMysqlDbConnection().prepareStatement(sql)) {
			
		
		
		pst.setString(1, customer.getEmailId());
		pst.setString(2,customer.getCustomerPwd());	
		
		int count=pst.executeUpdate();
		if(count>0)
			flag=true;
		else {
			flag=false;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
	}



private Connection getDbConnection() {
	Connection connection=null;
	try{	
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/customer", "root", "India123");
		return connection;
	}catch (ClassNotFoundException|SQLException e) {
		e.printStackTrace();
	}
	
	return null;
	
}


@Override
public boolean createaccount(Account acc,String mailid) {
	// TODO Auto-generated method stub
	
	int custid=0;
	
	String sql="insert into account(acctype,openingdate,openingbalance,description,cstid) values(?,?,?,?,?) ";
	String sql1="select * from customers";
	String sql2="select * from account";
	String sql3="select * from account where cstid=?";
			
try(PreparedStatement pst=getMysqlDbConnection().prepareStatement(sql)) {
		
	PreparedStatement pst1=getMysqlDbConnection().prepareStatement(sql1);
	
	ResultSet res=pst1.executeQuery();
	
	while(res.next())
	{
		if(res.getString(2).compareTo(mailid)==0)
		{
			custid=res.getInt(1);
		}
	}
	
	
	PreparedStatement pst3=getMysqlDbConnection().prepareStatement(sql3);
	pst3.setInt(1, custid);
	
	ResultSet res3=pst3.executeQuery();
	
	while(res3.next())
	{
		if(res3.getString(2).compareTo(acc.getAccountType())==0)
		{
			return false;
		}
	}
	
	
	
	
	pst.setString(1, acc.getAccountType());
	pst.setDate(2, Date.valueOf(acc.getOpeningDate()));
	pst.setDouble(3, acc.getOpeningBalance());
	pst.setString(4, acc.getDescription());
	pst.setInt(5, custid);
	int count=pst.executeUpdate();
	if(count>0)
		return true;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return false;
}


@Override
public List<Account> getAllAccounts(String mailid) {
	// TODO Auto-generated method stub
	
	List<Account> accounts=new ArrayList<>();
	
	int custid=0;
	
	String sql="select * from account";
	
	String sql1="select * from customers";
	
	try(PreparedStatement pst=getMysqlDbConnection().prepareStatement(sql)) {
		
		PreparedStatement pst1=getMysqlDbConnection().prepareStatement(sql1);
		
		ResultSet res=pst1.executeQuery();
		
		while(res.next())
		{
			if(res.getString(2).compareTo(mailid)==0)
			{
				custid=res.getInt(1);
				System.out.println(custid);
			}
		}
		
		
		ResultSet res1=pst.executeQuery();
		
		while(res1.next())
		{
			if(res1.getInt(6)==custid)
			{
				Account acc=new Account();
				acc.setAccountNumber(res1.getInt(1));
			acc.setAccountType(res1.getString(2));
			//	acc.setOpeningDate(res1.getDate(3).toLocalDate());
				//acc.setOpeningBalance(res.getDouble(4));
				//acc.setDescription(res.getString(5));
			
			//	System.out.println(acc);
				accounts.add(acc);
			}
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	return accounts;
	
}


@Override
public boolean addtransaction1(Transaction trans, int acc, int no, String mail) {
	// TODO Auto-generated method stub

	
	String sql="insert into transactions(transactiondate,fromacc,toacc,amount,description,transtype,custid) values(?,?,?,?,?,?,?)";
		
	String sql1="select * from customers";
	
	int custid=0;
	
	
	try(PreparedStatement pst=getMysqlDbConnection().prepareStatement(sql)) {
		
	

		PreparedStatement pst1=getMysqlDbConnection().prepareStatement(sql1); 
		
		ResultSet res1=pst1.executeQuery();
		
		 while(res1.next())
		 {
			 if(res1.getString(2).compareTo(mail)==0)
			 {
				 custid=res1.getInt(1);
				 System.out.println(custid+1);
			 }
		 }
		
		
		
		pst.setDate(1, Date.valueOf(LocalDate.now()));
		
		pst.setInt(2, acc);
		
		pst.setInt(3, acc);
		
		pst.setString(4, trans.getAmount());
		
		pst.setString(5, trans.getDescription());
		
		pst.setString(6, trans.getTranstype());
		
       pst.setInt(7, custid);
		
       System.out.println(trans);
      System.out.println(custid+2);
				
		int count=pst.executeUpdate();
		
		if(count>0)
		{
		return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

return false;
}


@Override
public List<Account> getAllAccounts2(String mail) {
	// TODO Auto-generated method stub
	
	int custid=0;
	List<Account> accounts2 = new ArrayList<>();
	
   String sql="select * from account where cstid not in (?)";
   
   String sql2="select * from customers";
	
	try(PreparedStatement pst=getMysqlDbConnection().prepareStatement(sql2)) {

		ResultSet res=pst.executeQuery();

		 while(res.next())
		 {
			 if(res.getString(2).compareTo(mail)==0)
			 {
				 custid=res.getInt(1);
				
			 }
		 }
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	try(PreparedStatement pst2=getMysqlDbConnection().prepareStatement(sql)) {

	pst2.setInt(1, custid);
	
	ResultSet res2=pst2.executeQuery();
	
	while(res2.next())
	{
		Account acc=new Account();
		acc.setAccountNumber(res2.getInt(1));
	acc.setAccountType(res2.getString(2));
	//	acc.setOpeningDate(res1.getDate(3).toLocalDate());
		//acc.setOpeningBalance(res.getDouble(4));
		//acc.setDescription(res.getString(5));
	 System.out.println(acc);
	//	System.out.println(acc);
		accounts2.add(acc);	
	}

		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return accounts2;
}


@Override
public boolean addtransaction2(Transaction trans, int acc1, int acc2, String mail) {
	// TODO Auto-generated method stub
	
	String sql="insert into transactions(transactiondate,fromacc,toacc,amount,description,transtype,custid) values(?,?,?,?,?,?,?)";
	
	String sql1="select * from customers";
	
	int custid=0;
	
	
	try(PreparedStatement pst=getMysqlDbConnection().prepareStatement(sql)) {
		
	

		PreparedStatement pst1=getMysqlDbConnection().prepareStatement(sql1); 
		
		ResultSet res1=pst1.executeQuery();
		
		 while(res1.next())
		 {
			 if(res1.getString(2).compareTo(mail)==0)
			 {
				 custid=res1.getInt(1);
				 System.out.println(custid+1);
			 }
		 }
		
		
		
		pst.setDate(1, Date.valueOf(LocalDate.now()));
		
		pst.setInt(2, acc1);
		
		pst.setInt(3, acc2);
		
		pst.setString(4, trans.getAmount());
		
		pst.setString(5, trans.getDescription());
		
		pst.setString(6, trans.getTranstype());
		
       pst.setInt(7, custid);
		
       System.out.println(trans);
      System.out.println(custid+2);
				
		int count=pst.executeUpdate();
		
		if(count>0)
		{
		return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}


@Override
public List<Transaction> getalltransactions(String mail) {
	// TODO Auto-generated method stub
	
	List<Transaction> transactions = new ArrayList<>();
	
	int custid=0;
	
	String sql="select * from transactions";
	
	String sql1="select * from customers";
	
	try(PreparedStatement pst=getMysqlDbConnection().prepareStatement(sql)) {
		
		PreparedStatement pst1=getMysqlDbConnection().prepareStatement(sql1);
		
		ResultSet res1=pst1.executeQuery();
		
		while(res1.next())
		{
			if(res1.getString(2).compareTo(mail)==0)
			{
			custid=res1.getInt(1);
			}
		}
		
		
		
		
		ResultSet res=pst.executeQuery();
		
		while(res.next())
		{
			if(res.getInt(8)==custid)
			{
				Transaction trans=new Transaction();
				
				trans.setAmount(res.getString(5));
				trans.setDescription(res.getString(6));
				trans.setTransdate(res.getDate(2).toLocalDate());
				trans.setTranstype(res.getString(7));
				
				transactions.add(trans);
				
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return transactions;
}
}
