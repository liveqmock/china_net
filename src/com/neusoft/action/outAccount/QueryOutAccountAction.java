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

		//��ѯ���г���
		List<OutAccount> cityList=null;
		cityList=DAOFactory.getOutAccountDAO().getAllCityName();
		
		
		//��ѯ���в�Ʒ
		List<OutAccount> productList=null;
		productList=DAOFactory.getOutAccountDAO().getAllProductName();
		
		
		//��ѯ���г�������
		List<OutAccount> typeList=null;
		typeList=DAOFactory.getOutAccountDAO().getAllOutAccountType();
		
		
		//��ҳ
		List<OutAccount> outAccountList=null;
		String cityCode=request.getParameter("cityCode");
		String productCode=request.getParameter("productCode");
		String accountTypeCode=request.getParameter("accountTypeCode");
		String checkCode=request.getParameter("checkCode");
		
		String recordMonth1=request.getParameter("recordMonth1");//��ֹ����
		String recordMonth2=request.getParameter("recordMonth2");//��������
		String  current=request.getParameter("currentPage");
		if(current==null){
			current=1+"";
		}
	    int currentPage=Integer.parseInt(current);//��ǰҳ��
		int pageSize=4;//ÿҳ��ʾ�ļ�¼��
		int totalRows=0;
		Page page=null;
		outAccountList=DAOFactory.getOutAccountDAO().findOutAccountRecord(currentPage, pageSize, cityCode, productCode, accountTypeCode, checkCode, recordMonth1, recordMonth2);
		
		if(!outAccountList.isEmpty()){
			totalRows=DAOFactory.getOutAccountDAO().findAllRows(cityCode, productCode, accountTypeCode, checkCode, recordMonth1, recordMonth2);//������еļ�¼��
			request.setAttribute("outAccountList", outAccountList);//��ҳ��ѯ��¼
			request.setAttribute("isEmpty", "no");//��ʾ��ʾ��Ϣ-->�Ƿ������������ļ�¼
		}
		page=new Page(currentPage,pageSize,totalRows);//��ʼ��
		request.setAttribute("page", page);
		request.setAttribute("totalRows", totalRows);
		
		
		
		//1��ʾ����
		request.setAttribute("recordMonth1", recordMonth1);
		request.setAttribute("recordMonth2", recordMonth2);
		
		//2�����б�
		request.setAttribute("cityList", cityList);//���˳���
		request.setAttribute("productList", productList);//��Ʒ����
		request.setAttribute("typeList", typeList);//������������
		
		
		//3��ʾ֮ǰѡ���Ĳ�����Ϣ�������б�
		request.setAttribute("cityCode", cityCode);
		request.setAttribute("productCode", productCode);
		request.setAttribute("accountTypeCode", accountTypeCode);
		request.setAttribute("checkCode", checkCode);
		
		return mapping.findForward("ok");
		
	}
	
}
