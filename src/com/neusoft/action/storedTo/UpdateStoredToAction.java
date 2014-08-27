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


public class UpdateStoredToAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String storedToId=request.getParameter("storedToId");
		String recordMonth=request.getParameter("recordMonth1");
		String cityCode=request.getParameter("cityCode");
		String productCode=request.getParameter("productCode");
		String accountTypeCode=request.getParameter("accountTypeCode");
		String fee=request.getParameter("fee");
		
		int id=Integer.parseInt(storedToId);
		DAOFactory.getStoredToDAO().updateStoredTo(id, recordMonth, cityCode, productCode, accountTypeCode, fee);
		
		//查询所有城市
		List<StoredTo> cityList=null;
		cityList=DAOFactory.getStoredToDAO().getAllCityName();
		
		
		//查询所有产品
		List<StoredTo> productList=null;
		productList=DAOFactory.getStoredToDAO().getAllProductName();
		
		
		//查询所有出账类型
		List<StoredTo> typeList=null;
		typeList=DAOFactory.getStoredToDAO().getAllStoredToType();
		
		//下拉列表
		request.setAttribute("cityList", cityList);//出账城市
		request.setAttribute("productList", productList);//产品名称
		request.setAttribute("typeList", typeList);//出账收入类型
		
		Page page=new Page(0,1,0);//设置分页
		request.setAttribute("page", page);
		
		return mapping.findForward("ok");
	}

}
