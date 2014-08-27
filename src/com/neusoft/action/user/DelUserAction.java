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

public class DelUserAction extends Action {
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	String id=request.getParameter("id");
	DAOFactory.getUserDAO().delUser(id);
	
	List<User> userList=null;
	userList=DAOFactory.getUserDAO().getUser();
	request.setAttribute("userList", userList);
	
	return mapping.findForward("ok");
}
}
