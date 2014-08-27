package com.neusoft.action.storedTo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.util.Page;
import com.neusoft.vo.StoredTo;

public class GetStoredToMsgAction extends Action {
@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id=Integer.parseInt(request.getParameter("storedToId"));
		StoredTo oa=DAOFactory.getStoredToDAO().getStoredToById(id);
		
		//��ʾ֮ǰѡ���Ĳ�����Ϣ�������б�
		request.setAttribute("month", oa.getYearMonth());//��ʾ����
		request.setAttribute("cityCode", oa.getCityCode());
		request.setAttribute("productCode", oa.getProductTypeCode());
		request.setAttribute("accountTypeCode", oa.getStoredToTypeCode());
		request.setAttribute("fee", oa.getAmount());
		//����ID
		request.setAttribute("storedToId", oa.getStoredToId());
		
		//��ѯ���г���
		List<StoredTo> cityList=null;
		cityList=DAOFactory.getStoredToDAO().getAllCityName();
		
		
		//��ѯ���в�Ʒ
		List<StoredTo> productList=null;
		productList=DAOFactory.getStoredToDAO().getAllProductName();
		
		
		//��ѯ���г�������
		List<StoredTo> typeList=null;
		typeList=DAOFactory.getStoredToDAO().getAllStoredToType();
		
		//�����б�
		request.setAttribute("cityList", cityList);//���˳���
		request.setAttribute("productList", productList);//��Ʒ����
		request.setAttribute("typeList", typeList);//������������
		
		Page page=new Page(0,1,0);//���÷�ҳ
		request.setAttribute("page", page);
		
		return mapping.findForward("ok");
	}
}
