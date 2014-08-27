package com.neusoft.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;

public class AddUserAction extends Action {
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	String auth=request.getParameter("auth");
	if(!auth.equals(""))
	{
		DAOFactory.getUserDAO().addUser(name,password,auth);
	}
	request.setAttribute("msg", "Ìí¼Ó³É¹¦");
	return mapping.findForward("ok");
}
}
