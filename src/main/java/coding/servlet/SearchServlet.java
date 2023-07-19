package coding.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.entity.Room;
import coding.service.RoomService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SearchServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String searchInput = request.getParameter("searchInput");
			String weeklyPrice = request.getParameter("weeklyPrice");
			String state = request.getParameter("state");
			String availableDateParam = request.getParameter("availableDate");

			
			

			System.out.println("search: " + searchInput);
			System.out.println("price: " + weeklyPrice);
			System.out.println("date: " + availableDateParam);
			System.out.println("state: " + state);

			String error = "Please select a state.";
			RoomService roomService = new RoomService();
			// ask user to select state
			if (state == null) {
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("errorMessage", error);
				rd.forward(request, response);
			// not select weekly price
			} else if (state != null && weeklyPrice == null && !availableDateParam.equals("Available date")) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date availableDate = null;
				java.sql.Date sqlAvailableDate = null;

				try {
				    availableDate = dateFormat.parse(availableDateParam);
				 // Convert java.util.Date to java.sql.Date
				    sqlAvailableDate = new java.sql.Date(availableDate.getTime());
				    System.out.println(availableDate);
				} catch (ParseException e) {
				    e.printStackTrace();
				}
				List<Room> roomList = roomService.getRoomsBySearchWithoutWeeklyPrice(searchInput, state,
						sqlAvailableDate);
				request.setAttribute("roomList", roomList);
				request.setAttribute("searchInput", searchInput);
				request.setAttribute("weeklyPrice", weeklyPrice);
				request.setAttribute("state", state);
				request.setAttribute("availableDate", availableDateParam);
				RequestDispatcher rd = request.getRequestDispatcher("room-list.jsp");
				rd.forward(request, response);	
			// not select date & price 
			} else if (state != null && weeklyPrice == null && availableDateParam.equals("Available date")) {
				Date availableDate = new Date(); // Use the current time as the available date
			    System.out.println(availableDate);
			    java.sql.Date sqlAvailableDate = new java.sql.Date(availableDate.getTime());

			    List<Room> roomList = roomService.getRoomsBySearchWithoutWeeklyPrice(searchInput, state, sqlAvailableDate);
			    request.setAttribute("roomList", roomList);
			    request.setAttribute("searchInput", searchInput);
			    request.setAttribute("weeklyPrice", weeklyPrice);
			    request.setAttribute("state", state);
			    request.setAttribute("availableDate", availableDateParam);
			    RequestDispatcher rd = request.getRequestDispatcher("room-list.jsp");
			    rd.forward(request, response);
			    // not select date, set current time
			} else if (state != null && weeklyPrice != null && availableDateParam.equals("Available date")) {
				Date availableDate = new Date(); // Use the current time as the available date
			    System.out.println(availableDate);
			    java.sql.Date sqlAvailableDate = new java.sql.Date(availableDate.getTime());

			    List<Room> roomList = roomService.getRoomsBySearchWithState(searchInput, weeklyPrice, state,
						sqlAvailableDate);
			    request.setAttribute("roomList", roomList);
			    request.setAttribute("searchInput", searchInput);
			    request.setAttribute("weeklyPrice", weeklyPrice);
			    request.setAttribute("state", state);
			    request.setAttribute("availableDate", availableDateParam);
			    RequestDispatcher rd = request.getRequestDispatcher("room-list.jsp");
			    rd.forward(request, response);
			} else {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date availableDate = null;
				java.sql.Date sqlAvailableDate = null;

				try {
				    availableDate = dateFormat.parse(availableDateParam);
				 // Convert java.util.Date to java.sql.Date
				    sqlAvailableDate = new java.sql.Date(availableDate.getTime());
				    System.out.println(availableDate);
				} catch (ParseException e) {
				    e.printStackTrace();
				}
				List<Room> roomList = roomService.getRoomsBySearchWithState(searchInput, weeklyPrice, state,
						sqlAvailableDate);

				request.setAttribute("roomList", roomList);
				request.setAttribute("searchInput", searchInput);
				request.setAttribute("weeklyPrice", weeklyPrice);
				request.setAttribute("state", state);
				request.setAttribute("availableDate", availableDateParam);
				RequestDispatcher rd = request.getRequestDispatcher("room-list.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
