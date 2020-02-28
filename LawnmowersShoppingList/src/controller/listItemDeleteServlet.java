package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListItems;

/**
 * Servlet implementation class listItemDeleteServlet
 */
@WebServlet("/listItemDeleteServlet")
public class listItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listItemDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisToItem");
		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllListsServlet";

		ListDetailsHelper dao = new ListDetailsHelper();


		if (act.equals("delete"))
			try

			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails itemToDelete = dao.searchForListById(tempId);
				dao.deleteList(itemToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item.");
			}
		else if (act.contentEquals("add")) {
			path = "/addItemsForListServlet";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
