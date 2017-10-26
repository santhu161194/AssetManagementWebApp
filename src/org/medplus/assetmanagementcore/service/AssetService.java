package org.medplus.assetmanagementcore.service;

import java.util.Date;
import java.util.List;

import org.medplus.assetmanagementcore.exceptions.AssetException;
import org.medplus.assetmanagementcore.exceptions.AuthenticationException;
import org.medplus.assetmanagementcore.model.Asset;
import org.medplus.assetmanagementcore.model.NewTypeRequest;
import org.medplus.assetmanagementcore.model.Request;
import org.medplus.assetmanagementcore.utils.AssetStatus;
import org.medplus.assetmanagementcore.utils.AssetType;

public interface AssetService {

	public String updateAsset(Asset asset, String updatedBy, Date updatedDate);

	public String updateAssetStatus(int assetId, AssetStatus status,
			String ModifiedBy, Date dateModified)
			throws AuthenticationException;

	public String postAssetRequest(AssetType assetType, String requestedBy,
			Date requestedDate) throws AuthenticationException;

	public Asset getAsset(int assetId) throws AssetException;

	public String addAsset(Asset asset) throws AssetException,
			AuthenticationException;

	public List<Asset> getAllAssets() throws AssetException;

	public List<Asset> getAssetsByStatus(String status) throws AssetException;

	public List<Asset> getAssetsOfEmployee(String empId) throws AssetException;

	public String postNewAssetTypeRequest(String requestedBy, String assetType,
			String assetName, Date requestedDate)
			throws AuthenticationException;

	public List<Request> getAllAssetRequests() throws AssetException;

	public List<NewTypeRequest> getNewAssetTypeRequests() throws AssetException;

	public List<Request> getAssetRequests(String requestedBy)
			throws AssetException;

	public String allocateAsset(String assignedTo, int assetId,
			String asignedBy, Date handOverDate) throws AssetException,
			AuthenticationException;

	public String deAllocateAsset(int assetId, String deallocatedBy,
			Date deallocationDate) throws AssetException,
			AuthenticationException;

	public List<Asset> getAssetByType(AssetType type) throws AssetException;

}
