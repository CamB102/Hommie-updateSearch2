package coding.servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.entity.Room;
import coding.service.RoomService;

/**
 * Servlet implementation class WishListServlet
 */
@WebServlet("/wish-list")
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String command = request.getParameter("command");
			int roomId = 0;
			RoomService roomService = new RoomService();
			HttpSession session = request.getSession();
			Map<Integer, Room> wishList = (Map<Integer, Room>) session.getAttribute("wishList");
			
			if (wishList == null) {
				wishList = new HashMap<Integer, Room>();
			}
			
			if(command != null && command.equals("ADD_TO_WISH_LIST")) {
				roomId = Integer.parseInt(request.getParameter("roomId"));	
				Room room = roomService.getRoomDetails(roomId);	
				
				wishList.put(room.getId(), room);
				session.setAttribute("wishList", wishList);
				request.setAttribute("room", room);
				
				//response.sendRedirect("home?command=DETAIL&roomId=" + roomId);
				response.sendRedirect("roomList");
			} else if (command != null && command.equals("VIEW_WISH_LIST")) {
				   request.setAttribute("wishList", wishList);
		           request.getRequestDispatcher("wish-list.jsp").forward(request, response);
			} else if (command != null && command.equals("REMOVE")) {
				roomId = Integer.parseInt(request.getParameter("roomId"));
				wishList.remove(roomId);
				response.sendRedirect("wish-list.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
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
