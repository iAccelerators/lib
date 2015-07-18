package com.cts.bpi.igithub.domain;

public class IGitHubVO {
	
	private String remoteUrl;
	private String localProjectPath;
	private String branch;
	private String userID;
	private String password;
	
	
	public String getRemoteUrl() {
		return remoteUrl;
	}
	
	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}
	
	public String getLocalProjectPath() {
		return localProjectPath;
	}
	
	public void setLocalProjectPath(String localProjectPath) {
		this.localProjectPath = localProjectPath;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Details: remoteUrl : " + this.remoteUrl + ", localProjectPath : " + this.localProjectPath +
				", branch : " + this.branch + ", userID : " + this.userID + ", password : " + this.password;  
	}
}
