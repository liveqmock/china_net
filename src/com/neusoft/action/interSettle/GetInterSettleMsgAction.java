package com.neusoft.action.interSettle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.util.Page;
import com.neusoft.vo.InterSettle;

public class GetInterSettleMsgAction extends Action {
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	
	
	int id=Integer.parseInt(request.getParameter("interSettleId"));
	InterSettle is=DAOFactory.getInterSettleDao().getInterSettleById(id);
	
	//显示之前选过的操作信息（下拉列表）
	request.setAttribute("month", is.getYearMonth());//显示日期
	request.setAttribute("cityCode", is.getCityCode());
	request.setAttribute("productCode", is.getProductCode());
	request.setAttribute("balanceSpCode", is.getBalanceSpCode());
	request.setAttribute("balanceTypeCode", is.getBalanceTypeCode());
	request.setAttribute("amount", is.getAmount());
	//设置ID
	request.setAttribute("interSettleId", is.getInterSettleId());//返回网间结算收入的流水号
	
	//查询所有城市名称
	List<InterSettle> cityList =new ArrayList<InterSettle>();
	cityList=DAOFactory.getInterSettleDao().getAllCityName();
	
	//查询所有产品名称
	List<InterSettle> productList =new ArrayList<InterSettle>();
	productList=DAOFactory.getInterSettleDao().getAllProductName();
	
	//查询所有结算运营商名称
	List<InterSettle> balanceSpList =new ArrayList<InterSettle>();
	balanceSpList=DAOFactory.getInterSettleDao().getAllSpName();
	
	//查询所有结算类型名称
	List<InterSettle> balanceTypeList =new ArrayList<InterSettle>();
	balanceTypeList=DAOFactory.getInterSettleDao().getAllTypeName();
	
	
	//下拉列表
	request.setAttribute("cityList", cityList);
	request.setAttribute("productList", productList);
	request.setAttribute("balanceSpList", balanceSpList);
	request.setAttribute("balanceTypeList", balanceTypeList);
	
	Page page=new Page(0,1,0);//设置分页
	request.setAttribute("page", page);
	
	return mapping.findForward("ok");
}
}
