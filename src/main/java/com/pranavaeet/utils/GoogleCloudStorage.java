package com.pranavaeet.utils;

import com.google.api.gax.paging.Page;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Blob;


/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;
import com.pranavaeet.config.Variables;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class is a connector between the Web application and Google Cloud
 * Storage.
 * 
 * @throws IOException
 * @throws FileNotFoundException
 */
public class GoogleCloudStorage {

	public GoogleCloudStorage() {
		setDefaultStorageCredentials();
	}

	private final static String clientId = Variables.gcsClientId;
	private final static String clientEmail = Variables.gcsClientEmail;
	private final static String privateKey = Variables.gcsPrivateKey;
	private final static String privateKeyId = Variables.gcsPrivateKeyId;
	private final static String projectId = Variables.gcsProjectId;
	private String bucketName = getBucketName();
	
	final static Logger logger = LogManager.getLogger(GoogleCloudStorage.class);
	private static Storage storage = null;
	private static Credentials credentials = null;
	private boolean configLoaded = false;

	/**
	 * This is the initialization method for Google Cloud Storage. This method
	 * will read all the required properties from the configuration file and
	 * initialize the GCS bean.
	 * 
	 */
	private void setDefaultStorageCredentials() {
		if (!configLoaded) {
			try {
				credentials = ServiceAccountCredentials.fromPkcs8(clientId, clientEmail,
						privateKey, privateKeyId, null);
				storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(projectId)
						.build().getService();
				this.configLoaded = true;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}		
	}

	/**
	 * This method will return the bucket name based on the accountId. If
	 * the bucket doesn't exist, then a new bucket is created for the
	 * account.
	 * 
	 * @return String containing the bucket name.
	 */
	private String getBucketName() {
		setDefaultStorageCredentials();
		String bucketName = "pranava-labs-default-bucket";
		bucketName = bucketName.toLowerCase();
		boolean bucketFound = false;
		Page<Bucket> buckets = storage.list();
		for (Bucket bucket : buckets.iterateAll()) {
			if (bucket.getName().equalsIgnoreCase(bucketName))
				bucketFound = true;
		}
		if (!bucketFound)
			createBucket(bucketName);
		else
			logger.info("Found existing bucket: " + bucketName);
		return bucketName;
	}

	/**
	 * This method will create a new bucket based on the given bucket name.
	 * 
	 * @param bucketName Name of the bucket that needs to be created.
	 */
	private void createBucket(String bucketName) {
		logger.info("Creating a new bucket: " + bucketName);
		try {
			storage.create(BucketInfo.newBuilder(bucketName).setStorageClass(StorageClass.REGIONAL)
					.setLocation("asia-south1").build());
			return;
		} catch (Exception e) {
			logger.error("Bucket Already exists: " + bucketName);
		}
	}
	
	/**
	 * Uploads a given file to Google Cloud Storage.
	 * 
	 * @param filePath The desired file path for the file to be uploaded. Should include file name also.
	 * @param file The file in byte array format.
	 * @return true if the file has been successfully uploaded; false otherwise.
	 */
	@SuppressWarnings("deprecation")
	public boolean uploadDocument(String filePath, byte[] file) {
		try {
			setDefaultStorageCredentials();
			logger.info("Uploading file to bucket: "+bucketName+" at path: "+filePath);
			storage.create(BlobInfo.newBuilder(bucketName, filePath).build(), new ByteArrayInputStream(file));
			return true;
		} catch (Exception e) {			
			logger.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Uploads a given file to Google Cloud Storage along with meta data.
	 * 
	 * @param filePath The desired file path for the file to be uploaded. Should include file name also.
	 * @param file The file in byte array format.
	 * @param contentType MIME type of the file being uploaded.
	 * @param originalFileName Original File name of the file being uploaded.
	 * @return true if the file has been successfully uploaded; false otherwise.
	 */
	@SuppressWarnings("deprecation")
	public boolean uploadDocumentWithMetaData(String filePath, byte[] file, String contentType, String originalFileName) {
		Map<String, String> metadataMap = new HashMap<String, String>();
		metadataMap.put("Content-Type", contentType);
		metadataMap.put("Content-Disposition", originalFileName);
		try {
			setDefaultStorageCredentials();
			logger.info("Uploading file to bucket: "+bucketName+" at path: "+filePath);
			storage.create(BlobInfo.newBuilder(bucketName, filePath).setMetadata(metadataMap).build(), new ByteArrayInputStream(file));
			return true;
		} catch (Exception e) {			
			logger.error(e.getMessage());
			return false;
		}
	}

	/**
	 * Downloads a file from the specified location in Google Cloud Storage.
	 * 
	 * @param path The desired file path for the file to be uploaded. Should include file name also.
	 * @return Blob object containing the file content. Returns null if file is not found at the specified location.	 
	 */
	public Blob downloadDocumentWithMetaData(String path){
		try{			
			logger.info("Downloading file from bucket: "+bucketName+" in path: "+path);
			return storage.get(bucketName).get(path);
		}catch(Exception e){
			logger.info("Failed to download file from bucket: "+bucketName+" in path: "+path);
			return null;
		}
	}
	
	/**
	 * Downloads a file from the specified location in Google Cloud Storage.
	 * 
	 * @param path The desired file path for the file to be uploaded. Should include file name also.
	 * @return Byte array containing the file content. Returns null if file is not found at the specified location.	 
	 */
	public byte[] downloadDocument(String path){
		setDefaultStorageCredentials();		
		byte[] file = null;
		file = getFileFromBucket(bucketName, path);			
		return file;
	}
	
	private byte[] getFileFromBucket(String bucketName, String filePath){
		byte[] file = null;
		try{
			logger.info("Downloading file from bucket: "+bucketName+" in path: "+filePath);
			file = storage.get(bucketName).get(filePath).getContent();
		}catch(Exception e){
			logger.info("Failed to download file from bucket: "+bucketName+" in path: "+filePath);
			file = null;
		}
		return file;
	}

	/**
	 * Deletes the file at the specified file location in Google Cloud Storage.
	 * 
	 * @param path The desired file path of the file to be deleted. Should include file name also.
	 * @return true if the file has been deleted successfully; false otherwise.
	 */
	public boolean deleteDocument(String path) {
		setDefaultStorageCredentials();
		logger.info("Deleting file from bucket: "+bucketName+" in path: "+path);
		return storage.delete(storage.get(bucketName).get(path).getBlobId());
	}

}