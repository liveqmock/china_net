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

public class QueryOutAccountAction extends Action {

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
		
		
		//分页
		List<OutAccount> outAccountList=null;
		String cityCode=request.getParameter("cityCode");
		String productCode=request.getParameter("productCode");
		String accountTypeCode=request.getParameter("accountTypeCode");
		String checkCode=request.getParameter("checkCode");
		
		String recordMonth1=request.getParameter("recordMonth1");//起止日期
		String recordMonth2=request.getParameter("recordMonth2");//结束日期
		String  current=request.getParameter("currentPage");
		if(current==null){
			current=1+"";
		}
	    int currentPage=Integer.parseInt(current);//当前页号
		int pageSize=4;//每页显示的记录数
		int totalRows=0;
		Page page=null;
		outAccountList=DAOFactory.getOutAccountDAO().findOutAccountRecord(currentPage, pageSize, cityCode, productCode, accountTypeCode, checkCode, recordMonth1, recordMonth2);
		
		if(!outAccountList.isEmpty()){
			totalRows=DAOFactory.getOutAccountDAO().findAllRows(cityCode, productCode, accountTypeCode, checkCode, recordMonth1, recordMonth2);//查出所有的记录数
			request.setAttribute("outAccountList", outAccountList);//分页查询记录
			request.setAttribute("isEmpty", "no");//显示提示信息-->是否有满足条件的记录
		}
		page=new Page(currentPage,pageSize,totalRows);//初始化
		request.setAttribute("page", page);
		request.setAttribute("totalRows", totalRows);
		
		
		
		//1显示日期
		request.setAttribute("recordMonth1", recordMonth1);
		request.setAttribute("recordMonth2", recordMonth2);
		
		//2下拉列表
		request.setAttribute("cityList", cityList);//出账城市
		request.setAttribute("productList", productList);//产品名称
		request.setAttribute("typeList", typeList);//出账收入类型
		
		
		//3显示之前选过的操作信息（下拉列表）
		request.setAttribute("cityCode", cityCode);
		request.setAttribute("productCode", productCode);
		request.setAttribute("accountTypeCode", accountTypeCode);
		request.setAttribute("checkCode", checkCode);
		
		return mapping.findForward("ok");
		
	}
	
}
