package com.neusoft.action.cardSale;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.util.Page;
import com.neusoft.vo.CardSale;

public class UpdateCardSaleAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String cardSaleId = request.getParameter("cardSaleId");
		String yearMonth = request.getParameter("yearMonth");
		String cityCode = request.getParameter("cityCode");
		String productCode = request.getParameter("productCode");
		double parValue = Double.parseDouble(request.getParameter("parValue"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		double totalFee = Double.parseDouble(request.getParameter("totalFee"));
		double discountFee = Double.parseDouble(request.getParameter("discountFee"));
		double discount = Double.parseDouble(request.getParameter("discount"));
		
		int id = Integer.parseInt(cardSaleId);
		DAOFactory.getCardSaleDAO().updateCardSale(id, yearMonth, cityCode, productCode, parValue,amount,totalFee,discountFee,discount);
		
		//查询所有城市
		List<CardSale> cityList = null;
		cityList = DAOFactory.getCardSaleDAO().getAllCityName();
		
		
		//查询所有产品
		List<CardSale> productList = null;
		productList = DAOFactory.getCardSaleDAO().getAllProductName();
		
		
		//下拉列表
		request.setAttribute("city", cityList);//出账城市
		request.setAttribute("product", productList);//产品名称
		
		Page page = new Page(0,1,0);//设置分页
		request.setAttribute("page", page);
		
		return mapping.findForward("ok");	}

}
