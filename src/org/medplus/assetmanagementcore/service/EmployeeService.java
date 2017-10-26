package org.medplus.assetmanagementcore.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.medplus.assetmanagementcore.model.Employee;

public interface EmployeeService {
	public String addEmployee(Employee employee);

	public String updateEmployee(Employee employee, String updatedBy,
			Date updatedDate);

	public Employee getEmployee(String empId);

	public List<Employee> getAllEmployees();

	public String addRoleToEmp(String empId, List<Long> roleIdList,
			String addedBy, Date addedDate);

	public String addRole(int roleId, String roleName, String createdBy,
			Date createdDate);

	public List<Map<Integer, String>> getEmployeeRole(String empid);

	public List<Map<Integer, String>> getAllRole();

	public String removeEmployeeRole(String empid, String roleName,
			String removedBy, Date removedDate);

	public String changePassword(String empId, String oldPassword,
			String newPassword, String changedBy, Date changedDate);

	public String resetPassword(String empId, String changedBy,
			String newPassword);

	public List<Map<Integer, String>> getRole(String empId);

	public String authenticateEmployee(String empId, String password);
}
