package com.cts.bpi.igithub.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cts.bpi.igithub.bo.IGitHubBO;
import com.cts.bpi.igithub.bo.IGitHubBOImpl;
import com.cts.bpi.igithub.domain.IGitHubVO;
import com.cts.bpi.igithub.exception.IGitHubException;

@Component("iGitHubService")
public class IGitHubServiceImpl implements IGitHubService {

	private static Logger log = LoggerFactory.getLogger(IGitHubBOImpl.class);
	private IGitHubVO iGitHubVO;
	private IGitHubBO iGitHubBO;
	
	@Override
	public void gitDetails(String remoteUrl, String localProjectPath,
			String branch) {
		if(iGitHubVO == null){
			init();
		}
		iGitHubVO.setRemoteUrl(remoteUrl);
		iGitHubVO.setLocalProjectPath(localProjectPath);
		iGitHubVO.setBranch(branch);
	}

	@Override
	public void gitCredentials(String userID, String password) {
		if(iGitHubVO == null){
			init();
		}
		iGitHubVO.setUserID(userID);
		iGitHubVO.setPassword(password);
	}

	@Override
	public void gitRemoteUrl(String remoteUrl) {
		if(iGitHubVO == null){
			init();
		}
		iGitHubVO.setRemoteUrl(remoteUrl);
	}

	@Override
	public void gitBranch(String branch) {
		if(iGitHubVO == null){
			init();
		}
		iGitHubVO.setBranch(branch);
	}

	@Override
	public void gitLocalProjectPath(String localProjectPath) {
		if(iGitHubVO == null){
			init();
		}
		iGitHubVO.setLocalProjectPath(localProjectPath);
	}

	@Override
	public void gitClone(String userID, String password,
			String localProjectPath, String remoteUrl, String branch) {
		if(iGitHubVO == null){
			init();
		}
		
		iGitHubVO.setRemoteUrl(remoteUrl);
		iGitHubVO.setLocalProjectPath(localProjectPath);
		iGitHubVO.setBranch(branch);
		iGitHubVO.setUserID(userID);
		iGitHubVO.setPassword(password);
		
		if(iGitHubBO == null){
			init();
		}
		
		iGitHubBO.gitCloneToLocal(iGitHubVO);
	}

	@Override
	public void gitClone() {
		
		if(iGitHubBO == null){
			init();
		}
		
		if(iGitHubVO == null){
			NullPointerException e = new NullPointerException();
			log.error("Set all the values(remoteUrl, localProjectPath, branch, userID, password) before Clone", e);
			throw new IGitHubException("Set all the values(remoteUrl, localProjectPath, branch, userID, password) before Clone", e);
		}else{
			iGitHubBO.gitCloneToLocal(iGitHubVO);
		}
		
	}
	
	private void init(){
		
		if(iGitHubVO == null){
			iGitHubVO = new IGitHubVO();
		}
		
		if(iGitHubBO == null){
			iGitHubBO =  new IGitHubBOImpl();
		}
		
	}
	
}
