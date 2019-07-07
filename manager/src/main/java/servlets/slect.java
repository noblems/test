package servlets;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import commons.SessionReturn;
import javassist.bytecode.Descriptor.Iterator;
import manager.mappings.LibUser;

public class slect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionReturn sr=new SessionReturn();
		Session s=sr.sessionReturn();
		Transaction t=s.beginTransaction();
		String sql_query = "from LibUser";//user table name which is in database.
		Query query = s.createQuery(sql_query);
		List<?> list = query.list();
				 
		LibUser student = (LibUser)list.get(0);
		 
		     System.out.println(student.getUname());
		
	}


}
