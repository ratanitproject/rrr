package com.sathya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CalculateCostServlet() {        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double proCost = Double.parseDouble(request.getParameter("proCost"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		double totalCost = proCost * quantity;
		double discount = 0;
		String discountMessage = "No discount";

		if (totalCost > 1000 && totalCost <= 5000) {
			discount = totalCost * 0.05;
			discountMessage = "5% discount";
		} else if (totalCost > 5000 && totalCost <= 10000) {
			discount = totalCost * 0.1;
			discountMessage = "10% discount";
		} else if (totalCost > 10000) {
			discount = totalCost * 0.15;
			discountMessage = "15% discount";
		}

		double finalCost = totalCost - discount;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='aqua' style='text-align: center;'>");
		out.println("<h1>Product Bill Calculator Result</h1>");
		out.println("<p>Total Cost of " + quantity + " products: $" + totalCost + "</p>");
		out.println(discountMessage + " Amount..."+discount);
		out.println("<p>Net Amount to Pay: $" + finalCost + "</p>");
		out.println("</body></html>");
	}
}
