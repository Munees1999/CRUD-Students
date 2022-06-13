package com.vastpro.in.classtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StdentServlet
 */
@WebServlet("/StdentServlet")
public class StdentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StdentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String sName=request.getParameter("name");
		String sId=request.getParameter("id");
		String sRollNumber=request.getParameter("rollNumber");
		String sAge=request.getParameter("age");
		String sMark=request.getParameter("totalMarks");
		String sgrade=request.getParameter("grade");
		
		
		Student sn=new Student();
		sn.setName(sName);
		sn.setId(sId);
		sn.setRollNumber(sRollNumber);
		sn.setAge(sAge);
		sn.setTotalMarks(sMark);
		sn.setGrade(sgrade);
		
		
		int status=0;
		status=StudentConnection.insert(sn);
		if(status==1) {
			pw.print("Successfully insert");
		}
		else {
			pw.println("Error");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
