package com.cts.bpi.igithub.util;

import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;

import com.cts.bpi.igithub.service.IGitHubService;
import com.cts.bpi.igithub.service.IGitHubServiceImpl;

/**
 * Hello world!
 *
 */
public class IGitHub 
{
	private static final String remoteUrl = "https://github.com/MuleSoftAccelerators/PrototypeGitHubClient.git";
	private static final String userID = "u999";
	private static final String password = "password";
	private static final String localProjectPath = "/Users/jcon787/Downloads/personal/CTS/gitsss";
	private static final String branch = "master";
	

	public static void main(String[] args){
		IGitHubService iGitHubService =  new IGitHubServiceImpl();
		iGitHubService.gitClone(userID, password, localProjectPath, remoteUrl, branch);
	}
}
