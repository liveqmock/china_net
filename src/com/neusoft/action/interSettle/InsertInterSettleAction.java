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
import com.neusoft.vo.User;

public class InsertInterSettleAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String yearMonth=request.getParameter("recordMonth1");
		String cityCode=request.getParameter("cityCode");
		String productCode=request.getParameter("productCode");
		String balanceSpCode=request.getParameter("balanceSpCode");
		String balanceTypeCode=request.getParameter("balanceTypeCode");
		double amount=Double.parseDouble(request.getParameter("amount"));
		//¼����Ա
		User user=(User) request.getSession().getAttribute("user");
		String recordOperator=user.getName();
		DAOFactory.getInterSettleDao().insertInterSettle(yearMonth, cityCode, productCode, balanceSpCode, balanceTypeCode, amount, recordOperator);
		
		//��ѯ���г�������
		List<InterSettle> cityList =new ArrayList<InterSettle>();
		cityList=DAOFactory.getInterSettleDao().getAllCityName();
		
		//��ѯ���в�Ʒ����
		List<InterSettle> productList =new ArrayList<InterSettle>();
		productList=DAOFactory.getInterSettleDao().getAllProductName();
		
		//��ѯ���н�����Ӫ������
		List<InterSettle> balanceSpList =new ArrayList<InterSettle>();
		balanceSpList=DAOFactory.getInterSettleDao().getAllSpName();
		
		//��ѯ���н�����������
		List<InterSettle> balanceTypeList =new ArrayList<InterSettle>();
		balanceTypeList=DAOFactory.getInterSettleDao().getAllTypeName();
		
		
		//�����б�
		request.setAttribute("cityList", cityList);
		request.setAttribute("productList", productList);
		request.setAttribute("balanceSpList", balanceSpList);
		request.setAttribute("balanceTypeList", balanceTypeList);
		
		Page page=new Page(0,1,0);//���÷�ҳ
		request.setAttribute("page", page);
		
		return mapping.findForward("ok");
	}

}
