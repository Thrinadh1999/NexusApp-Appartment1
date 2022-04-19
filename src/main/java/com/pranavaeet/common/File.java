package com.pranavaeet.common;

import java.util.Arrays;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class File {

	private CommonsMultipartFile userUpload;
	private String fileId;
	private String filePath;
	private String fileType;
	private String fileContentAsString;
	private byte[] fileContent;
	
	public File() {
		
	}

	public CommonsMultipartFile getUserUpload() {
		return userUpload;
	}

	public void setUserUpload(CommonsMultipartFile userUpload) {
		this.userUpload = userUpload;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileContentAsString() {
		return fileContentAsString;
	}

	public void setFileContentAsString(String fileContentAsString) {
		this.fileContentAsString = fileContentAsString;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	@Override
	public String toString() {
		return "File [userUpload=" + userUpload + ", fileId=" + fileId + ", filePath=" + filePath + ", fileType="
				+ fileType + ", fileContentAsString=" + fileContentAsString + ", fileContent="
				+ Arrays.toString(fileContent) + "]";
	}
	
}
