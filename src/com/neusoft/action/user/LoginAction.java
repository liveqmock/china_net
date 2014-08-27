package com.neusoft.action.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neusoft.commonDao.DAOFactory;
import com.neusoft.vo.User;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = DAOFactory.getUserDAO().validateUser(name, password);
		
		String msg = null;
		if(user!=null){
			request.getSession().setAttribute("user", user);
			if(user.getAuth()==0){
				msg = "admin";//管理员
			}
			else if(user.getAuth()==1){
				msg = "recorder";//录入人员
			}
			else if(user.getAuth()==2){
				msg = "checker";//稽核人员
			}
			else{
				msg = "gather";//归集人员
			}
			return mapping.findForward(msg);
		} else {
			
			request.setAttribute("msg", "用户名或密码不正确！");
			return mapping.findForward("error");
		}
	}
}
