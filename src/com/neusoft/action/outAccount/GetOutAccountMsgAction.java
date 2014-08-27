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

public class GetOutAccountMsgAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int id=Integer.parseInt(request.getParameter("outAccountId"));
		OutAccount oa=DAOFactory.getOutAccountDAO().getOutAccountById(id);
		
		//��ʾ֮ǰѡ���Ĳ�����Ϣ�������б�
		request.setAttribute("month", oa.getYearMonth());//��ʾ����
		request.setAttribute("cityCode", oa.getCityCode());
		request.setAttribute("productCode", oa.getProductTypeCode());
		request.setAttribute("accountTypeCode", oa.getOutAccountTypeCode());
		request.setAttribute("fee", oa.getAmount());
		//����ID
		request.setAttribute("outAccountId", oa.getOutAccountId());
		
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
