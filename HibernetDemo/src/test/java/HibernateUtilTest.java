import static org.junit.Assert.*;
import org.hibernate.Session;
import org.junit.Test;

import dao.EmployeeDao;
import dao.HibernateUtil;
import pojo.Employee;

public class HibernateUtilTest{
	@Test
	public void getSessionTest()
	{
		Session session= HibernateUtil.getSessionFactory().openSession();
		assertNotNull(session);
	}
}