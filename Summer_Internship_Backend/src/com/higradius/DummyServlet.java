package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class dummyServlet
 */
@WebServlet("/dummyServlet")
public class DummyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
   static final String DB_URL="jdbc:mysql://localhost/mydb";
   
   private static final String USER="root";
   private static final String PASSWORD="Sourabh";
   
   
    public DummyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 Connection conn = null;
		Statement stmt = null;
		String customerName = null;
		String customerNumber = null;
		String invoiceId =null;
		String totalAmt = null;
		String dueDate = null;
		ArrayList<Response> demolist = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String sql;
			sql = "Select name_customer,cust_number,invoice_id,total_open_amount,due_in_date from mytable";
//			sql = "Select name_customer,cust_number from mytable";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Response  res = new Response();
				customerName = rs.getString("name_customer");
				customerNumber = rs.getString("cust_number");
				invoiceId = rs.getString("invoice_id");
				totalAmt  = rs.getString("total_open_amount");
				dueDate = rs.getString("due_in_date");
//				System.out.println(cName + " having "+ number);
				res.setName_customer(customerName);
				res.setCust_number(customerNumber);
				res.setInvoice_id(invoiceId);
				res.setTotal_open_amount(totalAmt);
				res.setDue_in_date(dueDate);
				
				demolist.add(res);
			}
			
			String jsonString = getJSONStringFromObject(demolist);
			response.setContentType("application/json");
			try {
				response.getWriter().write(jsonString);						
			}catch (Exception io) {
				io.printStackTrace();
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception sq)
			{
				sq.printStackTrace();
			}
			
		}
 
		
		
	}
	 private  String getJSONStringFromObject(ArrayList<Response> rlist)
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson .toJson(rlist);
			return json;
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
