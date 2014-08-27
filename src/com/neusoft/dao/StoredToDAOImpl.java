package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.util.DBConnection;
import com.neusoft.vo.StoredTo;


public class StoredToDAOImpl implements StoredToDAO {

	//查询所以记录数
	public int findAllRows(String cityCode,String productCode,String accountTypeCode,String checkCode ,String recordMonth1,String recordMonth2 ) throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		int rows=0;
		StringBuffer sb=new StringBuffer();
		
		String selectSql="SELECT count(*) FROM rp_pre_fee_record_t pf,rp_product_code_t pc,rp_write_off_type_code_t wtc,rp_city_code_t cc "+ 
						"WHERE pf.city_code=cc.city_code AND pf.product_code=pc.product_code AND pf.write_off_type_code=wtc.write_off_type_code ";
		
		sb.append(selectSql);//模糊查询
		if(cityCode!=null&&!cityCode.equals("")){
			sb.append(" AND pf.city_code="+cityCode);
		}
		if(productCode!=null&&!productCode.equals("")){
			sb.append(" AND pf.product_code="+productCode);
		}
		if(accountTypeCode!=null&&!accountTypeCode.equals("")){
			sb.append(" AND pf.write_off_type_code="+accountTypeCode);
		}
		if(checkCode!=null&&!checkCode.equals("")){
			sb.append(" AND pf.check_status="+checkCode);
		}
		//sb.append(" ORDER BY id");//排序
		if((recordMonth1!=null&&!recordMonth1.equals(""))&&(!recordMonth2.equals("")&&recordMonth1!=null)){//起始日期,结束日期//???month标识符符无效
			sb.append(" AND to_char(pf.record_date,'yyyy-mm-dd') BETWEEN '"+recordMonth1+"' AND '"+recordMonth2+"'");
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
	public List<StoredTo> findStoredToRecord(int currentPage, int pageSize,String cityCode,String productCode,String accountTypeCode,String checkCode ,String recordMonth1,String recordMonth2)
			throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StoredTo oa=null;
		List<StoredTo> list=null;
		
		StringBuffer sb=new StringBuffer();
		
		String selectSql="SELECT pf.ID id, pf.record_date month,cc.city_name cityName,pc.product_name productName," +
						"wtc.write_off_type_name accountType,pf.write_off_fee fee,pf.RECORD_OPERATOR person,pf.check_status status "+
						"FROM rp_pre_fee_record_t pf,rp_product_code_t pc,rp_write_off_type_code_t wtc,rp_city_code_t cc "+ 
						"WHERE pf.city_code=cc.city_code AND pf.product_code=pc.product_code AND pf.write_off_type_code=wtc.write_off_type_code ";
		
		sb.append(selectSql);//模糊查询
		if(cityCode!=null&&!cityCode.equals("")){
			sb.append(" AND pf.city_code="+cityCode);
		}
		if(productCode!=null&&!productCode.equals("")){
			sb.append(" AND pf.product_code="+productCode);
		}
		if(accountTypeCode!=null&&!accountTypeCode.equals("")){
			sb.append(" AND pf.write_off_type_code="+accountTypeCode);
		}
		if(checkCode!=null&&!checkCode.equals("")){
			sb.append(" AND pf.check_status="+checkCode);
		}
		//sb.append(" ORDER BY id");//排序
		if((recordMonth1!=null&&!recordMonth1.equals(""))&&(!recordMonth2.equals("")&&recordMonth1!=null)){//起始日期,结束日期//???month标识符符无效
			sb.append(" AND to_char(pf.record_date,'yyyy-mm-dd') BETWEEN '"+recordMonth1+"' AND '"+recordMonth2+"'");
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
			list=new ArrayList<StoredTo>();
			while(rs.next()){
				oa=new StoredTo();
				oa.setStoredToId(rs.getString("id"));
				oa.setYearMonth(rs.getDate("month"));
				oa.setCityName(rs.getString("cityName"));
				oa.setProductName(rs.getString("productName"));
				oa.setStoredToTypeName(rs.getString("accountType"));
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
	public List<StoredTo> getAllCityName() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		StoredTo oa=null;
		List<StoredTo> list=null;
		
		String sql="select * from rp_city_code_t";
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(sql);
			list=new ArrayList<StoredTo>();
			while(rs.next()){
				oa=new StoredTo();
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
	public List<StoredTo> getAllStoredToType() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		StoredTo oa=null;
		List<StoredTo> list=null;
		
		String sql="select * from rp_write_off_type_code_t";
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(sql);
			list=new ArrayList<StoredTo>();
			while(rs.next()){
				oa=new StoredTo();
				oa.setStoredToTypeCode(rs.getString("write_off_type_code"));
				oa.setStoredToTypeName(rs.getString("write_off_type_name"));
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
	public List<StoredTo> getAllProductName() throws Exception {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		StoredTo oa=null;
		List<StoredTo> list=null;
		
		String sql="select * from rp_product_code_t";
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(sql);
			list=new ArrayList<StoredTo>();
			while(rs.next()){
				oa=new StoredTo();
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
    //出账收入录入
	public void insertStoredTo(String recordMonth, String cityCode,
			String productCode, String accountTypeCode, String fee,
			String operator) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into rp_pre_fee_record_t" +
				"(ID,CITY_CODE,PRODUCT_CODE,WRITE_OFF_TYPE_CODE,RECORD_DATE,WRITE_OFF_FEE,RECORD_OPERATOR) " +
				 "(RECORD_DATE, CHECK_STATUS, CHECK_PERSON, CHECK_TIME)" +
				"values(seq_cnc.nextval,?,?,?,to_date(?,'yyyy-mm-dd'),?,?)" + 
				"('12-5月-2011', '1', 'admin', '12-5月-2011')";

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
	//通过ID查询出要修改的记录
	public StoredTo getStoredToById(int id) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StoredTo oa=null;
		
		String sql="select ID,CITY_CODE,PRODUCT_CODE,WRITE_OFF_TYPE_CODE ,RECORD_DATE,WRITE_OFF_FEE from rp_pre_fee_record_t where id=?";
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			oa=new StoredTo();
			if(rs.next()){
				oa.setStoredToId(rs.getString(1));
				oa.setCityCode(rs.getString(2));
				oa.setProductTypeCode(rs.getString(3));
				oa.setStoredToTypeCode(rs.getString(4));
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
	//销账收入修改
	public void updateStoredTo(int id, String recordMonth, String cityCode,
			String productCode, String accountTypeCode ,String fee) throws Exception {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="update rp_pre_fee_record_t set CITY_CODE=?,PRODUCT_CODE=?,WRITE_OFF_TYPE_CODE=?,RECORD_DATE=to_date(?,'yyyy-mm-dd'),WRITE_OFF_FEE=?,check_status=2 where id=?  ";
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
	//删除操作
	public void deleteStoredToById(int id) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from rp_pre_fee_record_t where id=?";
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
	//改变稽核状态
	public void UpdateAuditStatusAccountById(String id, String status,
			String operator) throws Exception {

		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql="update rp_pre_fee_record_t set check_status=?,CHECK_PERSON=? where id=?";
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
