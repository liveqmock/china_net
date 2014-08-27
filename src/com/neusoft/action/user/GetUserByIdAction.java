package com.neusoft.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class GetUserByIdAction extends Action {
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

	String id=request.getParameter("id");
	String userName=request.getParameter("userName");
	
	System.out.println(userName+"____");
	
	request.setAttribute("id", id);
	request.setAttribute("userName", userName);
	return mapping.findForward("ok");
}
}
