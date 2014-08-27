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

public class GetOutAccountAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//查询所有城市
		List<OutAccount> cityList=null;
		cityList=DAOFactory.getOutAccountDAO().getAllCityName();
		
		
		//查询所有产品
		List<OutAccount> productList=null;
		productList=DAOFactory.getOutAccountDAO().getAllProductName();
		
		
		//查询所有出账类型
		List<OutAccount> typeList=null;
		typeList=DAOFactory.getOutAccountDAO().getAllOutAccountType();
		
		//下拉列表
		request.setAttribute("cityList", cityList);//出账城市
		request.setAttribute("productList", productList);//产品名称
		request.setAttribute("typeList", typeList);//出账收入类型
		
		
		Page page=new Page(0,1,0);//设置分页
		request.setAttribute("page", page);
		
		return mapping.findForward("ok");
	}
	
}
