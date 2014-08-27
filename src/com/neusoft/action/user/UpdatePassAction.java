package com.neusoft.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.vo.User;

public class UpdatePassAction extends Action {
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	

		User user=(User)request.getSession().getAttribute("user");
		int id=user.getId();
		String newpass = request.getParameter("newpass");
		
		DAOFactory.getUserDAO().updatePass(newpass,id);
		request.setAttribute("msg", "ÐÞ¸Ä³É¹¦£¡");
		return mapping.findForward("ok");
	}
}

