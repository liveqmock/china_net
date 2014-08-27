package com.neusoft.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.util.DBConnection;
import com.neusoft.vo.InterSettle;

public class InterSettleDaoImpl implements InterSettleDao {

	public void delete() throws Exception{//示例，此方法需要在InterSettleDao接口里面定义
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="";
		
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
	}

	//查询所有记录数
	public int findAllRows(String cityCode, String productCode,
			String balanceSpCode, String balanceTypeCode, String checkCode,
			String recordMonth1, String recordMonth2) throws Exception {

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		int rows=0;
		StringBuffer sb=new StringBuffer();
		
		String selectSql="SELECT count(*) FROM rp_net_balance_record_t nb,rp_product_code_t pc,rp_city_code_t cc,rp_balance_sp_code_t bsc,rp_balance_type_code_t btc "+ 
						"WHERE nb.city_code=cc.city_code AND nb.product_code=pc.product_code AND nb.balance_sp_code=bsc.balance_sp_code AND nb.balance_type_code=btc.balance_type_code";
		
		sb.append(selectSql);//模糊查询
		if(cityCode!=null&&!cityCode.equals("")){
			sb.append(" AND nb.city_code="+cityCode);
		}
		if(productCode!=null&&!productCode.equals("")){
			sb.append(" AND nb.product_code="+productCode);
		}
		if(balanceSpCode!=null&&!balanceSpCode.equals("")){
			sb.append(" AND nb.balance_sp_code="+balanceSpCode);
		}
		if(balanceTypeCode!=null&&!balanceTypeCode.equals("")){
			sb.append(" AND nb.balance_type_code="+balanceTypeCode);
		}
		if(checkCode!=null&&!checkCode.equals("")){
			sb.append(" AND nb.check_status="+checkCode);
		}
		//sb.append(" ORDER BY id");//排序
		if((recordMonth1!=null&&!recordMonth1.equals(""))&&(!recordMonth2.equals("")&&recordMonth1!=null)){//起始日期,结束日期//???month标识符符无效
			sb.append(" AND to_char(nb.balance_month,'yyyy-mm-dd') BETWEEN '"+recordMonth1+"' AND '"+recordMonth2+"'");
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
	public List<InterSettle> findInterSettleRecord(int currentPage,
			int pageSize, String cityCode, String productCode,
			String balanceSpCode, String balanceTypeCode, String checkCode,
			String recordMonth1, String recordMonth2) throws Exception {
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		InterSettle is=null;
		List<InterSettle> list=null;
		
		StringBuffer sb=new StringBuffer();
		
		String selectSql="SELECT nb.ID id, nb.balance_month month,cc.city_name cityName,pc.product_name productName,bsc.balance_sp_name balanceSpName, " +
						"btc.balance_type_name balanceTypeName,nb.balance_fee amount,nb.record_operator recordOperator,nb.check_status status "+
						"FROM rp_net_balance_record_t nb,rp_product_code_t pc,rp_city_code_t cc,rp_balance_sp_code_t bsc,rp_balance_type_code_t btc "+ 
						"WHERE nb.city_code=cc.city_code AND nb.product_code=pc.product_code AND nb.balance_sp_code=bsc.balance_sp_code AND nb.balance_type_code=btc.balance_type_code";
		
		sb.append(selectSql);//模糊查询
		if(cityCode!=null&&!cityCode.equals("")){
			sb.append(" AND nb.city_code="+cityCode);
		}
		if(productCode!=null&&!productCode.equals("")){
			sb.append(" AND nb.product_code="+productCode);
		}
		if(balanceSpCode!=null&&!balanceSpCode.equals("")){
			sb.append(" AND nb.balance_sp_code="+balanceSpCode);
		}
		if(balanceTypeCode!=null&&!balanceTypeCode.equals("")){
			sb.append(" AND nb.balance_type_code="+balanceTypeCode);
		}
		if(checkCode!=null&&!checkCode.equals("")){
			sb.append(" AND nb.check_status="+checkCode);
		}
		//sb.append(" ORDER BY id");//排序
		if((recordMonth1!=null&&!recordMonth1.equals(""))&&(!recordMonth2.equals("")&&recordMonth1!=null)){//起始日期,结束日期//???month标识符符无效
			sb.append(" AND to_char(nb.balance_month,'yyyy-mm-dd') BETWEEN '"+recordMonth1+"' AND '"+recordMonth2+"'");
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
			list=new ArrayList<InterSettle>();
			while(rs.next()){
				is=new InterSettle();
				is.setInterSettleId(rs.getString("id"));
				is.setYearMonth(rs.getDate("month"));
				is.setCityName(rs.getString("cityName"));
				is.setProductName(rs.getString("productName"));
				is.setBalanceSpName(rs.getString("balanceSpName"));
				is.setBalanceTypeName(rs.getString("balanceTypeName"));
				is.setAmount(rs.getDouble("amount"));
				is.setRecordOperator(rs.getString("recordOperator"));
				if(rs.getString("status").equals("0")){//0代表失败
					is.setCheckStatus("稽核失败");
				}else if(rs.getString("status").equals("1")){
					is.setCheckStatus("稽核成功");
				}else{
					is.setCheckStatus("未稽核");
				}
				list.add(is);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt, rs);
		}
		return list;
	}
	public List<InterSettle> getAllCityName() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from rp_city_code_t";
		List<InterSettle> list=new ArrayList<InterSettle>();
		
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				String cityCode=rs.getString("city_code");
				String cityName=rs.getString("city_name");
				
				InterSettle s=new InterSettle();
				s.setCityCode(cityCode);
				s.setCityName(cityName);
				list.add(s);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt);
		}
		return list;
	}

	public List<InterSettle> getAllProductName() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from rp_product_code_t";
		List<InterSettle> list=new ArrayList<InterSettle>();
		
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				String productCode=rs.getString("product_code");
				String productName=rs.getString("product_name");
				InterSettle s=new InterSettle();
				s.setProductCode(productCode);
				s.setProductName(productName);
				list.add(s);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt);
		}
		return list;
	}

	public List<InterSettle> getAllSpName() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from rp_balance_sp_code_t";
		List<InterSettle> list=new ArrayList<InterSettle>();
		
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				String balanceSpCode=rs.getString("balance_sp_code");
				String balanceSpName=rs.getString("balance_sp_name");
				InterSettle s=new InterSettle();
				s.setBalanceSpCode(balanceSpCode);
				s.setBalanceSpName(balanceSpName);
				list.add(s);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt);
		}
		return list;
	}

	public List<InterSettle> getAllTypeName() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from rp_balance_type_code_t";
		List<InterSettle> list=new ArrayList<InterSettle>();
		
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				String balanceTypeCode=rs.getString("balance_type_code");
				String balanceTypeName=rs.getString("balance_type_name");
				InterSettle s=new InterSettle();
				s.setBalanceTypeCode(balanceTypeCode);
				s.setBalanceTypeName(balanceTypeName);
				list.add(s);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt);
		}
		return list;
	}

	public void insertInterSettle(String yearMonth, String cityCode,
			String productCode, String balanceSpCode, String balanceTypeCode,
			double amount, String recordOperator) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into rp_net_balance_record_t(id,balance_month,city_code,product_code,balance_sp_code,balance_type_code,balance_fee,record_operator) values(seq_cnc.nextval,to_date(?,'yyyy-mm-dd'),?,?,?,?,?,?)";
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, yearMonth);
			pstmt.setString(2, cityCode);
			pstmt.setString(3, productCode);
			pstmt.setString(4, balanceSpCode);
			pstmt.setString(5, balanceTypeCode);
			pstmt.setDouble(6, amount);
			pstmt.setString(7, recordOperator);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pstmt);
		}
		
		
	}

	public void updateInterSettle(String interSettleId,String yearMonth, String cityCode,
			String productCode, String balanceSpCode, String balanceTypeCode,
			double amount) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update rp_net_balance_record_t set balance_month=to_date(?,'yyyy-mm-dd'),city_code=?,product_code=?,balance_sp_code=?,balance_type_code=?,balance_fee=?,check_status=2 where id=?";
			try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, yearMonth);
			pstmt.setString(2, cityCode);
			pstmt.setString(3, productCode);
			pstmt.setString(4, balanceSpCode);
			pstmt.setString(5, balanceTypeCode);
			pstmt.setDouble(6, amount);
			pstmt.setString(7, interSettleId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pstmt);
		}
		
	}
	

	public InterSettle getInterSettleById(int id) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		InterSettle is=null;
		
		String sql="select ID,BALANCE_MONTH,CITY_CODE,PRODUCT_CODE,BALANCE_SP_CODE ,BALANCE_TYPE_CODE,BALANCE_FEE from rp_net_balance_record_t where id=?";
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			is=new InterSettle();
			if(rs.next()){
				is.setInterSettleId(rs.getString(1)); 
				is.setYearMonth(rs.getDate(2));
				is.setCityCode(rs.getString(3));
				is.setProductCode(rs.getString(4));
				is.setBalanceSpCode(rs.getString(5));
				is.setBalanceTypeCode(rs.getString(6));
				is.setAmount(rs.getDouble(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt, rs);
		}
		
		return is;
	}

	public void deleteInterSettleById(int id) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from rp_net_balance_record_t where id=?";
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

	public void UpdateAuditStatusSettleById(String id, String status,
			String operator) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="update rp_net_balance_record_t set check_status=?,CHECK_PERSON=? where id=?";
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
