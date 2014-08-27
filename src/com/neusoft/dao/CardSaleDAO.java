package com.neusoft.dao;

import java.util.List;

import com.neusoft.vo.CardSale;

public interface CardSaleDAO {

	/**分页查询所有记录*/
	public List<CardSale> findCardSaleRecord(int currentPage, int pageSize,String cityCode,String productCode,String checkCode ,String recordMonth1,String recordMonth2)throws Exception;
	/**查询总的记录数*/
	public int findAllRows(String cityCode,String productCode,String checkCode ,String recordMonth1,String recordMonth2) throws Exception;
	
	
	public void insertCardSale(String yearMonth, String cityCode,String productCode,
			double amount,double parValue,double discountFee, 
			double totalFee, double discount,String recordOperator) throws Exception;

	public List<CardSale> getAllProductName() throws Exception;
	
	public List<CardSale> getAllCityName() throws Exception;
	
	public CardSale getCardSaleById(int id) throws Exception;
	
	public void updateCardSale(int id, String yearMonth, String cityCode,
			String productCode, double parValue, double amount,
			double totalFee, double discountFee, double discount) throws Exception;
	
	public void deleteCardSaleById(int id) throws Exception;
	
	public void UpdateAuditStatusCardSaleById(String id, String status,
			String operator) throws Exception;
	
}
