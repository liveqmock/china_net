package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.util.DBConnection;
import com.neusoft.vo.OutAccount;

public class OutAccountDAOImpl implements OutAccountDAO {

	//查询所以记录数
	public int findAllRows(String cityCode,String productCode,String accountTypeCode,String checkCode ,String recordMonth1,String recordMonth2 ) throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		int rows=0;
		StringBuffer sb=new StringBuffer();
		
		String selectSql="SELECT count(*) FROM rp_account_fee_record_t af,rp_product_code_t pc,rp_account_type_code_t atc,rp_city_code_t cc "+ 
						"WHERE af.city_code=cc.city_code AND af.product_code=pc.product_code AND af.account_fee_type_code=atc.account_type_code ";
		
		sb.append(selectSql);//模糊查询
		if(cityCode!=null&&!cityCode.equals("")){
			sb.append(" AND af.city_code="+cityCode);
		}
		if(productCode!=null&&!productCode.equals("")){
			sb.append(" AND af.product_code="+productCode);
		}
		if(accountTypeCode!=null&&!accountTypeCode.equals("")){
			sb.append(" AND af.account_fee_type_code="+accountTypeCode);
		}
		if(checkCode!=null&&!checkCode.equals("")){
			sb.append(" AND af.check_status="+checkCode);
		}
		//sb.append(" ORDER BY id");//排序
		if((recordMonth1!=null&&!recordMonth1.equals(""))&&(!recordMonth2.equals("")&&recordMonth1!=null)){//起始日期,结束日期//???month标识符符无效
			sb.append(" AND to_char(af.account_record_month,'yyyy-mm-dd') BETWEEN '"+recordMonth1+"' AND '"+recordMonth2+"'");
		}
		
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sb.toString());
			if(rs.next()){
				rows=Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt,rs);
		}
		return rows;
	}
	//分页查询
	public List<OutAccount> findOutAccountRecord(int currentPage, int pageSize,String cityCode,String productCode,String accountTypeCode,String checkCode ,String recordMonth1,String recordMonth2)
			throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		OutAccount oa=null;
		List<OutAccount> list=null;
		
		StringBuffer sb=new StringBuffer();
		
		String selectSql="SELECT af.ID id, af.account_record_month month,cc.city_name cityName,pc.product_name productName," +
						"atc.account_type_name accountType,af.account_fee fee,af.ACCOUNT_OPERATOR person,af.check_status status "+
						"FROM rp_account_fee_record_t af,rp_product_code_t pc,rp_account_type_code_t atc,rp_city_code_t cc "+ 
						"WHERE af.city_code=cc.city_code AND af.product_code=pc.product_code AND af.account_fee_type_code=atc.account_type_code ";
		
		sb.append(selectSql);//模糊查询
		if(cityCode!=null&&!cityCode.equals("")){
			sb.append(" AND af.city_code="+cityCode);
		}
		if(productCode!=null&&!productCode.equals("")){
			sb.append(" AND af.product_code="+productCode);
		}
		if(accountTypeCode!=null&&!accountTypeCode.equals("")){
			sb.append(" AND af.account_fee_type_code="+accountTypeCode);
		}
		if(checkCode!=null&&!checkCode.equals("")){
			sb.append(" AND af.check_status="+checkCode);
		}
		//sb.append(" ORDER BY id");//排序
		if((recordMonth1!=null&&!recordMonth1.equals(""))&&(!recordMonth2.equals("")&&recordMonth1!=null)){//起始日期,结束日期//???month标识符符无效
			sb.append(" AND to_char(af.account_record_month,'yyyy-mm-dd') BETWEEN '"+recordMonth1+"' AND '"+recordMonth2+"'");
		}

		String sql="SELECT * FROM (SELECT a1.*,ROWNUM rn FROM ("+sb+") a1 WHERE ROWNUM <=?) WHERE rn >?";
		
		
		
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			
			int begin=(currentPage-1)*pageSize;//当前页号
			int end=(currentPage)*pageSize;//每页显示的记录数
			
			pstmt.setInt(1, end);
			pstmt.setInt(2, begin);
			rs=pstmt.executeQuery();
			list=new ArrayList<OutAccount>();
			int id=0;
			while(rs.next()){
				oa=new OutAccount();
				id=id+6;
				oa.setId(id);
				oa.setOutAccountId(rs.getString("id"));
				oa.setYearMonth(rs.getDate("month"));
				oa.setCityName(rs.getString("cityName"));
				oa.setProductName(rs.getString("productName"));
				oa.setOutAccountTypeName(rs.getString("accountType"));
				oa.setAmount(rs.getDouble("fee"));
				oa.setRecordOperator(rs.getString("person"));
				if(rs.getString("status").equals("0")){//0代表失败
					oa.setSelectAuditStatus("稽核失败");
				}else if(rs.getString("status").equals("1")){
					oa.setSelectAuditStatus("稽核成功");
				}else{
					oa.setSelectAuditStatus("未稽核");
				}
				list.add(oa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt, rs);
		}
		return list;
	}
	//查询所有城市
	public List<OutAccount> getAllCityName() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		OutAccount oa=null;
		List<OutAccount> list=null;
		
		String sql="select * from rp_city_code_t";
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(sql);
			list=new ArrayList<OutAccount>();
			while(rs.next()){
				oa=new OutAccount();
				oa.setCityCode(rs.getString("city_code"));
				oa.setCityName(rs.getString("city_name"));
				list.add(oa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt, rs);
		}
		return list;
	}
	//查询所有出账类型
	public List<OutAccount> getAllOutAccountType() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		OutAccount oa=null;
		List<OutAccount> list=null;
		
		String sql="select * from rp_account_type_code_t";
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(sql);
			list=new ArrayList<OutAccount>();
			while(rs.next()){
				oa=new OutAccount();
				oa.setOutAccountTypeCode(rs.getString("account_type_code"));
				oa.setOutAccountTypeName(rs.getString("account_type_name"));
				list.add(oa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt, rs);
		}
		return list;
	}
	//查询所有产品
	public List<OutAccount> getAllProductName() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		OutAccount oa=null;
		List<OutAccount> list=null;
		
		String sql="select * from rp_product_code_t";
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(sql);
			list=new ArrayList<OutAccount>();
			while(rs.next()){
				oa=new OutAccount();
				oa.setProductTypeCode(rs.getString("product_code"));
				oa.setProductName(rs.getString("product_name"));
				list.add(oa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt, rs);
		}
		return list;
	}
	public OutAccount getOutAccountById(int id) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		OutAccount oa=null;
		
		String sql="select ID,CITY_CODE,PRODUCT_CODE,ACCOUNT_FEE_TYPE_CODE ,ACCOUNT_RECORD_MONTH,ACCOUNT_FEE from rp_account_fee_record_t where id=?";
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			oa=new OutAccount();
			if(rs.next()){
				oa.setOutAccountId(rs.getString(1));
				oa.setCityCode(rs.getString(2));
				oa.setProductTypeCode(rs.getString(3));
				oa.setOutAccountTypeCode(rs.getString(4));
				oa.setYearMonth(rs.getDate(5));
				oa.setAmount(rs.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt, rs);
		}
		
		return oa;
	}
	
	public void updateOutAccount(int id, String recordMonth, String cityCode,
			String productCode, String accountTypeCode ,String fee) throws Exception {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="update rp_account_fee_record_t set CITY_CODE=?,PRODUCT_CODE=?,ACCOUNT_FEE_TYPE_CODE=?,ACCOUNT_RECORD_MONTH=to_date(?,'yyyy-mm-dd'),ACCOUNT_FEE=?,check_status=2 where id=?  ";
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, cityCode);
			pstmt.setString(2, productCode);
			pstmt.setString(3, accountTypeCode);
			pstmt.setString(4, recordMonth);
			pstmt.setString(5, fee);
			pstmt.setInt(6, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
		
	}
	public void insertOutAccount(String recordMonth, String cityCode,
			String productCode, String accountTypeCode, String fee,
			String operator) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into rp_account_fee_record_t" +
				"(ID,CITY_CODE,PRODUCT_CODE,ACCOUNT_FEE_TYPE_CODE,ACCOUNT_RECORD_MONTH,ACCOUNT_FEE,ACCOUNT_OPERATOR) " +
				"values(seq_cnc.nextval,?,?,?,to_date(?,'yyyy-mm-dd'),?,?)";
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, cityCode);
			pstmt.setString(2, productCode);
			pstmt.setString(3, accountTypeCode);
			pstmt.setString(4, recordMonth);
			pstmt.setString(5, fee);
			pstmt.setString(6, operator);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
		
	}
	public void deleteOutAccountById(int id) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from rp_account_fee_record_t where id=?";
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
	}
	public void UpdateAuditStatusAccountById(String id, String status,
			String operator) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="update rp_account_fee_record_t set check_status=?,CHECK_PERSON=? where id=?";
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setString(2, operator);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
		
	}

	
}








