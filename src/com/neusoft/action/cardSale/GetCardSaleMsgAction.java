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

public class GetCardSaleMsgAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int id=Integer.parseInt(request.getParameter("cardSaleId"));
		CardSale cs=DAOFactory.getCardSaleDAO().getCardSaleById(id);
		
		//��ʾ֮ǰѡ���Ĳ�����Ϣ�������б�
		request.setAttribute("month", cs.getYearMonth());//��ʾ����
		request.setAttribute("cityCode", cs.getCityCode());
		request.setAttribute("productCode", cs.getProductCode());
		request.setAttribute("amount", (int)(cs.getAmount()));
		request.setAttribute("pv", (int)cs.getParValue());
		request.setAttribute("tf", (int)cs.getTotalFee());
		request.setAttribute("df", (int)cs.getDiscountFee());
		request.setAttribute("dt", (int)cs.getDiscount());
		
		
		//����ID
		request.setAttribute("cardSaleId", cs.getCardSaleId());
		
		//��ѯ���г���
		List<CardSale> cityList=null;
		cityList=DAOFactory.getCardSaleDAO().getAllCityName();
		
		
		//��ѯ���в�Ʒ
		List<CardSale> productList=null;
		productList=DAOFactory.getCardSaleDAO().getAllProductName();
		
		//�����б�
		request.setAttribute("cityList", cityList);//���˳���
		request.setAttribute("productList", productList);//��Ʒ����
		
		Page page=new Page(0,1,0);//���÷�ҳ
		request.setAttribute("page", page);
		
		return mapping.findForward("ok");
	}
	
}
