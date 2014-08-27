package com.neusoft.action.interSettle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.util.Page;
import com.neusoft.vo.InterSettle;

public class QueryInterSettleAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ѯ���г�������
		List<InterSettle> cityList =null;
		cityList=DAOFactory.getInterSettleDao().getAllCityName();
		
		//��ѯ���в�Ʒ����
		List<InterSettle> productList =null;
		productList=DAOFactory.getInterSettleDao().getAllProductName();
		
		//��ѯ���н�����Ӫ������
		List<InterSettle> balanceSpList =null;
		balanceSpList=DAOFactory.getInterSettleDao().getAllSpName();
		
		//��ѯ���н�����������
		List<InterSettle> balanceTypeList =null;
		balanceTypeList=DAOFactory.getInterSettleDao().getAllTypeName();
		
		
		
		//��ҳ
		List<InterSettle> interSettleList=null;
		String cityCode=request.getParameter("cityCode");
		String productCode=request.getParameter("productCode");
		String balanceSpCode=request.getParameter("balanceSpCode");
		String balanceTypeCode=request.getParameter("balanceTypeCode");
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
		interSettleList=DAOFactory.getInterSettleDao().findInterSettleRecord(currentPage, pageSize, cityCode, productCode, balanceSpCode, balanceTypeCode, checkCode, recordMonth1, recordMonth2);
		
		if(!interSettleList.isEmpty()){
			totalRows=DAOFactory.getInterSettleDao().findAllRows(cityCode, productCode, balanceSpCode, balanceTypeCode, checkCode, recordMonth1, recordMonth2);//������еļ�¼��
			request.setAttribute("interSettleList", interSettleList);//��ҳ��ѯ��¼
			request.setAttribute("isEmpty", "no");//��ʾ��ʾ��Ϣ-->�Ƿ������������ļ�¼
		}
		page=new Page(currentPage,pageSize,totalRows);//��ʼ��
		request.setAttribute("page", page);
		request.setAttribute("totalRows", totalRows);
		
		
		
		//1��ʾ����
		request.setAttribute("recordMonth1", recordMonth1);
		request.setAttribute("recordMonth2", recordMonth2);
		
		//2�����б�
		request.setAttribute("cityList", cityList);
		request.setAttribute("productList", productList);
		request.setAttribute("balanceSpList", balanceSpList);
		request.setAttribute("balanceTypeList", balanceTypeList);
		
		//3��ʾ֮ǰѡ���Ĳ�����Ϣ�������б�
		request.setAttribute("cityCode", cityCode);
		request.setAttribute("productCode", productCode);
		request.setAttribute("balanceSpCode", balanceSpCode);
		request.setAttribute("balanceTypeCode", balanceTypeCode);
		request.setAttribute("checkCode", checkCode);
		
		
		return mapping.findForward("ok");
	}

}
