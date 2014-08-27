package com.neusoft.dao;

import java.util.List;


import com.neusoft.vo.StoredTo;




public interface StoredToDAO {

	/**分页查询所有记录*/
	public List<StoredTo> findStoredToRecord(int currentPage, int pageSize,String cityCode,String productCode,String accountTypeCode,String checkCode ,String recordMonth1,String recordMonth2)throws Exception;
	/**查询总的记录数*/
	public int findAllRows(String cityCode,String productCode,String accountTypeCode,String checkCode ,String recordMonth1,String recordMonth2) throws Exception;
	
	public List<StoredTo> getAllCityName() throws Exception;
	
	public List<StoredTo> getAllProductName() throws Exception;
	
	public List<StoredTo> getAllStoredToType() throws Exception;
	
	public void insertStoredTo(String recordMonth,String cityCode,String productCode,String accountTypeCode ,String fee ,String operator) throws Exception;
	
	public StoredTo getStoredToById(int id) throws Exception;
	
	public void updateStoredTo(int id,String recordMonth,String cityCode,String productCode,String accountTypeCode ,String fee) throws Exception;
	
	public void deleteStoredToById(int id) throws Exception;
	
	public void UpdateAuditStatusAccountById(String id,String status,String operator) throws Exception;
	
}
