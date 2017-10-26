package org.medplus.assetmanagementwebapp.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.medplus.assetmanagementcore.exceptions.AssetException;
import org.medplus.assetmanagementcore.exceptions.AuthenticationException;
import org.medplus.assetmanagementcore.model.Asset;
import org.medplus.assetmanagementcore.model.Employee;
import org.medplus.assetmanagementcore.model.Request;
import org.medplus.assetmanagementcore.service.AssetService;
import org.medplus.assetmanagementcore.service.impl.EmployeeServiceImpl;
import org.medplus.assetmanagementcore.utils.AssetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller

public class AssetController {

	
		@Autowired	
		AssetService assetServiceImpl;
		
		
		
		List<Asset> assetlist;
		
		List<Request> requestList;
		
		@Autowired
		EmployeeServiceImpl employeeServiceImpl;
		
		Employee employee;
		
		List<Request> getAllAssetRequests;
		
		List<Asset> getAssetsByStatus;
		
		
		//getting form
		@RequestMapping(value="/addAsset",method=RequestMethod.GET)
			public ModelAndView getAssetForm(){
		       Asset asset =new Asset();
				ModelAndView mav=new ModelAndView();
				mav.addObject(asset);
				mav.setViewName("Asset");
				return mav;
		}

		 @InitBinder
		 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
		     final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
		     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
		 }

		
/*
		 @InitBinder
		 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
		     final SimpleDateFormat public class EmployeeController {dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
		     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
		 }

		*/
		 @RequestMapping(value="/addAsset",method=RequestMethod.POST)
			public ModelAndView addAsset(@ModelAttribute("asset") Asset asse, BindingResult result)
			{
				ModelAndView mav=new ModelAndView();
				
				String rows;
				try {
					
					
						rows = assetServiceImpl.addAsset(asse);
					
					if(rows.equals(0))
					{
						
						return mav;
					
					}
					else
					{
					return new ModelAndView("redirect:home");
				}
				} catch (AssetException |AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return mav;
			}
		 @RequestMapping(value="/viewAssets",method=RequestMethod.GET)
			public ModelAndView viewAssetForm()
			{
				ModelAndView mav=new ModelAndView();
				
			try {
				assetlist=assetServiceImpl.getAllAssets();
				mav.addObject("assets", assetlist);
				mav.addObject("viewdetails", "All Assets");
				mav.setViewName("ViewAssets");
		        return mav;
			} catch (AssetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mav;
			}
		 
		 
		 @RequestMapping(value="/viewAssetsByStatus",method=RequestMethod.GET)
			public ModelAndView viewAssetsByStatus(@RequestParam("status") String status)
			{
				ModelAndView mav=new ModelAndView();
				
			try {
				assetlist=assetServiceImpl.getAssetsByStatus(status);
				mav.addObject("assets", assetlist);
				if(status.equals("A")){
				mav.addObject("viewdetails", "Available Assets");}
				else if(status.equals("N"))
				mav.addObject("viewdetails", "Allocated Assets");	
				mav.setViewName("ViewAssets");
				
		        return mav;
			} catch (AssetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mav;
			}
		 
		 
		 @RequestMapping(value="/viewAssetsByType",method=RequestMethod.GET)
			public ModelAndView viewAssetsByType(@RequestParam("type") AssetType type,@RequestParam("RequestedBy") String RequestedBy)
			{
				ModelAndView mav=new ModelAndView();
				
			try {
				assetlist=assetServiceImpl.getAssetByType(type);
				mav.addObject("assets", assetlist);
				
				mav.addObject("viewdetails", "Available Assets");	
				mav.addObject("RequestedBy", RequestedBy);
				mav.setViewName("ViewAssets");
				
		        return mav;
			} catch (AssetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mav;
			}
		 
		 @RequestMapping(value="/allocateAsset",method=RequestMethod.GET)
			public ModelAndView getAllocationForm(@RequestParam("assetID") String assetID,@RequestParam("RequestedBy") String RequestedBy){
				
				ModelAndView mav=new ModelAndView();
				mav.addObject("assetID", assetID);
				mav.addObject("RequestedBy",RequestedBy);
				mav.setViewName("Allocation");
				return mav;
		}
		 
		 
		 @RequestMapping(value="/allocateAsset",method=RequestMethod.POST)
			public ModelAndView allocateAsset(@RequestParam("employeeID") String employeeId,
					@RequestParam("assetID") String assetID,
					@RequestParam("assignedBy") String assignedBy) throws NumberFormatException, AuthenticationException
			{
				ModelAndView mav=new ModelAndView();
				
				String rows;
				try {
					rows = assetServiceImpl.allocateAsset(employeeId, Integer.parseInt(assetID), assignedBy, new Date());
					if(rows.equals("success"))
					{
						mav.addObject("message", "allocated asset successfully");
						mav.setViewName("EDPHome");
						return mav;
					
					}
					else
					{
						mav.addObject("message", "allocation failed");
						mav.setViewName("EDPHome");
						return mav;

				}
				} catch (AssetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return mav;
			}
		 
		 @RequestMapping(value="/deallocateAsset",method=RequestMethod.GET)
			public ModelAndView getDeAllocationForm(@RequestParam("assetID") String assetID){
				
				ModelAndView mav=new ModelAndView();
				mav.addObject("assetID", assetID);
				mav.setViewName("DeAllocation");
				return mav;
		}
		 
		 
		 @RequestMapping(value="/deallocateAsset",method=RequestMethod.POST)
			public ModelAndView DeallocateAsset(
					@RequestParam("assetID") String assetID,
					@RequestParam("deassignedBy") String deassignedBy) throws NumberFormatException, AuthenticationException
			{
				ModelAndView mav=new ModelAndView();
				
				String rows="";
				try {
					rows = assetServiceImpl.deAllocateAsset(Integer.parseInt(assetID), deassignedBy, new Date());
					if(rows.equals("success"))
					{
						mav.addObject("message", "Deallocated asset successfully");
						mav.setViewName("EDPHome");
						return mav;
					}
					else
					{
						mav.addObject("message", "allocation failed");
						mav.setViewName("EDPHome");
						return mav;
				}
				} catch (AssetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return mav;
			}
		 
		 @RequestMapping(value="/ViewAssetRequests",method=RequestMethod.GET)
			public ModelAndView viewAssetRequestForm()
			{
				ModelAndView mav=new ModelAndView();
				
			try {
				getAllAssetRequests=assetServiceImpl.getAllAssetRequests();
				mav.addObject("assetRequests",getAllAssetRequests);
				mav.setViewName("ViewAssetRequests");
		        return mav;
			} catch (AssetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mav;
			}

		
		 
		 

		 
		 
		 @RequestMapping(value="/adminhome",method=RequestMethod.GET)
			public ModelAndView emphome(HttpServletRequest request, HttpServletResponse response)
			{
				ModelAndView mav=new ModelAndView();
				HttpSession session=request.getSession();
				String username=session.getAttribute("username").toString();
			try {
				
				
				mav.addObject("emp", employee);
				mav.setViewName("AdminHome");
		        return mav;
			} catch(NullPointerException e1)
			{
				return mav;
			}
			}
		 
		 @RequestMapping(value="/employee",method=RequestMethod.GET)
			public ModelAndView EmployeeHome(HttpServletRequest request, HttpServletResponse response)
			{
				ModelAndView mav=new ModelAndView();
				HttpSession session=request.getSession();
				String username=session.getAttribute("username").toString();
			try {
				System.out.println("1");
				assetlist=assetServiceImpl.getAssetsOfEmployee(username);
				
				mav.addObject("assets", assetlist);
				
				requestList	=assetServiceImpl.getAssetRequests(username);
				System.out.println("2");
				
				mav.addObject("requestList", requestList);
				employee=employeeServiceImpl.getEmployee(username);
				System.out.println("3");
				mav.addObject("emp", employee);
				mav.setViewName("EmployeeHome");
		        return mav;
			} catch (AssetException e) {
				return mav;
				
			}
			catch(NullPointerException e1)
			{
				return mav;
			}
			}
		 
		 @RequestMapping(value="/EDPHome",method=RequestMethod.GET)
			public ModelAndView EDPHome(HttpServletRequest request, HttpServletResponse response)
			{
				ModelAndView mav=new ModelAndView();
				HttpSession session=request.getSession();
				String username=session.getAttribute("username").toString();
			try {
				assetlist=assetServiceImpl.getAssetsOfEmployee(username);
				
				mav.addObject("assets", assetlist);
				
				requestList	=assetServiceImpl.getAssetRequests(username);
				System.out.println("ccccc"+requestList.size());
				mav.addObject("requestList", requestList);
				employee=employeeServiceImpl.getEmployee(username);
				mav.addObject("emp", employee);
				mav.setViewName("EDPHome");
		        return mav;
			} catch (AssetException e) {
				return mav;
				
			}
			catch(NullPointerException e1)
			{
				return mav;
			}
			}
		 
		 @RequestMapping(value="/empassets",method=RequestMethod.GET)
         public ModelAndView EmployeeAssets(@RequestParam("username") String username,HttpServletRequest request, HttpServletResponse response)
         {
             ModelAndView mav=new ModelAndView();
             
         try {
             
             assetlist=assetServiceImpl.getAssetsOfEmployee(username);
             mav.addObject("assets", assetlist);
             employee=employeeServiceImpl.getEmployee(username);
             mav.addObject("emp", employee);
             mav.setViewName("EmployeeAsset");
             return mav;
         } catch (AssetException e) {
             mav.addObject("message", e.getErrorMessage());
             return mav;
             
         }
         
         }
		 
		 @RequestMapping(value="/emprequest",method=RequestMethod.GET)
         public ModelAndView EmployeeRequest(@RequestParam("username") String username,HttpServletRequest request, HttpServletResponse response)
         {
             ModelAndView mav=new ModelAndView();
             
         try {
         
             
             requestList    =assetServiceImpl.getAssetRequests(username);
             mav.addObject("requestList", requestList);
             
             mav.setViewName("EmployeeRequests");
             return mav;
         } catch (AssetException e) {
             mav.addObject("message", e.getErrorMessage());
             return mav;
             
         }
         
         }
		 
		  @RequestMapping(value="assetrequest",method=RequestMethod.GET)
	         public ModelAndView postNewTypeAssetRequestForm(HttpServletRequest request, HttpServletResponse response)
	            {
	                ModelAndView mav=new ModelAndView();
	                
	            
	            
	                mav.setViewName("NewRequest");
	            
	            return mav;
	            
	            }
	         @RequestMapping(value="assetrequest",method=RequestMethod.POST)
	         public ModelAndView postNewTypeAssetRequest(@RequestParam("userName") String userName,@RequestParam("assetType") String assetType,@RequestParam("assetName") String assetName,HttpServletRequest request, HttpServletResponse response)
	            {
	             System.out.println("here");
	                ModelAndView mav=new ModelAndView();
	                String msg="";
	                try {
	                    msg=assetServiceImpl.postNewAssetTypeRequest(userName,assetType,assetName,new Date());
	                    mav.addObject("message", msg);
	                } catch (AuthenticationException e) {
	                    mav.addObject("msg", e.getErrorMessage());
	                    e.printStackTrace();
	                }
	                mav.setViewName("EmployeeHome");
	            
	            return mav;
	            
	            }
	         @RequestMapping(value="postAssetRequests",method=RequestMethod.GET)
	         public ModelAndView postAssetRequestForm(HttpServletRequest request, HttpServletResponse response)
	            {
	                ModelAndView mav=new ModelAndView();
	                mav.setViewName("Request1");
	                return mav;
	            
	            
	            }
	         @RequestMapping(value="postAssetRequests",method=RequestMethod.POST)
	         public ModelAndView postAssetRequest(@RequestParam("EmployeeId") String requestedBy,@RequestParam("type") String type,HttpServletRequest request, HttpServletResponse response)
	            {
	                ModelAndView mav=new ModelAndView();
	                
	            
	            try {
	                String msg=assetServiceImpl.postAssetRequest(AssetType.valueOf(type),requestedBy,new Date());
	                mav.addObject("message", msg);
	                mav.setViewName("EmployeeHome");
	                return mav;
	            } catch (AuthenticationException e) {
	                mav.addObject("message", e.getErrorMessage());
	                //e.printStackTrace();
	            }
	            
	            return mav;
	            
	            }

		
	}


