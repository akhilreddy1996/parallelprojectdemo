package org.capg.dao;

import java.util.List;

import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.model.LoginBean;
import org.capg.model.Transaction;

public interface ILoginDao {
	public boolean isValidLogin(LoginBean loginBean);
	
	public boolean createCustomer(Customer customer);

	public boolean createaccount(Account acc,String mailid);

	public List<Account> getAllAccounts(String mailid);

	public boolean addtransaction1(Transaction trans, int acc, int no, String mail);

	public List<Account> getAllAccounts2(String mail);

	public boolean addtransaction2(Transaction trans, int acc1, int acc2, String mail);

	public List<Transaction> getalltransactions(String mail);

	
}
