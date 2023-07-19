package coding.servlet;

import com.braintreegateway.*;

import coding.service.PaymentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PaymentServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String username = (String) request.getSession().getAttribute("username");
	    if (username == null || username.isEmpty()) {
	        response.sendRedirect("login.jsp");
	    } else {
	        PaymentService paymentService = new PaymentService();
	        String clientToken = paymentService.getClientToken();
	        request.setAttribute("clientToken", clientToken);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
	        dispatcher.forward(request, response);
	    }
	}

	private PaymentService paymentService = new PaymentService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String username = (String) request.getSession().getAttribute("username");
	    if (username == null || username.isEmpty()) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    String nonce = request.getParameter("payment_method_nonce");
	    BigDecimal amount;

	    try {
	        amount = new BigDecimal(request.getParameter("amount"));
	    } catch (NumberFormatException e) {
	        response.getWriter().append("Error: The provided amount is not a valid number.");
	        return;
	    }

	    String currency = request.getParameter("currency");

	    PaymentService paymentService = new PaymentService();
	    Result<Transaction> result = paymentService.processPayment(nonce, amount, currency);

	    if (result.isSuccess()) {
	        response.getWriter().append("Payment executed successfully, ID = " + result.getTarget().getId());
	    } else if (result.getTransaction() != null) {
	        response.getWriter().append(
	                "Error occurred during payment execution: " + result.getTransaction().getProcessorResponseText());
	    } else {
	        String errorMessage = "";
	        for (ValidationError error : result.getErrors().getAllDeepValidationErrors()) {
	            errorMessage += "Validation error: " + error.getMessage() + "\n";
	        }
	        response.getWriter().append("Error occurred during payment execution: " + errorMessage);
	    }
	}

}
