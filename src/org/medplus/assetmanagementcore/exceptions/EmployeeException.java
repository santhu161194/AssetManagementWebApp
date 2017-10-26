package org.medplus.assetmanagementcore.exceptions;

public class EmployeeException extends Exception{
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String message;
		public EmployeeException( String message) {
			this.message=message;
		}
		public String getErrorMessage(){
			return this.message;
		}

	}

	

