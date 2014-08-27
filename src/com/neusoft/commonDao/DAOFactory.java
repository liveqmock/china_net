package com.neusoft.commonDao;

import com.neusoft.dao.CardSaleDAO;
import com.neusoft.dao.CardSaleDAOImpl;
import com.neusoft.dao.InterSettleDao;
import com.neusoft.dao.InterSettleDaoImpl;
import com.neusoft.dao.OutAccountDAO;
import com.neusoft.dao.OutAccountDAOImpl;
import com.neusoft.dao.StoredToDAO;
import com.neusoft.dao.StoredToDAOImpl;
import com.neusoft.dao.UserDao;
import com.neusoft.dao.UserDaoImpl;


public class DAOFactory {

	public static OutAccountDAO getOutAccountDAO(){
		return new OutAccountDAOImpl();
	}
	public static CardSaleDAO getCardSaleDAO(){
		return new CardSaleDAOImpl();
	}
	
	public static StoredToDAO getStoredToDAO(){
		return new StoredToDAOImpl();
	}
	public static InterSettleDao getInterSettleDao(){
		return new InterSettleDaoImpl();
	}
	public static UserDao getUserDAO() {
		return new UserDaoImpl();
	}
	
}
