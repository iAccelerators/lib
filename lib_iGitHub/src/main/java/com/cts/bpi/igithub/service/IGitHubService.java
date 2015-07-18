package com.cts.bpi.igithub.service;


public interface IGitHubService {
	
	void gitDetails(String remoteUrl, String localProjectPath, String branch);
	void gitCredentials(String userID, String password);
	void gitRemoteUrl(String remoteUrl);
	void gitBranch(String branch);
	void gitLocalProjectPath(String localProjectPath);
	void gitClone(String userID, String password, String localProjectPath, String remoteUrl, String branch);
	void gitClone();
}
