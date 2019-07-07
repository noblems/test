package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import commons.SessionReturn;
import manager.mappings.LibUser;
import manager.mappings.Person;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doLogin(request, response);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
		SessionReturn sr=new SessionReturn();
		Session s=sr.sessionReturn();
		Transaction t=s.beginTransaction();
		String sql_query = "from LibUser where uname=:u";//user table name which is in database.
		Query query = s.createQuery(sql_query);
		Query q1=s.createQuery("from Person where personid=:p");
		
		query.setParameter("u", request.getParameter("uname"));
		List<?> list = query.list();
		if(list!=null)	{	 
			LibUser u = (LibUser)list.get(0);
			if(u.getPassword().equals(request.getParameter("passwd"))) {
				q1.setParameter("p", u.getPersonid());
				List<?> plist = q1.list();
				Person p= (Person)plist.get(0);
				System.out.println(p.getFname()+" "+p.getLname());
				//System.out.println(u.getUname()+" "+request.getParameter("passwd")+" "+u.getPassword());
				Cookie pid=new Cookie("personid",Integer.toString(p.getPersonid()));
				Cookie level=new Cookie("level",u.getLevel());
				response.addCookie(pid);
				response.addCookie(level);
				//response.wait(1,20);
				
				response.sendRedirect("Home.jsp");
			}
			
		}
		response.getWriter().append("done");
		 
	}

}
