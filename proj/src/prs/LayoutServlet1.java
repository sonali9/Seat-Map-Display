package prs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/LayoutServlet1")
public class LayoutServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LayoutServlet1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/jsp");

		// 1. get class,train no and date
		String cls = request.getParameter("class1");
		String t = request.getParameter("trainNo");
		int tno = Integer.parseInt(t);
		String date = request.getParameter("startdate");

		// 2.add data
		request.setAttribute("class1", cls);
		request.setAttribute("trainNo", t);
		request.setAttribute("startdate", date);

		// 3.get request dispatcher
		if (cls.equals("Sleeper Class (SL)")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/sleeper.jsp");
			dispatcher.forward(request, response);
		} else if (cls.equals("AC 3 Tier (3A)")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ac3.jsp");
			dispatcher.forward(request, response);
		} else if (cls.equals("AC 2 Tier (2A)")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ac2.jsp");
			dispatcher.forward(request, response);
		} else if (cls.equals("First Class AC (1A)")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ac1.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}