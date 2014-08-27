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

public class QueryCardSaleAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("GBK");
		
		//��ѯ���г���
		List<CardSale> cityList = null;
		cityList = DAOFactory.getCardSaleDAO().getAllCityName();
		
		//��ѯ���в�Ʒ
		List<CardSale> productList = null;
		productList = DAOFactory.getCardSaleDAO().getAllProductName();
		
		//��ҳ
		List<CardSale> CardSaleList = null;
		String cityCode = request.getParameter("cityCode");
		String productCode = request.getParameter("productCode");
		String checkCode = request.getParameter("checkCode");
		
		String recordMonth1 = request.getParameter("recordMonth1");//��ֹ����
		String recordMonth2 = request.getParameter("recordMonth2");//��������
		String  current = request.getParameter("currentPage");
		if(current==null){
			current = 1+"";
		}
	    int currentPage = Integer.parseInt(current);//��ǰҳ��
		int pageSize = 4;//ÿҳ��ʾ�ļ�¼��
		int totalRows = 0;
		Page page = null;
		CardSaleList = DAOFactory.getCardSaleDAO().findCardSaleRecord(currentPage, pageSize, cityCode, productCode, checkCode, recordMonth1, recordMonth2);
		
		if(!CardSaleList.isEmpty()){
			totalRows = DAOFactory.getCardSaleDAO().findAllRows(cityCode, productCode, checkCode, recordMonth1, recordMonth2);//������еļ�¼��
			request.setAttribute("cardSaleList", CardSaleList);//��ҳ��ѯ��¼
			request.setAttribute("isEmpty", "no");//��ʾ��ʾ��Ϣ-->�Ƿ������������ļ�¼
		}
		page = new Page(currentPage,pageSize,totalRows);//��ʼ��
		request.setAttribute("page", page);
		request.setAttribute("totalRows", totalRows);
		
		
		//1��ʾ����
		request.setAttribute("recordMonth1", recordMonth1);
		request.setAttribute("recordMonth2", recordMonth2);
		
		//2�����б�
		request.setAttribute("city", cityList);//���˳���
		request.setAttribute("product", productList);//��Ʒ����
		
		
		//3��ʾ֮ǰѡ���Ĳ�����Ϣ�������б�
		request.setAttribute("cityCode", cityCode);
		request.setAttribute("productCode", productCode);
		request.setAttribute("checkCode", checkCode);
		
		return mapping.findForward("ok");
	}

}
