package commons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class SessionReturn {
	Session session;
	SessionFactory factory;
	Metadata meta;
	StandardServiceRegistry ssr;
	public Session sessionReturn() {
		ssr=new StandardServiceRegistryBuilder().configure("./hibernate.cfg.xml").build();
		meta = new MetadataSources(ssr).getMetadataBuilder().build();
		factory = meta.getSessionFactoryBuilder().build();  
		session = factory.openSession();
        return session;
	}
	public void closeAll() {
		this.factory.close();
		this.session.close();
		
	}

}
