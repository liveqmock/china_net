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
		
		//显示之前选过的操作信息（下拉列表）
		request.setAttribute("month", cs.getYearMonth());//显示日期
		request.setAttribute("cityCode", cs.getCityCode());
		request.setAttribute("productCode", cs.getProductCode());
		request.setAttribute("amount", (int)(cs.getAmount()));
		request.setAttribute("pv", (int)cs.getParValue());
		request.setAttribute("tf", (int)cs.getTotalFee());
		request.setAttribute("df", (int)cs.getDiscountFee());
		request.setAttribute("dt", (int)cs.getDiscount());
		
		
		//设置ID
		request.setAttribute("cardSaleId", cs.getCardSaleId());
		
		//查询所有城市
		List<CardSale> cityList=null;
		cityList=DAOFactory.getCardSaleDAO().getAllCityName();
		
		
		//查询所有产品
		List<CardSale> productList=null;
		productList=DAOFactory.getCardSaleDAO().getAllProductName();
		
		//下拉列表
		request.setAttribute("cityList", cityList);//出账城市
		request.setAttribute("productList", productList);//产品名称
		
		Page page=new Page(0,1,0);//设置分页
		request.setAttribute("page", page);
		
		return mapping.findForward("ok");
	}
	
}
