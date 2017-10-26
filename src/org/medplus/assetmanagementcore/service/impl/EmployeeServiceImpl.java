package org.medplus.assetmanagementcore.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.medplus.assetmanagementcore.dao.impl.EmployeeDaoImpl;
import org.medplus.assetmanagementcore.exceptions.EmployeeException;
import org.medplus.assetmanagementcore.model.Employee;
import org.medplus.assetmanagementcore.service.EmployeeService;
import org.medplus.assetmanagementcore.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
EmployeeDaoImpl employeeDaoImpl;
	
	public boolean isUserExisting(String empId) {
		Employee emp = employeeDaoImpl.getEmployee(empId);
		if(emp==null)
			
			return false;
		else
			return true;
	}
	
	@Override
	public String addEmployee(Employee employee) {
		String msg=null;
		
		int rows = employeeDaoImpl.insertEmployee(employee);
		
		if(rows > 0)
			 msg="SUCCESS";
		else
		{
			EmployeeException iae= new EmployeeException("No Employee Found");
			try {
				throw iae;
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	return msg;
	}

	@Override
	public String updateEmployee(Employee employee, String updatedBy, Date updatedDate) {
		
			//employee=employeeDaoImpl.getEmployee(employee.getEmployeeId());
		String msg=null;
		try {
			int rows = employeeDaoImpl.updateEmployeeInfo(employee);
			
			if(rows > 0)
				 msg="SUCCESS";
			else
			msg="FAILURE";
		} catch (Exception e) {
			System.out.println("sql exception raised");
		}
		
		return msg;
		
	}

	public Employee getEmployee(String empId) {
		Employee emp = employeeDaoImpl.getEmployee(empId);

		System.out.println(emp.getEmployeeId() + " " + emp.getGender());
		return emp;

	}


	public String changePassword(String empId, String password,
			String newPassword,String changedBy,Date changedDate) {

		if (employeeDaoImpl.updatePassword(empId, changedBy,
				 password, newPassword) != 0)
			return "SUCCESS";
		else
			return "FAILURE";

	}

	public String resetPassword(String empId, String changedBy,
			String newPassword) {
		

		if (employeeDaoImpl.resetPassword(empId, changedBy,
				 newPassword) != 0)
			return "SUCCESS";
		else
			return "FAILURE";

	}


	

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> rows = employeeDaoImpl.getEmployees();
		System.out.println(rows.size());
		if(rows.size()==0)
		{
		EmployeeException iae= new EmployeeException("No Employee Found");
			try {
				throw iae;
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else 
			
		
		return rows;
		return rows;
		
	}
	
	@Override
	public String removeEmployeeRole(String empId,String roleName, String removedBy, Date removedDate) {
		
		String msg=null;
		if(removedBy.equals(getRole(removedBy).contains("admin"))) {
		try {
			int rows = employeeDaoImpl.removeRole(empId, roleName, removedBy);
			
			if(rows > 0)
				 msg="REMOVED";
			else
			msg="NOT REMOVED";
		} catch (Exception e) {
			System.out.println("sql exception raised");
		}
		}
		else 
			return "NO AUTHORITY";
		
		return msg;
		
	}
	
	@Override
	public String addRoleToEmp(String empId, List<Long> roleIdList, String addedBy,Date addedDate) {
		
		String msg=null;
		try {
			
			int rows = employeeDaoImpl.addRoleToEmp(empId, roleIdList, addedBy, addedDate);
			if(rows > 0)
				 msg="SUCCESS";
			else
			msg="FAILURE";
		} catch (Exception e) {
			System.out.println("sql exception raised");
		}
		
		return msg;
	}

	@Override
	public String addRole(int roleId, String roleName, String addedBy, Date addedDate) {
		
		String msg=null;
		
			int rows = employeeDaoImpl.addRole(roleId, roleName, addedBy, addedDate);
			
			if(rows > 0)
				 msg="SUCCESS";
			else
			{
				EmployeeException iae= new EmployeeException("No Employee Found");
				try {
					throw iae;
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
		return msg;
			
	}

public String authenticateEmployee(String empId, String password) {
		if(!isUserExisting(empId))
		{
		return "INVALID USER";
		}
		else
		{
		password=Encryption.cryptWithMD5(password);
		
		try{
		if(employeeDaoImpl.autheticateEmployee(empId, password)!=null)
		{
		return "LOGIN SUCCESSFUL";
		}
		else
		return "Username and password do not match";
	}
catch(NullPointerException e)
		{
	return "Username and password do not match";
		}
		}
}



	
	

	@Override
	public List<Map<Integer, String>> getEmployeeRole(String empId) {
		List<Map<Integer, String>> list=employeeDaoImpl.getRole(empId);
		if(list.size()==0)
		{
		EmployeeException iae= new EmployeeException("No Employee Found");
			try {
				throw iae;
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return list;
	}

	@Override
	public List<Map<Integer, String>> getAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*private String getRoleId(String roleName) {
		
		String msg=null;
		
		long rows = employeeDaoImpl.getRoleId(roleName);
		
		if(rows > 0)
			 msg="SUCCESS";
		else
		{
			EmployeeException iae= new EmployeeException("No Employee Found");
			try {
				throw iae;
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	return msg;
	}*/

	


	@Override
	public List<Map<Integer, String>> getRole(String empId) {
		
			List<Map<Integer, String>> list=employeeDaoImpl.getRole(empId);
			if(list.size()==0)
			{
			EmployeeException iae= new EmployeeException("No Employee Found");
				try {
					throw iae;
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			return list;
		}
	
}
