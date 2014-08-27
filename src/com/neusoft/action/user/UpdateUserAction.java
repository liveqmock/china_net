package com.neusoft.action.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.vo.User;

public class UpdateUserAction extends Action {
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	String auth=request.getParameter("auth");
	
	DAOFactory.getUserDAO().updateUserById(id, password, auth);
	
	List<User> userList=null;
	userList=DAOFactory.getUserDAO().getUser();
	request.setAttribute("userList", userList);
	
	return mapping.findForward("ok");
}
}
