package com.medplus.assetmanagementcore.utils;

public class Queries {
	//public static String addNewAsset="insert into tbl_asset(SerialNumber,AssetName,AssetType,Cost,Status,CreatedBy,DateCreated) values(?,?,?,?,?,?,?)";
	//public static String updateAssetStatus="update tbl_asset set Status=?,ModifiedBy=?,DateModified=? where AssetId=?";
	public static String updateEmployee="update tbl_employee set FirstName=?,LastName=?,Gender=?,MobileNumber=?,DateOfBirth=?,DateOfJoining=?,Address=?,ModifiedBy=?,DateModified=? where EmployeeId=?";
	public static String getAllEmployees="select * from tbl_employee";
	public static String GET_EMPLOYEE="select * from tbl_employee where employeeId=?";
	public static String addRole="insert into tbl_role values(?,?,?,?)";
	public static String addRoleToEmp="insert into tbl_role_mapping values(?,?,?,?)";
	public static String getAllRoles="select * from tbl_role";
	public static String getRoleId="select RoleId from tbl_role where RoleName =?";
	public static String getRoleName="select RoleName from tbl_role where RoleId =?";
	
	public static String getRoleOfEmployee="select RoleId from tbl_role_mapping where EmployeeId=?";
	public static String removeRole="delete from tbl_role_mapping where EmployeeId=? and RoleId=?";
	public static String employeeModification="update tbl_employee set ModifiedBy=?,DateModified=? where EmployeeId=?";
	
	
	public static String addNewAssetLog="insert into tbl_asset_log(SerialNumber,AssetName,AssetType,Cost,Status,CreatedBy,DateCreated) values(?,?,?,?,?,?,?)";
	public static String updateAssetStatusLog="update tbl_asset_log set Status=?,ModifiedBy=?,DateModified=? where AssetId=?";
	public static String addRoleLog="insert into tbl_role_log values(?,?,?,?)";
	public static String ADD_EMPLOYEE="insert into tbl_employee values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String ADD_EMPLOYEE_LOG="insert into tbl_employee_log values(?,?,?,?,?,?,?,?,?)";

	public static String updateEmployeeLog="update tbl_employee_log set FirstName=?,LastName=?,Gender=?,MobileNumber=?,DateOfBirth=?,DateOfJoining=?,Address=?,ModifiedBy=?,DateModified=? where EmployeeId=?";

	public static String employeeModificationLog="update tbl_employee_log set CreatedBy=?,DateModified=? where EmployeeId=?";

	//public static String removeRoleLog="delete from tbl_role_mapping where EmployeeId=? and RoleId=?";

	//public static String allocateAsset="insert into tbl_asset_mapping(AssignedTo,AssignedBy,AssetId,Status,HandOverDate)values(?,?,?,?,?)";
	
	public static String allocateAssetLog="insert into tbl_asset_mapping_log(AssignedTo,AssignedBy,AssetId,Status,HandOverDate)values(?,?,?,?,?)";

	public static String UPDATE_EMPLOYEE_TO_LOG_QRY="INSERT INTO AssetManagement.tbl_employee_log VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String UPDATE_EMPLOYEE="UPDATE AssetManagement.tbl_employee SET EmployeeId = ?,FirstName = ?,LastName = ?,Gender = ?,MobileNumber = ?,DateOfBirth = ?,DateOfJoining = ?,Address = ?,ModifiedBy=?,DateModified = ? WHERE EmployeeId = ?";
	//public static String postAssetRequest="insert into tbl_asset_request values(?,?,?)";
	//public static String getAssetRequestsByEmployee ="select * from tbl_asset_request where EmployeeId=?";
	public static String UPDATE_PASSWORD="UPDATE AssetManagement.tbl_employee set Password=? where EmployeeId=?";

	
	//asset
	public static  String getAllAssetRequests = "select * from tbl_asset_request";
	public static  String getEmployeeAsset ="select a.* from tbl_asset  a inner join tbl_asset_mapping am on a.AssetId=am.AssetId where am.AssignedTo=?";
		public static String getAssetByStatus = "select * from tbl_asset where Status=?";
		public static String getAsset="select * from tbl_asset where assetId=?";
		public static String getAllAsset="select * from tbl_asset";
		public static String getAssetRequestsByEmployee ="select * from tbl_asset_request where EmployeeId=?";
		public static String postAssetRequest="insert into tbl_asset_request values(?,?,?)";
		public static String updateAssetStatus="update tbl_asset set Status=?,ModifiedBy=?,DateModified=? where AssetId=?";
		public static String addNewAsset="insert into tbl_asset(SerialNumber,AssetName,AssetType,Cost,Status,CreatedBy,DateCreated) values(?,?,?,?,?,?,?)";
		public static String allocateAsset="insert into tbl_asset_mapping(AssignedTo,AssignedBy,AssetId,Status,HandOverDate)values(?,?,?,?,?)";
		public static String deallocateAsset="update tbl_asset_mapping set Status=?,ReturnDate=?,AssignedBy=? where AssetId=?";//change
		public static String postNewAssetTypeRequest="insert into tbl_asset_request_unavailable values(?,?,?,?)";
		public static String getNewAssetTypeRequest="select * from tbl_asset_request_unavailable ";


//asset log
		public static String UPDATE_ASSET_TO_LOG_="insert into tbl_asset_log values(?,?,?,?,?,?,?,?,?,?)";	


		//log asset-mapping
				public static String getAssetMapping="select * from tbl_asset_mapping where AssetId=?";
				public static String UPDATE_ASSET_MAPPING_TO_LOG="insert into tbl_asset_mapping_log values(?,?,?,?,?,?)";


}
