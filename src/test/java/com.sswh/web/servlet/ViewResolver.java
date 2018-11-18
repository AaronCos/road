package com.sswh.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewResolver extends HttpServlet {
	private String prefix;
	private String suffix;

	@Override
	public void init(ServletConfig config) throws ServletException {
		prefix = config.getInitParameter("prefix");
		suffix = config.getInitParameter("suffix");
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//this.getServletConfig().getInitParameter(prefix ); 如果用这句化，每次访问都调用
		String pageName = req.getParameter("pageName");
		System.out.println("pageName" + prefix);
		req.getRequestDispatcher(prefix + pageName+suffix).forward(req, resp);

	}

}
