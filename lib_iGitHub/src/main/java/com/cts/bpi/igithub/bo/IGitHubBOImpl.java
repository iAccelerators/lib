package com.cts.bpi.igithub.bo;

import java.io.File;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cts.bpi.igithub.domain.IGitHubVO;
import com.cts.bpi.igithub.exception.IGitHubException;


@Component("iGitHubBO")
public class IGitHubBOImpl implements IGitHubBO {
	
	private static Logger log = LoggerFactory.getLogger(IGitHubBOImpl.class);
	
	private File localPath;
	private Git result;

	@Override
	public void gitCloneToLocal(IGitHubVO iGitHubVO) {

		try {
			
			getLocalPath(iGitHubVO.getLocalProjectPath());

			CredentialsProvider credentialsProvider = getCredentialsProvider(iGitHubVO.getUserID(), iGitHubVO.getPassword());

			CloneCommand cloneCommand = new CloneCommand()
					.setCredentialsProvider(credentialsProvider)
					.setDirectory(localPath).setURI(iGitHubVO.getRemoteUrl()).setBranch(iGitHubVO.getBranch());
			
			result = cloneCommand.call();
			result.getRepository().getDirectory();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new IGitHubException(e.getMessage(), e);
		} finally{
			result.close();
		}
		
	}
	
	private void getLocalPath(String path){
		try{
			localPath = new File(path);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new IGitHubException(e.getMessage(), e);
		}finally{
			localPath.deleteOnExit();
		}
	}
	
	private CredentialsProvider getCredentialsProvider(String userID, String password){
		return new UsernamePasswordCredentialsProvider(userID, password);
	}

}
