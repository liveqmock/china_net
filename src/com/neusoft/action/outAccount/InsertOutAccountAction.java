package com.neusoft.action.outAccount;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.util.Page;
import com.neusoft.vo.OutAccount;
import com.neusoft.vo.User;

public class InsertOutAccountAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String recordMonth=request.getParameter("recordMonth1");
		String cityCode=request.getParameter("cityCode");
		String productCode=request.getParameter("productCode");
		String accountTypeCode=request.getParameter("accountTypeCode");
		String fee=request.getParameter("fee");
		
		//¼����Ա
		User user=(User) request.getSession().getAttribute("user");
		String operator=user.getName();
		
		DAOFactory.getOutAccountDAO().insertOutAccount(recordMonth, cityCode, productCode, accountTypeCode, fee, operator);
		
		//��ѯ���г���
		List<OutAccount> cityList=null;
		cityList=DAOFactory.getOutAccountDAO().getAllCityName();
		
		
		//��ѯ���в�Ʒ
		List<OutAccount> productList=null;
		productList=DAOFactory.getOutAccountDAO().getAllProductName();
		
		
		//��ѯ���г�������
		List<OutAccount> typeList=null;
		typeList=DAOFactory.getOutAccountDAO().getAllOutAccountType();
		
		//�����б�
		request.setAttribute("cityList", cityList);//���˳���
		request.setAttribute("productList", productList);//��Ʒ����
		request.setAttribute("typeList", typeList);//������������
		
		Page page=new Page(0,1,0);//���÷�ҳ
		request.setAttribute("page", page);
		
		
		return mapping.findForward("ok");
	}
	
}
