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
import com.neusoft.vo.User;

public class InsertCardSaleAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("GBK");
		
		String yearMonth = request.getParameter(("yearMonth"));
		String cityCode = request.getParameter("cityCode");
		String productCode = request.getParameter("productCode");
		double amount = Double.parseDouble(request.getParameter("amount"));
		double parValue = Double.parseDouble(request.getParameter("parValue"));
		double discountFee = Double.parseDouble(request.getParameter("discountFee"));
		double totalFee = Double.parseDouble(request.getParameter("totalFee"));
		double discount = Double.parseDouble(request.getParameter("discount"));
		
		//¼����Ա
		User user = (User) request.getSession().getAttribute("user");
		String recordOperator = user.getName();
		
		DAOFactory.getCardSaleDAO().insertCardSale(yearMonth,cityCode,
									productCode,amount,parValue,discountFee,totalFee,discount,recordOperator);
		
		//��ѯ���г���
		List<CardSale> cityList = null;
		cityList=DAOFactory.getCardSaleDAO().getAllCityName();
		
		//��ѯ���в�Ʒ
		List<CardSale> productList = null;
		productList=DAOFactory.getCardSaleDAO().getAllProductName();
		
		//�����б�
		request.setAttribute("city", cityList);//���˳���
		request.setAttribute("product", productList);//��Ʒ����
		
		Page page = new Page(0,1,0);//���÷�ҳ
		request.setAttribute("page", page);
		
		return mapping.findForward("ok");
	}

}
