package mypackage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.business.LeapYearService;
import mypackage.business.LeapYearServiceImpl;

@SuppressWarnings("serial")
public class LeapYearController extends HttpServlet {
	
	private LeapYearService leapYearService;
	private String successPage;

	@Override
	public void init() throws ServletException {
		successPage = getServletConfig().getInitParameter("success_page");
		leapYearService = new LeapYearServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String message = null;
		try {
			int year = Integer.parseInt(req.getParameter("year"));
			boolean isLeapYear = leapYearService.isLeapYear(year);
			message = createMessage(year, isLeapYear);
			
		} catch (RuntimeException e) {
			message = req.getParameter("year") + " is not a valid year.";
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher(successPage).forward(req, resp);
	}

	private String createMessage(int year, boolean isLeapYear) {
		return isLeapYear 
				? "" + year + " is a leap year." 
				: "" + year + " is not a leap year.";
	}

	/**
	 * Dependency-injection to enable unit-testing
	 * @param impl
	 */
	protected void setLeapYearService(LeapYearService impl) {
		leapYearService = impl;
	}
}
