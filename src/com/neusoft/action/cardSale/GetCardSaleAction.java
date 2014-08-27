package com.neusoft.action.cardSale;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.vo.CardSale;

public class GetCardSaleAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("GBK");
		
		List<CardSale> list = DAOFactory.getCardSaleDAO().getAllCityName();
		request.setAttribute("city", list);
		list = DAOFactory.getCardSaleDAO().getAllProductName();
		request.setAttribute("product", list);
		
		return mapping.findForward("ok");
	}

}
