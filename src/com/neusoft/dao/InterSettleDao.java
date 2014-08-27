package com.neusoft.dao;

import java.util.List;

import com.neusoft.vo.InterSettle;

public interface InterSettleDao {

	public void delete() throws Exception;

	public List<InterSettle> getAllCityName() throws Exception;

	public List<InterSettle> getAllProductName() throws Exception;

	public List<InterSettle> getAllSpName() throws Exception;

	public List<InterSettle> getAllTypeName() throws Exception;

	public void insertInterSettle(String yearMonth, String cityCode,
			String productCode, String balanceSpCode, String balanceTypeCode,
			double amount, String recordOperator) throws Exception;

	public void updateInterSettle(String interSettleId,String yearMonth, String cityCode,
			String productCode, String balanceSpCode, String balanceTypeCode,
			double amount)throws Exception;
	/**分页查询所有记录*/
	public List<InterSettle> findInterSettleRecord(int currentPage,
			int pageSize, String cityCode, String productCode,
			String balanceSpCode, String balanceTypeCode, String checkCode,
			String recordMonth1, String recordMonth2) throws Exception;
	/**查询总的记录数*/
	public int findAllRows(String cityCode, String productCode,
			String balanceSpCode, String balanceTypeCode, String checkCode,
			String recordMonth1, String recordMonth2) throws Exception;

	public InterSettle getInterSettleById(int id) throws Exception;

	public void deleteInterSettleById(int id) throws Exception;
	public void UpdateAuditStatusSettleById(String id,String status,String operator) throws Exception;
}
