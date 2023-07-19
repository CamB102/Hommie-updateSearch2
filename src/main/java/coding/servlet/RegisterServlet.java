package coding.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.entity.User;
import coding.service.UserService;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String role = request.getParameter("role");

		// Validate email and password
		List<String> errors = validateData(email, password, confirmPassword);
		if (!errors.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			request.setAttribute("errorMessage", errors);
			rd.forward(request, response);
			return;
		}

		UserService userService = new UserService();
		try {
			// Check for duplicate email, and password

			boolean isEmailAvailable = userService.isEmailAvailable(email);

			if (!isEmailAvailable) {
				errors.add("Email has been registered. Please use another email.");
			}

			if (!errors.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				request.setAttribute("errorMessage", errors);
				rd.forward(request, response);
				return;
			}

			User user = new User(firstName, lastName, phoneNumber, email, password, role);

			boolean isInsertSuccessful = userService.insertUser(user);

			if (isInsertSuccessful) {
				response.sendRedirect("register-success.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				request.setAttribute("errorMessage", "An error has occurred. Please reinput your information");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private List<String> validateData(String email, String password, String confirmPassword) {
		List<String> errors = new ArrayList<>();

		// Validate email
		if (email == null || email.trim().isEmpty() || !email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com")) {
			errors.add("Invalid email. Please enter a valid email address!");
		}

		// Validate password
		if (password == null || password.trim().isEmpty() || !password.matches("[a-zA-Z0-9]+")) {
			errors.add("Invalid password. Please enter a valid password!");
		}

		// Validate password
		if (!password.equals(confirmPassword)) {
			errors.add("Passwords are not matching. Please double check!");
		}

		return errors;
	}
}