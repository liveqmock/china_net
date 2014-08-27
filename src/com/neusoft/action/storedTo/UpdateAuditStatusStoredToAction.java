package com.neusoft.action.storedTo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.vo.User;

public class UpdateAuditStatusStoredToAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String status=request.getParameter("status");//要修改的状态码
		String storedToId=request.getParameter("storedToId");
		String[] storedToIds=request.getParameterValues("storedToIds");
		
		
		String msgStr=null;
		
		//稽核人员
		User user=(User) request.getSession().getAttribute("user");
		String operator=user.getName();
		try {
			if(storedToId==null){
				for(String s:storedToIds){
					DAOFactory.getStoredToDAO().UpdateAuditStatusAccountById(s, status, operator);
				}
			}else{
				DAOFactory.getStoredToDAO().UpdateAuditStatusAccountById(storedToId, status, operator);
			}
			if(storedToId!=null){
				if(status.equals("1")){
					msgStr="稽核成功";
				}else{
					msgStr="稽核失败";
				}
				response.setContentType("text/xml;charset=GBK");
			    response.setHeader("Cache-Control","no-cache");
				response.getWriter().println("<?xml version='1.0' encoding='GBK' ?>");
			    response.getWriter().println("<root>");
			    response.getWriter().println("<content1>");
			    response.getWriter().print(msgStr);
			    response.getWriter().println("</content1>");
			    response.getWriter().print("<content2>");//print("<content2>")不能换行
			    response.getWriter().print(storedToId);
			    response.getWriter().println("</content2>");
			    response.getWriter().println("</root>");
			    response.getWriter().close();
			}
		} catch (Exception e) {
		}
	    
		

		return null;
	}

}
