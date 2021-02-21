package mypackage.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mypackage.business.LeapYearService;

@ExtendWith(MockitoExtension.class)
public class LeapYearControllerTest {

	/*
	 * To be able to test outside the container, we have to stub/mock
	 * container objects. There exist several specialized frameworks
	 * for this (e.g. Spring Mock Objects), but here we use mockito.
	 */
	@Mock private HttpServletRequest request;
	@Mock private RequestDispatcher dispatcher;
	@Mock private HttpServletResponse response;
	@Mock private ServletConfig config;
	
	/*
	 * In some of the test cases we want to stub/mock the leap year 
	 * service. In fact, maybe it should have been stubbed/mocked 
	 * for all these tests? ...
	 */
	@Mock private LeapYearService service;

	/*
	 * The SUT (System Under Test), the leapYearController
	 */
	private LeapYearController leapYearController;

	@BeforeEach
	public void setup() throws Exception {
		
		/*
		 * When running the application, this stuff is set up by the 
		 * web-container with values from annotations / web.xml and 
		 * stored in the config object. In the tests, we have to stub 
		 * the config.
		 */
		when(config.getInitParameter("success_page"))
				.thenReturn("result.jsp");
		
		/*
		 * We also need to instruct the request-stub to return the 
		 * dispatcher-stub when asked for it.
		 */
		when(request.getRequestDispatcher("result.jsp"))
				.thenReturn(dispatcher);
		
		/*
		 *  Finally, we initialize the leapYearController (our SUT)
		 *  with the stubbed config.
		 */
		leapYearController = new LeapYearController();
		leapYearController.init(config);
	}

	// -----------------------------------------------------------------------

	@Test
	public void shouldCreateIsALeapYearMessageWhenLeapYear() 
			throws Exception {

		// Set up a request with ...?year=2012
		when(request.getParameter("year")).thenReturn("2012");
		
		//We choose not to stub the leapYearService in this test
		//..., but we could have.
		
		// Run doGet() to simulate a request
		leapYearController.doGet(request, response);
		
		/*
		 * Verify that the model (here: the message-string) is created, 
		 * is correct, and is stored in the request-scope. 
		 */
		verify(request).setAttribute("message", "2012 is a leap year.");
		//assertEquals("2012 is a leap year.", request.getAttribute("message"));
	}

	@Test
	public void shouldCreateIsNotALeapYearMessageWhenNonLeapYear()
			throws Exception {

		when(request.getParameter("year")).thenReturn("2009");
		
		//We choose not to stub the leapYearService in this test
		//..., but we could have.
		
		leapYearController.doGet(request, response);

		/*
		 * Verify that the model (here: the message-string) is created, 
		 * is correct, and is stored in the request-scope.
		 */
		verify(request).setAttribute("message", "2009 is not a leap year.");
		//assertEquals("2009 is not a leap year.", request.getAttribute("message"));
	}

	@Test
	public void shouldCreateInvalidYearMessageWhenInvalidInput() 
			throws Exception {

		when(request.getParameter("year")).thenReturn("xxxx");
		
		leapYearController.doGet(request, response);
		
		verify(request).setAttribute("message", "xxxx is not a valid year.");
	}

	@Test
	public void shouldCreateInvalidYearMessageWhenServiceThrowsException()
			throws Exception {

		when(request.getParameter("year")).thenReturn("1000");
		
		/*
		 * Here, we choose to stub (and inject) the leapYearService.
		 */
		doThrow(new RuntimeException()).when(service).isLeapYear(
				any(Integer.class));
		leapYearController.setLeapYearService(service);

		leapYearController.doGet(request, response);
		
		verify(request).setAttribute("message", "1000 is not a valid year.");
	}

	@Test
	public void shouldForwardToCorrectViewOnSuccess() throws Exception {

		leapYearController.doGet(request, response);

		verify(request).getRequestDispatcher(config.getInitParameter("success_page"));
		verify(dispatcher).forward(request, response);
	}

	@Test
	public void shouldCallLeapYearServiceOnceAndOnlyOnce() throws Exception {

		when(request.getParameter("year")).thenReturn("2009");
		
		// Here, we need to MOCK the leapYearService
		leapYearController.setLeapYearService(service);

		leapYearController.doGet(request, response);
		
		//times(1) is default, so it can be omitted
		verify(service, times(1)).isLeapYear(2009);
	}

}
