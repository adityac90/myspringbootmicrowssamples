package com.ehi.vehicles.vi.services.sftp.impl;

import com.ehi.vehicles.vi.services.sftp.SFTPFileHandlingService;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@PropertySource("classpath:sftp/sftp-${spring.profiles.active}.properties")
public class SFTPFileHandlingServiceImpl implements SFTPFileHandlingService {
    @Autowired
    private SSHClient viFtpClient;
    @Value("${sftp.host}")
    private String remoteHost;
    @Value("${sftp.user.name}")
    private String username;
    @Value("${sftp.user.password}")
    private String password;
    @Value("${sftp.remote.push.path}")
    private String remotePushDirectory;
    @Value("${sftp.remote.pull.path}")
    private String remotePullFilePath;


    /**
     * Connect to SFTP
     */
    @Override
    public void connectToSFTPServer() throws IOException {
        viFtpClient.connect(remoteHost);
        viFtpClient.authPassword(username, password);
    }

    /**
     * disConnect from SFTP
     */
    @Override
    public void disconnectFromSFTPServer() throws IOException {
        viFtpClient.disconnect();
    }

    /**
     * push files to SFTP
     *
     * @return boolean
     */
    @Override
    public boolean pushFileToSFTPServer(String localFilePath) throws IOException {
        connectToSFTPServer();
        //logic to push the file
        final SFTPClient sftpClient = viFtpClient.newSFTPClient();
        sftpClient.put(localFilePath, remotePushDirectory);
        sftpClient.close();
        disconnectFromSFTPServer();
        return true;
    }

    /**
     * pull files from SFTP
     *
     * @return boolean
     */
    @Override
    public boolean pullFilesFromSFTPServer(String localFilePath) throws IOException {
        connectToSFTPServer();
        final SFTPClient sftpClient = viFtpClient.newSFTPClient();
        sftpClient.get(remotePullFilePath, localFilePath);
        sftpClient.close();
        disconnectFromSFTPServer();
        return true;
    }
}
