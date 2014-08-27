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
		
		//显示之前选过的操作信息（下拉列表）
		request.setAttribute("month", oa.getYearMonth());//显示日期
		request.setAttribute("cityCode", oa.getCityCode());
		request.setAttribute("productCode", oa.getProductTypeCode());
		request.setAttribute("accountTypeCode", oa.getOutAccountTypeCode());
		request.setAttribute("fee", oa.getAmount());
		//设置ID
		request.setAttribute("outAccountId", oa.getOutAccountId());
		
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
