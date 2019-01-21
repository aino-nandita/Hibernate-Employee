import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.EmployeeDao;
import pojo.Employee;

public class EmployeeDaoTest {


	@Test
	public void createTest()
	{
		EmployeeDao empdao=new EmployeeDao();
		Employee emp=new Employee();
		emp.setId(3);
		emp.setFirstname("saving");
		emp.setLastname("3rd ");
		emp.setMiddlename("record");

		int id=(Integer)empdao.create(emp);
		assertTrue(emp.getId()==id);

		// clean database
		empdao.delete(id);
	}

	@Test
	public void readTest()
	{
		EmployeeDao empdao=new EmployeeDao();
		Employee emp=new Employee();
		emp.setId(4);
		emp.setFirstname("aaaa");
		emp.setLastname("4th");
		emp.setMiddlename("record");

		int id=(Integer)empdao.create(emp);

		Employee emp1=empdao.read(id);

		assertTrue(emp1.getId() == emp.getId());
		assertTrue(emp1.getFirstname().equals(emp.getFirstname()));
		assertTrue(emp1.getLastname().equals(emp.getLastname()));
		assertTrue(emp1.getMiddlename().equals(emp.getMiddlename()));

		// clean database
		empdao.delete(id);
	}

	@Test
	public void updateTest()
	{
		EmployeeDao empdao=new EmployeeDao();
		Employee emp=new Employee();
		emp.setId(6);
		emp.setFirstname("rajat");
		emp.setLastname("pqr");
		emp.setMiddlename("abdhd");

		int id=(Integer) empdao.create(emp);

		emp.setFirstname("update");
		emp.setLastname("6th");
		emp.setMiddlename("record");

		empdao.update(emp);

		Employee emp1=empdao.read(id);

		assertTrue(emp1.getFirstname().equals(emp.getFirstname()));
		assertTrue(emp1.getLastname().equals(emp.getLastname()));
		assertTrue(emp1.getMiddlename().equals(emp.getMiddlename()));

		// clean database
		empdao.delete(id);
	}

	@Test
	public void deleteTest()
	{
		EmployeeDao empdao=new EmployeeDao();
		Employee emp=new Employee();

		emp.setId(7);
		emp.setFirstname("deleted");
		emp.setLastname("7th");
		emp.setMiddlename("record");

		int id=(Integer) empdao.create(emp);

		empdao.delete(id);
		Employee emp1 = empdao.read(id);

		assertTrue(emp1== null);

		// clean database
		empdao.delete(id);
	}
}
