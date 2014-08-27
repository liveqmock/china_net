package com.neusoft.action.interSettle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;

public class UpdateInterSettleAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String interSettleId=request.getParameter("interSettleId");
		String yearMonth=request.getParameter("recordMonth1");
		String cityCode=request.getParameter("cityCode");
		String productCode=request.getParameter("productCode");
		String balanceSpCode=request.getParameter("balanceSpCode");
		String balanceTypeCode=request.getParameter("balanceTypeCode");
		double amount=Double.parseDouble(request.getParameter("amount"));
		
		DAOFactory.getInterSettleDao().updateInterSettle(interSettleId,yearMonth, cityCode, productCode, balanceSpCode, balanceTypeCode, amount);
		
		return mapping.findForward("ok");
	}

}
