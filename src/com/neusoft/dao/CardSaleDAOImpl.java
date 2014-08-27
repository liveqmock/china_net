package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.util.DBConnection;
import com.neusoft.vo.CardSale;

public class CardSaleDAOImpl implements CardSaleDAO {
	
	//查询所有记录数
	public int findAllRows(String cityCode,String productCode,String checkCode ,String recordMonth1,String recordMonth2 ) throws Exception {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int rows = 0;
		
		StringBuffer sb = new StringBuffer();
		
		String selectSql = "SELECT count (*) FROM rp_card_sale_record_t cs,rp_product_code_t pc,rp_city_code_t cc WHERE cs.city_code = cc.city_code AND cs.product_code = pc.product_code ";
		
		sb.append(selectSql);//模糊查询
		if(cityCode!=null&&!cityCode.equals("")){
			sb.append(" AND cs.city_code = "+cityCode);
		}
		if(productCode!=null&&!productCode.equals("")){
			sb.append(" AND cs.product_code = "+productCode);
		}
		if(checkCode!=null&&!checkCode.equals("")){
			sb.append(" AND cs.check_status = "+checkCode);
		}
		//sb.append(" ORDER BY id");//排序
		if((recordMonth1!=null&&!recordMonth1.equals(""))&&(!recordMonth2.equals("")&&recordMonth1!=null)){//起始日期,结束日期//???month标识符符无效
			sb.append(" AND to_char(cs.sale_date,'yyyy-mm-dd') BETWEEN '"+recordMonth1+"' AND '"+recordMonth2+"'");
		}
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sb.toString());
			if(rs.next()){
				rows = Integer.parseInt(rs.getString(1));
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
	public List<CardSale> findCardSaleRecord(int currentPage,int pageSize,String cityCode,String productCode,String checkCode ,String recordMonth1,String recordMonth2)
			throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CardSale cs = null;
		List<CardSale> list = null;
		
		StringBuffer sb = new StringBuffer();
		
		String selectSql = "SELECT cs.id id, cs.sale_date month,cc.city_name cityName,pc.product_name productName," +
							"cs.card_par_value_fee pv,cs.card_sale_amount amount,cs.total_fee tf,cs.discount_fee df," + 
							"cs.DISCOUNT_RATE dt,cs.record_operator person,cs.check_status status "+
							"FROM rp_card_sale_record_t cs,rp_product_code_t pc,rp_city_code_t cc "+ 
							"WHERE cs.city_code=cc.city_code AND cs.product_code=pc.product_code ";
		
		sb.append(selectSql);//模糊查询
		if(cityCode!=null&&!cityCode.equals("")){
			sb.append(" AND cs.city_code="+cityCode);
		}
		if(productCode!=null&&!productCode.equals("")){
			sb.append(" AND cs.product_code="+productCode);
		}
		if(checkCode!=null&&!checkCode.equals("")){
			sb.append(" AND cs.check_status="+checkCode);
		}
		//sb.append(" ORDER BY id");//排序
		if((recordMonth1!=null&&!recordMonth1.equals(""))&&(!recordMonth2.equals("")&&recordMonth1!=null)){//起始日期,结束日期//???month标识符符无效
			sb.append(" AND to_char(cs.sale_date,'yyyy-mm-dd') BETWEEN '"+recordMonth1+"' AND '"+recordMonth2+"'");
		}

		String sql="SELECT * FROM (SELECT a1.*,ROWNUM rn FROM ("+sb+") a1 WHERE ROWNUM <=?) WHERE rn >?";
		
		
		
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			
			int begin = (currentPage-1)*pageSize;//当前页号
			int end = (currentPage)*pageSize;//每页显示的记录数
			
			pstmt.setInt(1, end);
			pstmt.setInt(2, begin);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<CardSale>();
			while(rs.next()){
				cs = new CardSale();
				cs.setCardSaleId(rs.getString("id"));
				cs.setYearMonth(rs.getDate("month"));
				cs.setCityName(rs.getString("cityName"));
				cs.setProductName(rs.getString("productName"));
				cs.setParValue(rs.getDouble("pv"));
				cs.setAmount(rs.getDouble("amount"));
				cs.setTotalFee(rs.getDouble("tf"));
				cs.setDiscountFee(rs.getDouble("df"));
				cs.setDiscount(rs.getDouble("dt"));
				cs.setRecordOperator(rs.getString("person"));
				if(rs.getString("status").equals("0")){//0代表失败
					cs.setSelectAuditStatus("稽核失败");
				}else if(rs.getString("status").equals("1")){
					cs.setSelectAuditStatus("稽核成功");
				}else{
					cs.setSelectAuditStatus("未稽核");
				}
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt, rs);
		}
		return list;
	}
	
	//新增卡销售
	public void insertCardSale(String yearMonth, String cityCode,String productCode,
			double amount,double parValue,double discountFee,
			double totalFee, double discount,String recordOperator) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into rp_card_sale_record_t (id,city_code,product_code,sale_date,card_sale_amount," +
						"card_par_value_fee,record_operator,total_fee,discount_fee,discount) " +
						"values(seq_cnc.nextval,?,?,to_date(?,'yyyy-mm-dd'),?,?,?,?,?,?)";
		
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,cityCode);
			pstmt.setString(2,productCode);
			pstmt.setString(3,yearMonth);
			pstmt.setDouble(4,amount);
			pstmt.setDouble(5,parValue);
			pstmt.setString(6,recordOperator);
			pstmt.setDouble(7,totalFee);
			pstmt.setDouble(8,discountFee);
			pstmt.setDouble(9,discount);
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
	}
	
	//查询所有城市
	public List<CardSale> getAllCityName() throws Exception {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		CardSale cs = null;
		List<CardSale> list = null;
		
		String sql = "select * from rp_city_code_t";
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			list = new ArrayList<CardSale>();
			while(rs.next()){
				cs = new CardSale();
				cs.setCityCode(rs.getString("city_code"));
				cs.setCityName(rs.getString("city_name"));
				list.add(cs);
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
	public List<CardSale> getAllProductName() throws Exception {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		CardSale cs = null;
		List<CardSale> list = null;
		
		String sql = "select * from rp_product_code_t";
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			list = new ArrayList<CardSale>();
			while(rs.next()){
				cs = new CardSale();
				cs.setProductCode(rs.getString("product_code"));
				cs.setProductName(rs.getString("product_name"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, stmt, rs);
		}
		return list;
	}
	
	//获得要修改的数据
	public CardSale getCardSaleById(int id) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CardSale cs = null;
		
		String sql = "select id,city_code,product_code,sale_date,card_sale_amount,card_par_value_fee,total_fee,discount_fee,discount from rp_card_sale_record_t where id = ?";
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			cs = new CardSale();
			
			if(rs.next()){
				cs.setCardSaleId(rs.getString(1));
				cs.setCityCode(rs.getString(2));
				cs.setProductCode(rs.getString(3));
				cs.setYearMonth(rs.getDate(4));
				cs.setAmount(rs.getDouble(5));
				cs.setParValue(rs.getDouble(6));
				cs.setTotalFee(rs.getDouble(7));
				cs.setDiscountFee(rs.getDouble(8));
				cs.setDiscount(rs.getDouble(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt, rs);
		}
		
		return cs;
	}
	
	//修改数据
	public void updateCardSale(int id, String yearMonth, String cityCode,
			String productCode, double parValue, double amount,
			double totalFee, double discountFee, double discount)
			throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update rp_card_sale_record_t set city_code = ?,product_code = ?,sale_date = to_date(?,'yyyy-mm-dd')," + 
				"card_sale_amount = ?,card_par_value_fee = ?,total_fee = ?,discount_fee = ?,discount = ?,check_status=2 where id = ?";
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, cityCode);
			pstmt.setString(2, productCode);
			pstmt.setString(3, yearMonth);
			pstmt.setDouble(4, amount);
			pstmt.setDouble(5, parValue);
			pstmt.setDouble(6, totalFee);
			pstmt.setDouble(7, discountFee);
			pstmt.setDouble(8, discount);
			pstmt.setInt(9, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
	}
	public void deleteCardSaleById(int id) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from rp_card_sale_record_t where id = ?";
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBConnection.close(con, pstmt);
		}
	}
	public void UpdateAuditStatusCardSaleById(String id, String status,
			String operator) throws Exception{

		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update rp_card_sale_record_t set check_status = ?,CHECK_PERSON = ? where id = ?";
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
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
