package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import commons.SessionReturn;
import manager.mappings.Person;

/**
 * Servlet implementation class CreatePerson
 */
public class CreatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private static int pid=1;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePerson() {
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
		createPerson(request, response);
	}
	public void createPerson(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException { 
       SessionReturn sr= new SessionReturn();  
       Session session =sr.sessionReturn();
        Transaction t = session.beginTransaction();
        Person p=new Person();
        p.setPersonid(pid++);
        p.setAge(Integer.parseInt(request.getParameter("age")));
        p.setEmail(request.getParameter("email"));
        p.setFname(request.getParameter("fname"));
        p.setMname(request.getParameter("mname"));
        p.setLname(request.getParameter("lname"));
        p.setPhoneno(request.getParameter("phoneno"));
        p.setSex(request.getParameter("sex"));
        session.save(p);
        t.commit();
        sr.closeAll();
        response.getWriter().append("saved successfully");
        
	}

}
