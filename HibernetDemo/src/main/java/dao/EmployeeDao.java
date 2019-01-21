/**
 * 
 */
package dao;

import java.io.Serializable;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Employee;

/**
 * @author intern2
 *
 */
public class EmployeeDao {

	public static Session getSession()
	{
		return HibernateUtil.getSessionFactory().openSession();

	}

	public Serializable create(Employee emp)
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Integer id = null;
		try {
			id=(Integer)session.save(emp);
			transaction.commit();
			System.out.println("Record saved! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return id;
	}


	public Employee read(int id)
	{
		Employee emp=null;
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try {
			Query query = session.createQuery("from Employee where id= :id");
			query.setParameter("id", id);
			Object object = (Object)((org.hibernate.query.Query) query).uniqueResult();
			emp= (Employee)object;

			transaction.commit();
			System.out.println("Reading/Displaying the Record! ");
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return emp;
	}


	public void update(Employee emp)
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try
		{
			session.update(emp);
			transaction.commit();
			System.out.println("Record updated! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public void delete(int id)
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.delete(id);
			transaction.commit();
			System.out.println("Record deleted! ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}

