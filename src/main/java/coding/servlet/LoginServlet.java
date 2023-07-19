package coding.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.entity.User;
import coding.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			UserService userService = new UserService();
			User user = new User();
			user = userService.getUserByEmailAndPassword(email, password);

			if (user == null) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("errorMessage", "Login details are incorrect, please try again!");
				rd.forward(request, response);

			} else {
				HttpSession session = request.getSession(false);
				
				if (user.getRole().equals("student")) {
					session.setAttribute("user", user);
					session.setAttribute("studentId", user.getId());
					RequestDispatcher rd = request.getRequestDispatcher("home");
					rd.forward(request, response);
				}
				else if (user.getRole().equals("landlord")) {
					session.setAttribute("user", user);
					session.setAttribute("landlordId", user.getId());
					RequestDispatcher rd = request.getRequestDispatcher("landlord-home.jsp");
					rd.forward(request, response);
				}
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
