package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		//String selectedHobby = "";
		String selectedCollors = "";
		//for (String hobby : request.getParameterValues("hobby")) {
		//	selectedHobby += hobby + " ";
		//}
		for (String collors : request.getParameterValues("collors")) {
			selectedCollors += collors + " ";
		}
		
		try {
			out.println("<html><body><h2>Your data</h2>" +
					"<p>First name: " + request.getParameter("firstName") + "<br />" +
					"<p>Date of birth: " + new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("date")) + "<br />" +
					//"<p>Your hobby: " + selectedHobby + "<br />" +
					"<p>Your selected collors: " + selectedCollors + "<br />" +
					"</body></html>");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
