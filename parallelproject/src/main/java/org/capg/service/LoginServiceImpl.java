package org.capg.service;

import java.util.List;

import org.capg.dao.ILoginDao;
import org.capg.dao.LoginDaoImpl;
import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.model.LoginBean;
import org.capg.model.Transaction;

public class LoginServiceImpl implements ILoginService{

	private ILoginDao loginDao=new LoginDaoImpl();
	
	@Override
	public boolean isValidLogin(LoginBean loginBean) {
		/*if(loginBean.getUserName().equals("tom") && 
				loginBean.getUserPassword().equals("tom123")) {
			return true;
		}*/
		
		if(loginDao.isValidLogin(loginBean))
			return true;
		
		return false;
	}

	@Override
	public boolean createCustomer(Customer customer) {
		
		return loginDao.createCustomer(customer);
	}

	@Override
	public boolean createaccount(Account acc,String mailid) {
		// TODO Auto-generated method stub
		if(loginDao.createaccount(acc,mailid))
			return true;
		else
		{
			return false;
		}
	}

	@Override
	public List<Account> getAllAccounts(String mailid) {
		// TODO Auto-generated method stub
    
	return loginDao.getAllAccounts(mailid);
	
	}

	@Override
	public boolean addtransaction1(Transaction trans, int acc, int no, String mail) {
		// TODO Auto-generated method stub
		return loginDao.addtransaction1(trans,acc,no,mail);
		
		
	}

	@Override
	public List<Account> getAllAccounts2(String mail) {
		// TODO Auto-generated method stub
		return loginDao.getAllAccounts2(mail);
	}

	@Override
	public boolean addtransaction2(Transaction trans, int acc1, int acc2, String mail) {
		// TODO Auto-generated method stub
		return loginDao.addtransaction2(trans, acc1, acc2, mail);
	}

	@Override
	public List<Transaction> getalltransactions(String mail) {
		// TODO Auto-generated method stub
		return loginDao.getalltransactions(mail);
		
	}

	
}
