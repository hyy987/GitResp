package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.Account;
import com.bjsxt.service.AccountService;
import com.bjsxt.service.impl.AccountServiceImpl;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

	private AccountService accountService = new AccountServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		Account accOut = new Account();
		accOut.setAccount(req.getParameter("accOutNo"));
		accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble((req.getParameter("accOutBalance"))));
		Account accIn = new Account();
		accIn.setName(req.getParameter("accInName"));
		accIn.setAccount(req.getParameter("accInAccount"));

		int index = accountService.transfer(accIn, accOut);
		if (index == AccountService.SUCCESS) {

			resp.sendRedirect("/bank/log.jsp");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("code", index);
			resp.sendRedirect("/bank/error/error.jsp");
		}
	}
}
