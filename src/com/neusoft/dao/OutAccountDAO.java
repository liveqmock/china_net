package com.neusoft.dao;

import java.util.List;

import com.neusoft.vo.OutAccount;


public interface OutAccountDAO {

	/**分页查询所有记录*/
	public List<OutAccount> findOutAccountRecord(int currentPage, int pageSize,String cityCode,String productCode,String accountTypeCode,String checkCode ,String recordMonth1,String recordMonth2)throws Exception;
	/**查询总的记录数*/
	public int findAllRows(String cityCode,String productCode,String accountTypeCode,String checkCode ,String recordMonth1,String recordMonth2) throws Exception;
	
	public List<OutAccount> getAllCityName() throws Exception;
	
	public List<OutAccount> getAllProductName() throws Exception;
	
	public List<OutAccount> getAllOutAccountType() throws Exception;
	
	public OutAccount getOutAccountById(int id) throws Exception;
	
	public void updateOutAccount(int id,String recordMonth,String cityCode,String productCode,String accountTypeCode ,String fee) throws Exception;
	
	public void insertOutAccount(String recordMonth,String cityCode,String productCode,String accountTypeCode ,String fee ,String operator) throws Exception;
	
	public void deleteOutAccountById(int id) throws Exception;
	
	public void UpdateAuditStatusAccountById(String id,String status,String operator) throws Exception;
	
}
